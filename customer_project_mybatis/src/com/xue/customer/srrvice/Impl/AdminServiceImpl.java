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
		// TODO ���ô������ӷ�������ɾ�����Ӵ��룡
		//1.��ȡ�Ự
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//����ֵ����Ự���ײ��װ��jdbc���еĲ������
		//2.��ȡ����ӿڵĵĴ������
		AdminDao1 mapper = sqlsession.getMapper(AdminDao1.class);
		//����ֵmapper�������ӿڲ�Ĵ���������ǿ����øö�����ô���ķ���
		//3.���ô�����
		Admin amin = mapper.select(admin);
		//4��ɾ�Ĳ�����Ҫ�ύ����
//		sqlsession.commit();//�ύ����
		//5.�ر���Դ
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
		// TODO �����ݿ�������ע��admin
//		String sql = "insert into tbl_admin values(default, ?, ?)";
//		return AdminDao.update(sql, admin.getName(), admin.getPassword());
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//����ֵ����Ự���ײ��װ��jdbc���еĲ������
		//2.��ȡ����ӿڵĵĴ������
		AdminDao1 mapper = sqlsession.getMapper(AdminDao1.class);
		//����ֵmapper�������ӿڲ�Ĵ���������ǿ����øö�����ô���ķ���
		//3.���ô�����
		int result = mapper.addAdmin(admin);
		//4��ɾ�Ĳ�����Ҫ�ύ����
		sqlsession.commit();//�ύ����
		//5.�ر���Դ
		sqlsession.close();
		return result > 0 ? true : false;  
	}

}
