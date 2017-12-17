package com.ashok.dao.impl;

import java.util.LinkedList;
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
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findById(int id) {
		System.out.println("hello");
		List ll = new LinkedList();
		String userName = cache.get(id);
		
		if(userName != null){
			System.out.println("inside");
			int i = id;
			String str = userName;
			User user = new User(i, str);
			ll.add(user);
			return ll;
		}
		
		ll = wrappedUserDao.findById(id);
		if(ll != null){
			System.out.println("outside");
			User user = (User) ll.get(0);
			cache.put(id,user.getName());
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
