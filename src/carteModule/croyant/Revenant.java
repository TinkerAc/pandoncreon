package carteModule.croyant;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;

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
		new Diplomates().sacrifier(joueur);
	}

}
