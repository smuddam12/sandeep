package com.marketing.app.marketingapp.mapper;

import com.marketing.app.marketingapp.entities.VendorContact;
import com.marketing.app.marketingapp.models.Contact;

public class ContactMapper {

    public Contact toDto(VendorContact model) {

        if (null == model) return null;

        Contact dTo = new Contact();

        dTo.setContactId(model.getContactId());
        dTo.setName(model.getName());
        dTo.setAddressLine1(model.getAddressLine1());
        dTo.setAddressLine2(model.getAddressLine2());
        dTo.setEmailAddress(model.getEmailAddress());
        dTo.setCity(model.getCity());
        dTo.setState(model.getState());
        dTo.setPostalCode(model.getPostalCode());
        dTo.setCountry(model.getCountry());
        dTo.setCompanyName(model.getCompanyName());

        return dTo;
    }

    public VendorContact toModel(Contact dTo) {
        if (null == dTo) return null;

        VendorContact model = new VendorContact();

        model.setContactId(dTo.getContactId());
        model.setName(dTo.getName());
        model.setAddressLine1(dTo.getAddressLine1());
        model.setAddressLine2(dTo.getAddressLine2());
        model.setEmailAddress(dTo.getEmailAddress());
        model.setCity(dTo.getCity());
        model.setState(dTo.getState());
        model.setPostalCode(dTo.getPostalCode());
        model.setCountry(dTo.getCountry());
        model.setCompanyName(dTo.getCompanyName());

        return model;
    }
}
