package com.marketing.app.marketingapp.dao;

import com.marketing.app.marketingapp.entities.VendorAccount;
import com.marketing.app.marketingapp.entities.VendorContact;

import java.util.List;

public interface VendorContactDAO {

    VendorContact saveContact(final VendorContact vendorContact);
    VendorContact findContactByName(final String contactName);
    VendorAccount findAccountByName(final String companyName);
    VendorAccount saveAccount(final VendorAccount vendorAccount);
    List<VendorContact> findContacts(final String companyName);
}
