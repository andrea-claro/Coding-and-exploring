package factory;

import dao.LibroDAO;
import dao.impl.LibroDAOImplDB;
import dao.impl.LibroDAOImplFL;
import dao.impl.TypePersistence;

public class LibroFactory {

	public static LibroDAO getInstance(TypePersistence tipo) {
		
		return (tipo == TypePersistence.DATABASE) ? new LibroDAOImplDB() : new LibroDAOImplFL();
	}
}
