package com.marketing.app.marketingapp.controller;

import com.marketing.app.marketingapp.models.Account;
import org.springframework.http.ResponseEntity;

public interface AccountController {

    ResponseEntity<Account> createAccount(final Account account);
    ResponseEntity<Account> readAccount(final String company);
    ResponseEntity<Account> updateAccount(final Account account);
}
