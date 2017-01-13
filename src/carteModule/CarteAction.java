package carteModule;

import player.Joueur;
import service.Partie;

public abstract class CarteAction extends Carte implements Sacrifier {
	protected int numDeCarte;
	
	protected Joueur joueur;
	protected Partie parite;
	
	public CarteAction() {

	}
	
	public abstract void utiliser();
	
	public void setJoueur(Joueur j) {
		this.joueur = j;
	}
	
}
