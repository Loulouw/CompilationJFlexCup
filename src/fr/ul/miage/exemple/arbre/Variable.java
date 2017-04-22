package fr.ul.miage.exemple.arbre;

import fr.ul.miage.exemple.utils.Utils;

public class Variable implements Noeud {

	private int place;

	public Variable(int place) {
		this.place = place;
	}

	public int getPlace() {
		return place;
	}

	@Override
	public String toString() {
		return "Variable (" + Utils.symbols.get(place).getNom() + " : " + place + ")";
	}
	
	
}
