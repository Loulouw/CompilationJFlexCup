package fr.ul.miage.exemple;

import java.util.ArrayList;

public class Symbol {

	private String nom;
	private String type;
	private String cat;
	private Integer val;
	
	
	public Symbol(String nom, String type, String cat, Integer val) {
		this.nom = nom;
		this.type = type;
		this.cat = cat;
		this.val = val;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCat() {
		return cat;
	}


	public void setCat(String cat) {
		this.cat = cat;
	}


	public Integer getVal() {
		return val;
	}


	public void setVal(Integer val) {
		this.val = val;
	}
	
	
	
}
