package com.spring.FirstSpringDemo;

public class EmployeeBean {

	private String name;
	
	private ProjectBean project;
	
	public EmployeeBean() {
	}

	public EmployeeBean(ProjectBean project) {
		this.project = project;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProjectBean getProject() {
		return project;
	}
	public void setProject(ProjectBean project) {
		this.project = project;
	}
}
