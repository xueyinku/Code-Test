package com.xue.cloud.service;

import java.util.List;

import com.xue.cloud.model.User;

public interface UserService {
	boolean insertUser(User user);//ע���û�
	User checkUser(String name,String password);//��½У�飬�����ݿ�����û�ж�Ӧ��user
	List<User> seleteAll();//��ѯ���л�Ա��Ϣ
}
