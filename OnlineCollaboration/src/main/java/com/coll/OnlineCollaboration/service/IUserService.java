package com.coll.OnlineCollaboration.service;

import java.util.List;

import com.coll.OnlineCollaboration.model.User;

public interface IUserService {

	List<User> userListbyStatus(String status);
	List<User> getAllUsers();
	User getUserById(int userId);
	User getUserByUsername(String username);
	User validateUser(User user);
	boolean addUser(User user);
	boolean updateUser(User user);
	boolean deleteUser(int userId);
	boolean deactiveuser(int userId);
	boolean activeUser(int userId);
	boolean updateUserProfile(String file, Integer userId);
	List<User> getAlldeactiveUser();
	List<User> getAllInactiveUsers();
}
