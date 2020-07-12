package com.xue.test.servlet;

import java.util.List;

import com.xue.test.model.User;
import com.xue.test.service.impl.UserServiceImpl;
import com.xue.test.service1.UserService;

public class Test {
	public static void main(String[] args) {
		UserService us = new UserServiceImpl();
		User user = new User();
		user.setName("test01");
		user.setPassword("121221");
		user.setType(0);
		boolean result = us.insert(user);
		if (result) {
			System.out.println("添加成功");
		} else {
		System.out.println("添加失败");
		}
//		User updateUser = new User();
//		updateUser.setId(9);
//		updateUser.setName("xiugainame");
//		updateUser.setPassword("hahha");
//		boolean resultUpdate = us.update(updateUser);
//		if (resultUpdate) {
//			System.out.println("修改成功");
//		} else {
//			System.out.println("修改失败");
//		}
//		boolean result = us.delete(9);
//		if (result) {
//			System.out.println("success");
//		} else {
//			System.out.println("default");
//		}
//		List<User> list = us.selectByNameAndPassword("小", "1234567");	
//		for (User user : list) {
//			System.out.println(user.getName());
//		}
	}

}
