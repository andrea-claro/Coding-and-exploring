package it.clarome.ereditarieta.prodotti;

public abstract class Prodotto implements Cloneable{
	
	private String codiceBarre;
	private String descrizione;
	private float prezzo;
	
	public String getCodiceBarre() {
		return codiceBarre;
	}
	public void setCodiceBarre(String codiceBarre) {
		this.codiceBarre = codiceBarre;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "Prodotto [codiceBarre=" + codiceBarre + ", descrizione=" + descrizione + ", prezzo=" + prezzo ;
	}
	
	public Prodotto() {
		super();
	}
	
	public Prodotto(String codiceBarre, String descrizione, float prezzo) {
		super();
		
		setCodiceBarre(codiceBarre);
		setDescrizione(descrizione);
		setPrezzo(prezzo);
	}
	
	public void applicaSconto() {
		float sconto = (this.prezzo / 100) * 5;
		float prezzoScontato = this.prezzo - sconto;
		setPrezzo(prezzoScontato);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((codiceBarre == null) ? 0 : codiceBarre.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + Float.floatToIntBits(prezzo);
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Prodotto other = (Prodotto) obj;
		if (codiceBarre == null) {
			if (other.codiceBarre != null)
				return false;
		} else if (!codiceBarre.equals(other.codiceBarre))
			return false;
		
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		
		if (Float.floatToIntBits(prezzo) != Float.floatToIntBits(other.prezzo))
			return false;
		return true;
	}
	
	@Override
	public Prodotto clone() {
		
		Prodotto prod = null;
		try {
			prod = (Prodotto) super.clone();
			
			prod.setCodiceBarre(this.getCodiceBarre());
			prod.setDescrizione(this.getDescrizione());
			prod.setPrezzo(this.getPrezzo());
			
			return prod;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return prod;
	}
}
