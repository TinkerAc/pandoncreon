package carteModule.croyant;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;

public class Demon extends Croyant {
	
	public Demon() {
		super();
		this.nbPriere = 2;
		this.nom = "Demon";
		this.origine = Carte.NUIT;
		this.description = "Donne un point d'Action d'Origine Nuit.";
	}
	
	
	@Override
	public void sacrifier(Joueur joueur) {
		this.joueur.setPointActionNuit(this.joueur.getPointActionNuit() + 1);
		
	}
}
