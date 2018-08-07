package com.marketing.app.marketingapp.dao;

import com.marketing.app.marketingapp.entities.VendorAccount;

public interface VendorAccountDAO {

    VendorAccount saveAccount(final VendorAccount vendorAccount);
    VendorAccount findAccountByCompany(final String companyName);
}
