package ua.yaremechko.admissionsoffice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.yaremechko.admissionsoffice.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	
}
