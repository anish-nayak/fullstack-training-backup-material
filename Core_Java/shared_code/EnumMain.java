package com.java;

enum Fruits {
	APPLE(5), BANANA(2), ORANGE(35);
	int value;
	Fruits(int value) {
		System.out.println("Inside constructor: " + value);
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		switch(this) {
			case APPLE: return "toString() Apple " + value;
			case BANANA: return "toString() Banana " + value;
			default: return "Invalid fruit";
		}
	}
};

public class EnumMain {

	public static void main(String[] args) {
		Fruits f = Fruits.APPLE;
		System.out.println("Apple value = " + f.getValue());
		f.setValue(35);
		System.out.println("Apple value = " + Fruits.APPLE);
		System.out.println(f);
		
		switch(f) {
			case ORANGE: System.out.println("switch Apple found"); break;
			default: System.out.println("switch Invalid fruit");
		}
	}

}




