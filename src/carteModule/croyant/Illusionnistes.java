package carteModule.croyant;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;

public class Illusionnistes extends Croyant {
	
	public Illusionnistes() {
		super();
		this.setNbPriere(4);
		this.nom = "Illusionnistes";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{Carte.NATURE,Carte.CHAOS,Carte.SYMBOLES};
		this.description = "Vous b¨¦n¨¦ficiez de la capacit¨¦ sp¨¦ciale de sacrifice d'une carte de Croyants appartenant ¨¤ une autre Divinit¨¦. La carte en question reste en jeu.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		
	}

}
