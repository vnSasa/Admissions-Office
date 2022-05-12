package ua.yaremechko.admissionsoffice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.yaremechko.admissionsoffice.domain.Entrant;
import ua.yaremechko.admissionsoffice.domain.Faculty;
import ua.yaremechko.admissionsoffice.domain.Subject;
import ua.yaremechko.admissionsoffice.domain.User;
import ua.yaremechko.admissionsoffice.service.EntrantService;
import ua.yaremechko.admissionsoffice.service.FacultyService;
import ua.yaremechko.admissionsoffice.service.SubjectService;
import ua.yaremechko.admissionsoffice.service.UserService;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EntrantService entrantsService;
	
	@Autowired
	private SubjectService subjectService;

	@GetMapping("/entrantRegistration")
	public ModelAndView entrantRegistration(@RequestParam("facultyId") Integer id, @RequestParam("email") String email) {
		User user = userService.findByEmail(email);
		Faculty faculty = facultyService.findById(id);
		Entrant entrant = new Entrant();
		entrant.setUser(user);
		entrant.setFaculty(faculty);
		ModelAndView map = new ModelAndView("entrantRegistration");
		map.addObject("entrant", entrant);
		return map;
	}
	
	@PostMapping("/entrantRegistration")
	public String saveEntrant(@RequestParam Integer facultyId, @RequestParam String email, @RequestParam List<Integer> marks, @RequestParam MultipartFile image) throws IOException {
		
		User user = userService.findByEmail(email);
		Faculty faculty = facultyService.findById(facultyId);
		List<Subject> listOfSubjects = new ArrayList<>();
		for (int i = 0; i<marks.size(); i++) {
			Subject subject = new Subject();
			subject.setNameOfSubject(faculty.getRequiredSubjects().get(i));
			subject.setMark(marks.get(i));
			subjectService.save(subject);
			listOfSubjects.add(subject);
		}
		Entrant entrant = new Entrant(image, user, faculty, listOfSubjects);
		entrantsService.save(entrant);
		return "redirect:/home";	
		
	}

}
