package com.xue.test.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xue.test.dao.UserDao;
import com.xue.test.model.User;
import com.xue.test.service1.UserService;
import com.xue.test.util.MybatisUtil;

public class UserServiceImpl implements UserService{

	//引入Mybits框架后，业务成不在写sql语句，而是通过调用持久层代码来完成具体功能！
	//条用持久层中代理的内容 
	@Override
	public boolean insert(User user) {
		// TODO 调用代理的添加方法，完成具体添加代码！
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//返回值代表会话，底层封装了jdbc所有的步骤代码
		//2.获取代理接口的的代理对象
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		//返回值mapper代表代理接口层的代理对象，我们可以用该对象调用代理的方法
		//3.调用代理方法
		int result = mapper.insert(user);
//		try {    这是最正确的第三步
//			int result = mapper.insert(user);
//		} catch (Exception e) {
//			sqlsession.rollback();//回滚
//		}
		//4增删改操作需要提交数据
		sqlsession.commit();//提交数据
		//5.关闭资源
		sqlsession.close();
		return result > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		// TODO 
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.获取代理接口的的代理对象
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		//3.调用代理方法
		int result = 0;
		try {    //这是最正确的第三步
			result = mapper.delete(id);
		} catch (Exception e) {
			sqlsession.rollback();//回滚
		}
		//4增删改操作需要提交数据
		sqlsession.commit();//提交数据
		//5.关闭资源
		sqlsession.close();
		return result > 0 ? true : false;
	}

	@Override
	public boolean update(User user) {
		 // TODO 调用代理的添加方法，完成具体添加代码！
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//返回值代表会话，底层封装了jdbc所有的步骤代码
		//2.获取代理接口的的代理对象
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		//返回值mapper代表代理接口层的代理对象，我们可以用该对象调用代理的方法
		//3.调用代理方法
//		int result = mapper.update(user);
		int result = 0;
		try {    //这是最正确的第三步
			result = mapper.update(user);
		} catch (Exception e) {
			sqlsession.rollback();//回滚
		}
		//4增删改操作需要提交数据
		sqlsession.commit();//提交数据
		//5.关闭资源
		sqlsession.close();
		return result > 0 ? true : false;
	}

	@Override
	public List<User> select() {
		// TODO 调用代理的查询方法
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.获取代理接口的的代理对象
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		//3.调用代理方法
		List<User> list = mapper.selectDynamic(0, "", "");
		//4.关闭资源
		sqlsession.close();
		return list;
	}

	@Override
	public List<User> selectByName(String name) {
		// TODO 试验姓名的模糊查询
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.获取代理接口的的代理对象
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		//3.调用代理方法
		List<User> list = mapper.selectDynamic(0, name, "");
		//4.关闭资源
		sqlsession.close();
		return list;
	}

	@Override
	public List<User> selectByNameAndPassword(String name, String password) {
		// TODO 实现姓名和密码的模糊查询
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.获取代理接口的的代理对象
		UserDao mapper = sqlsession.getMapper(UserDao.class);
		//3.调用代理方法
		List<User> list = mapper.selectDynamic(0, name, password);
		//4.关闭资源
		sqlsession.close();
		return list;
	}

}
