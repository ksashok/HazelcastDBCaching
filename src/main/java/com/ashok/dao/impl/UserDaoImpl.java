package com.ashok.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.ashok.dao.UserDAO;
import com.ashok.dbconn.DBConnection;
import com.ashok.model.User;

public class UserDaoImpl implements UserDAO{

	public List<User> findAll() {
		ResultSet rs = null;
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection();
		String sql = "SELECT * from userCache";
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (List<User>) rs;
	}

	public List<User> findById(int input_id) {
		ResultSet rs = null;
		List ll = new LinkedList();
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection();
		String sql = "SELECT * from userCache where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, input_id);
//			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery();
			
			while(rs.next()){
			//	System.out.println(rs.getInt(1) + " " + rs.getString(2));
				int i = rs.getInt(1);
				String str = rs.getString(2);
				User user = new User(i, str);
				ll.add(user);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ll;
		
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

	public List<User> findById() {
		// TODO Auto-generated method stub
		return null;
	}

}
