package com.hibernate.inheritance.singletable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Employee employee = new Employee("Tom", 10000);
		Labour labour = new Labour("Jerry", 20000, 5000);
		Manager manager = new Manager("Ivan", 20000, 5000);
		Transaction tx = session.beginTransaction();
		session.persist(employee);
		session.persist(labour);
		session.persist(manager);
		tx.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Employee, Labour & Manager saved into single table!!");
	}

}
