package com.metacube.user.facade;

import java.util.List;

import com.metacube.user.dao.MySQLUserDao;
import com.metacube.user.dao.UserDao;
import com.metacube.user.enums.Status;
import com.metacube.user.pojo.User;

public class UserFacade{

	private static UserFacade userFacade = new UserFacade();
	
	UserDao userDao = MySQLUserDao.getInstance();
	
	public static UserFacade getInstance(){
		return userFacade;
	}
	
	public List<User> getAllUsers(){
		return userDao.getAll();
	}
	
	public Status insert(User user){
		
		List<User> userList = userDao.getAll();
		int result = userDao.insert(user);
		
		if(result==1){
			return Status.INSERTED;
		}
		
		for(User tempUser: userList){
			if(tempUser.getEmail().equals(user.getEmail())){
				return Status.DUPLICATE;
			}
		}
		
		return Status.ERROR;
	}
	
	public Status update(User user){
		
		int result = userDao.update(user);
		
		if(result==1){
			return Status.UPDATED;
		}
		return Status.NOT_FOUND;
	}
	
	public Status delete(User user){
		
		int result = userDao.delete(user);
		if(result==1){
			return Status.DELETED;
		}
		return Status.NOT_FOUND;
	}
	
	public User getUserByEmail(String email){
		
		List<User> userList = userDao.getAll();
		
		for(User tempUser: userList){
			if(tempUser.getEmail().equals(email)){
				return userDao.getUserByEmail(email);
			}
		}
		
		return null;
	}
}
