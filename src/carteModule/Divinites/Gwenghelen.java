package carteModule.Divinites;

import carteModule.Carte;
import carteModule.Divinite;
import service.Partie;

public class Gwenghelen extends Divinite {
	
	public Gwenghelen() {
		this.type = "divinite";
		this.origine = Carte.AUBE;
		this.nom = "Gwenghelen";
		this.description = "R¨¦cup¨¨re autant de points d'Action suppl¨¦mentaires d'Origine N¨¦ant que le nombre de Guides Spirituels que la Divinit¨¦ poss¨¨de.";
		this.dogmes = new String[]{Carte.HUMAIN,Carte.MYSTIQUE,Carte.SYMBOLES};
	}
	
	@Override
	public void capacite(Partie partie) {
		// TODO Auto-generated method stub

	}

}
