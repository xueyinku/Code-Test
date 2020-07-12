package com.xue.customer.srrvice.Impl;

import java.util.List;

import com.xue.custom.model.Admin;
import com.xue.customer.dao.AdminDao;
import com.xue.customer.service.AdminService;

public class AdminServiceImpl  implements AdminService{

	@Override
	public Admin select(Admin admin) {
		// TODO 查询进行校验
		String sql = "select admin_id,admin_name, admin_password from tbl_admin where admin_name = ? and admin_password = ?";
		List<Admin> query = AdminDao.query(sql, admin.getName(),admin.getPassword());
		if (query != null && query.size() > 0) {
			return query.get(0);
		}
 		return null;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO 给数据库增加新注册admin
		String sql = "insert into tbl_admin values(default, ?, ?)";
		return AdminDao.update(sql, admin.getName(), admin.getPassword());
	}

}
