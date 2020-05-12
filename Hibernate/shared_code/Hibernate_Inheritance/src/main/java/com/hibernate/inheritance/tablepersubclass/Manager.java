package com.hibernate.inheritance.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="MANAGER")
@PrimaryKeyJoinColumn(name="empId")
public class Manager extends Employee {

	@Column
	private double incentive;

	public Manager(String name, double sal, double incentive) {
		super(name, sal);
		this.incentive = incentive;
	}

	public double getIncentive() {
		return incentive;
	}

	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}
	
}
