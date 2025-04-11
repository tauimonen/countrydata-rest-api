package dev.tau.countrydata.service;

import dev.tau.countrydata.entity.Country;
import dev.tau.countrydata.repository.CountryRepository;
import dev.tau.countrydata.rest.CountryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryByCode(String code) {
        return countryRepository.findById(code)
                .orElseThrow(() -> new CountryNotFoundException("Country with code " + code + " not found"));
    }
}

