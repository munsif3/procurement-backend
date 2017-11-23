package com.sliit.procurement.service;

import java.util.List;

import com.sliit.procurement.model.User;

public interface UserService {

	User findById(int id);
	List<User> findAll();
	User addUser(User user);
	User findUserByPersonNo(int personNo);
}
