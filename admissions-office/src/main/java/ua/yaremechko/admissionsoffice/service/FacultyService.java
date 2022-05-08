package ua.yaremechko.admissionsoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.yaremechko.admissionsoffice.dao.FacultyRepository;
import ua.yaremechko.admissionsoffice.domain.Faculty;

@Service
public class FacultyService {
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	public List<Faculty> findAllFaculties(){
		return facultyRepository.findAll();
	} 
	
	public Faculty findById(Integer id) {
		return facultyRepository.findById(id).get();
	}
}
