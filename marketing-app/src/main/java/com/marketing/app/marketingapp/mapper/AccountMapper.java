package com.marketing.app.marketingapp.mapper;

import com.marketing.app.marketingapp.entities.VendorAccount;
import com.marketing.app.marketingapp.models.Account;

public class AccountMapper {

    public Account toDto(VendorAccount model) {
        if (null == model) return null;

        Account dto = new Account();

        dto.setAccountId(model.getAccountId());
        dto.setCompanyName(model.getCompanyName());
        dto.setAddressLine1(model.getAddressLine1());
        dto.setAddressLine2(model.getAddressLine2());
        dto.setPostalCode(model.getPostalCode());
        dto.setCity(model.getCity());
        dto.setState(model.getState());
        dto.setCountry(model.getCountry());

        return dto;
    }

    public VendorAccount toModel(Account dto) {
        if (null == dto) return null;

        VendorAccount model = new VendorAccount();

        model.setAccountId(dto.getAccountId());
        model.setCompanyName(dto.getCompanyName());
        model.setAddressLine1(dto.getAddressLine1());
        model.setAddressLine2(dto.getAddressLine2());
        model.setPostalCode(dto.getPostalCode());
        model.setCity(dto.getCity());
        model.setState(dto.getState());
        model.setCountry(dto.getCountry());

        return model;
    }
}
