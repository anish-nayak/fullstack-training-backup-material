package com.filehandling;

import java.io.File;
import java.io.FileInputStream;

public class FileOperations {

	public static void main(String[] args) throws Exception {
		
File file = 
new File("G:\\anand\\Training\\Ongoing_trainings\\IBM_Fullstack_Bhuwaneshwar\\Core_Java\\code\\abc.txt");
FileInputStream fis = new FileInputStream(file);
StringBuilder sb = new StringBuilder("");
int i=0;
do {
	i = fis.read();
	if(i!=-1) {
		sb.append((char)i);
	}
}while(i!=-1);
System.out.println("File Contents: " + sb.toString());
fis.close();

/*
FileOutputStream fos = new FileOutputStream(file, true);
String msg = "Hello ITER students";
fos.write(msg.getBytes());
fos.flush();
fos.close();
System.out.println("File written");
*/
	}

}
