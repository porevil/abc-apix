package com.abc.domain;

import com.abc.bill.BillInfo;
import com.abc.bill.BillInfoRepository;
import com.abc.bill.BillInfoService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by cadet on 1/23/2018 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringMongoConfiguration.class})
public class BillTests {

    //@Autowired
    //BillInfoRepository billRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void findEqualId(){

        BillInfo pf = new BillInfo();

        String refId="1234567891";
        // fetch an individual customer


        //BillInfo info =  billRepository.findByBillRefNo(refId);
/*
        BillInfoService service  = new BillInfoService();

        Query query = new Query();
        query.addCriteria(Criteria.where("billRefNo").is(refId));

        Update update = new Update();
        update.set("payStatus", "Y" );
        update.set("lastPayDate", service.getCurrentDateToStr() );
*/

    }

}
