package com.asjy.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.asjy.model.Car;
import com.asjy.serive.CarService;
import com.asjy.serive.impl.CarServiceImpl;

@Controller
@RequestMapping("/car")
public class CarController {

	@RequestMapping("/goIndex")
	public String goIndex(Model model){
		//查询所有汽车信息
		CarService c1 = new CarServiceImpl();
		List<Car> carList = c1.findCar();
		model.addAttribute("carList", carList);
		return "car_index";
	}
	
	@RequestMapping("/goAdd")
	public String goAdd() {
		return "car_add";
	}
	@RequestMapping("/doAdd")
	public String doAdd(Car car, MultipartFile picture, HttpServletRequest request) {
		//一、将图片保存到服务器中
		//1、方法形参声明MultipartFile对象，接取文件字节码信息
		//2.文件上传寻找服务器根目录
		UUID uuid = null;
		String originalFilename = null;
		int i = 0;
			String realPath = request.getSession().getServletContext().getRealPath("img");
			//3.设置上传文件的文件名  ！设置的文件名可以设置为用户选择的图片的文件名
			originalFilename = picture.getOriginalFilename();//获取用户上传时的文件名
			//4.设定具体上传目录	
			//注意，如果多个用户上传同名文件，会覆盖之前的图片，所以保证图片名不一致
			//uuid随机码
			System.out.println();
			uuid = UUID.randomUUID();
			File file = new File(realPath + "\\" + uuid.toString() + "-" + originalFilename);
			if (!file.exists()) {
				//如果不存在
				file.mkdirs();//新建一个指定文件 
			} 
			//5将字节码文件写入到指定服务器文件中
			try {
				picture.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			i++;
		
		//二、将添加的信息存放到数据库中
		CarService c1 = new CarServiceImpl();
		car.setImgName(uuid.toString() + "-" + originalFilename);//只需要存文件名
		boolean result = c1.addCar(car);
		if (result) {
			//添加成功跳转到首页
			return "redirect:goIndex";
		}
		return "";
	}
}



