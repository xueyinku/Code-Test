package com.asjy.service;

import java.util.List;

import com.asjy.model.User;

public interface UserService {

	//登陆验证
	User login(User user);
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<User> findUser();
}
