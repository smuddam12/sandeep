package com.marketing.app.marketingapp.util;

import com.marketing.app.marketingapp.entities.VendorContact;
import com.marketing.app.marketingapp.models.Account;
import com.marketing.app.marketingapp.models.Contact;

import java.util.List;

public class TestDataBuilder {

    public Account buildTestAccount() {
        Account account = new Account();

        account.setAccountId(123L);
        account.setCompanyName("Atlassian");
        account.setAddressLine1("1 Atlassian Way");
        account.setAddressLine2("Buliding 100");
        account.setCity("San Francisco");
        account.setState("California");
        account.setCountry("USA");
        account.setPostalCode("123456-5678");

        return account;
    }

    public Contact buildTestContact() {
        Contact contact = new Contact();

        contact.setContactId(123L);
        contact.setName("Test-User");
        contact.setEmailAddress("test@mail.com");
        contact.setCompanyName("Atlassian");
        contact.setAddressLine1("1 Atlassian Way");
        contact.setAddressLine2("Buliding 100");
        contact.setCity("San Francisco");
        contact.setState("California");
        contact.setCountry("USA");
        contact.setPostalCode("123456-5678");

        return contact;
    }

    public VendorContact buildVendorContact() {
        VendorContact vendorContact = new VendorContact();

        vendorContact.setContactId(123L);
        vendorContact.setName("Test-User");
        vendorContact.setCompanyName("Atlassian");
        vendorContact.setAddressLine1("1 Atlassian Way");
        vendorContact.setAddressLine2("Buliding 100");
        vendorContact.setCity("San Francisco");
        vendorContact.setState("California");
        vendorContact.setCountry("USA");
        vendorContact.setPostalCode("123456-5678");

        return vendorContact;
    }

    public void buildDataSets(List<Contact> contacts, List<VendorContact> vendorContacts) {

        for (int i =0; i<3; i++) {
            Contact contact = buildTestContact();
            contact.setContactId(contact.getContactId()+1);

            VendorContact vendorContact = buildVendorContact();
            vendorContact.setContactId(vendorContact.getContactId()+1);

            vendorContacts.add(vendorContact);
            contacts.add(contact);
        }
    }

}
