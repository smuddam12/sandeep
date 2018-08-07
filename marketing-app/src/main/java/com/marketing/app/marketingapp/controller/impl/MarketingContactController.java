package com.marketing.app.marketingapp.controller.impl;

import com.marketing.app.marketingapp.controller.ContactController;
import com.marketing.app.marketingapp.models.Contact;
import com.marketing.app.marketingapp.service.MarketingContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/marketing-app/contacts")
public class MarketingContactController implements ContactController {

    private final MarketingContactService marketingContactService;

    public MarketingContactController(final MarketingContactService marketingContactService) {
        this.marketingContactService = marketingContactService;
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> createContact(@Valid @RequestBody final Contact contact) {

        Contact createdContact =  marketingContactService.saveContact(contact);

        if (null == createdContact) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Contact>(createdContact, HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/{contact}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> readContact(@PathVariable("contact") final String contactName) {
        Contact readContact =  marketingContactService.read(contactName);

        if (null == readContact) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Contact>(readContact, HttpStatus.OK);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> updateContact(@Valid @RequestBody final Contact contact) {

        Contact updatedContact =  marketingContactService.update(contact);

        if (null == updatedContact) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(updatedContact, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/company/{companyName}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contact>> getContacts(@PathVariable("companyName") final String companyName) {

        List<Contact> contactsRetrieved =  marketingContactService.getContacts(companyName);

        if (null == contactsRetrieved || contactsRetrieved.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(contactsRetrieved, HttpStatus.OK);
    }
}
