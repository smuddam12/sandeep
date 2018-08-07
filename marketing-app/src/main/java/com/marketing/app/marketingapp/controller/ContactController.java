package com.marketing.app.marketingapp.controller;

import com.marketing.app.marketingapp.models.Contact;

import java.util.List;

public interface ContactController {

    Contact createContact(final Contact contact);
    Contact readContact(final String contactName);
    Contact updateContact(final Contact contact);
    List<Contact> getContacts(final String companyName);
}
