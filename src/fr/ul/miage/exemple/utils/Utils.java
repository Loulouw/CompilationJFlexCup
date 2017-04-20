package fr.ul.miage.exemple.utils;

import java.util.*;
import java.util.regex.Pattern;

import fr.ul.miage.exemple.arbre.Constante;
import fr.ul.miage.exemple.arbre.Noeud;
import fr.ul.miage.exemple.arbre.Variable;
import fr.ul.miage.exemple.symbol.Symbol;
import fr.ul.miage.exemple.symbol.SymbolFunc;
import fr.ul.miage.exemple.symbol.SymbolVar;

public class Utils {

	public static ArrayList<Symbol> symbols = new ArrayList<>();
	public static ArrayList<SymbolVar> symbolParams = new ArrayList<>();
	public static ArrayList<SymbolVar> symbolVarsLoc = new ArrayList<>();
	
	
	public static Noeud convertToNoeud(String val) {
        Pattern patternVariable = Pattern.compile("^[a-zA-Z]+$");
        Pattern patternConstante = Pattern.compile("^-?[0-9]+$");
        Noeud res = null;

        if (patternConstante.matcher(val).find()) {
            res = new Constante(Integer.parseInt(val));
        } else if (patternVariable.matcher(val).find()) {
            res = new Variable(0);
        }

        return res;
    }
	
	public static int getVariablePlace(String name){
		int res = -1;
		ArrayList<Symbol> array = new ArrayList<>();
		for(Symbol s : symbols){
			if(s.getCat().equals("glob")){
				array.add(s);
			}else{
				array.add(new SymbolFunc("","","func",0,0));
			} 
		}
		array.add(new SymbolFunc("","","func",0,0));
		array.addAll(symbolParams);
		array.addAll(symbolVarsLoc);

		for(int i=array.size()-1;i>=0;i--){
			Symbol s = array.get(i);
			if(s.getNom().equals(name) && !s.getCat().equals("func")){
				res = i;
				break;
			}	
		}
		return res;
	}
}
