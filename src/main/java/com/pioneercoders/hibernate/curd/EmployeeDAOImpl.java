package com.pioneercoders.hibernate.curd;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDAOImpl implements IEmployeeDAO {

	private SessionFactory sessionFactory = HibenateUtils.getSessionFactory();

	public void createEmployee(String empName, int age) {

		// construct employee entity
		EmployeeEntity empent = new EmployeeEntity();
		empent.setEmployeeName(empName);
		empent.setAge(age);

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(empent);
		// commit the changes to db.
		transaction.commit();

		System.out.println("----------- Emplyee created successfully in DB ------------------------");
	}

	public void updateEmployee(int empId, String empName, int age) {

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		// get employee entity from session 
		EmployeeEntity empent = (EmployeeEntity) session.get(EmployeeEntity.class, new Long(empId));
		empent.setEmployeeName(empName);
		empent.setAge(age);
		
		// save the entity into session
		session.save(empent);
		
		// commit the changes to db.
		transaction.commit();

		System.out.println("----------- Updated successfully ------------------------");

	}

	public void deleteEmployee(int empId) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		// get employee entity from session 
		EmployeeEntity empent = (EmployeeEntity) session.get(EmployeeEntity.class, new Long(empId));
		
		// delete the entity from session
		session.delete(empent);
		
		// commit the changes to db.
		transaction.commit();

		System.out.println("----------- Deleted successfully ------------------------");


	}

	@SuppressWarnings("unchecked")
	public List<EmployeeEntity> retrieveEmployees() {

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		List<EmployeeEntity> employeesList =session.createQuery("from EmployeeEntity").list();

		// commit the changes to db.
		transaction.commit();
		
		System.out.println("----------- Retrived successfully ------------------------");
		
		return employeesList;
	}

}
