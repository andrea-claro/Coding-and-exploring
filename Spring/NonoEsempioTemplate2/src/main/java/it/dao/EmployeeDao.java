package it.dao;

import java.util.List;

import it.model.Employee;

public interface EmployeeDao {
	public int getRowCount();
	public Employee getEmployeeById(int empId);
	public List<Employee> getListEmployee();

}
