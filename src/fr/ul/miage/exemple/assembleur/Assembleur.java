package fr.ul.miage.exemple.assembleur;

import java.util.*;

import fr.ul.miage.exemple.arbre.*;
import fr.ul.miage.exemple.arbre.calcul.*;
import fr.ul.miage.exemple.symbol.*;
import fr.ul.miage.exemple.utils.Utils;


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
		Variable partieGauche = (Variable)noeudGauche;	
		String res = getCalcul(noeudDroit) + 
		"POP(R0)\n" + 
		"STORE(R0," + symbols.get(partieGauche.getPlace()).getNom() +")\n";	
		
		return res;
	}
	
	private String getCalcul(Noeud n){
		String res = "";
		if(n instanceof Variable){
			Variable v = (Variable)n;	
			res += "LD(" + symbols.get(v.getPlace()).getNom() + ",RO)\n" +
			"PUSH(R0)\n";
		}else if(n instanceof Constante){
			Constante c = (Constante)n;
			res += "MOVE(" + c.getValeur() + ",R0)\n" + 
			"PUSH(R0)\n";				
		}else if(n instanceof AppelFonction){
			AppelFonction f = (AppelFonction)n;
			
		}else if(n instanceof Calcul){
			Noeud g = ((Calcul)n).getPartieGauche();
			String partieGauche = getCalcul(g);
			
			Noeud d = ((Calcul)n).getPartieDroite();
			String partieDroite = getCalcul(d);
			
			if(n instanceof Addition){
				
			}else if(n instanceof Soustraction){
				
			}else if(n instanceof Multiplication){
				
			}else if(n instanceof Division){
				
			}
			
		}
		
		return res;
	}
	
	
	
	
}
