package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.opensymphony.xwork2.ActionSupport;
import com.str.*;

public class searchall2 extends ActionSupport{
	HttpServletRequest request=null;
	public String sa(){
		System.out.println("S2");
		List<str> str=new ArrayList<str>();
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
				.build();
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery( "from str" ).list();
		for ( str st : (List<str>) result ) {
			System.out.println( "str  : " + st.getstring() );
		}
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		request = ServletActionContext.getRequest();
		request.setAttribute("list", result);
		if(request.getAttribute("list")!=null)
			return SUCCESS;
		else
			return ERROR;
					
	}
}
