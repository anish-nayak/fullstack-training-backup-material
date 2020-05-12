package com.spring.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.entity.Employee;

public class EmployeeHibernateDAOSupportImpl 
extends HibernateDaoSupport 
	implements EmployeeDAO {

	@Transactional
	public void save(Employee employee) {
		getHibernateTemplate().save(employee);
	}
	


}
