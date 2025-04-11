package dev.tau.countrydata.service;

import dev.tau.countrydata.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country getCountryByCode(String code);
}

