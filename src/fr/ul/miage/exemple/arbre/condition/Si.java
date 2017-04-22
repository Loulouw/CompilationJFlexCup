package fr.ul.miage.exemple.arbre.condition;

import java.util.ArrayList;

import fr.ul.miage.exemple.arbre.Noeud;

public class Si implements Noeud {

	private boolean etat = true;
	private Condition condition;
	private ArrayList<Noeud> validee = new ArrayList<>();
	private ArrayList<Noeud> refusee = new ArrayList<>();
	
	public Si(Condition condition){
		this.condition = condition;
	}
	
	public Condition getCondition() {
		return condition;
	}

	public ArrayList<Noeud> getValidee() {
		return validee;
	}

	public ArrayList<Noeud> getRefusee() {
		return refusee;
	}

	public boolean getEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "\nSi (" + condition + " )" + validee + "\nSinon" + refusee + "\nFin Si";
	}
	
	
	
}
