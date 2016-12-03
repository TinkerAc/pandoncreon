package carteModule.croyant;

import carteModule.*;
import player.Joueur;

public class Moine extends Croyant {
	
	public Moine() {
		super();
		this.nbPriere = 2;
		this.nom = "Moine";
		this.origine = Carte.JOUR;
		this.description = "Donne un point d'Action d'Origine Jour.";
	}

	@Override
	public void sacrifier(Joueur joueur) {
		this.joueur = joueur;
		this.joueur.setPointActionJour(joueur.getPointActionJour() + 1);		
	}

	@Override
	public void utiliser() {
		
	}

	
	
}
