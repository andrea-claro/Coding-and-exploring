package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the libro database table.
 * 
 */
@Entity
@Table(name="libro")
@NamedQuery(name="LibroC.findAll", query="SELECT l FROM LibroC l")
public class LibroC implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;

	@Column(name="numero_pagine")
	private Integer numeroPagine;

	private float prezzo;

	private String titolo;

	public LibroC() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroPagine() {
		return this.numeroPagine;
	}

	public void setNumeroPagine(Integer numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public float getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

}