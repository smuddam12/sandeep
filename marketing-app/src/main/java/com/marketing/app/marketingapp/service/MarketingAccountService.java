package com.marketing.app.marketingapp.service;

import com.marketing.app.marketingapp.models.Account;

public interface MarketingAccountService {

    Account saveAccount(final Account account);
    Account read(final String companyName);
    Account update(final Account account);
}
