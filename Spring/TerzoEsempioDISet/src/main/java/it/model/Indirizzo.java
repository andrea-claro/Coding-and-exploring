package it.model;

import it.interfaces.Stampabili;

public class Indirizzo implements Stampabili {
	private String via;
	private String cap;
	private String pronvincia;
	
	public Indirizzo(){
	}
	
	public Indirizzo(String via, String cap, String provincia) {
		super();
		this.via = via;
		this.cap = cap;
		this.pronvincia = provincia;
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
		return pronvincia;
	}
	public void setProvincia(String provincia) {
		this.pronvincia = provincia;
	}
	

}
