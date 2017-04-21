package fr.ul.miage.exemple.arbre;

public class Ecrire implements Noeud{

	private Noeud val;

	public Ecrire(Noeud val) {
		super();
		this.val = val;
	}

	public Noeud getVal() {
		return val;
	}
	
}
