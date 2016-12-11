package carteModule.croyant;

import java.util.ArrayList;
import java.util.Iterator;
import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;
import util.Input;

public class Ermite extends Croyant {

	public Ermite() {
		super();
		this.setNbPriere(1);
		this.nom = "Ermite";
		this.origine = Carte.JOUR;
		this.dogmes = new String[]{Carte.NATURE,Carte.MYSTIQUE,Carte.SYMBOLES};
		this.description = "Impose le sacrifice d'un Croyant d'un autre joueur, qui choisit la carte. La capacit¨¦ sp¨¦ciale du sacrifice est jou¨¦e.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = parite.getJoueurs();
		Iterator<Joueur> it = js.iterator();
		System.out.print("choisir un joueur: ");
		while(it.hasNext()) {
			System.out.println("Íæ¼Ò" + it.next().getNumj());
		}
		int i = Input.getInt();
		//js.get(i).sacrifierGuide();
	}

}







