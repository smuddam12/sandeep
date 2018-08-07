package com.marketing.app.marketingapp.dao.impl;

import com.marketing.app.marketingapp.dao.VendorContactDAO;
import com.marketing.app.marketingapp.entities.VendorAccount;
import com.marketing.app.marketingapp.entities.VendorContact;
import com.marketing.app.marketingapp.repository.VendorAccountRepository;
import com.marketing.app.marketingapp.repository.VendorContactRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendorContactDAOImpl implements VendorContactDAO {

    private final VendorContactRepository vendorContactRepository;
    private final VendorAccountRepository vendorAccountRepository;

    public VendorContactDAOImpl(final VendorContactRepository vendorContactRepository,
                                final VendorAccountRepository vendorAccountRepository) {
        this.vendorContactRepository = vendorContactRepository;
        this.vendorAccountRepository = vendorAccountRepository;
    }

    @Override
    public VendorContact saveContact(final VendorContact vendorContact) {
        return vendorContactRepository.save(vendorContact);
    }

    @Override
    public VendorContact findContactByName(final String contactName) {
        return vendorContactRepository.findByName(contactName);
    }

    @Override
    public VendorAccount findAccountByName(final String companyName) {
        return vendorAccountRepository.findByCompanyName(companyName);
    }

    @Override
    public List<VendorContact> findContacts(final String companyName) {
        return vendorContactRepository.findAllByCompanyName(companyName);
    }

    @Override
    public VendorAccount saveAccount(final VendorAccount vendorAccount) {
        return vendorAccountRepository.save(vendorAccount);
    }
}
