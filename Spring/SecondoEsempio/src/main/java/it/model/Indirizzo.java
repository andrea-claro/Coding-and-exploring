package it.model;

import it.interfaces.Stampabili;

public class Indirizzo implements Stampabili {
	private String via;
	private String cap;
	private String Provincia;
	
//	public Indirizzo(){
//		System.out.println("Costruttore di Indirizzo");
//	}
	
	public Indirizzo(String via, String cap, String provincia) {
		super();
		System.out.println("Costruttore parametrizzato di Indirizzo");
		this.via = via;
		this.cap = cap;
		Provincia = provincia;
	}

	@Override
	public void stampa() {
		System.out.println("Via: " + this.getVia());
		System.out.println("Cap: " + this.getCap());
		System.out.println("Provincia: " + this.getProvincia());
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	

}
