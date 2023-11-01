package net.java.springboot.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import net.java.springboot.dto.UserRegistrationDto;
import net.java.springboot.entity.UserInfo;
import net.java.springboot.service.ServiceTest;
import net.java.springboot.service.UserService;
import net.java.springboot.service.UserServiceImpl;

@RestController
public class UserRegistrationController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ServiceTest servicetest;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public UserRegistrationDto userRegistrationDto()
	{
		return new UserRegistrationDto();
	}
	
	@GetMapping("/registration")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String showRegistrationForm()
	{
		return "registration";
	}
	
	@GetMapping("/userlogin")
	public String login()
	{
		return "Login";
	}
	
	@PostMapping("/neew")
	public ResponseEntity<String> addNewUser(@RequestBody UserInfo userInfo)
	{
		 servicetest.addUuser(userInfo);
		 return new ResponseEntity<String>("Saved",HttpStatus.OK);
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto)
	{
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
	

	
	

}
