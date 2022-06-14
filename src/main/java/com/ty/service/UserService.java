package com.ty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.Userdao;
import com.ty.dto.User;
@Component
public class UserService {
	@Autowired
	Userdao userDao;
	
	public User saveUser(User user)
	{
		return userDao.saveUser(user);
	}
	public User getUserById(int id)
	{
		return userDao.getUserById(id);
	}
	
	public List<User> getAllUser()
	{
		return userDao.getAllUser();
	}
	public List<User> validateUser(String email,String password)
	{
		return userDao.validateUser(email, password);
	}
	public boolean deleteUser(int id)
	{
		return userDao.deleteUser(id);
	}
	public User updateUserById(int id,User user) {
		return userDao.updateUserById(id, user);
	}

}
