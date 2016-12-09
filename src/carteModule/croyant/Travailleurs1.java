package carteModule.croyant;

import carteModule.Carte;
import carteModule.CarteAction;
import carteModule.Croyant;
import player.Joueur;

public class Travailleurs1 extends Croyant {

	public Travailleurs1() {
		super();
		this.setNbPriere(2);
		this.nom = "Travailleurs";
		this.origine = Carte.JOUR;
		this.dogmes = new String[]{Carte.CHAOS,Carte.HUMAIN,Carte.MYSTIQUE};
		this.description = "Emp¨ºche une Divinit¨¦ poss¨¦dant le Dogme Nature ou Mystique de sacrifier une de ses cartes de Croyants durant ce tour.";
	}

	@Override
	public void sacrifier(Joueur joueur) {
		new Aliene1().sacrifier(joueur);
	}
	
	

}
