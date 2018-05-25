package pl.coderslab.betting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.betting.entity.Team;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
