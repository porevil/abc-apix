package com.abc.api;

import com.abc.bill.BillInfoService;
import com.abc.account.AccountInfoService;
import com.abc.notification.NotificationService;
import com.abc.transaction.TransactionApiController;
import com.abc.transaction.TransactionService;
import com.abc.transaction.TransactionEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TransactionApiControllerTest {

    private MockMvc mockMvc;

    @Mock
    TransactionService transactionService;

    @Mock
    NotificationService notificationService;

    @Mock
    BillInfoService billInfoService;

    @Mock
    AccountInfoService accountService;

    @InjectMocks
    private TransactionApiController transactionApiController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(transactionApiController)
                .build();
    }

    @Test
    public void saveTransactionSuccess() throws Exception{
        TransactionEntity transaction = new TransactionEntity();
        transaction.setBillRefNo("");
        transaction.setSavingAccountNo("");
        transaction.setSavingAmount(new BigDecimal(1));
        transaction.setDepositAccountNo("");
        transaction.setBillTotalAmount(new BigDecimal(1));

        when(transactionService.saveTransaction(transaction)).thenReturn(1L);
        when(billInfoService.updateBillPay(transaction.getBillRefNo())).thenReturn(true);
        when(accountService.saveAccountBalance(transaction.getSavingAccountNo(),transaction.getSavingAmount().doubleValue())).thenReturn(true);
        when(accountService.debitAccountBalance(transaction.getDepositAccountNo(),-transaction.getBillTotalAmount().doubleValue())).thenReturn(true);

        ObjectMapper mapper = new ObjectMapper();
        String requestString = mapper.writeValueAsString(transaction);
        mockMvc.perform(post("/transaction")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(requestString)
                )
                .andExpect(status().isOk());
    }

}
