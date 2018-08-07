package com.marketing.app.marketingapp.dao.impl;

import com.marketing.app.marketingapp.dao.VendorAccountDAO;
import com.marketing.app.marketingapp.entities.VendorAccount;
import com.marketing.app.marketingapp.repository.VendorAccountRepository;
import org.springframework.stereotype.Component;

@Component
public class VendorAccountDAOImpl implements VendorAccountDAO {

    private final VendorAccountRepository vendorAccountRepository;

    public VendorAccountDAOImpl(final VendorAccountRepository vendorAccountRepository) {
        this.vendorAccountRepository = vendorAccountRepository;
    }

    @Override
    public VendorAccount saveAccount(final VendorAccount vendorAccount) {
        return vendorAccountRepository.save(vendorAccount);
    }

    @Override
    public VendorAccount findAccountByCompany(final String companyName) {
        return vendorAccountRepository.findByCompanyName(companyName);
    }
}
