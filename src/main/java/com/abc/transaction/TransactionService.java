package com.abc.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Locale;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public Long saveTransaction(TransactionEntity entity){
        entity.setBillTotalAmount(entity.getBillAmount().add(entity.getSavingAmount()));
        entity.setCurrentDateTime(Calendar.getInstance(Locale.US).getTime());
        transactionRepository.save(entity);
        return entity.getTransactionId();
    }

    public TransactionEntity getTransactionById(Long transactionId){
        return transactionRepository.findOne(transactionId);
    }
}
