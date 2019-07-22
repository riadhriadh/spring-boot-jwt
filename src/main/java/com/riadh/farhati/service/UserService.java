package com.riadh.farhati.service;

import java.util.List;

import com.riadh.farhati.domain.User;

public interface UserService {

	public List<User> getAllUsers();
	public User addUsers(User user);
	public User findUserById(int id);
	public void DelateUser(int id);
	public User    UpdateUser(User user);
}
