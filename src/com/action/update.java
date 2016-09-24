package com.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.str.str;

import dao.conn3;

public class update extends ActionSupport{
	private conn3 con=new conn3();
	public String up(){
		SessionFactory sessionFactory = con.buildsessionFactory();
		String string=ServletActionContext.getRequest().getParameter("string");
		int id=Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		System.out.println("U"+id);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query<str> query=session.createQuery("from str where id=?");
		query.setInteger(0, id);
		List result=query.list();
		if(result.size()>0){
			str str=(str)result.get(0);
			str.setstring(string);
			session.update(str);
			session.flush();
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			return SUCCESS;
		}else
			return ERROR;
		
	}
}
