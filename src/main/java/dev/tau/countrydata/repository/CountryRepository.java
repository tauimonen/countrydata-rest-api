package dev.tau.countrydata.repository;

import dev.tau.countrydata.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}

