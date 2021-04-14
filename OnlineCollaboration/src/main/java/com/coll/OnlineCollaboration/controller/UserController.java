package com.coll.OnlineCollaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coll.OnlineCollaboration.model.User;
import com.coll.OnlineCollaboration.service.IUserService;

@RestController  
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")  
public class UserController {

	@Autowired 
	IUserService userService;
	
	@PostMapping("save-user")  
    public boolean saveUser(@RequestBody User user) {  
         return userService.addUser(user);  
          
    }  
      
    @GetMapping("user-list")  
    public List<User> allUsers() {  
         return userService.getAllUsers();  
          
    } 
    @GetMapping("deactive-user-list")  
    public List<User> alldeactiveUser() {  
         return userService.getAlldeactiveUser();       
    } 
      
    @DeleteMapping("delete-user/{userId}")  
    public boolean deleteUser(@PathVariable("userId") int userId) {  
        return userService.deleteUser(userId);  
    }  
  
    @GetMapping("user/{userId}")  
    public User userById(@PathVariable("userId") int userId) {  
         return userService.getUserById(userId);  
          
    }  
    
    @PostMapping("activate-user/{userId}")
    public boolean activeUser(@PathVariable("userId") int userId) {  
        return userService.activeUser(userId);  
    } 
    
     
    @PostMapping("update-user/{userId}")  
    public boolean updateUser(@RequestBody User user,@PathVariable("userId") int userId) {  
        user.setUserId(userId);  
        return userService.updateUser(user);  
    } 
    
    @RequestMapping(value="login/{username,password}", method=RequestMethod.POST)  
    public User validateUser(@RequestBody User user,@PathVariable("username") String username, @PathVariable("password") String password) {  
        user.setUsername(username);  
        user.setPassword(password);
        return userService.validateUser(user);  
    } 
}

