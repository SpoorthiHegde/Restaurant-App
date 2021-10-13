package com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.service;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.User;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.UserRole;

public interface UserService {
	
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	public User getUser(String userName);
	
	public List<User> getAllUsers();
	
	public void deleteUser(String userName);
	
	public User updateUser(User user,String userName);
	
	public User login(String userName, String password);

}
