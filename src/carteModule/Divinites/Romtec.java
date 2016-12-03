package carteModule.Divinites;

import carteModule.Carte;
import carteModule.Divinite;
import service.Partie;

public class Romtec extends Divinite {

	public Romtec() {
		this.type = "divinite";
		this.origine = Carte.CREPUSCULE;
		this.nom = "Romtec";
		this.description = "Peut emp¨ºcher un jour de cr¨¦er un Guide Spirituel. La carte est d¨¦fauss¨¦e.";
		this.dogmes = new String[]{Carte.NATURE,Carte.HUMAIN,Carte.CHAOS};
	}
	
	@Override
	public void capacite(Partie partie) {
		// TODO Auto-generated method stub

	}

}
