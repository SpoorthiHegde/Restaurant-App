package com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CharlieOnlineFoodChainApp.CharlieOnlineFoodChain.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserName(String userName);

	public User findByUserNameAndPassword(String userName, String password);

}
