package fr.ul.miage.exemple.assembleur;

import java.util.*;
import fr.ul.miage.exemple.arbre.Noeud;
import fr.ul.miage.exemple.arbre.Programme;
import fr.ul.miage.exemple.symbol.Symbol;
import fr.ul.miage.exemple.symbol.SymbolFunc;
import fr.ul.miage.exemple.symbol.SymbolVarGlob;


public class Assembleur {

	private Programme programme;
	private ArrayList<Symbol> symbols;
	private String fichierAssembleur;
	
	public Assembleur(Programme programme, ArrayList<Symbol> symbols){
		this.programme = programme;
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
		fichierAssembleur += nom + ":" + programme.toString();
	}
	
	
	
	
}
