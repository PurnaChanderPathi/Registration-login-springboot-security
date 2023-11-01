package net.java.springboot.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import net.java.springboot.entity.UserInfo;
import net.java.springboot.repository.UserInfoRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserInfo> userInfo=userInfoRepository.findByName(username);
		
		return userInfo.map(UserInfoUserDetails::new).
		orElseThrow(() -> new UsernameNotFoundException("User not found"+username));
		
	}

}
