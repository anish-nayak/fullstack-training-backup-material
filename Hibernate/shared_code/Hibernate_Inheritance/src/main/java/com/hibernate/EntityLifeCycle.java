package com.hibernate;

import java.io.File;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EntityLifeCycle {

	public static void main(String[] args) throws Exception {

Configuration configuration = new Configuration();
configuration.configure(new File("src/hibernate.cfg.xml"));

SessionFactory sessionFactory = configuration.buildSessionFactory();

//CREATE A PRODUCT
Session session_1 = sessionFactory.openSession();
Product product = new Product("Laptop", 40000); //Transient entity
Transaction transaction = session_1.beginTransaction();
session_1.save(product); //Persistent entity
long productId = product.getId();
transaction.commit();
session_1.evict(product); //Detach entity
session_1.delete(product); //Removed entity
session_1.close();

//UPDATE A PRODUCT
Session session_2 = sessionFactory.openSession();
transaction = session_2.beginTransaction();

Product product_2 = session_2.load(Product.class, productId);

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












