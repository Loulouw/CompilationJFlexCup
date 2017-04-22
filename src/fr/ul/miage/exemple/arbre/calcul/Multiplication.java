package fr.ul.miage.exemple.arbre.calcul;

import fr.ul.miage.exemple.arbre.Noeud;

public class Multiplication extends Calcul{

	public Multiplication(Noeud partieGauche, Noeud partieDroite) {
		super(partieGauche, partieDroite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "{" + super.getPartieGauche() + " * " +super.getPartieDroite() + "}";
	}

}
