package com.example.TestEuris.dao;

import java.util.List;

import com.example.TestEuris.model.Prodotto;

public interface IDaoMySQL {

	List<Prodotto> prodotti();
	
	Prodotto prodotti(int id);
	
	void add(Prodotto p);
	
	void delete(int id);
	
	void update(Prodotto p);
	
}




 




