package carteModule.croyant;

import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;

public class Demon extends Croyant {
	
	public Demon() {
		super();
		this.setNbPriere(2);
		this.nom = "Demon";
		this.origine = Carte.NUIT;
		this.description = "Donne un point d'Action d'Origine Nuit.";
	}
	
	
	@Override
	public void sacrifier(Joueur joueur) {
		this.joueur.setPointActionNuit(this.joueur.getPointActionNuit() + 1);
		
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
