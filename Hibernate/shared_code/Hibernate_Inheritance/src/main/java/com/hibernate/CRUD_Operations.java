package com.hibernate;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class CRUD_Operations {

	public static void fireSQL(SessionFactory sessionFactory) {

Session session = sessionFactory.openSession();
NativeQuery sqlQuery = 
	session.createSQLQuery("SELECT P_ID, NAME FROM PRODUCT_MASTER");
List<Map> productList = sqlQuery.list();
for(Map hmapRow: productList) {
	//Map hmapRow = (Map)data;
	System.out.println(hmapRow.get("P_ID") + " - " + hmapRow.get("NAME"));
}

	}
	
	public static void main(String[] args) throws Exception {

Configuration configuration = new Configuration();
configuration.configure(new File("src/hibernate.cfg.xml"));

SessionFactory sessionFactory = configuration.buildSessionFactory();

//CREATE A PRODUCT
Session session_1 = sessionFactory.openSession();
Product product = new Product("Laptop", 40000);
Transaction transaction = session_1.beginTransaction();

session_1.save(product); //Hibernate
//OR
//session_1.persist(product); //JPA

long productId = product.getId();
transaction.commit();
session_1.close();

//UPDATE A PRODUCT
Session session_2 = sessionFactory.openSession();
transaction = session_2.beginTransaction();

Product product_2 = session_2.load(Product.class, productId);
//OR
//product_2 = session_2.get(Product.class, productId);

product_2.setPrice(55000);
session_2.update(product_2);
transaction.commit();
session_2.close();


//READ ALL PRODUCTS
//fireSQL(sessionFactory);

Session session_3 = sessionFactory.openSession();
//Query query = session_3.createQuery("from Product");
Query query = session_3.getNamedQuery("getAllProducts");
List<Product> productList = query.list();
for(Product product_3: productList) {
	System.out.println(product_3);
}
session_3.close();


//DELETE ALL PRODUCTS
Session session_4 = sessionFactory.openSession();

Query query_2 = session_4.createQuery("delete from Product");
transaction = session_4.beginTransaction();
int updates = query_2.executeUpdate();
System.out.println("No of records deleted = " + updates);
transaction.commit();
session_4.close();

sessionFactory.close();
	}

}












