package fr.ul.miage.exemple.arbre.calcul;

import fr.ul.miage.exemple.arbre.Noeud;

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

	@Override
	public String toString() {
		return "[partieGauche=" + partieGauche + ", partieDroite=" + partieDroite + "]";
	}
	
	
	
}
