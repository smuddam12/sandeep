package com.marketing.app.marketingapp.controller;

import com.marketing.app.marketingapp.models.Account;

public interface AccountController {

    Account createAccount(final Account account);
    Account readAccount(final String company);
    Account updateAccount(final Account account);
}
