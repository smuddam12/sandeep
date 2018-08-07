package com.marketing.app.marketingapp.repository;

import com.marketing.app.marketingapp.entities.VendorContact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VendorContactRepository extends CrudRepository<VendorContact, Long> {

    VendorContact findByName(final String contactName);
    List<VendorContact> findAllByCompanyName(final String companyName);
}
