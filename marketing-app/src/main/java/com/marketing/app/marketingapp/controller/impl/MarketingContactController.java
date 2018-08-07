package com.marketing.app.marketingapp.controller.impl;

import com.marketing.app.marketingapp.controller.ContactController;
import com.marketing.app.marketingapp.models.Contact;
import com.marketing.app.marketingapp.service.MarketingContactService;
import org.springframework.http.MediaType;
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
    public Contact createContact(@Valid @RequestBody final Contact contact) {
        return marketingContactService.saveContact(contact);
    }

    @Override
    @RequestMapping(value = "/{contact}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Contact readContact(@PathVariable("contact") final String contactName) {
        return marketingContactService.read(contactName);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Contact updateContact(@Valid @RequestBody final Contact contact) {
        return marketingContactService.update(contact);
    }

    @Override
    @RequestMapping(value = "/company/{companyName}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> getContacts(@PathVariable("companyName") final String companyName) {
        return marketingContactService.getContacts(companyName);
    }
}
