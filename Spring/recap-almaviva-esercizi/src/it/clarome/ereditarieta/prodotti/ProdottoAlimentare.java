package it.clarome.ereditarieta.prodotti;

import java.util.Date;

public class ProdottoAlimentare extends Prodotto {
	
	private Date dataScadenza;

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	@Override
	public String toString() {
		return super.toString()+", dataScadenza=" + dataScadenza + "]";
	}

	public ProdottoAlimentare(String codiceBarre, String descrizione, float prezzo, Date dataScadenza) {
		super(codiceBarre, descrizione, prezzo);
		setDataScadenza(dataScadenza);
	}

	public ProdottoAlimentare() {
		super();
	}
	
	@Override
	public void applicaSconto() {
		Date now = new Date();
		
		if (this.dataScadenza != null) {
			int res = now.compareTo(dataScadenza);
			
			if (res > 0) {
				float sconto = (this.getPrezzo() / 100) * 20;
				float prezzoScontato = this.getPrezzo() - sconto;

				this.setPrezzo(prezzoScontato);
			}
		}
	}
	
	@Override
	public ProdottoAlimentare clone() {
		ProdottoAlimentare prod = null;
		
		prod = (ProdottoAlimentare) super.clone();
		prod.setDataScadenza(this.getDataScadenza());
		
		return prod;
	}
}
