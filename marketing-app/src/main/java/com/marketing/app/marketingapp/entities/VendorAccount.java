package com.marketing.app.marketingapp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Vendor_Account")
public class VendorAccount implements Serializable {

    @Id @GeneratedValue
    @Column(name = "Account_Id", unique = true, nullable = false)
    private Long accountId;

    @Column(name = "Company_Name", unique = true, nullable = false)
    private String companyName;

    @Column(name = "Address_Line1")
    private String addressLine1;

    @Column(name = "Address_Line2")
    private String addressLine2;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "State", nullable = false)
    private String state;

    @Column(name = "Postal_Code", nullable = false)
    private String postalCode;

    @Column(name = "Country", nullable = false)
    private String country;

    @OneToMany
    @JoinTable(
            name = "Account_Contact",
            joinColumns = {@JoinColumn(name = "Account_Id")},
            inverseJoinColumns = {@JoinColumn(name = "Contact_Id")}
    )
    private Set<VendorContact> vendorContacts;

    public VendorAccount() {
        vendorContacts = new HashSet<>();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<VendorContact> getAccount_contacts() {
        return vendorContacts;
    }

    public void setAccount_contacts(Set<VendorContact> vendorContacts) {
        this.vendorContacts = vendorContacts;
    }

}
