package com.Apple.employeeREST.EmployeeRESTproj.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import com.Apple.employeeREST.EmployeeRESTproj.Model.Employee;

@org.springframework.stereotype.Repository
public interface EmployeeDAO extends MongoRepository<Employee, String>{

	/*Method to get employees based on name*/
	@Query("{ 'fname' : ?0 }")
	List<Employee> readEmployeesfromName(String fname);

	/*Method to get employees based on department*/
	@Query("{ 'department' : ?0 }")
	List<Employee> readEmployeesbyDept(String department);
	
	

}
