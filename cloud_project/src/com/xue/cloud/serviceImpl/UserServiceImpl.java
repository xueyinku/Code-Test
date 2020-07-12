package com.xue.cloud.serviceImpl;

import java.util.List;

import com.xue.cloud.dao.UserDao;
import com.xue.cloud.model.User;
import com.xue.cloud.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public boolean insertUser(User user) {
		// TODO ���ݴ��������ݣ������ݿ�������user
		//1дsql���
		String sql = "insert into users values(default,?,?,?)";
		return UserDao.update(sql, user.getName(), user.getPassword(), user.getType());
	}

	@Override
	public User checkUser(String name, String password) {
		// TODO ���ݴ��������ݣ��鿴�������Ƿ������ݿ��У�����ɵ�½У��
		//дsql���
		String sql = "select USER_ID,USER_NAME,PASSWORD,USER_TYPE from users where USER_NAME = ? and PASSWORD = ?";
		List<User> query = UserDao.query(sql, name,password);
		if (query != null && query.size() > 0) {
			return query.get(0);
		} else {
			return null;
		}
		
	}

	@Override
	public List<User> seleteAll() { //ȫ��ѯ
		// TODO 
		String sql = "select USER_ID,USER_NAME,PASSWORD,USER_TYPE from users";
		return UserDao.query(sql);
	}

}
