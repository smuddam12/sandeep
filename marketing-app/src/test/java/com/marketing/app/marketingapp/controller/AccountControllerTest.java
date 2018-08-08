package com.marketing.app.marketingapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketing.app.marketingapp.controller.impl.MarketingAccountController;
import com.marketing.app.marketingapp.models.Account;
import com.marketing.app.marketingapp.service.MarketingAccountService;
import com.marketing.app.marketingapp.util.TestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(MarketingAccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @MockBean
    private MarketingAccountService marketingAccountService;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testPostAccount() throws Exception {
        MockHttpServletResponse response = createAccount();
        assertEquals(201, response.getStatus());
    }

    @Test
    public void testPostAccount_With_BadRequest() throws Exception {
        TestDataBuilder dataBuilder = new TestDataBuilder();
        Account account = dataBuilder.buildTestAccount();
        account.setCompanyName(null);
        RequestBuilder requestBuilder = getRequestBuilder(account, MockMvcRequestBuilders
                .post("/marketing-app/accounts"));
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    public void testGetAccount() throws Exception {
        Account createdAccount = getCreatedAccount(createAccount());

        Mockito.when(marketingAccountService.read(Mockito.any(String.class))).thenReturn(createdAccount);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/marketing-app/accounts/" + createdAccount.getCompanyName())
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(200, response.getStatus());
        assertEquals(createdAccount.getAccountId(), getCreatedAccount(response).getAccountId());
    }

    @Test
    public void testGetAccount_With_Entity_Not_Found() throws Exception {

        Mockito.when(marketingAccountService.read(Mockito.any(String.class))).thenReturn(null);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/marketing-app/accounts/" + "testCompany")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(404, response.getStatus());
    }

    @Test
    public void testUpdateAccount() throws Exception {
        Account createdAccount = getCreatedAccount(createAccount());
        createdAccount.setAccountId(234L);

        Mockito.when(marketingAccountService.update(Mockito.any(Account.class))).thenReturn(createdAccount);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/marketing-app/accounts")
                .accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(createdAccount))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(200, response.getStatus());
        assertEquals(createdAccount.getAccountId(), getCreatedAccount(response).getAccountId());
    }

    private Account getCreatedAccount(MockHttpServletResponse response) throws Exception {
        return objectMapper.readValue(response.getContentAsString(), Account.class);
    }

    private MockHttpServletResponse createAccount() throws Exception {
        TestDataBuilder dataBuilder = new TestDataBuilder();
        Account account = dataBuilder.buildTestAccount();

        Mockito.when(marketingAccountService.saveAccount(Mockito.any(Account.class))).thenReturn(account);
        RequestBuilder requestBuilder = getRequestBuilder(account, MockMvcRequestBuilders
                .post("/marketing-app/accounts"));
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        return result.getResponse();

    }

    private MockHttpServletRequestBuilder getRequestBuilder(Account account, MockHttpServletRequestBuilder post) throws JsonProcessingException {
        return post
                .accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(account))
                .contentType(MediaType.APPLICATION_JSON);
    }

}
