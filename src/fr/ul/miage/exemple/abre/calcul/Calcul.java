package fr.ul.miage.exemple.abre.calcul;

import fr.ul.miage.exemple.abre.Noeud;

public abstract class Calcul implements Noeud {

	private Noeud partieGauche;
	private Noeud partieDroite;
	
	public Calcul(Noeud partieGauche, Noeud partieDroite) {
		this.partieGauche = partieGauche;
		this.partieDroite = partieDroite;
	}

	public Noeud getPartieGauche() {
		return partieGauche;
	}

	public Noeud getPartieDroite() {
		return partieDroite;
	}
	
	
	
}
