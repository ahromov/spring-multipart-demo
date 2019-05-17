package ua.lviv.lgs.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.model.User;
import ua.lviv.lgs.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User store(User user) throws IOException {
		if (user != null) {
			return userRepository.save(user);
		}
		return null;
	}

}
