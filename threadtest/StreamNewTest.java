package com.threadtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee
{
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empName=" + empName + ", salary=" + salary + ", department="
				+ department + ", designation=" + designation + "]";
	}

	Employee()
	{}
	
	public Employee(String employeeId, String empName, String salary, String department, String designation) {
		super();
		this.employeeId = employeeId;
		this.empName = empName;
		this.salary = salary;
		this.department = department;
		this.designation = designation;
	}
	private String employeeId;
	private String empName;
	private String salary;
	private String department;
	private String designation;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}

public class StreamNewTest {
	
	//public List<Employee>


	public static List<Employee> applyConditions(List<Employee> newList)
	{
		return  newList.stream().filter(x->x.getDepartment().equals("chem")).sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList());
	}
	
	public static void main(String args[]) {

		
		String fileName = "/Users/Talent/Documents/workspace/com.threadtest/src/com/threadtest/Newemployee.properties";
		List<String> list = new ArrayList<>();
		List<Employee> empObj=new ArrayList<>();

		try (

			Stream<String> stream = Files.lines(Paths.get(fileName))) {
			//stream.forEach(System.out::println);
			list=stream.collect(Collectors.toList());
			//list.forEach(System.out::println);
			int j=0;
			for(int i=0;i<list.size()/5;i++)
			{
				empObj.add(new Employee(list.get(j),list.get(j+1),list.get(j+2),list.get(j+3),list.get(j+4)));
				j=j+5;
			}
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		/*try{
			File file= new File("/Users/Talent/Documents/workspace/com.threadtest/src/com/threadtest/employee.properties");
			FileInputStream fileInput=new FileInputStream(file);
			Properties prop= new Properties();
			prop.load(fileInput);
			fileInput.close();
			Enumeration enumKey=prop.keys();
			
			while(enumKey.hasMoreElements())
			{
				String key=(String) enumKey.nextElement();
				String value=prop.getProperty(key);
				System.out.println(key+":"+value);
			}
		}catch(Exception e)
		{
		}*/
		
		
		//List<Employee> newempObj=new ArrayList<>();
		 //   try {
		    	
		    	//applyConditions(empObj);
		        
		      //  newempObj=empObj.stream().filter(x->x.getDepartment().equals("chem")).sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList());
		    	
		    //} catch (Exception e) {
		       // throw new IllegalStateException(e);
		 //   }
		   //return newempObj;
		
		
		/*Calling completable future*/
		CompletableFuture<List<Employee>> future = CompletableFuture.supplyAsync(() -> {
		return applyConditions(empObj);
		}).exceptionally(ex -> {
		    System.out.println("We have an exception - " + ex.getMessage());
		    return null;
		});

		try {
			
			System.out.println(future.get());
			//future.get().forEach(x-> {System.out.println(x.toString());});//"EmpId :" +x.getEmployeeId()+" EmpName : "+x.getEmpName()+" Dept :"+x.getDepartment()+" designation :"+x.getDesignation()+" Salary :"+x.getSalary());});;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
