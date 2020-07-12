package com.xue.cloud.service;

import java.util.List;

import com.xue.cloud.model.User;

public interface UserService {
	boolean insertUser(User user);//注册用户
	User checkUser(String name,String password);//登陆校验，看数据库中有没有对应的user
	List<User> seleteAll();//查询所有会员信息
}
