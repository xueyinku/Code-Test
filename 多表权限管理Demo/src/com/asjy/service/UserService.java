package com.asjy.service;

import java.util.List;

import com.asjy.model.User;

public interface UserService {

	//��½��֤
	User login(User user);
	
	/**
	 * ��ѯ�����û���Ϣ
	 * @return
	 */
	List<User> findUser();
}
