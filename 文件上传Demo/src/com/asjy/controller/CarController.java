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
		//��ѯ����������Ϣ
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
		//һ����ͼƬ���浽��������
		//1�������β�����MultipartFile���󣬽�ȡ�ļ��ֽ�����Ϣ
		//2.�ļ��ϴ�Ѱ�ҷ�������Ŀ¼
		UUID uuid = null;
		String originalFilename = null;
		int i = 0;
			String realPath = request.getSession().getServletContext().getRealPath("img");
			//3.�����ϴ��ļ����ļ���  �����õ��ļ�����������Ϊ�û�ѡ���ͼƬ���ļ���
			originalFilename = picture.getOriginalFilename();//��ȡ�û��ϴ�ʱ���ļ���
			//4.�趨�����ϴ�Ŀ¼	
			//ע�⣬�������û��ϴ�ͬ���ļ����Ḳ��֮ǰ��ͼƬ�����Ա�֤ͼƬ����һ��
			//uuid�����
			System.out.println();
			uuid = UUID.randomUUID();
			File file = new File(realPath + "\\" + uuid.toString() + "-" + originalFilename);
			if (!file.exists()) {
				//���������
				file.mkdirs();//�½�һ��ָ���ļ� 
			} 
			//5���ֽ����ļ�д�뵽ָ���������ļ���
			try {
				picture.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			i++;
		
		//��������ӵ���Ϣ��ŵ����ݿ���
		CarService c1 = new CarServiceImpl();
		car.setImgName(uuid.toString() + "-" + originalFilename);//ֻ��Ҫ���ļ���
		boolean result = c1.addCar(car);
		if (result) {
			//��ӳɹ���ת����ҳ
			return "redirect:goIndex";
		}
		return "";
	}
}



