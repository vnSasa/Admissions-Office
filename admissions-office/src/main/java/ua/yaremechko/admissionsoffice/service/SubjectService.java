package ua.yaremechko.admissionsoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.yaremechko.admissionsoffice.dao.SubjectRepository;
import ua.yaremechko.admissionsoffice.domain.Subject;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public Subject save(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	public List<Subject> findAll(){
		return subjectRepository.findAll();
	}
}
