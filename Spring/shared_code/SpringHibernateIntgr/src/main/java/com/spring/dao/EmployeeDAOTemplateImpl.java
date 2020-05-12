package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.entity.Employee;

public class EmployeeDAOTemplateImpl implements EmployeeDAO {

	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void save(Employee employee) {
		template.save(employee);
	}
	


}
