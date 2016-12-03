package pandoncreon.Divinites;

import pandoncreon.Carte;
import pandoncreon.Divinite;
import service.Partie;

public class Killinstred extends Divinite {

	public Killinstred() {
		this.type = "divinite";
		this.origine = Carte.NUIT;
		this.nom = "Killinstred";
		this.description = "Peut obliger un joueur ¨¤ poser une carte Apocalypse s'il en poss¨¨de une.";
		this.dogmes = new String[]{Carte.NATURE,Carte.CHAOS,Carte.MYSTIQUE};
	}
	
	@Override
	public void capacite(Partie partie) {
		// TODO Auto-generated method stub

	}

}
