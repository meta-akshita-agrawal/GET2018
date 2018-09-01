package com.metacube.user.dao;

import java.util.List;

import com.metacube.user.pojo.User;

public interface UserDao extends BaseDao<User> {

	public User getUserByEmail(String email);
	public List<String> getEmailListByCompanyName(String companyName,String email);
}
