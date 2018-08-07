package com.marketing.app.marketingapp.service.impl;

import com.marketing.app.marketingapp.dao.VendorContactDAO;
import com.marketing.app.marketingapp.entities.VendorAccount;
import com.marketing.app.marketingapp.entities.VendorContact;
import com.marketing.app.marketingapp.mapper.ContactMapper;
import com.marketing.app.marketingapp.models.Contact;
import com.marketing.app.marketingapp.service.MarketingContactService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketingContactServiceImpl implements MarketingContactService {

    private final VendorContactDAO vendorContactDAO;
    private final ContactMapper  mapper;

    public MarketingContactServiceImpl(final VendorContactDAO vendorContactDAO) {
        this.vendorContactDAO = vendorContactDAO;
        this.mapper = new ContactMapper();
    }

    @Override
    public Contact saveContact(Contact contact) {
        VendorContact vendorContact = mapper.toModel(contact);
        VendorAccount retrievedAccount = getRetrievedAccount(vendorContact);

        VendorContact contactCreated = vendorContactDAO.saveContact(vendorContact);

        addContactToAccount(retrievedAccount, contactCreated);

        return mapper.toDto(contactCreated);
    }

    @Override
    public Contact read(String contactName) {
        VendorContact contactRetrieved = vendorContactDAO.findContactByName(contactName);

        return mapper.toDto(contactRetrieved);
    }

    @Override
    public Contact update(final Contact contact) {
        return saveContact(contact);
    }

    @Override
    public List<Contact> getContacts(final String companyName) {
        List<VendorContact> vendorContacts = vendorContactDAO.findContacts(companyName);
        ContactMapper contactMapper = new ContactMapper();

        List<Contact> contactList = new ArrayList<>();

        for (VendorContact vendorContact : vendorContacts) {
            contactList.add(contactMapper.toDto(vendorContact));
        }

        return contactList;
    }

    private void addContactToAccount(VendorAccount retrievedAccount, VendorContact vendorContact) {
        if (null != retrievedAccount) {
            retrievedAccount.getAccount_contacts().add(vendorContact);
            vendorContactDAO.saveAccount(retrievedAccount);
        }
    }

    private VendorAccount getRetrievedAccount(VendorContact vendorContact) {
        return (null != vendorContact.getCompanyName()) ?
                vendorContactDAO.findAccountByName(vendorContact.getCompanyName()): null;
    }
}
