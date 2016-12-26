package carteModule.Guide;

import carteModule.Carte;
import carteModule.GuideSpirituel;
import player.Joueur;

public class Martyr3 extends GuideSpirituel {

	public Martyr3() {
		super();
		this.nom = "Martyr";
		this.origine = Carte.NEANT;
		this.dogmes = new String[]{Carte.NATURE,Carte.CHAOS};
		this.description = "Equivalent ид la pose d'une carte Apocalypse.";
	}

	@Override
	public void sacrifier(Joueur joueur) {
		
	}
}
