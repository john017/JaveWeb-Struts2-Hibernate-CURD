package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.str.str;



public class PageListAction extends ActionSupport{
	private int allPage;  
    /** 页面大小 */  
    private int pageSize = 5;  
    /** 记录总数 */  
    private int allRows;  
    /** 当前页面数， 默认为1 */  
     int page = 1;  
    /** 第一条记录的索引 */  
    private int offset;
    searchall3 sa=new searchall3();
    HttpServletRequest request;
	public String sa() throws Exception {  
		request=ServletActionContext.getRequest();
        allRows = findRows();  
        offset = (page - 1) * pageSize;  
        if(request.getParameter("page")!=null)
        	{	
        		String s=request.getParameter("page").toString();
        		page=Integer.parseInt(s);
        	}
        System.out.println(page);
        if (allRows % pageSize == 0) {  
            allPage = allRows / pageSize;  
        } else {  
            allPage = allRows / pageSize + 1;  
        }  
        List<str> str=new ArrayList<str>();
        str= sa.sa(page,pageSize);  
        request.setAttribute("list", str);
        request.setAttribute("page", page);
        request.setAttribute("allpage", allPage);
        request.setAttribute("pageSize", pageSize);
        if (str != null) {  
            return SUCCESS;  
        }  
        return ERROR;  
    }
	private int findRows() { 
		System.out.println("S0");
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
				.build();
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<str> query=session.createQuery("from str");
		int rows=query.list().size();
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		System.out.println(rows);
		return rows;
		}  
	
}
