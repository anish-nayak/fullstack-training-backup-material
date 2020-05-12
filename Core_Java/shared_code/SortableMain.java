package com.java;

interface Sortable{
	boolean compare(Sortable s);
}

class Employee3 implements Sortable
{
   String name;
   float salary;
   public Employee3(String name, float salary)
   {
	   this.name=name;
	   this.salary=salary;
   }
   @Override
   public boolean compare(Sortable s) {
	   if(this.salary < ((Employee3)s).salary)
		   return true;
	   return false;
   }
   
   public String toString()
   {
	   return ""+this.salary;
   }
}

class Circle2 implements Sortable, Cloneable
{
   
   float radius;
   public Circle2(float radius)
   {
	   this.radius=radius;
   }
	@Override
	public boolean compare(Sortable s) {
		if(this.radius < ((Circle2)s).radius)
			return true;
		return false;
	}
	public String toString()
	{
		return ""+this.radius;
	}
}

public class SortableMain {

	public static void sortAll(Sortable x[]) 
	{
	   Sortable temp;
	   for(int i=0; i<x.length;i++)
	   {
		   for(int j=i+1; j<x.length;j++)
		   {
			   if(x[i].compare(x[j]))
			   {
				   temp=x[i];
				   x[i]=x[j];
				   x[j]=temp;
			   }
		   }
		   
	   }
	   for(int i=0; i<x.length;i++)
	   {
		   System.out.println(x[i]);
	   }
	
	}
	public static void main(String[] args) throws Exception
	{
		Sortable se[]=new Sortable[2];
		Sortable sc[]=new Sortable[2];
		se[0]=new Employee3("A",100);
		se[1]=new Employee3("B",200);
		sc[0]=new Circle2(2);
		sc[1]=new Circle2(3);
		sortAll(se);
		sortAll(sc);

		Circle2 c = new Circle2(10);
		
	}

}
