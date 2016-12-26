package carteModule.Guide;

import carteModule.Carte;
import carteModule.GuideSpirituel;
import player.Joueur;

public class Martyr2 extends GuideSpirituel {
	
	public Martyr2() {
		super();
		this.nom = "Martyr";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{Carte.SYMBOLES,Carte.HUMAIN};
		this.description = "Equivalent ид la pose d'une carte Apocalypse.";
	}

	@Override
	public void sacrifier(Joueur joueur) {
		
	}
}
