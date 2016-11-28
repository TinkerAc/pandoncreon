package croyant;

import pandoncreon.*;
import service.Joueur;

public class Moine extends Croyant {
	
	
	
	Moine() {
		super();
		this.nbPriere = 2;
		this.nom = "Moine";
		this.origine = Carte.JOUR;
		this.description = "Donne un point d'Action d'Origine Jour.";
	}

	@Override
	public void sacrifier() {
		this.joueur.setPointActionJour(joueur.getPointActionJour() + 1);		
	}

	@Override
	public void utiliser() {
		
	}

	
	
}
