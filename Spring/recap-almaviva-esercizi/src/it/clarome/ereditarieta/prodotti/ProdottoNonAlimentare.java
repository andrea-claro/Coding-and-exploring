package it.clarome.ereditarieta.prodotti;

public class ProdottoNonAlimentare extends Prodotto {
	
	private Materiale materiale;

	public Materiale getMateriale() {
		return materiale;
	}

	public void setMateriale(Materiale materiale) {
		this.materiale = materiale;
	}

	@Override
	public String toString() {
		return super.toString()+", materiale=" + materiale + "]";
	}

	public ProdottoNonAlimentare(String codiceBarre, String descrizione, float prezzo, Materiale materiale) {
		super(codiceBarre, descrizione, prezzo);
		setMateriale(materiale);
	}

	public ProdottoNonAlimentare() {
		super();
	}
	
	@Override
	public void applicaSconto() {
		if (this.materiale == Materiale.PLASTICA  
				||  this.materiale == Materiale.VETRO  
				||  this.materiale == Materiale.CARTA) {
			
			float sconto = (this.getPrezzo() / 100) * 10;
			float prezzoScontato = this.getPrezzo() - sconto;
			
			this.setPrezzo(prezzoScontato);
		}
	}
	
	@Override
	public ProdottoNonAlimentare clone() {
		ProdottoNonAlimentare prod = null;
		
		prod = (ProdottoNonAlimentare) super.clone();
		prod.setMateriale(this.getMateriale());
		
		return prod;		
	}
}
