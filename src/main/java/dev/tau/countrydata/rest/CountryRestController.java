package dev.tau.countrydata.rest;

import dev.tau.countrydata.entity.Country;
import dev.tau.countrydata.repository.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CountryRestController {

    private final CountryRepository countryRepository;

    public CountryRestController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @GetMapping("/countries/{countryCode}")
    public ResponseEntity<Country> getCountryByCountryCode(@PathVariable String countryCode) {
        Country country = countryRepository.findById(countryCode)
                .orElseThrow(() -> new CountryNotFoundException("Country with code " + countryCode + " not found"));

        return ResponseEntity.ok(country);
    }

}
