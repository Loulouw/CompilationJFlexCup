package fr.ul.miage.exemple.arbre.calcul;

import fr.ul.miage.exemple.arbre.Noeud;

public class Soustraction extends Calcul{

	public Soustraction(Noeud partieGauche, Noeud partieDroite) {
		super(partieGauche, partieDroite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + "Soustraction []";
	}

}
