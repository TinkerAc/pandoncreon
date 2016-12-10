package carteModule.croyant;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;
import service.Partie;

public class Diplomates extends Croyant {
	
	public Diplomates() {
		super();
		this.setNbPriere(4);
		this.nom = "Diplomates";
		this.origine = Carte.JOUR;
		this.dogmes = new String[]{Carte.HUMAIN,Carte.CHAOS,Carte.SYMBOLES};
		this.description = "Relancez le d¨¦ de Cosmogonie. Le tour se finit normalement sous la nouvelle influence.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		Partie.getPartie().getCurrentTour2().terminerLeTour();
		
	}

}
