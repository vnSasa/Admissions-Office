package ua.yaremechko.admissionsoffice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.yaremechko.admissionsoffice.domain.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
