package fr.ul.miage.exemple.symbol;

public class SymbolVarGlob extends Symbol {

	private int rang;
	private int val;
	
	public SymbolVarGlob(String nom, String type, String cat,int val,int rang) {
		super(nom, type, cat);
		this.rang = rang;
		this.val = val;
	}

	public int getRang() {
		return rang;
	}

	public int getVal() {
		return val;
	}

	@Override
	public String toString() {
		return super.toString() + "SymbolVarGlob [rang=" + rang + ", val=" + val + "]";
	}
	
	
}
