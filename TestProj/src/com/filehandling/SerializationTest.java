package com.filehandling;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest {
	public static void main(String args[]) throws Exception {
		Order order = new Order("Chairs", 20000.50, 50);
		//writeObject(order);
		//System.out.println("object serialized");
		System.out.println("Reading order object: " + readObject());
	}
	
	public static void writeObject(Order order)throws Exception { //Serialization
		File file = new File("G:\\anand\\Training\\Ongoing_trainings\\IBM_Fullstack_Bhuwaneshwar\\Core_Java\\code\\orders.dat");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(order);
		oos.flush();
		fos.flush();
		oos.close();
		fos.close();
	}
	public static Order readObject() throws Exception{
		File file = new File("G:\\anand\\Training\\Ongoing_trainings\\IBM_Fullstack_Bhuwaneshwar\\Core_Java\\code\\orders.dat");
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Order order = (Order)ois.readObject();
		ois.close();
		fis.close();
		return order;
	}
}


class Account implements Externalizable {
	int accno;
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.write(this.accno);
	}
	
}

class Order implements Serializable {
	
	
	private static final long serialVersionUID = 2L;
	
	private String name;
	private double price;
	private int quantity;
	public Order(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Order [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
class Date implements Serializable { 
	int day = 20;
	public Date(int day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "Date [day=" + day + "]";
	}
}

