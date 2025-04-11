package dev.tau.countrydata;

import dev.tau.countrydata.entity.Country;
import dev.tau.countrydata.repository.CountryRepository;
import dev.tau.countrydata.rest.CountryRestController;
import dev.tau.countrydata.service.CountryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CountryRestControllerTest {

    @Mock
    private CountryRepository countryRepository;  // Mock CountryRepository

    @Mock
    private CountryService countryService;  // Mock CountryService

    @InjectMocks
    private CountryRestController countryRestController;  // Inject mocks to the controller

    @Test
    public void testGetAllCountries() {
        // Test data
        Country country1 = new Country(
                "FIN",               // code
                "FI",                // code2
                1,                   // capital (just an example ID)
                "Alexander Stubb",   // headOfState
                "Republic",          // governmentForm
                "Suomi",             // localName
                270000.0,            // gnpOld
                300000.0,            // gnp
                5560000,             // population
                82.5,                // lifeExpectancy
                1917,                // indepYear
                338424.0,            // surfaceArea
                "Nordic Countries",  // region
                "Europe",            // continent
                "Finland"            // name
        );

        Country country2 = new Country(
                "SE",                // code
                "SE",                // code2
                2,                   // capital (just an example ID)
                "Carl XVI Gustaf",   // headOfState
                "Monarchy",          // governmentForm
                "Sverige",           // localName
                130000.0,            // gnpOld
                150000.0,            // gnp
                10000000,            // population
                81.0,                // lifeExpectancy
                1520,                // indepYear
                450295.0,            // surfaceArea
                "Scandinavia",       // region
                "Europe",            // continent
                "Sweden"             // name
        );

        List<Country> countries = Arrays.asList(country1, country2);

        // Mock service method call to return the countries list
        when(countryService.getAllCountries()).thenReturn(countries);

        // Call the controller method
        List<Country> result = countryRestController.getAllCountries();

        // Verify results
        assertEquals(2, result.size());
        assertEquals("FIN", result.get(0).getCode());
        assertEquals("SE", result.get(1).getCode());
    }
}
