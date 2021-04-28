package model;

public class Libro {
	
	private String autore;
	private String titolo;
	private int numP;
	private double prezzo;
	
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getNumP() {
		return numP;
	}
	public void setNumP(int numP) {
		this.numP = numP;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", titolo=" + titolo + ", numP=" + numP + ", prezzo=" + prezzo + "]";
	}
	
	public Libro() {
		
	}
	
	public Libro(String autore, String titolo, int numP, double prezzo) {
		super();
		setAutore(autore);
		setTitolo(titolo);
		setNumP(numP);
		setPrezzo(prezzo);
	}
	
}
