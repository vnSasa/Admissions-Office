package ua.yaremechko.admissionsoffice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.yaremechko.admissionsoffice.dao.UserRepository;
import ua.yaremechko.admissionsoffice.domain.User;
import ua.yaremechko.admissionsoffice.domain.UserRole;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setConfirmPassword(bCryptPasswordEncoder.encode(user.getConfirmPassword()));
		user.setRole(UserRole.ROLE_ENTRANT);
		userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).get();
	}
}
