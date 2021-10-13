package com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.User;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.UserRole;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Repository.RoleRepository;
import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

//------------------------------------	Creating User----------------------------------
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByUserName(user.getUserName());
		if (local != null) {
			System.out.println("User already exist");
			throw new Exception("User already exists");
		} else 
		{
			for (UserRole ur : userRoles) 
			{
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}
	
	//----------------Get user by userName-----------------------------------------

	@Override
	public User getUser(String userName) {
		userRepository.findByUserName(userName);
		return userRepository.findByUserName(userName);
	}

	//-------------------------Get All users-----------------------------------------
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	//-------------------------Delete user by userName -----------------------------------------

	@Override
	public void deleteUser(String userName) {
		User user=userRepository.findByUserName(userName);
		userRepository.delete(user);
	}
	
	//-------------------------Update user by userName -----------------------------------------

	@Override
	public User updateUser(User user,String userName) {
		User updateUser=userRepository.findByUserName(userName);
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setUserName(user.getUserName());
		updateUser.setPassword(user.getPassword());
		updateUser.setPhone(user.getPhone());
		updateUser=this.userRepository.save(updateUser);
		return updateUser;
	}
	
	public User login(String userName, String password) {
		User user1 = userRepository.findByUserNameAndPassword(userName, password);
		return user1;
	}

}
