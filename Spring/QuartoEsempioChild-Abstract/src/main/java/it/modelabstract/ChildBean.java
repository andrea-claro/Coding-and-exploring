package it.modelabstract;

public class ChildBean extends ParentBean {
	private int age;
	private int cm;
	
	public ChildBean(){
		
	}
	
	public void printAll(){
//		System.out.println("Name: " + getName());
//		System.out.println("Surname: " + getSurname());
		super.printAll();
		System.out.println("Age: " + this.getAge());
		System.out.println("Cm: " + this.getCm());
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCm() {
		return cm;
	}

	public void setCm(int cm) {
		this.cm = cm;
	}
}
