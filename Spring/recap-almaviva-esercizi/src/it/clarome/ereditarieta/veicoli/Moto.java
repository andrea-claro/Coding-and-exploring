package it.clarome.ereditarieta.veicoli;

public class Moto extends Veicolo {
	
	private Categoria cat;

	public Categoria getCat() {
		return cat;
	}

	public void setCat(Categoria cat) {
		this.cat = cat;
	}

	public Moto(Modello modello, Colore colore, int annoDiImmatricolazione, Categoria cat) {
		super(modello, colore, annoDiImmatricolazione);
		this.setCat(cat);
	}

	@Override
	public String toString() {
		return super.toString()+", cat=" + cat + "]";
	}

}
