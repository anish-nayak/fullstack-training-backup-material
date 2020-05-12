package com.spring.FirstSpringDemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
AbstractApplicationContext iocContainer = 
			new ClassPathXmlApplicationContext("Beans_simple.xml");
EmployeeBean ebean = (EmployeeBean)iocContainer.getBean("employee");
System.out.println("Project Name: " + ebean.getProject().getName());




/*
MessagePrinterBean bean = (MessagePrinterBean)iocContainer.getBean("messagePrinter");
MessagePrinterBean bean_2 = (MessagePrinterBean)iocContainer.getBean("messagePrinter");
System.out.println("Bean message: " + bean.getMessage());
System.out.println("Bean_2 message: " + bean_2.getMessage());
*/
    }
}
