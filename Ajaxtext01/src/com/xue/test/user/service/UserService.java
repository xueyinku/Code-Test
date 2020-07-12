package com.xue.test.user.service;

import xom.xue.test.user.model.User;

public interface UserService {
	boolean selectExistName(String name);//查询账号是否存在
	boolean insertuser(User user);//注册成功，在数据库中增加数据
}
