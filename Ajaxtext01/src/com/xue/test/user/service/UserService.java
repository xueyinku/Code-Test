package com.xue.test.user.service;

import xom.xue.test.user.model.User;

public interface UserService {
	boolean selectExistName(String name);//��ѯ�˺��Ƿ����
	boolean insertuser(User user);//ע��ɹ��������ݿ�����������
}
