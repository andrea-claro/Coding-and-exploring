package testJPA;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the libro database table.
 * 
 */
@Entity
@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer idLibro;

	@Column(name="nome")
	private String autoreLibro;

	@Column(name="numero_pagine")
	private Integer numeroPagineLibro;

	@Column(name="prezzo")
	private float prezzoLibro;

	@Column(name="titolo")
	private String titoloLibro;

	public Libro() {
	}

	public Integer getIdLibro() {
		return this.idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getAutoreLibro() {
		return this.autoreLibro;
	}

	public void setAutoreLibro(String autoreLibro) {
		this.autoreLibro = autoreLibro;
	}

	public Integer getNumeroPagineLibro() {
		return this.numeroPagineLibro;
	}

	public void setNumeroPagineLibro(Integer numeroPagineLibro) {
		this.numeroPagineLibro = numeroPagineLibro;
	}

	public float getPrezzoLibro() {
		return this.prezzoLibro;
	}

	public void setPrezzoLibro(float prezzoLibro) {
		this.prezzoLibro = prezzoLibro;
	}

	public String getTitoloLibro() {
		return this.titoloLibro;
	}

	public void setTitoloLibro(String titoloLibro) {
		this.titoloLibro = titoloLibro;
	}

}