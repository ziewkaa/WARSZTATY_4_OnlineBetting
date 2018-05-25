package pl.coderslab.betting.service;

import pl.coderslab.betting.entity.Country;

import java.util.List;

public interface CountryService {

    void saveCountry(Country country);

    List<Country> findAllCountries();
}
