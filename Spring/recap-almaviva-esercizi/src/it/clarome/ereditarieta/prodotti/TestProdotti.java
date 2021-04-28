package it.clarome.ereditarieta.prodotti;

import java.util.Date;

public class TestProdotti {

	public static void main(String[] args) {
		
		Prodotto a1 = new ProdottoAlimentare("xxx", "yyy", 11.43f, new Date());
		Prodotto a2 = new ProdottoAlimentare("vvv", "hhh", 1.3f, new Date());
		
		Prodotto na1 = new ProdottoNonAlimentare("111", "fff", 24f, Materiale.FERRO);
		Prodotto na2 = new ProdottoNonAlimentare("333", "rrr", 22.4f, Materiale.VETRO);
		
		ListaSpesa lst1 = new ListaSpesa(true);
		ListaSpesa lst2 = new ListaSpesa(false);
		
		lst1.aggProdotto(a1);
		lst1.aggProdotto(a2);
		lst1.aggProdotto(na1);
		lst1.aggProdotto(na2);

		lst2.aggProdotto(a1.clone());
		lst2.aggProdotto(a2.clone());
		lst2.aggProdotto(na1.clone());
		lst2.aggProdotto(na2.clone());

		lst1.calcoloTotale();
		lst2.calcoloTotale();
		
		System.out.println("\nlst1: "+lst1.getTotale()+"\nlst2: "+lst2.getTotale());
	}

}
