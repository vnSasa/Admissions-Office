package ua.yaremechko.admissionsoffice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import ua.yaremechko.admissionsoffice.domain.Entrant;
import ua.yaremechko.admissionsoffice.domain.Faculty;

public interface EntrantRepository extends JpaRepository<Entrant, Integer>{

	@Query("Select e from Entrant e where e.accepted=?1")
	List<Entrant> find(@RequestParam("accepted") boolean accepted);

	@Query("Select e from Entrant e where e.faculty=?1 and e.accepted=true")
	List<Entrant> findByFaculty(@RequestParam("faculty") Faculty faculty);
	
}
