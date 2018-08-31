package com.metacube.user.dao;

import com.metacube.user.pojo.User;

public interface UserDao extends BaseDao<User> {

	public User getUserByEmail(String email);
}
