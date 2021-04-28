package it.clarome.ereditarieta.veicoli;

public class Auto extends Veicolo {

	private int numPorte;

	public int getNumPorte() {
		return numPorte;
	}

	public void setNumPorte(int numPorte) {
		this.numPorte = numPorte;
	}

	public Auto(Modello modello, Colore colore, int annoDiImmatricolazione, int numPorte) {
		super(modello, colore, annoDiImmatricolazione);
		this.setNumPorte(numPorte);
	}

	@Override
	public String toString() {
		return super.toString()+", numPorte=" + numPorte + "]";
	}
	
}
