package service;

public class Partie {
	
	private static Partie partie;
	
	private int nbJoueurs;
	private Joueur[] joueurs;
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
	
	public Partie getParte() {
		this.partie = new Partie();
		return partie;
	}
	public void addJoueurs() {
	}
	public void deleteJoueurs() {
	}
	public void compareNbPriere() {
	}
	public void eliminerJoueur() {
	}
	public void commencerPartie() {
	}
	public void terminerPartie() {
	}
	
	
}







