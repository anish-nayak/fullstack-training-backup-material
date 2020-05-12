package com.java8.approaches.util;

@FunctionalInterface
public interface TransactionPredicate {
	boolean test(Transaction t);
	default public void foo() {
		
	}
	public static void bar() {
		
	}
}
