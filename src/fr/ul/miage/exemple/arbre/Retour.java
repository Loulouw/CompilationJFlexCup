package fr.ul.miage.exemple.arbre;

public class Retour implements Noeud {

	private Noeud valRetour;

	public Retour(Noeud valRetour) {
		super();
		this.valRetour = valRetour;
	}

	public Noeud getValRetour() {
		return valRetour;
	}
	
}
