package com.adaptaconsultoria.objects.in;

import java.util.List;

import com.adaptaconsultoria.models.Category;
import com.adaptaconsultoria.models.Rule;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Seller {
	
        private String code; 
        private String name;
        private String description;
        private String url; 
        private String email; 
        private String phone;
        private Category partnerCategory; 
        private Category sellerCategory; 
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
        private List<Rule> rules;
        
        // future partner array
}
