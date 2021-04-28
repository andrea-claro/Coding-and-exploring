package dao;

import model.Libro;

public interface LibroDAO {
	
	int salvaLibro(Libro l);
	Libro cercaLibro(int id);

}
