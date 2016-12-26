package carteModule.croyant;

import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.Partie;

public class Revenant extends Croyant {

	public Revenant() {
		super();
		this.setNbPriere(1);
		this.nom = "Ermite";
		this.origine = Carte.JOUR;
		this.dogmes = new String[]{Carte.NATURE,Carte.MYSTIQUE,Carte.HUMAIN};
		this.description = "Relancez le d¨¦ de Cosmogonie. Le tour se finit normalement sous la nouvelle influence.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		this.joueur.getCroyants().remove(this);
		this.joueur.setNbPriere(this.joueur.getNbPriere() - this.getNbPriere());
		Iterator<GuideSpirituel> it2 = this.joueur.getGuides().iterator();
		while(it2.hasNext()){
			if(it2.next().getCroyants().contains(this)){
				it2.next().getCroyants().remove(this);
				it2.next().setNbCroyant(it2.next().getNbCroyant() - 1);
			}
		}
		this.setJoueur(null);
		
		Partie.getPartie().getCurrentTour2().terminerLeTour();

	}

}
