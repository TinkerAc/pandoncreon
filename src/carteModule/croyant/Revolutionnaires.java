package carteModule.croyant;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;

public class Revolutionnaires extends Croyant {
	
	public Revolutionnaires() {
		super();
		this.setNbPriere(2);
		this.nom = "Vampire";
		this.origine = Carte.NEANT;
		this.dogmes = new String[]{Carte.CHAOS,Carte.HUMAIN,Carte.SYMBOLES};
		this.description = "Impose le sacrifice d'un Croyant d'un autre joueur, qui choisit la carte. La capacit¨¦ sp¨¦ciale du sacrifice est jou¨¦e.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		new Ermite().sacrifier(joueur);
	}

}
