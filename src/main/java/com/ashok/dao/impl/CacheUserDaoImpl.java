package com.ashok.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.cache.Cache;

import com.ashok.dao.UserDAO;
import com.ashok.model.User;

public class CacheUserDaoImpl implements UserDAO{
	
	private final Cache<Integer, String> cache;
	private final UserDAO wrappedUserDao;

	public CacheUserDaoImpl(Cache<Integer, String> cache, UserDAO wrappedUserDao) {
		super();
		this.cache = cache;
		this.wrappedUserDao = wrappedUserDao;
	}

	public List<User> findAll() {
		return wrappedUserDao.findAll();
	}

	public List<User> findById(int id) {
		List<User> ll = new ArrayList<User>();
		String userName = cache.get(id);
		
		if(userName != null){
			System.out.println("Fetching Data from Cache . . . ");
			int i = id;
			String str = userName;
			User user = new User(i, str);
			ll.add(user);
			return ll;
		}
		
		ll = wrappedUserDao.findById(id);
		if(ll != null){
			System.out.println("Fetching Data from MySQL DB . . . ");
			User user = ll.get(0);
			System.out.println("Inserting Data into Cache . . . ");
			cache.put(id,user.getName());
			System.out.println("Inserted into Cache !");
			return ll;

		}
		return null;
	}

	public List<User> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
