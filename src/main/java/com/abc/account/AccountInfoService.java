package com.abc.account;

import com.abc.account.AccountInfoModel;
import com.abc.account.AccountInfoRepository;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    public boolean saveAccountBalance(String savingAccNo, double savingAmount){

        boolean result = false;
        Query query = new Query();
        query.addCriteria(Criteria.where("savingAccountNo").is(savingAccNo));
        AccountInfoModel accInfoModel = this.getAccount(query);
        if(accInfoModel!=null){

            Update update = new Update();
            update.set("accountBalance", accInfoModel.getAccountBalance() + savingAmount);
            WriteResult wResult = mongoTemplate.updateFirst(query, update, AccountInfoModel.class);
            if (wResult.getN() >= 1) {
                result = true;
            }
        }

        return result;

    }

    public boolean debitAccountBalance(String debitAccNo, double debitAmount){

        boolean result = false;
        Query query = new Query();
        query.addCriteria(Criteria.where("debitAccountNo").is(debitAccNo));
        AccountInfoModel accInfoModel = this.getAccount(query);
        if(accInfoModel!=null){

            Update update = new Update();
            update.set("debitAccountBalance", accInfoModel.getDebitAccountBalance() - debitAmount);
            WriteResult wResult = mongoTemplate.updateFirst(query, update, AccountInfoModel.class);
            if (wResult.getN() >= 1) {
                result = true;
            }
        }

        return result;

    }

    public AccountInfoModel findByAccountId(int accountId) {
        return accountInfoRepository.findByAccountId(accountId);
    }

    public AccountInfoModel findByAccountIdAndRuleId(int accountId, String ruleId) {
        return accountInfoRepository.findByAccountIdAndRuleId(accountId, ruleId);
    }

    private AccountInfoModel getAccount(Query query){
        return mongoTemplate.findOne(query,AccountInfoModel.class);
    }
}
