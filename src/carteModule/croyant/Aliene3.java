package carteModule.croyant;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;

public class Aliene3 extends Croyant {
	
	public Aliene3() {
		super();
		this.nbPriere = 2;
		this.nom = "Ali¨¦n¨¦";
		this.origine = Carte.NEANT;
		this.dogmes = new String[]{Carte.CHAOS,Carte.HUMAIN,Carte.SYMBOLES};
		this.description = "Vous piochez deux cartes au hasard dans la main d'une autre Divinit¨¦.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		new Travailleurs3().sacrifier(joueur);
	}

}
