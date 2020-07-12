package com.xue.customer.srrvice.Impl;

import java.util.List;

import com.xue.custom.model.Customer;
import com.xue.customer.dao.CustomerDao;
import com.xue.customer.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public boolean inserCustomer(Customer customer) {
		String sql = "insert into tbl_customer values(?,?,?,?,?)";
		return CustomerDao.update(sql, customer.getId(),customer.getName(),customer.getScore(),customer.getTel(),customer.getSex());
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from tbl_customer where customer_id = ?";
		return CustomerDao.update(sql, id);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "update tbl_customer set customer_name = ?,customer_score = ?,customer_tel = ?,customer_sex = ? where customer_id = ?";
		return CustomerDao.update(sql, customer.getName(),customer.getScore(),customer.getTel(),customer.getSex(),customer.getId());
	}

	@Override
	public List<Customer> selectCustomer() {
		// TODO Auto-generated method stub
		String sql = "select customer_id,customer_name, customer_score, customer_tel, customer_sex from tbl_customer";
		return CustomerDao.query(sql);
	}

	@Override
	public Customer selectCustomerById(int id) {
		// TODO Auto-generated method stub
		String sql = "select customer_id,customer_name, customer_score, customer_tel, customer_sex from tbl_customer where customer_id = ?";
		List<Customer> query = CustomerDao.query(sql, id);
		if (query != null && query.size() > 0) {
			return query.get(0);
		}
		return null;
	}

	@Override
	public List<Customer> selectCustomerByIdAndTel(String id, String tel) {
		// TODO 进行模糊查询
		String sql = "select customer_id,customer_name,customer_score,customer_tel,customer_sex from tbl_customer where customer_id like ? and customer_tel like ?";
		List<Customer> list = CustomerDao.query(sql, "%" + id + "%", "%" + tel + "%");
		return list;
	}

}
