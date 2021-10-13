package com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Exception.ResourceNotFoundException;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.Item;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.Role;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.User;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.UserRole;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.service.ItemService;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.service.UserService;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

//-------------------------Creating new user-----------------------------------------

	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {

		Role role = new Role();
		role.setRoleId(2L);
		role.setRoleName("Customer");

		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);

		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(userRole);
		return this.userService.createUser(user, userRoles);
	}

	// -------------------------Get user by userName -----------------------

	@GetMapping("/users/{userName}")
	public User getUserByUsername(@PathVariable String userName) {
		return this.userService.getUser(userName);
	}

	// -------------------------Get all Users ---------------------------

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	// -------------------------Delete user by userName
	// -----------------------------------------
	@DeleteMapping("/users/{userName}")
	public void deleteUserByUsername(@PathVariable String userName) {
		this.userService.deleteUser(userName);
	}

	// -------------------------Update user by userName
	// -----------------------------------------

	@PutMapping("/users/{userName}")
	public User updateByUsername(@RequestBody User user, @PathVariable String userName) {
		return this.userService.updateUser(user, userName);
	}
	
	
	
	// ------------login------------------
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		User logedinUser = userService.login(userName, password);
		if (logedinUser == null) {
			throw new ResourceNotFoundException("Invalid Credentials");
		}
		return logedinUser;
	}
}
