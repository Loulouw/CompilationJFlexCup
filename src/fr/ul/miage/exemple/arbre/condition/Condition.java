package fr.ul.miage.exemple.arbre.condition;

import fr.ul.miage.exemple.arbre.Noeud;

public class Condition {

	private Noeud partieDroite;
	private Noeud partieGauche;
	private String signe;
	
	public Condition(Noeud partieGauche, Noeud partieDroite, String signe) {
		super();
		this.partieGauche = partieGauche;
		this.partieDroite = partieDroite;
		this.signe = signe;
	}
	
	public Noeud getPartieDroite() {
		return partieDroite;
	}
	public Noeud getPartieGauche() {
		return partieGauche;
	}
	public String getSigne() {
		return signe;
	}

	@Override
	public String toString() {
		return partieGauche + " " + signe + " " + partieDroite;
	}
	
	
	
}
