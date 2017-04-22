package fr.ul.miage.exemple.arbre;

public class Constante implements Noeud {

	private int valeur;

	public Constante(int valeur) {
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}

	@Override
	public String toString() {
		return "Constante (" + valeur + ")";
	}
	
	
	
}
