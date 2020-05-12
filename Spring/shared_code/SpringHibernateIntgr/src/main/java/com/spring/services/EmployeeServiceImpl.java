package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.spring.dao.EmployeeDAO;
import com.spring.entity.Employee;
import com.spring.utils.EntityConvertor;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("employeeDao_3")
	private EmployeeDAO employeeDao;

	public void save(Employee employeeJson) {
		employeeDao.save(EntityConvertor.convertEmployeeJsonToHibernate(employeeJson));
	}

}
