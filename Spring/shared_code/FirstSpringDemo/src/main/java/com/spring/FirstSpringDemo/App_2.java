package com.spring.FirstSpringDemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App_2 {

	public static void main(String[] args) {
		
		AbstractApplicationContext iocContainer = 
			new ClassPathXmlApplicationContext("Beans_simple.xml");
		MessagePrinterBean messagePrinterBean = (MessagePrinterBean)iocContainer.getBean("messagePrinter");
		System.out.println("Message: " + messagePrinterBean.getMessage());
	}

}
