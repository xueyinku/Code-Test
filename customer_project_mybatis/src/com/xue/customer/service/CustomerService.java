package com.xue.customer.service;

import java.util.List;

import com.xue.custom.model.Customer;

public interface CustomerService {
	//定义出多有的方法
	//增
	boolean inserCustomer(Customer customer);
	//删
	boolean deleteCustomer(int id);
	//改
	boolean updateCustomer(Customer customer);
	//查
	List<Customer> selectCustomer();
	//根据id查customer
	Customer selectCustomerById(int id);
	//根据id和tel进行模糊查询
	List<Customer> selectCustomerByIdAndTel(String id, String tel);
}
