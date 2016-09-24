package com.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.opensymphony.xwork2.ActionSupport;
import com.str.str;

import dao.conn3;

public class add extends ActionSupport{
	private SessionFactory sessionFactory;
	private conn3 con=new conn3();
	public String add(){
		str str=new str();
		sessionFactory =con.buildsessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String s=(String)ServletActionContext.getRequest().getAttribute("string");
		session.save(new str(s));
		session.getTransaction().commit();
		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery( "from str where string="+s ).list();
		session.close();
		sessionFactory.close();
		if(result!=null)
			return SUCCESS;
		else
			return ERROR;
	}
	
}
