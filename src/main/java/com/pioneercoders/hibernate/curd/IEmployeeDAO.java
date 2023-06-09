package com.pioneercoders.hibernate.curd;

import java.util.List;

public interface IEmployeeDAO {
	
	public void createEmployee(String empName, int age);

	public void updateEmployee(int empId ,String empName, int age);
	
	public void deleteEmployee(int empId);
	
	public List<EmployeeEntity> retrieveEmployees();
}
