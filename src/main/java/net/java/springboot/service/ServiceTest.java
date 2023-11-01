package net.java.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.springboot.entity.UserInfo;
import net.java.springboot.repository.UserInfoRepository;

@Service
public class ServiceTest {
	
	@Autowired
	private UserInfoRepository userRepo;
	
	
	public String addUuser(UserInfo user) {
		userRepo.save(user);
		return "Saved";
	
	}

}
