package carteModule.croyant;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;

public class Alchimistes3 extends Croyant {
	
	public Alchimistes3() {
		super();
		this.nbPriere = 2;
		this.nom = "Alchimistes";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{Carte.NATURE,Carte.CHAOS,Carte.SYMBOLES};
		this.description = "Vous piochez deux cartes au hasard dans la main d'une autre Divinit¨¦.";

	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		new Travailleurs3().sacrifier(joueur);
	}

}
