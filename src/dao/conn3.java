package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class conn3 {
	private SessionFactory sessionFactory;
	public SessionFactory buildsessionFactory(){
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
				.build();
		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		return sessionFactory;
	}
	public void close(){
		sessionFactory.close();
	}
}
