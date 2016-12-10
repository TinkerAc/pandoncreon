package carteModule.croyant;

import java.util.ArrayList;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;
import service.Partie;

public class Nibillistes extends Croyant {
	
	public Nibillistes() {
		super();
		this.setNbPriere(4);
		this.nom = "Nibillistes";
		this.origine = Carte.NEANT;
		this.dogmes = new String[]{Carte.CHAOS,Carte.MYSTIQUE,Carte.SYMBOLES};
		this.description = "Jusqu'à la fin du tour, plus aucune Divinité ne reçoit de points d'Action.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		Iterator<Joueur> it = js.iterator();
		while(it.hasNext()) {
			it.next().setEnableGetPoint(false);
		}
	}

}
