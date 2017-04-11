package fr.ul.miage.exemple;

public class SymbolVar extends Symbol{
	
	private int rang; //Place dans la pile (a vérifier)

	public SymbolVar(String nom, String type, String cat, int rang) {
		super(nom, type, cat);
		this.rang = rang;		
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

}
