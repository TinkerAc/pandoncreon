package carteModule;

import java.util.Random;

import player.Joueur;

public class Apocalypse extends CarteAction{

	private static final String[] origines = {Carte.JOUR, Carte.NEANT, Carte.NUIT, "sans Origine", "sans Origine"};
	
	public Apocalypse() {
		super();
		this.type = "apocalypse";
		this.nom = "Apocalypse";
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
