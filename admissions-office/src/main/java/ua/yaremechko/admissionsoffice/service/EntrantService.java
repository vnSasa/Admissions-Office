package ua.yaremechko.admissionsoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.yaremechko.admissionsoffice.dao.EntrantRepository;
import ua.yaremechko.admissionsoffice.domain.Entrant;

@Service
public class EntrantService {
	
	@Autowired
	private EntrantRepository entrantRepository;
	
	public Entrant save(Entrant entrant) {
		return entrantRepository.save(entrant);
	}
	
	public List<Entrant> getAllEntrants(){
		return entrantRepository.findAll();
	}
}
