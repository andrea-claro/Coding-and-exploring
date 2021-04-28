package it.clarome.ereditarieta.prodotti;

import java.util.ArrayList;
import java.util.List;

public class ListaSpesa {
	
	private boolean isFedele;
	private float totale;
	
	private List<Prodotto> carrello;
	
	
	public ListaSpesa(boolean isFedele) {
		carrello = new ArrayList<Prodotto>();
		totale = 0f;
		this.isFedele = isFedele;
	}

	public boolean isFedele() {
		return isFedele;
	}


	public void setFedele(boolean isFedele) {
		this.isFedele = isFedele;
	}


	public float getTotale() {
		return totale;
	}


	public void setTotale(float totale) {
		this.totale = totale;
	}


	public void aggProdotto(Prodotto prod) {
		carrello.add(prod);
	}
	
	public void calcoloTotale() {
		for (Prodotto prodotto : carrello) {
			
			if(this.isFedele == true) {
				prodotto.applicaSconto();
				totale += prodotto.getPrezzo();
			} else {
				totale += prodotto.getPrezzo();
			}	
		}
			
	}

	@Override
	public String toString() {
		return "ListaSpesa [isFedele=" + isFedele + ", totale=" + totale + ", carrello=" + carrello + "]";
	}
	
	
}
