package com.xue.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xue.dao.ActorDao;
import com.xue.model.Actor;
import com.xue.service1.ActorService;
import com.xue.util.MybatisUtil;

public class ActorServiceImpl implements ActorService{

	@Override
	public List<Actor> selectActorByname(String name) {
		// TODO //������Ա���ƣ��鿴��Ա��Ϣ���������ݵ�Ӱ��Ϣ ʹ�ô���ӿ�
		//��һ�������Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//�ڶ�����ȡ����ӿڵĴ������
		ActorDao mapper = sqlsession.getMapper(ActorDao.class);
		//�����������ô������ķ���
		List<Actor> selectByName = mapper.selectByName(name);
		//���Ĳ��ύ���ݣ���ѯ����Ҫ
		//���岽�ر���Դ
		sqlsession.close();
		return selectByName;
	}

}
