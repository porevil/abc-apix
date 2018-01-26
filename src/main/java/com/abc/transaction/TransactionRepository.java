package com.abc.transaction;

import com.abc.transaction.TransactionEntity;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cadet on 1/24/2018 AD.
 */

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {

    @Query("SELECT t FROM TransactionEntity t WHERE t.accountId=:accountId")
    List<TransactionEntity> findTransactionByAccountId(@Param("accountId") String accountId);

}
