package com.xue.cloud.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ListenerUi
 *
 */
@WebListener
public class ListenerUi implements HttpSessionListener {
	private int count;
    /**
     * Default constructor. 
     */
    public ListenerUi() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO seesion����ʱ���еĴ���
    	count++;
    	//����������װ��appliation�������м���
    	se.getSession().getServletContext().setAttribute("count", count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO seesion����ʱ���еĴ���
    	count--;
    	se.getSession().getServletContext().setAttribute("count", count);
    }
	
}
