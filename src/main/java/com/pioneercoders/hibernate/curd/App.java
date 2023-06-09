package com.pioneercoders.hibernate.curd;

import java.util.List;


public class App {
	
	
	public static void main(String[] args) {
		
		EmployeeDAOImpl empDaoImpl = new EmployeeDAOImpl();
		
		// create employee
		empDaoImpl.createEmployee("Rama", 24);
		empDaoImpl.createEmployee("Krisha", 24);
		empDaoImpl.createEmployee("Rama Krisha", 24);
		empDaoImpl.createEmployee("Test", 24);
		
		// Retrieve the employees
		List<EmployeeEntity> empList= empDaoImpl.retrieveEmployees();
		for(EmployeeEntity emp:empList){
			System.out.println("Emp Id:"+emp.getId()+" Emp Name:"+emp.getEmployeeName()+" Emp Age:"+emp.getAge());
		}
		
		// update employee
		empDaoImpl.updateEmployee(4, "Pioneer Coders", 32);
		
		// delete employee
		empDaoImpl.deleteEmployee(4);
		
		
	}


}