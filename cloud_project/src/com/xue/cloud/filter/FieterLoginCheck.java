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
		// TODO 进行登陆验证，如果没有登陆过不允许进入页面，返回登陆页
		//先将请求和相应进行转型
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		//判断是否是进入登陆页面
		String requestUri = httpRequest.getRequestURI();
		if (requestUri.indexOf("login") == -1) { //不是进入登陆页面，需要看是和i否有seesion对象
			User user = (User) httpRequest.getSession().getAttribute("user");
			if (user == null) { //如果没有session信息
				//返回登陆页面
				httpResponse.sendRedirect("login.jsp");//重定向
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
