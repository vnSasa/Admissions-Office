package ua.yaremechko.admissionsoffice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.yaremechko.admissionsoffice.domain.Entrant;

public interface EntrantRepository extends JpaRepository<Entrant, Integer>{

}
