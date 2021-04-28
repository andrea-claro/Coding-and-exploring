package it.clarome.ereditarieta.veicoli;

public class Taxi extends Auto {
	
	private String codice;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Taxi(Modello modello, Colore colore, int annoDiImmatricolazione, int numPorte, String codice) {
		super(modello, colore, annoDiImmatricolazione, numPorte);
		this.setCodice(codice);
	}

	@Override
	public String toString() {
		return super.toString()+", codice=" + codice + "]";
	}
	
}
