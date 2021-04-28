package it.clarome.factory;

import it.clarome.dao.LibroDAO;
import it.clarome.dao.impl.LibroDAOImplDB;
import it.clarome.dao.impl.LibroDAOImplFL;
import it.clarome.dao.impl.TypePersistence;

public class LibroFactory {

	public static LibroDAO getInstance(TypePersistence tipo) {
		
		return (tipo == TypePersistence.DATABASE) ? new LibroDAOImplDB() : new LibroDAOImplFL();
	}
}
