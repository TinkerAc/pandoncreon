package pandoncreon.Divinites;

import pandoncreon.Carte;
import pandoncreon.Divinite;
import service.Partie;

public class Shingva extends Divinite {
	
	public Shingva() {
		this.type = "divinite";
		this.origine = Carte.AUBE;
		this.nom = "Shingva";
		this.description = "Peut imposer le sacrifice d'un Guide Spirituel ayant le Dogme Symboles ou Nature.";
		this.dogmes = new String[]{Carte.HUMAIN,Carte.MYSTIQUE,Carte.CHAOS};
	}
	
	@Override
	public void capacite(Partie partie) {
		// TODO Auto-generated method stub

	}

}
