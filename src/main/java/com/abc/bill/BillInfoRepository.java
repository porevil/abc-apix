package com.abc.bill;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by cadet on 1/23/2018 AD.
 */
public interface BillInfoRepository extends MongoRepository<BillInfo, String>{

    BillInfo findByBillRefNo(String BillRefNo);

}
