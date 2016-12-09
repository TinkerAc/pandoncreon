package carteModule.croyant;

import java.util.ArrayList;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;
import util.Input;

public class Vampire extends Croyant {
	
	public Vampire() {
		super();
		this.nbPriere = 1;
		this.nom = "Vampire";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{Carte.NATURE,Carte.HUMAIN,Carte.SYMBOLES};
		this.description = "Impose le sacrifice d'un Croyant d'un autre joueur. Celui-ci choisit le sacrifié. La capacité spéciale du sacrifice est jouée.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = parite.getJoueurs();
		Iterator<Joueur> it = js.iterator();
		System.out.print("choisir un joueur: ");
		while(it.hasNext()) {
			System.out.println("玩家" + it.next().getNumj());
		}
		int i = Input.getInt();
		ArrayList<Croyant> cs = (ArrayList<Croyant>) js.get(i).getCroyants();
		Iterator<Croyant> ic = cs.iterator();
		System.out.println("请选择一张croyant");
		while(ic.hasNext()) {
			System.out.println(ic.next().toString());
		}
		int n = Input.getInt();
		js.get(i).getCroyants().remove(n).sacrifier(js.get(i));
		/*
		 * 怎么从guide里面移出去？？
		 * */
	}

}







