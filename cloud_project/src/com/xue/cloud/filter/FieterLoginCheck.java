package com.xue.cloud.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xue.cloud.model.User;

/**
 * Servlet Filter implementation class FileterUTF
 */
@WebFilter(filterName = "/FileterLoginCheck",urlPatterns = "*.jsp")
public class FieterLoginCheck implements Filter {

    /**
     * Default constructor. 
     */
    public FieterLoginCheck() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO ���е�½��֤�����û�е�½�����������ҳ�棬���ص�½ҳ
		//�Ƚ��������Ӧ����ת��
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		//�ж��Ƿ��ǽ����½ҳ��
		String requestUri = httpRequest.getRequestURI();
		if (requestUri.indexOf("login") == -1) { //���ǽ����½ҳ�棬��Ҫ���Ǻ�i����seesion����
			User user = (User) httpRequest.getSession().getAttribute("user");
			if (user == null) { //���û��session��Ϣ
				//���ص�½ҳ��
				httpResponse.sendRedirect("login.jsp");//�ض���
				return;
			}
		}
		chain.doFilter(httpRequest, httpResponse);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
