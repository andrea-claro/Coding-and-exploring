package it.clarome.dao;

import it.clarome.model.Libro;

public interface LibroDAO {
	
	int salvaLibro(Libro l);
	Libro cercaLibro(int id);

}
