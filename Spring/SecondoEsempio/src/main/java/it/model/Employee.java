package it.model;

public class Employee {
	
	private String employeeName;
	private int employeeAge;
	private boolean married;
	
	public Employee(String employeeName, int employeeAge, boolean married) {
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.married = married;
	}
	
	

	public Employee(String employeeName, int employeeAge) {
		super();
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
	}



	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeAge=" + employeeAge + ", married=" + married + "]";
	}

}
