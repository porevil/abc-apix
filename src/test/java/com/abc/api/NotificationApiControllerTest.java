package com.abc.api;

import com.abc.notification.NotificationApiController;
import com.abc.notification.NotificationService;
import com.abc.notification.SendEmailService;
import com.abc.transaction.TransactionService;
import com.abc.transaction.TransactionEntity;
import com.abc.template.EmailBillDto;
import com.abc.template.EmailTemplateService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class NotificationApiControllerTest {

    /*** EXAMPLES ***
     * https://memorynotfound.com/unit-test-spring-mvc-rest-service-junit-mockito/
     */

    private MockMvc mockMvc;

    @Mock
    private NotificationService notificationService;

    @Mock
    private SendEmailService sendEmailService;

    @Mock
    private EmailTemplateService emailTemplateService;

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private NotificationApiController notificationApiController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(notificationApiController)
                .build();
    }

    @Test
    public void sendMailSuccess() throws Exception {
        EmailBillDto emailBillDto = new EmailBillDto();
        emailBillDto.setTransactionNo("00001");
        when(emailTemplateService.getHtml(emailBillDto)).thenReturn("<br/><h1>transactionId = 1</h1>");

        TransactionEntity entity = new TransactionEntity();
        entity.setAccountName("thum");
        entity.setBillAmount(BigDecimal.valueOf(123.45));
        entity.setCurrentDateTime(new Date());
//        entity.setSavingPerMonthCurrentDateTime(new Date());
        System.out.println( entity.getCurrentDateTime());
        when(transactionService.getTransactionById(1L)).thenReturn(entity);

        mockMvc.perform(get("/notification/{transactionId}", 1))
                .andExpect(status().isOk());
    }
}
