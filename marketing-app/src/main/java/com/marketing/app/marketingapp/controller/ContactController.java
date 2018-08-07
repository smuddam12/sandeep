package com.marketing.app.marketingapp.controller;

import com.marketing.app.marketingapp.models.Contact;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactController {

    ResponseEntity<Contact> createContact(final Contact contact);
    ResponseEntity<Contact> readContact(final String contactName);
    ResponseEntity<Contact> updateContact(final Contact contact);
    ResponseEntity<List<Contact>> getContacts(final String companyName);
}
