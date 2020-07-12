package com.xue.customer.service;

import java.util.List;

import com.xue.custom.model.Customer;

public interface CustomerService {
	//��������еķ���
	//��
	boolean inserCustomer(Customer customer);
	//ɾ
	boolean deleteCustomer(int id);
	//��
	boolean updateCustomer(Customer customer);
	//��
	List<Customer> selectCustomer();
	//����id��customer
	Customer selectCustomerById(int id);
	//����id��tel����ģ����ѯ
	List<Customer> selectCustomerByIdAndTel(String id, String tel);
}
