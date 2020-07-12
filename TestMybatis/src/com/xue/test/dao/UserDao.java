package com.xue.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xue.test.model.User;

public interface UserDao {
	//代理接口，告诉Mybatis代理那些功能
	//要求，定义增删改修改方法时，返回值必须时int或者void
	//Mybatis具体代理的代码写在xml文件中
	//xml文件必须和对应的代理接口文件名一样
	//增加语句（代理增加）
	int insert(User user);
	
	
	//修改语句（代理修改）
	int update(User user);
	//删除语句（代理删除）
	int delete(int id);
//	//全查询语句（代理查询）
//	List<User> selectAll();
	//动态查询
	List<User> selectDynamic(@Param("id") int id,@Param("name") String name,@Param("password") String password);
}
