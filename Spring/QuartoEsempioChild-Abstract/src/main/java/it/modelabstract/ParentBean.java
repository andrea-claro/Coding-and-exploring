package it.modelabstract;

public abstract class ParentBean {
	private String name;
	private String surname;
	
	public ParentBean(){
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void printAll(){
		System.out.println("Name Abstract "+getName());
		System.out.println("SurName Abstract "+getSurname());
	}
	
}
