package com.xue.customer.srrvice.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xue.custom.model.Customer;
import com.xue.customer.dao.AdminDao1;
import com.xue.customer.dao.CustomerDao1;
import com.xue.customer.service.CustomerService;
import com.xue.customer.util.MybatisUtil;



public class CustomerServiceImpl implements CustomerService{

	@Override
	public boolean inserCustomer(Customer customer) {
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//返回值代表会话，底层封装了jdbc所有的步骤代码
		//2.获取代理接口的的代理对象
		CustomerDao1 mapper = sqlsession.getMapper(CustomerDao1.class);
		//返回值mapper代表代理接口层的代理对象，我们可以用该对象调用代理的方法
		//3.调用代理方法
		int result = mapper.insertCustomer(customer);
		//4增删改操作需要提交数据
		sqlsession.commit();//提交数据
		//5.关闭资源
		sqlsession.close();
		return result > 0 ? true : false;  
		
		
//		String sql = "insert into tbl_customer values(?,?,?,?,?)";
//		return CustomerDao.update(sql, customer.getId(),customer.getName(),customer.getScore(),customer.getTel(),customer.getSex());
	}

	@Override
	public boolean deleteCustomer(int id) {
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.获取代理接口的的代理对象
		CustomerDao1 mapper = sqlsession.getMapper(CustomerDao1.class);
		//3.调用代理方法
		int result = mapper.deleteCustomer(id);
		//4增删改操作需要提交数据
		sqlsession.commit();//提交数据
		//5.关闭资源
		sqlsession.close();
		return result > 0 ? true : false; 
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.获取代理接口的的代理对象
		CustomerDao1 mapper = sqlsession.getMapper(CustomerDao1.class);
		//3.调用代理方法
		int result = mapper.updateCustomer(customer);
		//4增删改操作需要提交数据
		sqlsession.commit();//提交数据
		//5.关闭资源
		sqlsession.close();
		return result > 0 ? true : false;
		
				
				
//		String sql = "update tbl_customer set customer_name = ?,customer_score = ?,customer_tel = ?,customer_sex = ? where customer_id = ?";
//		return CustomerDao.update(sql, customer.getName(),customer.getScore(),customer.getTel(),customer.getSex(),customer.getId());
	}

	@Override
	public List<Customer> selectCustomer() {
		// TODO Auto-generated method stub
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.获取代理接口的的代理对象
		CustomerDao1 mapper = sqlsession.getMapper(CustomerDao1.class);
		//3.调用代理方法
		List<Customer> list = mapper.selectCustomerDynamic("", "");
		//5.关闭资源
		sqlsession.close();
		return list;
		
		
//		String sql = "select customer_id,customer_name, customer_score, customer_tel, customer_sex from tbl_customer";
//		return CustomerDao.query(sql);
	}

	@Override
	public Customer selectCustomerById(int id) {
		// TODO Auto-generated method stub
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.获取代理接口的的代理对象
		CustomerDao1 mapper = sqlsession.getMapper(CustomerDao1.class);
		//3.调用代理方法
		Customer cust = mapper.selectCustomerById(id);
		//5.关闭资源
		sqlsession.close();
		return cust;
		
//		String sql = "select customer_id,customer_name, customer_score, customer_tel, customer_sex from tbl_customer where customer_id = ?";
//		List<Customer> query = CustomerDao.query(sql, id);
//		if (query != null && query.size() > 0) {
//			return query.get(0);
//		}
//		return null;
	}

	@Override
	public List<Customer> selectCustomerByIdAndTel(String id, String tel) {
		// TODO 进行模糊查询
		//1.获取会话
		SqlSession sqlsession = MybatisUtil.getSqlsession();
		//2.获取代理接口的的代理对象
		CustomerDao1 mapper = sqlsession.getMapper(CustomerDao1.class);
		//3.调用代理方法
		List<Customer> list = mapper.selectCustomerDynamic(id, tel);
		//5.关闭资源
		sqlsession.close();
		return list;
		
		
		
		
		
		
//		String sql = "select customer_id,customer_name,customer_score,customer_tel,customer_sex from tbl_customer where customer_id like ? and customer_tel like ?";
//		List<Customer> list = CustomerDao.query(sql, "%" + id + "%", "%" + tel + "%");
//		return list;
	}

}
