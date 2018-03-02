package com.threadtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Student{
		
		int roll;
		public int getRoll() {
			return roll;
		}
		public void setRoll(int roll) {
			this.roll = roll;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public Student(int roll, String name, String address) {
			super();
			this.roll = roll;
			this.name = name;
			this.address = address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		String name,address;
	}
	
public class testing {
	public static void main(String[] args) {
	
		ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(111, "bbbb", "london"));
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(121, "cccc", "jaipur"));
 
        System.out.println("Unsorted");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i).getAddress());
        
//      Comparator<Student> com= new Comparator<Student>() {
//    	  public int compare(Student a, Student b)
//    	    {
//    	        return a.roll - b.roll;}
//    	    
//	};   
       // Collections.sort(ar,com);
	Collections.sort(ar, (a,b)-> a.getAddress().compareTo(b.getAddress()));
	//ar.sort((a,b)-> a.getRoll()-b.getRoll());
       // ar.sort(Comparator.comparing(Student::getAddress));
	 System.out.println("\nSorted by rollno");
     for (int i=0; i<ar.size(); i++)
         System.out.println(ar.get(i).getAddress());
        
	}}


