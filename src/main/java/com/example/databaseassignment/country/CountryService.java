package com.example.databaseassignment.country;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {
    List<Country> getAllCountries();

    Country saveCountry(Country country);

    Country getCountryById(String Id);

    Country updateCountry(Country country);

    void deleteCountryById(String id);

}
