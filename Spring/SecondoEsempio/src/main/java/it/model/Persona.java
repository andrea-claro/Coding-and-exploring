package it.model;

import it.interfaces.Stampabili;

public class Persona implements Stampabili {
	private String nome;
	private String cognome;
	private Indirizzo indirizzo;
	
//	public Persona (){
//		System.out.println("Costruttore persona");
//	}
	public Persona (Indirizzo indi){
		System.out.println("Costruttore parametrizzato di Persona");
		this.setNome("Mario");
		this.setCognome("Rossi");
		this.indirizzo = indi;
	}
	@Override
	public void stampa() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Cognome: " + this.getCognome());
		System.out.println("INDIRIZZO ");
		this.indirizzo.stampa();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}
	
}

