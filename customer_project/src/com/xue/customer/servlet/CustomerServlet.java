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
		}  else if ("gotodelete".equals(flag)) {  //给删除画面传值，并且转到删除画面
			String customerDeleteId = request.getParameter("cus_delete_id");
			request.setAttribute("deleteId", customerDeleteId);
			request.getRequestDispatcher("cus_delete.jsp").forward(request, response);
		}  else if ("gotoupdate".equals(flag)) {  //收前端传来的要修改的信息，转到update画面
			String cusId = request.getParameter("cus_update_id");
			//根据id在数据库中查到customer信息
			CustomerService cusService = new CustomerServiceImpl();
			Customer cus = cusService.selectCustomerById(Integer.parseInt(cusId));
			//准备一个对象装这些数据，
//			Customer cus = new Customer();
//			cus.setId(Integer.parseInt(cusId));
//			cus.setName(cusName);
//			cus.setScore(Integer.parseInt(cusScore));
//			cus.setTel(cusTel);
//			cus.setSex(cusSex);
//			Customer cus = setCus(cusId, cusName, cusScore, cusTel, cusSex);
			//给前段update画面传过去 
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
		//首先先解决前段post中文乱码问题
		request.setCharacterEncoding("UTF-8");
		//接取相应的值，判断转向那个页面
		String flag = request.getParameter("flag");
		//转页面
		if ("gotoindex".equals(flag)) {
				//给首页表格赋值，首先全查询查到list表
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
			//接取到前段输入的值
			String cusId = request.getParameter("cus_id");
			String cusName = request.getParameter("cus_name");
			String cusScore = request.getParameter("cus_score");
			String cusTel = request.getParameter("cus_tel");
			String cusSex = request.getParameter("cus_sex");
			//创建对象，将值装入
			Customer cus = new Customer();
			cus.setId(Integer.parseInt(cusId));
			cus.setName(cusName);
			cus.setScore(Integer.parseInt(cusScore));
			cus.setTel(cusTel);
			cus.setSex(cusSex);
			//调用方法，将数据装到数据库
			CustomerService cusService = new CustomerServiceImpl();
			//将数据装到数据库
			boolean result = cusService.inserCustomer(cus);
			if (result) {
				request.setAttribute("cus_insert_ok_id", cusId);
				request.setAttribute("cus_insert_ok_name", cusName);
				request.setAttribute("cus_insert_ok_score", cusScore);
				request.setAttribute("cus_insert_ok_tel", cusTel);
				request.setAttribute("cus_insert_ok_sex", cusSex);
				request.getRequestDispatcher("cus_insert_ok.jsp").forward(request, response);
			} else {
				String alert = "添加会员失败，可能原因一：id输入了非数字，二：积分输入过高";
				request.setAttribute("alert", alert);
				request.getRequestDispatcher("cus_insert.jsp").forward(request, response);
			}
		}else if ("gotodeleteok".equals(flag)) { //删除确认后，区sql删除数据，并显示出来，成跳转到跳转成功页面，否则返回原网页
			String customerDeleteId = request.getParameter("cus_delete_id");
			boolean result = c1.deleteCustomer(Integer.parseInt(customerDeleteId));
			if (result) {
				request.setAttribute("deleteId", customerDeleteId);
				request.getRequestDispatcher("cus_delete_ok.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("cus_delete.jsp").forward(request, response);
			}
		} else if ("gotoupdateok".equals(flag)) { //接到修改画面传来的值，并在数据库中修改，然后返回到update_Ok页面
//			String cusName = request.getParameter("cus_name");
			String customerUpdateId = request.getParameter("update_id");
			String customerUpdateName = request.getParameter("update_name");
			String customerUpdateScore = request.getParameter("update_score");
			String customerUpdateTel = request.getParameter("update_tel");
			String customerUpdateSex = request.getParameter("update_sex");
			//创建一个对象，给对象赋值
			Customer updateCus = setCus(customerUpdateId, customerUpdateName, customerUpdateScore, customerUpdateTel, customerUpdateSex);
			//调用方法，修改数据库数据
			boolean result = c1.updateCustomer(updateCus);
			//给前段键值对
			if (result) {
				request.setAttribute("cus_id", customerUpdateId);
				request.setAttribute("cus_name", customerUpdateName);
				request.setAttribute("cus_score", customerUpdateScore);
				request.setAttribute("cus_tel", customerUpdateTel);
				request.setAttribute("cus_sex", customerUpdateSex);
				request.getRequestDispatcher("cus_update_ok.jsp").forward(request, response);
			} else {
				System.out.println("修改失败");
				request.getRequestDispatcher("cus_update.jsp").forward(request, response);
			}
		} else if ("gotoselect".equals(flag)) { //模糊查询并将数据传回首页
			doselect(request,response);
		}
	}

	private void doselect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 执行模糊查询
		//截取前段的id和tel
		String id = request.getParameter("id");
		String tel = request.getParameter("tel");
		//调用方法执行模糊查询工作
		CustomerService cus = new CustomerServiceImpl();
		List<Customer> list = cus.selectCustomerByIdAndTel(id, tel);
		//将键值对返回jsp文件，注意此时的键名和之前的一致
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
