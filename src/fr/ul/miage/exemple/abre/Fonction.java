package fr.ul.miage.exemple.abre;

import java.util.ArrayList;

public class Fonction implements Noeud{
	
	private int place;
	private ArrayList<Noeud> noeuds = new ArrayList();
	
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

	
	
}
