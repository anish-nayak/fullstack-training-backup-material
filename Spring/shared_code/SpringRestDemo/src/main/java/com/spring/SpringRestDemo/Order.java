package com.spring.SpringRestDemo;

public class Order {
	private int id;
	private String title;
	private double price;
	public Order() {}
	public Order(int id, String title, double price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		Order order = (Order)obj;
		if(order.getId()==this.getId())
			return true;
		return false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", title=" + title + ", price=" + price + "]";
	}
	
}
