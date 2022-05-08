package ua.yaremechko.admissionsoffice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.yaremechko.admissionsoffice.domain.Statement;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Integer> {

}
