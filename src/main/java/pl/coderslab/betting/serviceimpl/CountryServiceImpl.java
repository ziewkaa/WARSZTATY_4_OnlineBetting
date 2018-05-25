package pl.coderslab.betting.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.betting.entity.Country;
import pl.coderslab.betting.repository.CountryRepository;
import pl.coderslab.betting.service.CountryService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void saveCountry(Country country) {
        countryRepository.save(country);

    }

    @Override
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }
}
