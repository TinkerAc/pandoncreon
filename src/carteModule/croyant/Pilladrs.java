package carteModule.croyant;

import java.util.ArrayList;
import java.util.Iterator;
import carteModule.Carte;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.Partie;
import util.Input;

public class Pilladrs extends Croyant {
	
	public Pilladrs() {
		super();
		this.setNbPriere(4);
		this.nom = "Pilladrs";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{Carte.NATURE,Carte.MYSTIQUE,Carte.SYMBOLES};
		this.description = "R¨¦cup¨¦rez les points d'Action d'une Divinit¨¦ n'ayant pas encore jou¨¦ durant ce tour. Les points d'Action gardent leur Origine. La Divinit¨¦ perd ses points.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		Iterator<Joueur> it = js.iterator();
		while(it.hasNext()) {
			Joueur j = it.next();
			if(! j.isDone()) {
				System.out.println("joueur au choix" + j.getNumj());
			}
		}
		System.out.println("choisir un joueur:");
		int i = Input.getInt();
		Joueur jT = js.get(i);
		joueur.setPointActionJour(joueur.getPointActionJour() + jT.getPointActionJour());
		joueur.setPointActionNeant(joueur.getPointActionNeant() + jT.getPointActionNeant());
		joueur.setPointActionNuit(joueur.getPointActionNuit() + jT.getPointActionNuit());
		jT.setPointActionJour(0);
		jT.setPointActionNeant(0);
		jT.setPointActionNuit(0);
		
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



