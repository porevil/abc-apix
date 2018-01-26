package com.abc.account;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AccountInfoRepository  extends MongoRepository<AccountInfoModel, Long> {
    @Query(value = "{ 'accountId' : ?0 } ")
    AccountInfoModel findByAccountId(int accountId);

    @Query(value = "{ 'accountId' : ?0, 'rules.0.ruleId' : ?1 } ")
    AccountInfoModel findByAccountIdAndRuleId(int accountId, String ruleId);
}
