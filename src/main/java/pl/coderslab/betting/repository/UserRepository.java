package pl.coderslab.betting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.betting.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
