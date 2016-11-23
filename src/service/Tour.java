package service;

public class Tour {
	private Joueur[] joueurs;
	private int premiereJoueur;
	
	Tour(Joueur[] joueurs, Tour tourAvant) {
		this.joueurs = joueurs;
		this.premiereJoueur = tourAvant.getPremiereJoueur();
	}
	Tour(Joueur[] joueurs, int premiere) {
		this.joueurs = joueurs;
		this.premiereJoueur = premiere;
	}
	
	public void commencerNouveauTour() {
	}
	public void terminerLeTour() {
	}
	public void distribuerPointAction() {
		int n = joueurs[premiereJoueur].lancerDeCosnologie();
		
	}
	public int getPremiereJoueur() {
		return premiereJoueur;
	}
	
}







