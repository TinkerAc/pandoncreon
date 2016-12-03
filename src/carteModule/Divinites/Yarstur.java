package carteModule.Divinites;

import carteModule.Carte;
import carteModule.Divinite;
import service.Partie;

public class Yarstur extends Divinite {

	public Yarstur() {
		this.type = "divinite";
		this.origine = Carte.JOUR;
		this.nom = "Yartur";
		this.description = "Peut d¨¦truire toutes les cartes de Croyants au centre de la table d'Origine N¨¦ant.";
		this.dogmes = new String[]{Carte.CHAOS,Carte.SYMBOLES,Carte.MYSTIQUE};
	}
		
	@Override
	public void capacite(Partie partie) {
		// TODO Auto-generated method stub

	}

}
