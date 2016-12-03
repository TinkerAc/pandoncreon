package carteModule;

import player.Joueur;
import service.Partie;

public abstract class CarteAction extends Carte implements Sacrifier {
	protected int numDeCarte;
	
	protected Joueur joueur;
	protected Partie parite;
	
	CarteAction() {
		this.parite = Partie.getPartie();
	}
	
	public abstract void utiliser();
	
}
