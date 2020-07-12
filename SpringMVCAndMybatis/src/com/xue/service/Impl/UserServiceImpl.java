package com.xue.service.Impl;

import org.apache.ibatis.session.SqlSession;

import com.xue.customer.util.MybatisUtil;
import com.xue.dao.UserDao;
import com.xue.model.User;
import com.xue.service.UserServcice;

public class UserServiceImpl implements UserServcice{

	@Override
	public User selectUser(User user) {
		// TODO 调用持久层中的代理鉴权方法
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		User result = mapper.selecUser(user);
		sqlsession.close();
		return result;
	}
	

}
