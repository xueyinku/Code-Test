package com.xue.customer.servlet;

import java.util.List;

import com.xue.custom.model.Admin;
import com.xue.custom.model.Customer;
import com.xue.customer.service.AdminService;
import com.xue.customer.service.CustomerService;
import com.xue.customer.srrvice.Impl.AdminServiceImpl;
import com.xue.customer.srrvice.Impl.CustomerServiceImpl;

public class Test01 {
	public static void main(String[] args) {
//		AdminService as = new AdminServiceImpl();
//		Admin admin = new Admin();
//		admin.setName("xue111");
//		admin.setPassword("4665572");
//		Admin result = as.select(admin);
//		System.out.println(result);
		CustomerService cs = new CustomerServiceImpl();
//		Customer customer = new Customer();
//		customer.setId(1990);
//		customer.setName("test");
//		customer.setScore(12);
//		customer.setSex("ÄÐ");
//		customer.setTel("1231212");
//		boolean result = cs.inserCustomer(customer);
		List<Customer> result = cs.selectCustomerByIdAndTel("", "13");
		System.out.println(result);
	}
}
