package com.abc.payment;

import com.abc.transaction.TransactionEntity;
import com.abc.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class AccruedMonthlyDepositService {

    @Autowired
    TransactionRepository transactionRepository;

    public Double getAccruedMonthlyDeposit(String accountId, int month, int year) {
        BigDecimal amount = BigDecimal.ZERO;
        Date startDate = this.calculateStartDate(month, year);
        Date endDate = this.calculateEndDate(month, year);

        List<TransactionEntity> resultList =  transactionRepository.findTransactionByAccountId(accountId);

        for (TransactionEntity item : resultList) {

            if (item.getCurrentDateTime().compareTo(startDate) == 0 || item.getCurrentDateTime().compareTo(endDate) == 0
                    || (item.getCurrentDateTime().after(startDate) && item.getCurrentDateTime().before(endDate))) {
                amount = amount.add(item.getSavingAmount());
            }

        }

        Double accrueAmt = amount.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return accrueAmt;
    }

    public Date calculateStartDate(int month, int year) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.set(year, month, 1, 0,0, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    public Date calculateEndDate(int month, int year) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.set(year, month, 1, 0,0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);

        return cal.getTime();
    }


}
