package com.marketing.app.marketingapp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Vendor_Contact")
public class VendorContact implements Serializable {

    @Id @GeneratedValue
    @Column(name = "Contact_Id", unique = true, nullable = false)
    private Long contactId;

    @Column(name = "Name", unique = true, nullable = false)
    private String name;

    @Column(name = "Email_Address", unique = true, nullable = false)
    private String emailAddress;

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

    @Column(name = "Company_Name")
    private String companyName;

   /* @OneToOne(cascade = CascadeType.ALL)
    private VendorAccount vendorAccount;*/

    public VendorContact() {}

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

 /*   public VendorAccount getVendorAccount() {
        return vendorAccount;
    }

    public void setVendorAccount(VendorAccount vendorAccount) {
        this.vendorAccount = vendorAccount;
    }*/
}
