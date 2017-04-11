package fr.ul.miage.exemple;

public class SymbolVar extends Symbol{
	
	private int rang; //Place dans la pile (a vérifier)
	private int val;

	public SymbolVar(String nom, String type, String cat, int val, int rang) {
		super(nom, type, cat);
		this.rang = rang;	
		this.val = val;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return super.toString() + "SymbolVar [rang=" + rang + ", val=" + val + "]";
	}

	
	

}
