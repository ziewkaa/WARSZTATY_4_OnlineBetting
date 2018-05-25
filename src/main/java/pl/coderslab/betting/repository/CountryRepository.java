package pl.coderslab.betting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.betting.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
