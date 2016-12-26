package carteModule;

import java.util.Random;

import player.Joueur;

public class Apocalypse extends CarteAction{

	private static final String[] origines = {Carte.JOUR, Carte.NEANT, Carte.NUIT, null, null};
	
	public Apocalypse() {
		super();
		this.type = "apocalypse";
		this.dogmes = null;
		this.origine = origines[new Random().nextInt(5)];
	}

	@Override
	public void utiliser() {
		
	}

	@Override
	public void sacrifier(Joueur joueur) {
		utiliser();
	}

}
