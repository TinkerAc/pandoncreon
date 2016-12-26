package carteModule.croyant;

import java.util.ArrayList;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import util.Input;

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
		
		ArrayList<Joueur> js = parite.getJoueurs();
		Iterator<Joueur> it = js.iterator();
		System.out.print("choisir un joueur: ");
		while(it.hasNext()) {
			System.out.println("joueur" + it.next().getNumj());
		}
		int i = Input.getInt();
		js.get(i).sacrifier();

	}

}
