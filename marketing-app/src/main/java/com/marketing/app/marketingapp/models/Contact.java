package com.marketing.app.marketingapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NotNull
@JsonPropertyOrder({"contactId","name","emailAddress","addressLine1", "addressLine2",
        "city", "state", "postalCode","country","companyName"})
public class Contact implements Serializable  {

    private static final Long serialVersionUID = 1L;

    @JsonProperty(value = "contactId")
    private Long contactId;

    @NotNull
    @NotBlank
    @JsonProperty(value = "name", required = true)
    private String name;

    @NotNull
    @NotBlank
    @JsonProperty(value = "emailAddress", required = true)
    private String emailAddress;

    @JsonProperty("addressLine1")
    private String addressLine1;

    @JsonProperty("addressLine2")
    private String addressLine2;

    @NotNull
    @NotBlank
    @JsonProperty(value = "city", required = true)
    private String city;

    @NotNull
    @NotBlank
    @JsonProperty(value = "state", required = true)
    private String state;

    @NotNull
    @NotBlank
    @JsonProperty(value = "postalCode",required = true)
    private String postalCode;

    @NotNull
    @NotBlank
    @JsonProperty(value = "country", required = true)
    private String country;

    @JsonProperty(value = "companyName")
    private String companyName;

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

    @Override
    public boolean equals(Object contact) {
        Contact contacts = (Contact) contact;
        return getContactId().equals(contacts.getContactId());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
