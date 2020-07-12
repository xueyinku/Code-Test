package com.asjy.dao;

import org.apache.ibatis.annotations.Select;

import com.asjy.model.User;

public interface UserDao {

	//代理接口
	
	//代理的登陆验证方法
	@Select("select no, id, password, level from user where id = #{id} and password = #{password}")
	User login(User user);
}
