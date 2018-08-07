package com.marketing.app.marketingapp.repository;

import com.marketing.app.marketingapp.entities.VendorAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorAccountRepository extends CrudRepository<VendorAccount, Long> {

    VendorAccount findByCompanyName(final String companyName);
}
