package com.xue.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xue.test.model.User;

public interface UserDao {
	//����ӿڣ�����Mybatis������Щ����
	//Ҫ�󣬶�����ɾ���޸ķ���ʱ������ֵ����ʱint����void
	//Mybatis�������Ĵ���д��xml�ļ���
	//xml�ļ�����Ͷ�Ӧ�Ĵ���ӿ��ļ���һ��
	//������䣨�������ӣ�
	int insert(User user);
	
	
	//�޸���䣨�����޸ģ�
	int update(User user);
	//ɾ����䣨����ɾ����
	int delete(int id);
//	//ȫ��ѯ��䣨�����ѯ��
//	List<User> selectAll();
	//��̬��ѯ
	List<User> selectDynamic(@Param("id") int id,@Param("name") String name,@Param("password") String password);
}
