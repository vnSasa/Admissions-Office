package ua.yaremechko.admissionsoffice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.yaremechko.admissionsoffice.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByEmail(String email);
	
}
