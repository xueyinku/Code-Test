package com.xue.customer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xue.custom.model.Customer;

public interface CustomerDao1 {
	int insertCustomer(Customer customer);//增加
	int deleteCustomer(int id);//根据id删除会员
	int updateCustomer(Customer customer);//更改会员信息
	List<Customer> selectCustomerDynamic(@Param("id")String id,@Param("tel")String tel);//根据id和tel模糊查询会员信息
	Customer selectCustomerById(int id);//准确查询
}
