package fr.ul.miage.exemple.assembleur;

import java.util.*;
import fr.ul.miage.exemple.arbre.Noeud;
import fr.ul.miage.exemple.symbol.Symbol;
import fr.ul.miage.exemple.symbol.SymbolFunc;
import fr.ul.miage.exemple.symbol.SymbolVarGlob;


public class Assembleur {

	private ArrayList<Noeud> noeudsFonction = new ArrayList<>();
	private ArrayList<Symbol> symbols = new ArrayList();
	private String fichierAssembleur;
	
	public Assembleur(ArrayList<Noeud> noeudsFonction, ArrayList<Symbol> symbols){
		this.noeudsFonction = noeudsFonction;
		this.symbols = symbols;
		fichierAssembleur = ".include beta.uasm\n" +
		"CMOVE(pile, SP)\n" +
		"CALL(start)\n" +
		"HALT()\n\n";
	}
	
	public void generer(){
		System.out.println("ASSEMBLEUR");
		
		for (Symbol symbol : symbols) {
			if(symbol instanceof SymbolVarGlob){
				fichierAssembleur += symbol.getNom() + ": LONG(0)\n"; 
			}else if (symbol instanceof SymbolFunc) {
				genererFonction(symbol.getNom());
			}
		}
		
		System.out.println(fichierAssembleur);
	}

	private void genererFonction(String nom) {
		fichierAssembleur += nom + ":" + noeudsFonction.toString();
	}
	
	
	
	
}
