package pl.coderslab.betting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.betting.entity.Sport;

public interface SportRepository extends JpaRepository<Sport,Long> {


}
