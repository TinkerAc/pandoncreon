package pandoncreon;

import service.Joueur;

public abstract class CarteAction extends Carte implements Sacrifier {
	protected int numDeCarte;
	
	protected Joueur joueur;
	
	public abstract void utiliser();
	
}
