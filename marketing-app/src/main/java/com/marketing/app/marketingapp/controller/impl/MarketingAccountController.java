package com.marketing.app.marketingapp.controller.impl;

import com.marketing.app.marketingapp.controller.AccountController;
import com.marketing.app.marketingapp.models.Account;
import com.marketing.app.marketingapp.service.MarketingAccountService;
import org.springframework.http.MediaType;
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
    public Account createAccount(@Valid @RequestBody final Account account) {
        return marketingAccountService.saveAccount(account);
    }

    @Override
    @RequestMapping(value = "/{accountName}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Account readAccount(@PathVariable("accountName") final String companyName) {
        return marketingAccountService.read(companyName);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Account updateAccount(@Valid @RequestBody final Account account) {
        return marketingAccountService.update(account);
    }

}
