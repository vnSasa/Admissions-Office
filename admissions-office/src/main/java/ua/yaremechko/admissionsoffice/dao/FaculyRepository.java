package ua.yaremechko.admissionsoffice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.yaremechko.admissionsoffice.domain.Faculty;

public interface FaculyRepository extends JpaRepository<Faculty, Integer> {

}
