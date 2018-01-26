package com.abc.domain;


import com.abc.account.AccountInfoApiController;
import com.abc.account.AccountInfoModel;
import com.abc.account.AccountInfoService;
import com.abc.account.AccountRule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestAccountInfoService {
	private MockMvc mockMvc;

    @Mock
    private AccountInfoService accountService;

    @InjectMocks
	private AccountInfoApiController accountInfoApiController;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.standaloneSetup(accountInfoApiController)
				.build();
	}

	@Test
	public void testGetAccountId1() throws Exception {
		AccountInfoModel entity = new AccountInfoModel();
		entity.setAccountId(101);
        entity.setAccountName("Mr.Wachirasak Pakyoo");
		when(accountService.findByAccountId(101)).thenReturn(entity);

        mockMvc.perform(get("/accounts/{accountId}", 101))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.accountId", is(101)))
                .andExpect(jsonPath("$.accountName", is("Mr.Wachirasak Pakyoo")))
                ;
    }

    @Test
	public void retriveAccountId102ByRuleR2AndAccountId2() throws Exception{
		AccountInfoModel entity = new AccountInfoModel();
		entity.setAccountId(102);
		AccountRule ruleEntity = new AccountRule();
		ruleEntity.setRuleId("R2");
		List<AccountRule> listRules = new ArrayList<>();
		listRules.add(ruleEntity);
		entity.setRules(listRules);

		when(accountService.findByAccountIdAndRuleId(102, "R2")).thenReturn(entity);

        mockMvc.perform(get("/accounts/{accountId}/rules/{ruleId}", 102, "R2"))
				.andExpect(status().isOk())
		        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		        .andExpect(jsonPath("$.accountId", is(102)))
                .andExpect(jsonPath("$.rules", hasSize(1)))
                .andExpect(jsonPath("$.rules[0].ruleId", is("R2")))
        ;

	}
}
