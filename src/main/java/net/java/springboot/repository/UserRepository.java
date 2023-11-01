package net.java.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.java.springboot.entity.UserInfo;
import net.java.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	void save(UserInfo userInfo);

}
