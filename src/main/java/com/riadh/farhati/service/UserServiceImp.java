package com.riadh.farhati.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.riadh.farhati.domain.User;
@Component
public class UserServiceImp implements UserService {
	private static List<User> userList=new ArrayList<>();
	private static int usersCount =1;
	static {
		User user1=new User(1,"farhati","riadh","farhatired@gmail.com",new Date(),"1234");
		userList.add(user1);
	}
	
 
	@Override
	public List<User> getAllUsers() {
		
		return userList;
	}

	@Override
	public User addUsers(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		userList.add(user);
		
		return user;
		
	}

	@Override
	public User findUserById(int id) {
		for (User user:userList) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void DelateUser(int id) {
		List<User> newListUser = new ArrayList<>();
		for (User user:userList) {
			if(user.getId()==id) {
				
			
			}else {
				newListUser.add(user);
			}
			
		}
		userList =newListUser;
		
		
	}

	@Override
	public User UpdateUser(User user) {
		for (User use:userList) {
			if(use.getId()==user.getId()) {
				use.setBirthday(user.getBirthday());
				use.setFirstname(user.getFirstname());
				use.setEmail(user.getEmail());
				use.setLastName(user.getLastName());
				use.setPassword(user.getPassword());
				return user;
			}
		}
		return null;
	}
	

}
