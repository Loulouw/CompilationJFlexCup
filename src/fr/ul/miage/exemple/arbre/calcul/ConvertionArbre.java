package fr.ul.miage.exemple.arbre.calcul;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

import fr.ul.miage.exemple.arbre.AppelFonction;
import fr.ul.miage.exemple.arbre.Noeud;
import fr.ul.miage.exemple.utils.Utils;

public class ConvertionArbre {
	
	public static Noeud convertirCalcul(String chaine){
		return convertionEnArbre(convertToPostfix(chaine.trim()));
	}
	

	private static Noeud convertionEnArbre(String postfix){
		ArrayList<Object> part = new ArrayList<>(Arrays.asList(postfix.split("[ \t]+")));
        boolean fin = false;
        while (!fin) {
            Noeud prec1 = null;
            Noeud prec2 = null;
            for (int i = 0; i < part.size(); i++) {
                Object obj = part.get(i);
                Noeud noeud = null;
                if (obj instanceof String) {
                	if(((String)obj).startsWith("#F|")){
                		String f[] = ((String) obj).split("\\|");
                		noeud = new AppelFonction(Utils.getFonctionPlace(f[1]));
                		if(f.length>2){
                			for(int j = 2;j<f.length;j++){
                				((AppelFonction)noeud).ajouterParametre(convertionEnArbre(convertToPostfix(f[j])));
                			}
                		}
                	}else{
                		noeud = Utils.convertToNoeud((String) obj);
                	}
                    if(noeud != null){
                    	part.remove(i);
                    	part.add(i,noeud);
                    }
                } else if (obj instanceof Noeud) {
                    noeud = (Noeud) obj;
                }

                boolean operateur = false;
                if (obj.equals("+")) {
                    noeud = new Addition(prec2, prec1);
                    operateur = true;
                } else if (obj.equals("-")) {
                    noeud = new Soustraction(prec2, prec1);
                    operateur = true;
                } else if (obj.equals("*")) {
                    noeud = new Multiplication(prec2, prec1);
                    operateur = true;
                } else if (obj.equals("/")) {
                    noeud = new Division(prec2, prec1);
                    operateur = true;
                }

                if (operateur) {
                    part.remove(i);
                    part.remove(i - 1);
                    part.remove(i - 2);
                    part.add(i - 2, noeud);
                    break;
                }

                prec2 = prec1;
                prec1 = noeud;
            }
            if (part.size() == 1) fin = true;
        }
        
        Noeud n = null;
        if(part.get(0) instanceof Noeud){
        	n = (Noeud) part.get(0);
        }
        return n;
	}
	
    private static boolean estUnOperateur(String s) {
        Pattern p = Pattern.compile("^\\+|-|\\*|/|\\(|\\)$");
        return p.matcher(s).find();
    }

    private static int precedent(String ch) {
        switch (ch) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return -1;
    }

    private static boolean estUnOperand(String ch) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]$");
        return p.matcher(ch).find();
    }

    private static String convertToPostfix(String infix) {
        Stack<String> pile = new Stack<>();
        StringBuilder postfix = new StringBuilder(infix.length());
        String caracPrec = "";
        String carac;
        String temp = "";
        for (int i = 0; i < infix.length(); i++) {
            carac = Character.toString(infix.charAt(i));
            
            if (estUnOperand(carac)) {
                temp += carac;
            } else {
                if (carac.equals("(") && estUnOperand(caracPrec)) {
                	String nomFonc = temp;
                	ArrayList<String> params = new ArrayList<>();
                	String param = "|";
                    int pf = 1;
                    while (pf != 0) { 
                        i++;
                        String c = Character.toString(infix.charAt(i));
                        param += c;
                        if (c.equals(")")) {
                            pf--;
                            if(pf == 0) param = param.substring(0,param.length()-1);
                        } else if (c.equals("(")) {
                            pf++;
                        } else if (c.equals(",")){
                        	params.add(param);
                        	param="|";
                        }
                        
                        if(pf == 0 && !param.equalsIgnoreCase("|")){
                        	params.add(param);
                        }
                    }
                    String paramFinal = "";
                    for(String s : params) paramFinal += s;
                    postfix.append("#F|" + nomFonc + paramFinal + " " );
                    temp = "";
                } else {
                    if (!temp.equals("")) {
                        postfix.append(temp + " ");
                        temp = "";
                    }
                    if (carac.equals("(")) {
                        pile.push(carac);
                    } else if (carac.equals(")")) {
                        while (!pile.isEmpty() && !pile.peek().equals("(")) {
                            postfix.append(pile.pop() + " ");
                        }
                        if (!pile.isEmpty() && !pile.peek().equals("(")) {
                            return null;
                        } else if (!pile.isEmpty()) {
                            pile.pop();
                        }
                    } else if (estUnOperateur(carac)) {
                        if (!pile.isEmpty() && precedent(carac) <= precedent(pile.peek())) {
                            postfix.append(pile.pop() + " ");
                        }
                        pile.push(carac);
                    }
                }
            }
            caracPrec = carac;
            if (i + 1 >= infix.length()){
            	postfix.append(temp + " ");
            }
        }
        while (!pile.isEmpty()) postfix.append(pile.pop() + " ");
        return postfix.toString();
    }
}
