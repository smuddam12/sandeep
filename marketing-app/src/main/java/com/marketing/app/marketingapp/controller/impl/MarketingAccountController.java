package com.marketing.app.marketingapp.controller.impl;

import com.marketing.app.marketingapp.controller.AccountController;
import com.marketing.app.marketingapp.models.Account;
import com.marketing.app.marketingapp.service.MarketingAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/marketing-app/accounts")
public class MarketingAccountController implements AccountController {

    private final MarketingAccountService marketingAccountService;

    public MarketingAccountController(final MarketingAccountService marketingAccountService) {
        this.marketingAccountService = marketingAccountService;
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> createAccount(@Valid @RequestBody final Account account) {
        Account createdAccount =  marketingAccountService.saveAccount(account);

        if (null == createdAccount) return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Account>(createdAccount, HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/{accountName}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> readAccount(@PathVariable("accountName") final String companyName) {

        Account retrievedAccount =  marketingAccountService.read(companyName);

        if (null == retrievedAccount) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Account>(retrievedAccount, HttpStatus.OK);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> updateAccount(@Valid @RequestBody final Account account) {

        Account updatedAccount =  marketingAccountService.update(account);

        if (null == updatedAccount) return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Account>(updatedAccount, HttpStatus.OK);
    }

}
