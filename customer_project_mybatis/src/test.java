import java.util.List;

import com.xue.custom.model.Customer;
import com.xue.customer.service.CustomerService;
import com.xue.customer.srrvice.Impl.CustomerServiceImpl;

public class test {
	public static void main(String[] args) {
		//׼��sql���
//		String sql = "insert into tbl_customer values(105,'��',101,12312312312,'��')";
//		boolean result = CustomerDao.update(sql); 
//		if (result) {
//			System.out.println("�ɹ�");
//		} else {
//			System.out.println("ʧ��");
//		}
//		String sql = "select customer_id,customer_name, customer_score, customer_tel, customer_sex from tbl_customer";
//		List<Customer> cus1 = CustomerDao.query(sql);
//		for (Customer customer : cus1) {
//			System.out.println(customer);
//		}
		CustomerService ci1 = new CustomerServiceImpl();
		List<Customer> cs1 = ci1.selectCustomer();
		for (Customer customer : cs1) {
			System.out.println(customer);
		}
	}
}
