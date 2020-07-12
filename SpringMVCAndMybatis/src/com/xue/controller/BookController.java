package com.xue.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xue.model.Book;
import com.xue.model.BookPageMes;
import com.xue.service.BookService;
import com.xue.service.Impl.BookServiceImpl;

@Controller
@RequestMapping("BookController")
//�����ݸ�Ϊsession��������Ҫ��ע�� @SessionAttributes(value = {"asa","sas"}) huozhe("name")
public class BookController {
	@ResponseBody //����ֵһ��Ҫ��string������Ƿ���json���ݣ���Ҫʹ��tostring����
	@RequestMapping(value = "ajaxDeleteManyNo", method = RequestMethod.POST)
	public String ajaxDeleteManyNo(int[] manyNo,Map<String, Object> map) {
		BookService bs = new BookServiceImpl();
		boolean result = bs.deleteManyNo(manyNo);
//		if (result) { //�ɹ��Ļ��ض��򷵻���ҳ��Ϊʲô������ת��������Ϊ��������ظ��ύ��BUG
//			map.put("mes","ɾ���ɹ�");
//			return "redirect:goindex";
//		} else {  //ʧ�ܷ�����ҳ��ʾɾ��ʧ��
//			map.put("mes","ɾ��ʧ��");
//			return "redirect:goindex";
//		}
		return result + "";
	}
	
	@RequestMapping("goindex")
	public String goindex(Map<String, BookPageMes> map) {
		//��ѯÿҳ��ͼ����Ϣ���͵�bookindexҳ����
		//��ѯ��ҳ����book��Ϣ
		BookService bs = new BookServiceImpl();
		BookPageMes result = bs.selectBookByPage(1);
		map.put("BookMes", result);
		return "book_index";
	}
	@RequestMapping("goinsert")
	public String goinsert() {
		return "book_insert";
	}
	@RequestMapping("goinsertok")
	public String goinsertok(Book book, Map<String, Object> map) {
		//��ҵ���ķ����������ݿ�������book����
		BookService bs = new BookServiceImpl();
		boolean result = bs.insertBook(book);
		if (result) {
			return "redirect:goindex";
		} else {
			map.put("mes", "����ʧ��");
			return "book_insert";
		}
	}
}
