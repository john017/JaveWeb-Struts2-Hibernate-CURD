package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.opensymphony.xwork2.ActionSupport;
import com.str.*;

import dao.conn3;

public class searchall3{
	HttpServletRequest request=null;
	private conn3 con=new conn3();
	public List sa(int page,int pagesize){
		System.out.println("S3");
		List<str> str=new ArrayList<str>();
		SessionFactory sessionFactory = con.buildsessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<str> query=session.createQuery("from str");
		query.setFirstResult((page-1)*pagesize);
		query.setMaxResults(pagesize);
		List result = query.list();
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		return result;
					
	}
}
