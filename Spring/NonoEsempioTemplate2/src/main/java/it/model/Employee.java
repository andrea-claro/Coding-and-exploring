package it.model;

public class Employee {
	private int id;
	private String nome;
	private int eta;
	
	public Employee(){
	}
	

	public Employee(int id, String nome, int eta) {
		super();
		this.id = id;
		this.nome = nome;
		this.eta = eta;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", nome=" + nome + ", eta=" + eta + "]";
	}
	
	
	
	
}
