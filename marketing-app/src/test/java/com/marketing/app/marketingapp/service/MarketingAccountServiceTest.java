package com.marketing.app.marketingapp.service;

import com.marketing.app.marketingapp.dao.VendorAccountDAO;
import com.marketing.app.marketingapp.entities.VendorAccount;
import com.marketing.app.marketingapp.mapper.AccountMapper;
import com.marketing.app.marketingapp.models.Account;
import com.marketing.app.marketingapp.service.impl.MarketingAccountServiceImpl;
import com.marketing.app.marketingapp.util.TestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class MarketingAccountServiceTest {

    private MarketingAccountServiceImpl marketingAccountService;

    @MockBean
    private VendorAccountDAO vendorAccountDAO;

    private TestDataBuilder dataBuilder;
    private AccountMapper mapper;
    private Account testAccount;
    private VendorAccount vendorAccount;

    @Before
    public void setUp() {
      dataBuilder = new TestDataBuilder();
      mapper = new AccountMapper();
      testAccount = dataBuilder.buildTestAccount();
      vendorAccount = mapper.toModel(testAccount);

      marketingAccountService = new MarketingAccountServiceImpl(vendorAccountDAO);
    }

    @Test
    public void testCreate() {
        Mockito.when(vendorAccountDAO.saveAccount(Mockito.any(VendorAccount.class))).thenReturn(vendorAccount);
        assertEquals("Created Account and Actual test account are not Equal", testAccount,
                marketingAccountService.saveAccount(dataBuilder.buildTestAccount()));

        Mockito.verify(vendorAccountDAO).saveAccount(Mockito.any(VendorAccount.class));
    }


    @Test
    public void testRead() {
        Mockito.when(vendorAccountDAO.findAccountByCompany(Mockito.any(String.class))).thenReturn(vendorAccount);
        assertEquals("Retrieved Account and Actual test account are not Equal",testAccount,
                marketingAccountService.read("Atlassian"));

        Mockito.verify(vendorAccountDAO).findAccountByCompany(Mockito.any(String.class));
    }

    @Test
    public void testUpdate(){
        testAccount.setAddressLine1("123 ABC Street");
        vendorAccount = mapper.toModel(testAccount);

        Mockito.when(vendorAccountDAO.saveAccount(Mockito.any(VendorAccount.class))).thenReturn(vendorAccount);
        assertEquals("Updated Account and Actual test account are not Equal",testAccount,
                marketingAccountService.update(testAccount));

        Mockito.verify(vendorAccountDAO).saveAccount(Mockito.any(VendorAccount.class));
    }
}