package fr.ul.miage.exemple.assembleur;

import java.util.*;

import fr.ul.miage.exemple.arbre.Affectation;
import fr.ul.miage.exemple.arbre.Fonction;
import fr.ul.miage.exemple.arbre.Noeud;
import fr.ul.miage.exemple.arbre.Programme;
import fr.ul.miage.exemple.symbol.Symbol;
import fr.ul.miage.exemple.symbol.SymbolFunc;
import fr.ul.miage.exemple.symbol.SymbolVarGlob;


public class Assembleur {

	private Programme programme;
	private ArrayList<Fonction> fonctions;
	private int posFonc = 0;
	private ArrayList<Symbol> symbols;
	private String fichierAssembleur;
	
	public Assembleur(Programme programme, ArrayList<Symbol> symbols){
		this.programme = programme;
		this.fonctions = programme.getFonctions();
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
				fichierAssembleur += genererFonction(symbol.getNom());
				posFonc ++;
			}
		}
		
		System.out.println(fichierAssembleur);
	}

	private String genererFonction(String nom) {
		String res = nom + ": PUSH(LP)\n" +
		"PUSH(BP)\n" + 
		"MOVE(SP,BP)\n";
	
		
		for (Noeud noeud : fonctions.get(posFonc).getNoeuds() ) {
			res += genererInstructions(noeud);
		}
		
		res += "POP(BP)\n" + 
		"POP(LP)\n" + 
		"RCN()\n";
		
		return res;
	}

	private String genererInstructions(Noeud noeud) {
		String res = "";
		if(noeud instanceof Affectation){
			Affectation a = (Affectation)noeud;
			res += genererAffectation(a.getPartieGauche(),a.getPartieDroite());
		}
		return res;
	}

	private String genererAffectation(Noeud noeudGauche,Noeud noeudDroit) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
