package carteModule.croyant;

import java.util.Iterator;

import carteModule.*;
import player.Joueur;

public class Moine extends Croyant {
	
	public Moine() {
		super();
		this.setNbPriere(2);
		this.nom = "Moine";
		this.origine = Carte.JOUR;
		this.description = "Donne un point d'Action d'Origine Jour.";
	}

	@Override
	public void sacrifier(Joueur joueur) {
		this.joueur.setPointActionJour(joueur.getPointActionJour() + 1);	
		
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
		
	}

}
