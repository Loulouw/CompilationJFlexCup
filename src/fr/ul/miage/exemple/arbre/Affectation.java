package fr.ul.miage.exemple.arbre;


public class Affectation implements Noeud {

	private Noeud partieGauche;
	private Noeud partieDroite;
	
	public Affectation(Noeud partieGauche, Noeud partieDroite) {
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
		return "\nAffectation : " + partieGauche + " = " + partieDroite;
	}
	
	
}
