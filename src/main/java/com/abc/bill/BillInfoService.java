package com.abc.bill;

import com.abc.bill.BillInfo;
import com.abc.bill.BillInfoDto;
import com.abc.bill.BillInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@Service
public class BillInfoService {


    @Autowired
    BillInfoRepository billRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public BillInfoDto getBillInfo(String refId){
        BillInfoDto dto=null;
        Double amount = 0.00;
        try{
            BillInfo info =  billRepository.findByBillRefNo(refId);
            if(info!=null){
                dto = new BillInfoDto();
                 dto.setBillRefNo(info.getBillRefNo());
                 dto.setMercCode(info.getMercCode());
                 dto.setMercDesc(info.getMercDesc());

                 if(null != info.getBillAmt()){
                     amount = Double.parseDouble(info.getBillAmt());
                     dto.setBillAmt(amount);
                 }
                 dto.setPayStatus(info.getPayStatus());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dto;
    }

    public boolean updateBillPay(String refId){
        Query query = new Query();
        query.addCriteria(Criteria.where("billRefNo").is(refId));
        Update update = new Update();
        update.set("payStatus", "Y" );
        update.set("lastPayDate", this.getCurrentDateToStr() );
        mongoTemplate.updateFirst(query,update,BillInfo.class );
        return true;
    }

    public String getCurrentDateToStr(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        return reportDate;
    }

    public boolean refund(String refId){
        Query query = new Query();
        query.addCriteria(Criteria.where("billRefNo").is(refId));
        Update update = new Update();
        update.set("payStatus", "N" );
        update.set("lastPayDate", this.getCurrentDateToStr() );
        mongoTemplate.updateFirst(query,update,BillInfo.class );
        return true;
    }
}
