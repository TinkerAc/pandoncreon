package carteModule.croyant;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;

public class Esprits extends Croyant {

	public Esprits() {
		super();
		this.setNbPriere(2);
		this.nom = "Esprits";
		this.origine = Carte.NEANT;
		this.description = "Donne un point d'Action d'Origine N¨¦ant.";
	}
	
	
	@Override
	public void sacrifier(Joueur joueur) {
		this.joueur.setPointActionNeant(this.joueur.getPointActionNeant() + 1);
	}

}
