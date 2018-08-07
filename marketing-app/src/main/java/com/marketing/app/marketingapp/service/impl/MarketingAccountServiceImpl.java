package com.marketing.app.marketingapp.service.impl;

import com.marketing.app.marketingapp.dao.VendorAccountDAO;
import com.marketing.app.marketingapp.entities.VendorAccount;
import com.marketing.app.marketingapp.mapper.AccountMapper;
import com.marketing.app.marketingapp.models.Account;
import com.marketing.app.marketingapp.service.MarketingAccountService;
import org.springframework.stereotype.Service;

@Service
public class MarketingAccountServiceImpl implements MarketingAccountService {

    private final VendorAccountDAO vendorAccountDAO;
    private final AccountMapper mapper;

    public MarketingAccountServiceImpl(final VendorAccountDAO vendorAccountDAO) {
        this.vendorAccountDAO = vendorAccountDAO;
        this.mapper = new AccountMapper();
    }

    @Override
    public Account saveAccount(final Account account) {
        VendorAccount vendorAccount = mapper.toModel(account);
        VendorAccount createdVendorAccount = vendorAccountDAO.saveAccount(vendorAccount);
        return mapper.toDto(createdVendorAccount);
    }

    @Override
    public Account read(final String companyName) {
        VendorAccount accountRetrieved =  vendorAccountDAO.findAccountByCompany(companyName);
        return mapper.toDto(accountRetrieved);
    }

    @Override
    public Account update(final Account account) {
        return saveAccount(account);
    }

}
