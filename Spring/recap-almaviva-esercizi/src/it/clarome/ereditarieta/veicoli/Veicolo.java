package it.clarome.ereditarieta.veicoli;

public abstract class Veicolo {

	private Modello modello;
	private Colore colore;
	private int annoDiImmatricolazione;
	
	public Modello getModello() {
		return modello;
	}
	public void setModello(Modello modello) {
		this.modello = modello;
	}
	public Colore getColore() {
		return colore;
	}
	public void setColore(Colore colore) {
		this.colore = colore;
	}
	public int getAnnoDiImmatricolazione() {
		return annoDiImmatricolazione;
	}
	public void setAnnoDiImmatricolazione(int annoDiImmatricolazione) {
		this.annoDiImmatricolazione = annoDiImmatricolazione;
	}
	
	public Veicolo(Modello modello, Colore colore, int annoDiImmatricolazione) {
		super();
		this.setModello(modello);
		this.setColore(colore);
		this.setAnnoDiImmatricolazione(annoDiImmatricolazione);
	}
	
	@Override
	public String toString() {
		return "Veicolo [modello=" + modello + ", colore=" + colore + ", annoDiImmatricolazione="
				+ annoDiImmatricolazione;
	}
}
