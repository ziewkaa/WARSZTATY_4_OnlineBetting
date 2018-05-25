package pl.coderslab.betting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.betting.entity.League;

public interface LeagueRepository extends JpaRepository<League,Long> {
}
