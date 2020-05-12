import java.io.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Inside main()");
		try {
			int i = 10/0; //unchecked exception
			File file = new File("abc.txt");
			FileOutputStream fos = new FileOutputStream(file);
		}
		catch(FileNotFoundException | ArithmeticException e) {
			e.printStackTrace();
		}
		/*
		catch(FileNotFoundException e) { //checked exception
			e.printStackTrace();
		}
		catch(ArithmeticException e) {
			e.printStackTrace();
		}
		*/
		try {
			System.out.println("Inside try");
			int z = 10/0;
			System.out.println("exit try");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Inside catch");
			e.printStackTrace();
		}
		System.out.println("Exit main()");
	}

}
