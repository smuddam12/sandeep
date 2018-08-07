package com.marketing.app.marketingapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NotNull
@JsonPropertyOrder({"accountId","companyName","addressLine1", "addressLine2",
        "city", "state", "postalCode","country"})
public class Account implements Serializable {

    private static final Long serialVersionUID = 1L;

    @JsonProperty(value = "accountId")
    private Long accountId;

    @NotNull
    @NotBlank
    @JsonProperty(value = "companyName", required = true)
    private String companyName;

    @JsonProperty("addressLine1")
    private String addressLine1;

    @JsonProperty("addressLine2")
    private String addressLine2;

    @NotNull
    @NotBlank
    @JsonProperty(value = "city", required = true)
    private String city;

    @NotNull @NotBlank
    @JsonProperty(value = "state", required = true)
    private String state;

    @NotNull
    @NotBlank
    @JsonProperty(value = "postalCode", required = true)
    private String postalCode;

    @NotNull
    @NotBlank
    @JsonProperty(value = "country", required = true)
    private String country;

    public Account() {};

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

    @Override
    public boolean equals(Object account) {
        Account accounts = (Account) account;
        return getCompanyName().equals(accounts.getCompanyName());
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", companyName='" + companyName + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
