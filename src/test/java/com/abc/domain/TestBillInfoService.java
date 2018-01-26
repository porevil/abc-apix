package com.abc.domain;


import com.abc.bill.BillInfoDto;
import com.abc.bill.BillInfoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.abc.bill.BillInfoApiController;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestBillInfoService {
	private MockMvc mockMvc;

    @Mock
    private BillInfoService billInfoService;

    @InjectMocks
	private BillInfoApiController billInfoApiController;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.standaloneSetup(billInfoApiController)
				.build();
	}

	@Test
	public void testGetBillInfo() throws Exception {
		BillInfoDto entity = new BillInfoDto();
		entity.setBillRefNo("111");
		entity.setMercCode("MEA001");
		entity.setMercDesc("การไฟฟ้านครหลวง");
		entity.setBillAmt(1250.53);
		entity.setPayStatus("N");
		when(billInfoService.getBillInfo("111")).thenReturn(entity);

        mockMvc.perform(get("/bills/{bill_ref_no}", 111))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.billRefNo", is("111")))
				.andExpect(jsonPath("$.mercCode", is("MEA001")))
				.andExpect(jsonPath("$.mercDesc", is("การไฟฟ้านครหลวง")))
				.andExpect(jsonPath("$.billAmt", is(1250.53)))
				.andExpect(jsonPath("$.payStatus", is("N")))
                ;
    }

	@Test
	public void testUpdateBillInfo() throws Exception {
        Mockito.when(billInfoService.updateBillPay("112")).thenReturn(true);
		//Arrange
		BillInfoDto entity2 = new BillInfoDto();
		entity2.setBillRefNo("112");
		entity2.setMercCode("MEA001");
		entity2.setMercDesc("การไฟฟ้านครหลวง");
		entity2.setBillAmt(1250.53);
		entity2.setPayStatus("Y");
		when(billInfoService.getBillInfo("112")).thenReturn(entity2);

		mockMvc.perform(get("/billpay/{bill_ref_no}", 112))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.billRefNo", is("112")))
				.andExpect(jsonPath("$.mercCode", is("MEA001")))
				.andExpect(jsonPath("$.mercDesc", is("การไฟฟ้านครหลวง")))
				.andExpect(jsonPath("$.billAmt", is(1250.53)))
				.andExpect(jsonPath("$.payStatus", is("Y")))
		;


		Mockito.verify(billInfoService).updateBillPay("112");
        Mockito.verify(billInfoService).getBillInfo("112");
	}

}
