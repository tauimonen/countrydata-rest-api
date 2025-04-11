package dev.tau.countrydata;

import dev.tau.countrydata.entity.Country;
import dev.tau.countrydata.rest.CountryNotFoundException;
import dev.tau.countrydata.repository.CountryRepository;
import dev.tau.countrydata.service.CountryService;
import dev.tau.countrydata.service.CountryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class CountryServiceImplTest {

    private CountryRepository countryRepository;
    private CountryService countryService;
    private Country country1;

    @BeforeEach
    void setUp() {
        countryRepository = mock(CountryRepository.class);
        countryService = new CountryServiceImpl(countryRepository);

        country1 = new Country(
                "FIN",               // code
                "FI",               // code2
                1,                  // capital (just an example ID)
                "Alexander Stubb",  // headOfState
                "Republic",         // governmentForm
                "Suomi",            // localName
                270000.0,           // gnpOld
                300000.0,           // gnp
                5560000,            // population
                82.5,               // lifeExpectancy
                1917,               // indepYear
                338424.0,           // surfaceArea
                "Nordic Countries", // region
                "Europe",           // continent
                "Finland"           // name
        );
    }

    @Test
    void testGetCountryByCode_ReturnsCountry() {
        when(countryRepository.findById("FIN")).thenReturn(Optional.of(country1));

        Country result = countryService.getCountryByCode("FIN");

        assertNotNull(result);
        assertEquals("Finland", result.getName());
        assertEquals("FIN", result.getCode());
        verify(countryRepository, times(1)).findById("FIN");
    }

    @Test
    void testGetCountryByCode_ThrowsCountryNotFoundException() {
        when(countryRepository.findById("XX")).thenReturn(Optional.empty());

        assertThrows(CountryNotFoundException.class, () -> {
            countryService.getCountryByCode("XX");
        });

        verify(countryRepository, times(1)).findById("XX");
    }
}
