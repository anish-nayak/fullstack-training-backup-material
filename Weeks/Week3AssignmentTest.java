package com.week.assignment;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Week3AssignmentTest {

	private Random random = new Random();
	private boolean flag = false;
	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	private int randomNo = -1;

	public Week3AssignmentTest() {
		Runnable producer = () -> {
			while(true) {
				try {
					lock.lock();
					if(Week3AssignmentTest.this.flag == true) {
						condition.await();
					}
					randomNo = random.nextInt(1000);
					System.out.println("Produced: " + randomNo);
					try { Thread.sleep(500); } catch(Exception e) { e.printStackTrace(); }
					flag = true;
					condition.signal();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					lock.unlock();
				}
			}
		};
		Runnable consumer = () -> {
			while(true) {
				try {
					lock.lock();
					if(flag == false) {
						condition.await();
					}
					System.out.println("Consuming: " + randomNo);
					//try { Thread.sleep(500); } catch(Exception e) { e.printStackTrace(); }
					flag = false;
					condition.signal();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					lock.unlock();
				}
			}
		};
		new Thread(consumer).start();
		new Thread(producer).start();
	}
	public static void main(String[] args) {
		new Week3AssignmentTest();
	}

}
