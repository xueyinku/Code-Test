package com.xue.test.service1;

import java.util.List;

import com.xue.test.model.User;

public interface UserService {
	//Ôö
	boolean insert(User user);
	//É¾
	boolean delete(int id);
	//¸Ä
	boolean update(User user);
	//²é
	List<User> select();
	List<User> selectByName(String name);
	List<User> selectByNameAndPassword(String name,String password);
}
