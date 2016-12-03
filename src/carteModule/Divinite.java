package carteModule;

import service.Partie;

public abstract class Divinite extends Carte {
	
	public abstract void capacite(Partie partie);
	public String getOrigine() {
		return super.origine;
	}
}
