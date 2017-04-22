package fr.ul.miage.exemple.arbre;

import java.util.ArrayList;

import fr.ul.miage.exemple.utils.Utils;

public class AppelFonction implements Noeud{
	
	private int place;
	private ArrayList<Noeud> parametres = new ArrayList<>();
	
	public AppelFonction(int place){
		this.place = place;
	}
	
	public void ajouterParametre(Noeud n){
		parametres.add(n);
	}

	public ArrayList<Noeud> getParametres() {
		return parametres;
	}

	public int getPlace() {
		return place;
	}

	@Override
	public String toString() {
		return "AppelFonction (" + Utils.symbols.get(place).getNom() + parametres + " : " + place + ")";
	}

	

}
