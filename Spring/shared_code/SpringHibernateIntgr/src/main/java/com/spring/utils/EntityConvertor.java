package com.spring.utils;

public class EntityConvertor {
	
	public static com.spring.hibernate.entity.Employee convertEmployeeJsonToHibernate(com.spring.entity.Employee empJson) {
		com.spring.hibernate.entity.Employee empDB = new com.spring.hibernate.entity.Employee();
		empDB.setEmpname(empJson.getEmpname());
		empDB.setSalary(empJson.getSalary());
		return empDB;
	}
	
	public static com.spring.entity.Employee convertEmployeeHibernateToJson(com.spring.hibernate.entity.Employee empDB) {
		com.spring.entity.Employee empJson = new com.spring.entity.Employee();
		empJson.setEmpname(empDB.getEmpname());
		empJson.setSalary(empDB.getSalary());
		empJson.setId(empDB.getId());
		return empJson;
	}
}
