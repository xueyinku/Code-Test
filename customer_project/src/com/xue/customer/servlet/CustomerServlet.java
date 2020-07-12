package com.xue.customer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.xue.custom.model.Customer;
import com.xue.customer.dao.CustomerDao;
import com.xue.customer.service.CustomerService;
import com.xue.customer.srrvice.Impl.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if ("gotoindex".equals(flag)) {
			CustomerService c1 = new CustomerServiceImpl();
			List<Customer> allCustomer = c1.selectCustomer();
			request.setAttribute("allcustomer", allCustomer);
			request.getRequestDispatcher("cus_index.jsp").forward(request, response);
		} 
//		else if("gotoregister".equals(flag)){
//			request.getRequestDispatcher("cus_register.jsp").forward(request, response);
//		} else if("gotoregisterok".equals(flag)){
//			request.getRequestDispatcher("cus_register_ok.jsp").forward(request, response);
//		} else if ("gotologin".equals(flag)) {
//			request.getRequestDispatcher("cus_login.jsp").forward(request, response);
//		} 
		else if ("gotoinsert".equals(flag)) {
			request.getRequestDispatcher("cus_insert.jsp").forward(request, response);
		}  else if ("gotodelete".equals(flag)) {  //��ɾ�����洫ֵ������ת��ɾ������
			String customerDeleteId = request.getParameter("cus_delete_id");
			request.setAttribute("deleteId", customerDeleteId);
			request.getRequestDispatcher("cus_delete.jsp").forward(request, response);
		}  else if ("gotoupdate".equals(flag)) {  //��ǰ�˴�����Ҫ�޸ĵ���Ϣ��ת��update����
			String cusId = request.getParameter("cus_update_id");
			//����id�����ݿ��в鵽customer��Ϣ
			CustomerService cusService = new CustomerServiceImpl();
			Customer cus = cusService.selectCustomerById(Integer.parseInt(cusId));
			//׼��һ������װ��Щ���ݣ�
//			Customer cus = new Customer();
//			cus.setId(Integer.parseInt(cusId));
//			cus.setName(cusName);
//			cus.setScore(Integer.parseInt(cusScore));
//			cus.setTel(cusTel);
//			cus.setSex(cusSex);
//			Customer cus = setCus(cusId, cusName, cusScore, cusTel, cusSex);
			//��ǰ��update���洫��ȥ 
			request.setAttribute("cusupdate", cus);
			request.getRequestDispatcher("cus_update.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	CustomerService c1 = new CustomerServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����Ƚ��ǰ��post������������
		request.setCharacterEncoding("UTF-8");
		//��ȡ��Ӧ��ֵ���ж�ת���Ǹ�ҳ��
		String flag = request.getParameter("flag");
		//תҳ��
		if ("gotoindex".equals(flag)) {
				//����ҳ���ֵ������ȫ��ѯ�鵽list��
				List<Customer> allCustomer = c1.selectCustomer();
				request.setAttribute("allcustomer", allCustomer);
				request.getRequestDispatcher("cus_index.jsp").forward(request, response);
		}
//		else if("gotoregister".equals(flag)){
//			request.getRequestDispatcher("cus_register.jsp").forward(request, response);
//		} else if("gotoregisterok".equals(flag)){
//			String cusNewTel = request.getParameter("customer_reg_tel");
//			request.setAttribute("cus_reg_ok_tel", cusNewTel);
//			request.getRequestDispatcher("cus_register_ok.jsp").forward(request, response);
//		} else if ("gotologin".equals(flag)) {
//			request.getRequestDispatcher("cus_login.jsp").forward(request, response);
//		} 
		else if ("gotoinsert".equals(flag)) {
			request.getRequestDispatcher("cus_insert.jsp").forward(request, response);
		} else if ("gotoinsertok".equals(flag)) {
			//��ȡ��ǰ�������ֵ
			String cusId = request.getParameter("cus_id");
			String cusName = request.getParameter("cus_name");
			String cusScore = request.getParameter("cus_score");
			String cusTel = request.getParameter("cus_tel");
			String cusSex = request.getParameter("cus_sex");
			//�������󣬽�ֵװ��
			Customer cus = new Customer();
			cus.setId(Integer.parseInt(cusId));
			cus.setName(cusName);
			cus.setScore(Integer.parseInt(cusScore));
			cus.setTel(cusTel);
			cus.setSex(cusSex);
			//���÷�����������װ�����ݿ�
			CustomerService cusService = new CustomerServiceImpl();
			//������װ�����ݿ�
			boolean result = cusService.inserCustomer(cus);
			if (result) {
				request.setAttribute("cus_insert_ok_id", cusId);
				request.setAttribute("cus_insert_ok_name", cusName);
				request.setAttribute("cus_insert_ok_score", cusScore);
				request.setAttribute("cus_insert_ok_tel", cusTel);
				request.setAttribute("cus_insert_ok_sex", cusSex);
				request.getRequestDispatcher("cus_insert_ok.jsp").forward(request, response);
			} else {
				String alert = "��ӻ�Աʧ�ܣ�����ԭ��һ��id�����˷����֣����������������";
				request.setAttribute("alert", alert);
				request.getRequestDispatcher("cus_insert.jsp").forward(request, response);
			}
		}else if ("gotodeleteok".equals(flag)) { //ɾ��ȷ�Ϻ���sqlɾ�����ݣ�����ʾ����������ת����ת�ɹ�ҳ�棬���򷵻�ԭ��ҳ
			String customerDeleteId = request.getParameter("cus_delete_id");
			boolean result = c1.deleteCustomer(Integer.parseInt(customerDeleteId));
			if (result) {
				request.setAttribute("deleteId", customerDeleteId);
				request.getRequestDispatcher("cus_delete_ok.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("cus_delete.jsp").forward(request, response);
			}
		} else if ("gotoupdateok".equals(flag)) { //�ӵ��޸Ļ��洫����ֵ���������ݿ����޸ģ�Ȼ�󷵻ص�update_Okҳ��
//			String cusName = request.getParameter("cus_name");
			String customerUpdateId = request.getParameter("update_id");
			String customerUpdateName = request.getParameter("update_name");
			String customerUpdateScore = request.getParameter("update_score");
			String customerUpdateTel = request.getParameter("update_tel");
			String customerUpdateSex = request.getParameter("update_sex");
			//����һ�����󣬸�����ֵ
			Customer updateCus = setCus(customerUpdateId, customerUpdateName, customerUpdateScore, customerUpdateTel, customerUpdateSex);
			//���÷������޸����ݿ�����
			boolean result = c1.updateCustomer(updateCus);
			//��ǰ�μ�ֵ��
			if (result) {
				request.setAttribute("cus_id", customerUpdateId);
				request.setAttribute("cus_name", customerUpdateName);
				request.setAttribute("cus_score", customerUpdateScore);
				request.setAttribute("cus_tel", customerUpdateTel);
				request.setAttribute("cus_sex", customerUpdateSex);
				request.getRequestDispatcher("cus_update_ok.jsp").forward(request, response);
			} else {
				System.out.println("�޸�ʧ��");
				request.getRequestDispatcher("cus_update.jsp").forward(request, response);
			}
		} else if ("gotoselect".equals(flag)) { //ģ����ѯ�������ݴ�����ҳ
			doselect(request,response);
		}
	}

	private void doselect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ִ��ģ����ѯ
		//��ȡǰ�ε�id��tel
		String id = request.getParameter("id");
		String tel = request.getParameter("tel");
		//���÷���ִ��ģ����ѯ����
		CustomerService cus = new CustomerServiceImpl();
		List<Customer> list = cus.selectCustomerByIdAndTel(id, tel);
		//����ֵ�Է���jsp�ļ���ע���ʱ�ļ�����֮ǰ��һ��
		request.setAttribute("allcustomer", list);
		request.getRequestDispatcher("cus_index.jsp").forward(request, response);
	}

	public static Customer setCus(String id,String name,String score,String tel,String sex) {
		Customer cus = new Customer();
		cus.setId(Integer.parseInt(id));
		cus.setName(name);
		cus.setScore(Integer.parseInt(score));
		cus.setTel(tel);
		cus.setSex(sex);
		return cus;
	}
}
