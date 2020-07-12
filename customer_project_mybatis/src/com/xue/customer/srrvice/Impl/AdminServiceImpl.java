package com.xue.customer.srrvice.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xue.custom.model.Admin;
import com.xue.customer.dao.AdminDao1;
import com.xue.customer.service.AdminService;
import com.xue.customer.dao.AdminDao1;
import com.xue.customer.util.MybatisUtil;

public class AdminServiceImpl  implements AdminService{

	@Override
	public Admin select(Admin admin) {
		// TODO 调用代理的添加方法，完成具体添加代码！
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//返回值代表会话，底层封装了jdbc所有的步骤代码
		//2.获取代理接口的的代理对象
		AdminDao1 mapper = sqlsession.getMapper(AdminDao1.class);
		//返回值mapper代表代理接口层的代理对象，我们可以用该对象调用代理的方法
		//3.调用代理方法
		Admin amin = mapper.select(admin);
		//4增删改操作需要提交数据
//		sqlsession.commit();//提交数据
		//5.关闭资源
		sqlsession.close();
		return admin;
		
		
		
//		String sql = "select admin_id,admin_name, admin_password from tbl_admin where admin_name = ? and admin_password = ?";
//		List<Admin> query = AdminDao.query(sql, admin.getName(),admin.getPassword());
//		if (query != null && query.size() > 0) {
//			return query.get(0);
//		}
// 		return null;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO 给数据库增加新注册admin
//		String sql = "insert into tbl_admin values(default, ?, ?)";
//		return AdminDao.update(sql, admin.getName(), admin.getPassword());
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//返回值代表会话，底层封装了jdbc所有的步骤代码
		//2.获取代理接口的的代理对象
		AdminDao1 mapper = sqlsession.getMapper(AdminDao1.class);
		//返回值mapper代表代理接口层的代理对象，我们可以用该对象调用代理的方法
		//3.调用代理方法
		int result = mapper.addAdmin(admin);
		//4增删改操作需要提交数据
		sqlsession.commit();//提交数据
		//5.关闭资源
		sqlsession.close();
		return result > 0 ? true : false;  
	}

}
