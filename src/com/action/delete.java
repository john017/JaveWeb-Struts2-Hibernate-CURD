package com.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.str.str;

import dao.conn2;
import dao.conn3;

public class delete extends ActionSupport{
	private conn3 con=new conn3();
	public String dl(){
		SessionFactory sessionFactory = con.buildsessionFactory();
		int id=(int) ServletActionContext.getRequest().getAttribute("id");
		System.out.println("D"+id);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<str> query=session.createQuery("from str where id=?");
		query.setInteger(0,id);
		List result = query.list();
		if(result.size()>0){
			str str=(str)result.get(0);
			session.delete(str);
			session.flush();
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			return SUCCESS;
		}else
			return ERROR;
	}
}
