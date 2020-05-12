package com.spring.hibernate.entity;
import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	
	@GeneratedValue
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String empname;
	
	@Column(name = "SAL")
	private double salary;
	
	public Employee() {}
	public Employee(String empname, double salary) {
		this.empname = empname;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String toString() {
		return id +"-" + empname + "-" + salary;
	}
}
