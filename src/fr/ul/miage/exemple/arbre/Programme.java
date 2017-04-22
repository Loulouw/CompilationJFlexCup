package fr.ul.miage.exemple.arbre;

import java.util.ArrayList;

public class Programme {

	private ArrayList<Noeud> fonctions = new ArrayList();
	
	public void ajouterFonction(Fonction f){
		fonctions.add(f);
	}

	public ArrayList<Noeud> getFonctions() {
		return fonctions;
	}

	@Override
	public String toString() {
		return "Programme : " + fonctions;
	}

	
	
}
