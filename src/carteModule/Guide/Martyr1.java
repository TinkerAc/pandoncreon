package carteModule.Guide;

import carteModule.Carte;
import carteModule.GuideSpirituel;
import player.Joueur;

public class Martyr1 extends GuideSpirituel {

	public Martyr1() {
		super();
		this.nom = "Martyr";
		this.origine = Carte.JOUR;
		this.dogmes = new String[]{Carte.NATURE,Carte.HUMAIN};
		this.description = "Equivalent ид la pose d'une carte Apocalypse.";
	}

	@Override
	public void sacrifier(Joueur joueur) {
		
	}

	
}
