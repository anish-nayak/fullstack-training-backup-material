package com.reflection;

import java.lang.reflect.Constructor;

class A {
	public A(String str, boolean x, char ch) {
		System.out.println("Inside constructor: " + str + " - " + x + " ch " + ch);
	}
	public A(String str, boolean x) {
		System.out.println("Inside constructor: " + str + " - " + x);
	}
	public A(String str) {
		System.out.println("Inside constructor: " + str);
	}
	/*public A() {} */
}

public class InstanceCreationTest {

	public static void main(String[] args) throws Exception {
		
		Class c = Class.forName("com.reflection.A");
		Constructor constructors[] = c.getDeclaredConstructors();
		boolean foundDefaultConstructor = false;
		for(Constructor constructor : constructors) {
			if(constructor.getParameterCount()==0) { //Default constructor found
				foundDefaultConstructor = true;
				createDefaultInstance(c);
				break;
			}
		}
		if(foundDefaultConstructor==false) { //No default constructor found
			Class paramTypes[] = constructors[0].getParameterTypes();
			Object paramValues[] = new Object[paramTypes.length];
			Object paramRef = null;
			for(int i=0;i<paramTypes.length;i++) {
				System.out.println("paramTypes[i] = " + paramTypes[i]);
				if(paramTypes[i].isPrimitive()==true) {
					if(paramTypes[i] == Number.class) {
							paramValues[i] = 0;
					}
					else if(paramTypes[i] == boolean.class){
						paramValues[i] = false;
					}
					else if(paramTypes[i] == char.class){
						paramValues[i] = 'a';
					}
				}
				else {
					paramValues[i] = null;
				}
			}
			constructors[0].newInstance(paramValues);
		}
	}
	public static void createDefaultInstance(Class c) throws Exception {
		Object obj = c.newInstance();
		System.out.println("Created default instance: " + obj);
	}
}
