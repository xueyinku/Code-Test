package com.xue.test.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xue.test.dao.UserDao;
import com.xue.test.model.User;
import com.xue.test.service1.UserService;
import com.xue.test.util.MybatisUtil;

public class UserServiceImpl implements UserService{

	//����Mybits��ܺ�ҵ��ɲ���дsql��䣬����ͨ�����ó־ò��������ɾ��幦�ܣ�
	//���ó־ò��д�������� 
	@Override
	public boolean insert(User user) {
		// TODO ���ô������ӷ�������ɾ�����Ӵ��룡
		//1.��ȡ�Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//����ֵ����Ự���ײ��װ��jdbc���еĲ������
		//2.��ȡ����ӿڵĵĴ������
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		//����ֵmapper�������ӿڲ�Ĵ���������ǿ����øö�����ô���ķ���
		//3.���ô�����
		int result = mapper.insert(user);
//		try {    ��������ȷ�ĵ�����
//			int result = mapper.insert(user);
//		} catch (Exception e) {
//			sqlsession.rollback();//�ع�
//		}
		//4��ɾ�Ĳ�����Ҫ�ύ����
		sqlsession.commit();//�ύ����
		//5.�ر���Դ
		sqlsession.close();
		return result > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		// TODO 
		//1.��ȡ�Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.��ȡ����ӿڵĵĴ������
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		//3.���ô�����
		int result = 0;
		try {    //��������ȷ�ĵ�����
			result = mapper.delete(id);
		} catch (Exception e) {
			sqlsession.rollback();//�ع�
		}
		//4��ɾ�Ĳ�����Ҫ�ύ����
		sqlsession.commit();//�ύ����
		//5.�ر���Դ
		sqlsession.close();
		return result > 0 ? true : false;
	}

	@Override
	public boolean update(User user) {
		 // TODO ���ô������ӷ�������ɾ�����Ӵ��룡
		//1.��ȡ�Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//����ֵ����Ự���ײ��װ��jdbc���еĲ������
		//2.��ȡ����ӿڵĵĴ������
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		//����ֵmapper�������ӿڲ�Ĵ���������ǿ����øö�����ô���ķ���
		//3.���ô�����
//		int result = mapper.update(user);
		int result = 0;
		try {    //��������ȷ�ĵ�����
			result = mapper.update(user);
		} catch (Exception e) {
			sqlsession.rollback();//�ع�
		}
		//4��ɾ�Ĳ�����Ҫ�ύ����
		sqlsession.commit();//�ύ����
		//5.�ر���Դ
		sqlsession.close();
		return result > 0 ? true : false;
	}

	@Override
	public List<User> select() {
		// TODO ���ô���Ĳ�ѯ����
		//1.��ȡ�Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.��ȡ����ӿڵĵĴ������
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		//3.���ô�����
		List<User> list = mapper.selectDynamic(0, "", "");
		//4.�ر���Դ
		sqlsession.close();
		return list;
	}

	@Override
	public List<User> selectByName(String name) {
		// TODO ����������ģ����ѯ
		//1.��ȡ�Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.��ȡ����ӿڵĵĴ������
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		//3.���ô�����
		List<User> list = mapper.selectDynamic(0, name, "");
		//4.�ر���Դ
		sqlsession.close();
		return list;
	}

	@Override
	public List<User> selectByNameAndPassword(String name, String password) {
		// TODO ʵ�������������ģ����ѯ
		//1.��ȡ�Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.��ȡ����ӿڵĵĴ������
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		//3.���ô�����
		List<User> list = mapper.selectDynamic(0, name, password);
		//4.�ر���Դ
		sqlsession.close();
		return list;
	}

}
