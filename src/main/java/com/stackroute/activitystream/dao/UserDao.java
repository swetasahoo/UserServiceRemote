package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.User;

public interface UserDao {
	public boolean save(User user);
	public boolean update(User user);
	public User get(String id);
	public List<User> list();
	public User validate(String id,String password);
	public boolean isUserExist(User user);
}
