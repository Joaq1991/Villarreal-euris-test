package com.example.TestEuris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestEuris.dao.IDaoMySQL;
import com.example.TestEuris.model.Prodotto;


@RestController
@RequestMapping("/prodotti")
public class Test {
		
		@Autowired
		private IDaoMySQL dao;
		
		@GetMapping()
		public List<Prodotto> get(){
			return dao.prodotti();
		}
		
		@GetMapping("/{id}")
		public Prodotto get(@PathVariable int id) {
			return dao.prodotti(id);
		}
		
		@PostMapping
		public void add(@RequestBody Prodotto prodotto) {
			dao.add(prodotto);
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable int id) {
			dao.delete(id);
		}
		
		@PutMapping
		public void update(@RequestBody Prodotto prodotto) {
			dao.update(prodotto);
		}

}






