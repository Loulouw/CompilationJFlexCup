package fr.ul.miage.exemple.arbre;

import java.util.ArrayList;

public class Programme {

	private ArrayList<Fonction> fonctions = new ArrayList();
	
	public void ajouterFonction(Fonction f){
		fonctions.add(f);
	}

	public ArrayList<Fonction> getFonctions() {
		return fonctions;
	}

	@Override
	public String toString() {
		return "Programme : " + fonctions;
	}

	
	
}
