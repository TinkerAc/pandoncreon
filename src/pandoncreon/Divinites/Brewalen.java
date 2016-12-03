package pandoncreon.Divinites;

import pandoncreon.*;
import service.Partie;

public class Brewalen extends Divinite {

	public Brewalen() {
		this.type = "divinite";
		this.origine = Carte.JOUR;
		this.nom = "Brewalen";
		this.description = "Peut emp¨ºcher l'utilisation d'une carte Apocalypse. La carte est d¨¦fauss¨¦e";
		this.dogmes = new String[]{Carte.NATURE,Carte.HUMAIN,Carte.MYSTIQUE};
	}
	

	@Override
	public void capacite(Partie partie) {
		
	}
	
}




