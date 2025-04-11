package dev.tau.countrydata.rest;

import dev.tau.countrydata.entity.Country;
import dev.tau.countrydata.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/countries/{countryCode}")
    public ResponseEntity<Country> getCountryByCountryCode(@PathVariable String countryCode) {
        Country country = countryService.getCountryByCode(countryCode);
        return ResponseEntity.ok(country);
    }
}
