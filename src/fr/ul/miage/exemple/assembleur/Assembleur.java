package fr.ul.miage.exemple.assembleur;

import java.util.*;

import fr.ul.miage.exemple.arbre.*;
import fr.ul.miage.exemple.arbre.calcul.*;
import fr.ul.miage.exemple.symbol.*;
import fr.ul.miage.exemple.utils.Utils;


public class Assembleur {

	private Programme programme;
	private ArrayList<Fonction> fonctions;
	private ArrayList<String> symbolsVarGlobs;
	private int posFonc = 0;
	private ArrayList<Symbol> symbols;
	private String fichierAssembleur;
	
	public Assembleur(Programme programme, ArrayList<Symbol> symbols){
		this.programme = programme;
		this.fonctions = programme.getFonctions();
		this.symbols = symbols;
		this.symbolsVarGlobs = new ArrayList<String>();
		fichierAssembleur = ".include beta.uasm\n" +
		"BR(start)\n\n";
	}
	
	public void generer(){
		System.out.println("ASSEMBLEUR");
		
		int i = 0;
		for (Symbol symbol : symbols) {
			if(symbol instanceof SymbolVarGlob){
				SymbolVarGlob sym = (SymbolVarGlob)symbol;
				symbolsVarGlobs.add("LD(" + sym.getNom() + ",R" + i +")\n");
				fichierAssembleur += sym.getNom() + ": LONG(" + sym.getVal() + ")\n"; 
			}else if (symbol instanceof SymbolFunc) {
				fichierAssembleur += "\n" + genererFonction(symbol.getNom());
				posFonc ++;
			}
			i++;
		}
		
		System.out.println(fichierAssembleur);
	}

	private String genererFonction(String nom) {
		String res = nom + ":\n";
		if(nom.equals("start")){
			for (String str : symbolsVarGlobs) {
				res += str;
			}
		}
		
		/*res += "PUSH(LP)\n" +
		"PUSH(BP)\n" + 
		"MOVE(SP,BP)\n"; // + 
		"ALLOCATE(" + symbols.get(posFonc).getNbBLoc + ")";*/
	
		
		for (Noeud noeud : fonctions.get(posFonc).getNoeuds() ) {
			res += genererInstructions(noeud);
		}
		
		/*res += "POP(BP)\n" + 
		"POP(LP)\n";*/
		
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
		String res = getCalcul(noeudDroit, "R"+partieGauche.getPlace(), symbols.get(partieGauche.getPlace()).getNom());// + 
		//"POP(R0)\n" + 
		//"ST(R0," + symbols.get(partieGauche.getPlace()).getNom() +")\n";	
		
		return res;
	}
	
	private String getCalcul(Noeud n, String R, String var){
		String res = "";
		if(n instanceof Variable){
			Variable v = (Variable)n;	
			res += "LD(" + symbols.get(v.getPlace()).getNom() + "," + R + ")\n" +
			"PUSH("+ R +")\n";
		}else if(n instanceof Constante){
			Constante c = (Constante)n;
			res += "CMOVE(" + c.getValeur() + "," + R + ")\n" + 
			"PUSH("+ R +")\n";				
		}else if(n instanceof AppelFonction){
			AppelFonction f = (AppelFonction)n;
			
		}else if(n instanceof Calcul){
			Noeud g = ((Calcul)n).getPartieGauche();
			String partieGauche = getCalcul(g, "R0", var);
			
			Noeud d = ((Calcul)n).getPartieDroite();
			String partieDroite = getCalcul(d, "R1", var);
			
			if(n instanceof Addition){
				res += partieGauche +"\n"+
				partieDroite +"\n"+
				"LD(x,R0) \n"+
				"ADD(R0,R1,R2)\n" +
				"ST(R2," + var + ")\n";
			}else if(n instanceof Soustraction){
				res += partieGauche +"\n"+
				partieDroite +"\n"+
				"LD(x,R0) \n"+
				"ADD(R0,R1,R2)\n" +
				"ST(R2," + var + ")\n";
			}else if(n instanceof Multiplication){
				
			}else if(n instanceof Division){
				
			}
			
		}
		
		return res;
	}
	
	
	
	
}
