package com.spring.FirstSpringDemo;

public class MessagePrinterBean {
	private String message;

	public MessagePrinterBean() {
		super();
		System.out.println("Inside constructor");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessagePrinterBean [message=" + message + "]";
	}
}



