package carteModule.Divinites;

import carteModule.Carte;
import carteModule.Divinite;
import service.Partie;

public class Gorpa extends Divinite {
	
	public Gorpa() {
		this.type = "divinite";
		this.origine = Carte.CREPUSCULE;
		this.nom = "Gorpa";
		this.description = "Peut récupérer les points d'Action d'une autre Divinité en plus des siens. L'autre Divinité ne reçoit aucun point d'Action ce tour-ci.";
		this.dogmes = new String[]{Carte.HUMAIN,Carte.CHAOS,Carte.SYMBOLES};
	}
	
	@Override
	public void capacite(Partie partie) {
		// TODO Auto-generated method stub

	}

}
