package it.clarome.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import it.clarome.dao.LibroDAO;
import it.clarome.dao.impl.LibroDAOImplDB;
import it.clarome.dao.impl.TypePersistence;
import it.clarome.factory.LibroFactory;
import it.clarome.model.Libro;

public class TestConnection {

	public static void main(String[] args) {
		
//		final String URL = "jdbc:postgresql://127.0.0.1:5432/corsomarzo";
//		final String USN = "postgres";
//		final String PWD = "admin";
//		
//		final String QUERY1 = "INSERT INTO anagrafica (nome, stipendio, mansione, matricola) VALUES(?, ?, ?, ?)";
//		
//		try {
//			Connection connection = DriverManager.getConnection( URL, USN, PWD );
//			PreparedStatement ps = connection.prepareStatement(QUERY1);
//		
//			ps.setString(1, "Andrea");
//			ps.setDouble(2, 1200);
//			ps.setString(3, "Programmatore");
//			ps.setString(4, "AAAA");
//			
//			int res = ps.executeUpdate();
//			
//			if (res > 0 )
//				System.out.println("Dipendente inserito");
//			else
//				System.out.println("Dipendente non inserito");
//			
//			ps.close();
//			connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		LibroDAO dao = LibroFactory.getInstance(TypePersistence.FILE);
//		Libro l = dao.cercaLibro(1);
		
//		System.out.println(Objects.nonNull(l) ? "Trovato" : "non trovato");
		
//		l.setAutore("giacomo");
		
		dao.salvaLibro(new Libro("Manzoni", "Promessi sposi", 333, 33));
		
	}

}
