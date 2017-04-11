package fr.ul.miage.exemple;

public class SymbolFunc extends Symbol{

	private int nbBloc; //
	private int nbParam; // Nombre de parametres;
	
	public SymbolFunc(String nom, String type, String cat, int nbBloc, int nbParam) {
		super(nom, type, cat);
		this.nbBloc = nbBloc;
		this.nbParam = nbParam;
	}

	public int getNbBloc() {
		return nbBloc;
	}

	public void setNbBloc(int nbBloc) {
		this.nbBloc = nbBloc;
	}

	public int getNbParam() {
		return nbParam;
	}

	public void setNbParam(int nbParam) {
		this.nbParam = nbParam;
	}

}
