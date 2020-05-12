package com.hibernate.FirstHibernateDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_MASTER")
public class Product {

	// AUTO, IDENTITY, TABLE, SEQUENCE
	@GeneratedValue
	@Id
	@Column(name="p_id")
	private Long id;
	
	@Column(name="name")
	private String name;

	@Column(name="cost")
	private double price;
	
	public Product() {
	}
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public Product(Long id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return id + " - " + name + " - " + price;
	}
}





/*
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
@SequenceGenerator(
    name="course_seq",
    sequenceName="course_sequence",
    allocationSize=20
)
*/