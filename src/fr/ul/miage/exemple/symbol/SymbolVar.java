package fr.ul.miage.exemple.symbol;

public class SymbolVar extends Symbol{

	private int rang;
	
	public SymbolVar(String nom, String type, String cat,int rang) {
		super(nom, type, cat);
		this.rang = rang;
	}
	
	public int getRang() {
		return rang;
	}
	
	public void setRang(int rang) {
		this.rang = rang;
	}
	
	@Override
	public String toString() {
		return super.toString() + "SymbolVar [rang=" + rang + "]";
	}
	
	

}
