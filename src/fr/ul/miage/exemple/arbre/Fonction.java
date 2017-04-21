package fr.ul.miage.exemple.arbre;

import java.util.ArrayList;

public class Fonction implements Noeud{
	
	private int place;
	private ArrayList<Noeud> noeuds = new ArrayList();
	private Noeud retour;
	
	public Fonction(int place){
		this.place = place;
	}
	
	public void ajouterNoeud(Noeud n){
		noeuds.add(n);
	}

	public int getPlace() {
		return place;
	}

	public ArrayList<Noeud> getNoeuds() {
		return noeuds;
	}

	@Override
	public String toString() {
		return "Fonction [place=" + place + ", noeuds=" + noeuds + "]";
	}

	
	
}
