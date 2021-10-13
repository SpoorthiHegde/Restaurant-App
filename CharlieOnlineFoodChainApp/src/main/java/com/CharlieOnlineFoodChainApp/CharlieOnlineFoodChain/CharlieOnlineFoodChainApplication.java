package com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.Role;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.User;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.UserRole;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Repository.UserRepository;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.service.UserService;

@SpringBootApplication
public class CharlieOnlineFoodChainApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CharlieOnlineFoodChainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// -----------------------set new user----------------------------

//		User user = new User();
//		user.setFirstName("Spoorthi");
//		user.setLastName("Hegde");
//		user.setUserName("spoo@gmail.com");
//		user.setPassword("spoo@");
//		user.setPhone("1234567891");
//
//		// -----------------------set new role----------------------------
//
//		Role role = new Role();
//		role.setRoleId(1L);
//		role.setRoleName("Admin");
//
//		// -----------------------set user role----------------------------
//
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUserName());
	}
}
