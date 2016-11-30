package pandoncreon.croyant;

import pandoncreon.Carte;
import pandoncreon.Croyant;
import service.Joueur;

public class Esprits extends Croyant {

	public Esprits() {
		super();
		this.nbPriere = 2;
		this.nom = "Esprits";
		this.origine = Carte.NEANT;
		this.description = "Donne un point d'Action d'Origine N¨¦ant.";
	}
	
	
	@Override
	public void sacrifier(Joueur joueur) {
		this.joueur.setPointActionNeant(this.joueur.getPointActionNeant() + 1);
	}

}
