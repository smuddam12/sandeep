package com.marketing.app.marketingapp.service;

import com.marketing.app.marketingapp.models.Contact;

import java.util.List;

public interface MarketingContactService {

    Contact saveContact(final Contact contact);
    Contact read(final String contactName);
    Contact update(final Contact contact);
    List<Contact> getContacts(final String companyName);
}
