package carteModule.Divinites;

import carteModule.Carte;
import carteModule.Divinite;
import service.Partie;

public class Llewella extends Divinite {

	public Llewella() {
		this.type = "divinite";
		this.origine = Carte.NUIT;
		this.nom = "Llewella";
		this.description = "Peut obliger un joueur ¨¤ poser une carte Apocalypse s'il en poss¨¨de une.";
		this.dogmes = new String[]{Carte.NATURE,Carte.CHAOS,Carte.MYSTIQUE};
	}
	
	@Override
	public void capacite(Partie partie) {
		// TODO Auto-generated method stub

	}

}
