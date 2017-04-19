package fr.ul.miage.exemple.arbre;

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
		return "Variable [place=" + place + "]";
	}
	
	
}
