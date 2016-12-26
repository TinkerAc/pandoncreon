package carteModule.Guide;

import carteModule.Carte;
import carteModule.GuideSpirituel;
import player.Joueur;

public class Messie extends GuideSpirituel {

	public Messie(){
		super();
		this.nom = "Messie";
		this.origine = Carte.JOUR;
		this.dogmes = new String[]{Carte.MYSTIQUE,Carte.HUMAIN};
		this.description = "Le joueur pose le d¨¦ de Cosmogonie sur la face qu'il d¨¦sire et commence un nouveau tour de jeu.";
	}

	@Override
	public void sacrifier(Joueur joueur) {
		
	}
	
	
}
