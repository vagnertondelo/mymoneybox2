package com.adaptaconsultoria.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account extends Token {
    private String countryIsoCode;
    private String accountNo; 
    private String taxid; 
    private String personalValue;
    private String earningValue; 
    private String returnedValue; 
    private String accountSponsorAccount; 
    private String currency;
    private String address;
    private String addressCountryIsoCode;
    private String addressRegionCode;
    private String addressCityCode;

    private String addressNumber;

    private String addressDistrict;
    private String addressZipcode;
    private String addressLat;
    private String addressLng;
    private String addressGeoinformation;
}

