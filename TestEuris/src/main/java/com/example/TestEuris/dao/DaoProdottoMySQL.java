package com.example.TestEuris.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.example.TestEuris.model.Prodotto;
import com.example.TestEuris.util.BasicDao;

@Repository

public class DaoProdottoMySQL extends BasicDao implements IDaoMySQL{
		
		public DaoProdottoMySQL(@Value("${db.address}") String dbAddress, @Value("${db.user}") String user,
				@Value("${db.psw}") String password) {
			super(dbAddress, user, password);
		}
		
		@Override
		public List<Prodotto> prodotti() {
			List<Prodotto> ris = new ArrayList<>();
			
			List<Map<String, String>> maps = getAll("SELECT * FROM prodotti");
			
			for (Map<String, String> map : maps) {
				Prodotto p = new Prodotto();
				p.fromMap(map);
				ris.add(p);
			}
			
			return ris;
		}
		
		@Override
		public Prodotto prodotti(int id) {
			Prodotto ris = null;
			
			Map<String, String> map = getOne("SELECT * FROM prodotti WHERE id = ?", id);
			
			if (map != null) {
				ris = new Prodotto();
				ris.fromMap(map);
			}
			
			return ris;
		}
		
		@Override
		public void add(Prodotto p) {
			execute("INSERT INTO prodotti (prodotto, prezzo) VALUES (?, ?)", p.getProdotto(), p.getPrezzo());
		}
		
		@Override
		public void delete(int id) {
			execute("DELETE FROM prodotti WHERE id = ?", id);
		}
		
		@Override
		public void update(Prodotto p) {
			execute("UPDATE prodotti SET prodotto = ?, prezzo = ?", p.getProdotto(), p.getPrezzo());
		}
		
		@Override
		public String operazioni(String ops) {
		   
		    int sIndex = ops.indexOf("+");
		    int mIndex = ops.indexOf("-");
		    int xIndex = ops.indexOf("*");
		    int dIndex = ops.indexOf("/");
		        
		    if(sIndex != -1) {
		        String op1 = ops.substring(0, sIndex);
		        String op2 = ops.substring(sIndex+1, ops.length());
		        return s(op1,op2);
		            
		    } else if (mIndex == 1) {
		     	String op1 = ops.substring(0, mIndex);
		     	String op2 = ops.substring(mIndex+1, ops.length());
		       	return m(op1,op2);
		        	
		    } else if (xIndex == 1) {
		        String op1 = ops.substring(0, xIndex);
		        String op2 = ops.substring(xIndex+1, ops.length());
		        return x(op1,op2);
		            
		    } else if (dIndex == 1) {
		        String op1 = ops.substring(0, dIndex);
		        String op2 = ops.substring(dIndex+1, ops.length());
		        return division(op1,op2);

		    }
		}

		    private String somma(String v1, String v2){
		        String[] values1 = v1.split(" ");
		        String[] values2 = v2.split(" ");
		        
		        int p1 = Integer.parseInt(values1[0].substring(0, values1[0].length()-1));
		        int s1 = Integer.parseInt(values1[1].substring(0, values1[1].length()-1));
		        int d1 = Integer.parseInt(values1[2].substring(0, values1[2].length()-1));

		        int p2 = Integer.parseInt(values2[0].substring(0, values2[0].length()-1));
		        int s2 = Integer.parseInt(values2[1].substring(0, values2[1].length()-1));  
		        int d2 = Integer.parseInt(values2[2].substring(0, values2[2].length()-1));

		        int pence = (p1*240) + (s1*20) + d1;
		        int pence2 = (p2*240) + (s2*20) + d2;
		        
		        int sum = pence + pence2;
		        
		        int ptot = sum / 240;
		        sum = sum % 240;
		        int stot = sum / 12;
		        sum = sum % 12;
		        int dtot = sum;

		        String total = ptot + "p " + stot +"s " + dtot +"d";
		        return total;
		    }
		    
		    private String subtraction (String v1, String v2) {
		        String[] values1 = v1.split(" ");
		        String[] values2 = v2.split(" ");
		        
		        int p1 = Integer.parseInt(values1[0].substring(0, values1[0].length()-1));
		        int s1 = Integer.parseInt(values1[1].substring(0, values1[1].length()-1));
		        int d1 = Integer.parseInt(values1[2].substring(0, values1[2].length()-1));

		        int p2 = Integer.parseInt(values2[0].substring(0, values2[0].length()-1));
		        int s2 = Integer.parseInt(values2[1].substring(0, values2[1].length()-1));  
		        int d2 = Integer.parseInt(values2[2].substring(0, values2[2].length()-1));

		        int pence = (p1*240) + (s1*20) + d1;
		        int pence2 = (p2*240) + (s2*20) + d2;
		        
		        int sub = pence - pence2;
		        
		        int ptot = sub / 240;
		        sub = sub % 240;
		        int stot = sub / 12;
		        sub = sub % 12;
		        int dtot = sub;
		        
		        String total = ptot + "p " + stot +"s " + dtot +"d";
		        return total;
		    }
		    
		    
		        
		        
		    
		
	}



