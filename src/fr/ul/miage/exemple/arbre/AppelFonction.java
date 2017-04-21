package fr.ul.miage.exemple.arbre;

import java.util.ArrayList;

public class AppelFonction implements Noeud{
	
	private int place;
	private ArrayList<Noeud> parametre = new ArrayList<>();
	
	public AppelFonction(int place){
		this.place = place;
	}
	
	public void ajouterParametre(Noeud n){
		parametre.add(n);
	}

	public ArrayList<Noeud> getParametre() {
		return parametre;
	}

	public int getPlace() {
		return place;
	}

	@Override
	public String toString() {
		return "AppelFonction [place=" + place + ", parametre=" + parametre + "]";
	}

	

}
