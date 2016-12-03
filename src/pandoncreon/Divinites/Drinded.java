package pandoncreon.Divinites;

import pandoncreon.Carte;
import pandoncreon.Divinite;
import service.Partie;

public class Drinded extends Divinite {
	
	public Drinded() {
		this.type = "divinite";
		this.origine = Carte.JOUR;
		this.nom = "Drinded";
		this.description = "Peut emp¨ºcher le sacrifice d'un des Guides Spirituels de n'importe quel joueur.";
		this.dogmes = new String[]{Carte.HUMAIN,Carte.NATURE,Carte.SYMBOLES};
	}
	
	@Override
	public void capacite(Partie partie) {
		// TODO Auto-generated method stub

	}

}
