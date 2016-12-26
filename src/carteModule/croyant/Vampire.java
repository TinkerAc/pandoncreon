package carteModule.croyant;

import java.util.ArrayList;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import util.Input;

public class Vampire extends Croyant {
	
	public Vampire() {
		super();
		this.setNbPriere(1);
		this.nom = "Vampire";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{Carte.NATURE,Carte.HUMAIN,Carte.SYMBOLES};
		this.description = "Impose le sacrifice d'un Croyant d'un autre joueur. Celui-ci choisit le sacrifi¨¦. La capacit¨¦ sp¨¦ciale du sacrifice est jou¨¦e.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = parite.getJoueurs();
		Iterator<Joueur> it = js.iterator();
		System.out.print("choisir un joueur: ");
		while(it.hasNext()) {
			System.out.println("joueur" + it.next().getNumj());
		}
		int i = Input.getInt();
		ArrayList<Croyant> cs = (ArrayList<Croyant>) js.get(i).getCroyants();
		Iterator<Croyant> ic = cs.iterator();
		int count = 0;
		System.out.println("choisir un Croyant");
		while(ic.hasNext()) {
			System.out.println(count);
			System.out.println(ic.next().toString());
			count++;
		}
		int n = Input.getInt();
		js.get(i).getCroyants().remove(n).sacrifier(js.get(i));

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







