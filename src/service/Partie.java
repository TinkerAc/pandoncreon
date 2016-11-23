package service;

import java.util.ArrayList;

public class Partie {
	
	private static Partie partie;
	
	private int nbJoueurs;
	private ArrayList<Joueur> joueurs;
	private Cartes cartes;
	private Tour tour;
	private Tour tourAvant;
	private CartesSurTable carteSurTable;
	
	private Partie() {
		this.nbJoueurs = 0;
		this.joueurs = null;
		this.cartes = Cartes.getInstance();
		this.carteSurTable = CartesSurTable.getCartesSurTable();
	}
	
	public static Partie getPartie() {
		partie = new Partie();
		return partie;
	}
	public void addJoueurs() {
		joueurs.add(new Joueur());
	}
	public void deleteJoueurs() {
		joueurs.remove(joueurs.size() - 1);
	}
	public int compareNbPriere() {
		int max= joueurs.get(0).getNbPriere();
		int index = 0;
		int tmp = 0;
		int i = 1;
		while(i < joueurs.size()) {
			tmp = joueurs.get(i).getNbPriere();
			if(tmp > max) {
				max = tmp;
				index = i;
			}
		}
		return index;
		
	}
	public void eliminerJoueur(Joueur j) {
		joueurs.remove(j);
	}
	
	public void commencerPartie() {
	}
	public void terminerPartie() {
	}
	
	public Cartes getCartes() {
		return this.cartes;
	}
}







