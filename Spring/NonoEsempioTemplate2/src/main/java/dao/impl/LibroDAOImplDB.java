package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.LibroDAO;
import model.Libro;

public class LibroDAOImplDB extends DBUtil implements LibroDAO{
	
	private final String SELECT_LIBRO_BY_ID = "SELECT * FROM libro WHERE id=?";
	private final String SAVE_LIBRO = "INSERT INTO libro(nome, titolo, numero_pagine, prezzo) VALUES (?, ?, ?, ?)";

	@Override
	public int salvaLibro(Libro l) {
		int rs = 0;
		
		try (Connection conn = getConnection()){
			PreparedStatement ps = saveLibro(conn, SAVE_LIBRO, l);
			
			rs = ps.executeUpdate();
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public Libro cercaLibro(int id) {
		Libro l = null;

		try (Connection conn = getConnection()){
			PreparedStatement ps = setPrepareSelectByID(conn, id, SELECT_LIBRO_BY_ID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				l = new Libro();
				l.setAutore(rs.getString("nome"));
				l.setTitolo(rs.getString("titolo"));
				l.setNumP(rs.getInt("numero_pagine"));
				l.setPrezzo(rs.getDouble("prezzo"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	private PreparedStatement setPrepareSelectByID(Connection conn, int id, String query) throws SQLException{
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		return ps;
	}
	
	private PreparedStatement saveLibro(Connection conn, String query, Libro l) throws SQLException{
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, l.getAutore());
		ps.setString(2, l.getTitolo());
		ps.setInt(3, l.getNumP());
		ps.setDouble(4, l.getPrezzo());
		
		return ps;
	}
}
