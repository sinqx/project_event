package kg.itacademy.demo.repository;

import kg.itacademy.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByFullName(String username);
    Optional<User> findByEmail(String username);
    Optional<User> findByFullNameLikeIgnoringCase(String username);
}
