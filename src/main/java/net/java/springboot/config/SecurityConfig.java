package net.java.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	//authentication
	@Bean
public UserDetailsService userDetailsService(PasswordEncoder encoder)
{
//	UserDetails admin = org.springframework.security.core.userdetails.User
//			.withUsername("purna").password(encoder.encode("password")).roles("ADMIN").build();
//	
//	UserDetails user = org.springframework.security.core.userdetails.User
//			.withUsername("chandu").password(encoder.encode("password1")).roles("USER").build();
//	return new InMemoryUserDetailsManager(admin,user);
		return new UserInfoUserDetailsService();
}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http.csrf().disable().
				authorizeHttpRequests().requestMatchers("/registration","/new").permitAll()
				.and().authorizeHttpRequests().requestMatchers("/userlogin")
				.authenticated()
				.and().formLogin()
				.and().build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
