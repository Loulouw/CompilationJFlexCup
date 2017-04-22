package fr.ul.miage.exemple.arbre.condition;

import java.util.ArrayList;

import fr.ul.miage.exemple.arbre.Noeud;

public class TantQue implements Noeud{

	private Condition condition;
	private ArrayList<Noeud> actions = new ArrayList<>();
	
	public TantQue(Condition condition) {
		super();
		this.condition = condition;
	}

	public Condition getCondition() {
		return condition;
	}

	public ArrayList<Noeud> getActions() {
		return actions;
	}

	@Override
	public String toString() {
		return "\nTantQue (" + condition + ")\n" + actions + "\nFin TantQue";
	}
	
	
	
}
