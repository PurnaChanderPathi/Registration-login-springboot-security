package net.java.springboot.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testtt {
	
	@GetMapping("/")
	public String Index()
	{
		return "registration";
	}


}
