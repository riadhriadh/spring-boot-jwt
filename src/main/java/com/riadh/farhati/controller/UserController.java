package com.riadh.farhati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.riadh.farhati.domain.User;
import com.riadh.farhati.service.UserServiceImp;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceImp userServiceImp;
	
	@GetMapping("")
	public ResponseEntity<List<User>>  getUsers() {
		
		  List<User> users=userServiceImp.getAllUsers();
		return  new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
	}
	
	@PostMapping("")
	public   ResponseEntity<User> SaveUser(@RequestBody User user){
		if(user ==null) {	
			return  new ResponseEntity<User>(user,HttpStatus.FORBIDDEN);
		}
		
		 User userAdd =userServiceImp.addUsers(user);
		
		return  new ResponseEntity<User>(userAdd,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable int id){
		
		User user = userServiceImp.findUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
public ResponseEntity<Void> delateuser(@PathVariable int id){
		
		 userServiceImp.DelateUser(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PutMapping("")
		public ResponseEntity<User> Update(@RequestBody User user){
			
			User userUpdate = userServiceImp.UpdateUser(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}	
	
	

}
