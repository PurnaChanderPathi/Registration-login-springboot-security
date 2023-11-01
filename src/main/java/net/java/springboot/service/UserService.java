package net.java.springboot.service;

import net.java.springboot.dto.UserRegistrationDto;
import net.java.springboot.model.User;

public interface UserService {
	
	User save(UserRegistrationDto userRegistrationDto);

}
