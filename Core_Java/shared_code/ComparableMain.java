package com.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class OrderTitleComparator implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		return o1.title.compareTo(o2.title)*-1;
	}
}

class OrderPriceComparator implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		if(o1.price > o2.price) {
			return -1;
		}
		else if(o1.price < o2.price) {
			return 1;
		}
		return 0;
	}
}

class Order implements Comparable<Order> {

	String title;
	double price;
	
	public Order(String title, double price) {
		this.title = title;
		this.price = price;
	}
	
	public String toString() {
		return title + " - " + price;
	}

	//@Override
	public int compareTo(Order o) {
		if(this.price > o.price) {
			return -1;
		}
		else if(this.price < o.price) {
			return 1;
		}
		return 0;
	}
}
public class ComparableMain {

	public static void main(String[] args) {
		Order order1 = new Order("Chair purchase", 12000);
		Order order2 = new Order("Table purchase", 15000);
		Order order3 = new Order("Furniture Sale", 12000);
		
		List<Order> list = new ArrayList<Order>();
		list.add(order1);
		list.add(order2);
		list.add(order3);
		
		//Collections.sort(list); //calls Comparable
Collections.sort(list, new OrderTitleComparator()); //calls Comparator
		
		for(Order order: list) {
			System.out.println(order);
		}
	}

}
