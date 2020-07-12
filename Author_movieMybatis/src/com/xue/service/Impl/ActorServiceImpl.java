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
		// TODO //根据演员名称，查看演员信息，包含参演电影信息 使用代理接口
		//第一步创建会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//第二步获取代理接口的代理对象
		ActorDao mapper = sqlsession.getMapper(ActorDao.class);
		//第三步骤条用代理对象的方法
		List<Actor> selectByName = mapper.selectByName(name);
		//第四部提交内容，查询不需要
		//第五步关闭资源
		sqlsession.close();
		return selectByName;
	}

}
