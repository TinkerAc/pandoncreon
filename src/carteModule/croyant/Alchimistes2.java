package carteModule.croyant;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;

public class Alchimistes2 extends Croyant {
	
	public Alchimistes2() {
		super();
		this.nbPriere = 2;
		this.nom = "Alchimistes";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{Carte.NATURE,Carte.CHAOS,Carte.MYSTIQUE};
		this.description = "Emp¨ºche une Divinit¨¦ poss¨¦dant le Dogme Humain ou Symboles de sacrifier un de ses Guides Spirituels durant ce tour de jeu.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		// TODO Auto-generated method stub

	}

}
