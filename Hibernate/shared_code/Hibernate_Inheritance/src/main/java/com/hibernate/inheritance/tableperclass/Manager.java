package com.hibernate.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MANAGER")
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
