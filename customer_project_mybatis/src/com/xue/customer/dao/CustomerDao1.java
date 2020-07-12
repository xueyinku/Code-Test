package com.xue.customer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xue.custom.model.Customer;

public interface CustomerDao1 {
	int insertCustomer(Customer customer);//����
	int deleteCustomer(int id);//����idɾ����Ա
	int updateCustomer(Customer customer);//���Ļ�Ա��Ϣ
	List<Customer> selectCustomerDynamic(@Param("id")String id,@Param("tel")String tel);//����id��telģ����ѯ��Ա��Ϣ
	Customer selectCustomerById(int id);//׼ȷ��ѯ
}
