package com.myloginapp.login_backend;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// This interface extends JpaRepository, making it a Spring Data JPA repository.
// JpaRepository<User, Long> means:
// - User: The entity type this repository will manage (our User class).
// - Long: The data type of the entity's primary key (our User's 'id' is a Long).

public interface UserRepository extends JpaRepository<User, Long>{

    // Spring Data JPA will automatically implement this method for you.
    // It will generate the SQL query: SELECT * FROM users WHERE username = ?
    Optional<User> findByUsername(String username);

}
