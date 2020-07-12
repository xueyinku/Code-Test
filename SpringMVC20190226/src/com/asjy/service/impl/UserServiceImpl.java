package com.asjy.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.asjy.dao.UserDao;
import com.asjy.model.User;
import com.asjy.service.UserService;
import com.asjy.util.MybatisUtil;

public class UserServiceImpl implements UserService{

	@Override
	public User login(User user) {
		// TODO 调用代理的登陆验证方法
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		User result = mapper.login(user);
		sqlsession.close();
		return result;
	}

}
