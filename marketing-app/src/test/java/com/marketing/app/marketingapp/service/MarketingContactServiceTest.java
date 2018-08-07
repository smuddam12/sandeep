package com.marketing.app.marketingapp.service;

import com.marketing.app.marketingapp.dao.VendorContactDAO;
import com.marketing.app.marketingapp.entities.VendorAccount;
import com.marketing.app.marketingapp.entities.VendorContact;
import com.marketing.app.marketingapp.mapper.AccountMapper;
import com.marketing.app.marketingapp.mapper.ContactMapper;
import com.marketing.app.marketingapp.models.Account;
import com.marketing.app.marketingapp.models.Contact;
import com.marketing.app.marketingapp.service.impl.MarketingContactServiceImpl;
import com.marketing.app.marketingapp.util.TestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class MarketingContactServiceTest {

    @MockBean
    private VendorContactDAO vendorContactDAO;

    private Contact testContact;
    private Account testAccount;
    private VendorAccount testVendorAccount;
    private VendorContact vendorContact;
    private TestDataBuilder testDataBuilder;
    private ContactMapper mapper;
    private AccountMapper accountMapper;
    private MarketingContactService marketingContactService;

    @Before
    public void setUp() {
        testDataBuilder = new TestDataBuilder();
        mapper = new ContactMapper();
        accountMapper = new AccountMapper();

        testContact = testDataBuilder.buildTestContact();
        vendorContact = mapper.toModel(testContact);

        testAccount = testDataBuilder.buildTestAccount();
        testVendorAccount = accountMapper.toModel(testAccount);

        marketingContactService = new MarketingContactServiceImpl(vendorContactDAO);
    }

    @Test
    public void testCreate() {

        Mockito.when(vendorContactDAO.saveContact(Mockito.any(VendorContact.class))).thenReturn(vendorContact);
        Mockito.when(vendorContactDAO.findAccountByName(Mockito.any(String.class))).thenReturn(testVendorAccount);
        assertEquals("Created Contact and Actual testContact are not Equal",
                testContact, marketingContactService.saveContact(testContact));

        Mockito.verify(vendorContactDAO).saveContact(Mockito.any(VendorContact.class));
    }

    @Test
    public void testRead() {
        Mockito.when(vendorContactDAO.findContactByName(Mockito.any(String.class))).thenReturn(vendorContact);
        assertEquals("Retrieved Contact and Actual testContact are not Equal",testContact,
                marketingContactService.read("Test-User"));

        Mockito.verify(vendorContactDAO).findContactByName(Mockito.any(String.class));
    }

    @Test
    public void testUpdate(){
        testContact.setEmailAddress("abc@mail.com");
        vendorContact = mapper.toModel(testContact);

        Mockito.when(vendorContactDAO.saveContact(Mockito.any(VendorContact.class))).thenReturn(vendorContact);
        assertEquals("Updated Contact and Actual testContact are not Equal",testContact,
                marketingContactService.update(testContact));

        Mockito.verify(vendorContactDAO).saveContact(Mockito.any(VendorContact.class));
    }

    @Test
    public void testGetAllContacts() {
        List<Contact> testContactList = new ArrayList<>();
        List<VendorContact> testVendorContacts = new ArrayList<>();

        testDataBuilder.buildDataSets(testContactList, testVendorContacts);

        Mockito.when(vendorContactDAO.findContacts(Mockito.any(String.class))).thenReturn(testVendorContacts);

        assertEquals(testContactList, marketingContactService.getContacts(testAccount.getCompanyName()));
    }
}