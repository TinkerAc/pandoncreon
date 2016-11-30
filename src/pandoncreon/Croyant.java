package pandoncreon;

import service.Joueur;

public abstract class Croyant extends CarteAction{

	protected int nbPriere;
	
	protected Croyant() {
		super();
		this.type = "Croyant";
	}
	
	public void utiliser() {
		
	}
	
}
