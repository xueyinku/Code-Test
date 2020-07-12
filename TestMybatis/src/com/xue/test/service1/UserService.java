package com.xue.test.service1;

import java.util.List;

import com.xue.test.model.User;

public interface UserService {
	//��
	boolean insert(User user);
	//ɾ
	boolean delete(int id);
	//��
	boolean update(User user);
	//��
	List<User> select();
	List<User> selectByName(String name);
	List<User> selectByNameAndPassword(String name,String password);
}
