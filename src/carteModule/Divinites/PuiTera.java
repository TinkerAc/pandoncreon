package carteModule.Divinites;

import carteModule.Carte;
import carteModule.Divinite;
import service.Partie;

public class PuiTera extends Divinite {

	public PuiTera() {
		this.type = "divinite";
		this.origine = Carte.NUIT;
		this.nom = "Pui-Tera";
		this.description = "Peut d¨¦truire toutes les cartes de Croyants au centre de la table d'Origine Jour.";
		this.dogmes = new String[]{Carte.NATURE,Carte.SYMBOLES,Carte.MYSTIQUE};
	}
	
	@Override
	public void capacite(Partie partie) {
		// TODO Auto-generated method stub
		
	}
	
}
