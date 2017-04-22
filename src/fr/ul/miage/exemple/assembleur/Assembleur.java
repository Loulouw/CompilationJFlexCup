package fr.ul.miage.exemple.assembleur;

import java.util.*;
import fr.ul.miage.exemple.arbre.Noeud;
import fr.ul.miage.exemple.symbol.Symbol;


public class Assembleur {

	private ArrayList<Noeud> noeudsFonction = new ArrayList<>();
	private ArrayList<Symbol> symbols = new ArrayList();
	private String fichierAssembleur;
	
	public Assembleur(ArrayList<Noeud> noeudsFonction, ArrayList<Symbol> symbols){
		this.noeudsFonction = noeudsFonction;
		this.symbols = symbols;
		fichierAssembleur = ".include beta.uasm\n";
	}
	
	public void generer(){
		
	}
	
	
	
	
}
