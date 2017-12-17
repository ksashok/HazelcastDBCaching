package com.ashok.dao;

import java.util.List;

import com.ashok.model.User;

public interface UserDAO {

	List<User> findAll();

	List<User> findById(int id);

	List<User> findByName();

	boolean insertUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(User user);

}
