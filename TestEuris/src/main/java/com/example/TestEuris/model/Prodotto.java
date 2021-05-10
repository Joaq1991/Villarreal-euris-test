package com.example.TestEuris.model;

import com.example.TestEuris.util.IMappablePro;

public class Prodotto implements IMappablePro {

	
	private int id;
	private String prodotto;
	private String prezzo;
	
	public Prodotto() {
		super();
	}
	
	public Prodotto(int id, String prodotto, String prezzo) {
		super();
		this.id = id;
		this.prodotto = prodotto;
		this.prezzo = prezzo;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProdotto() {
		return prodotto;
	}
	
	public void setProduct(String prodotto) {
		this.prodotto = prodotto;
	}
	
	public String getPrezzo() {
		return prezzo;
	}
	
	public void setPrice(String prezzo) {
		this.prezzo = prezzo;
	}
}




	
	
