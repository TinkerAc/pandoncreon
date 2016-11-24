package service;

import java.util.ArrayList;
import java.util.Random;

import pandoncreon.*;


public class Joueur {
	private ArrayList<CarteAction> cartesEnMain;
	private Divinite carteDivinite;
	private int pointActionJour;
	private int pointActionNeant;
	private int pointActionNuit;
	private int nbPriere;
	private Process process;
	private Joueur nextJoueur;
	
	Joueur() {
		cartesEnMain = new ArrayList<CarteAction>();
		carteDivinite = new Divinite();
		setPointActionJour(0);
		setPointActionNeant(0);
		setPointActionNuit(0);
		nbPriere = 0;
	}
	
	public void defausser(CarteAction...index) {
		for(int i = 0; i < index.length; i++) {
			cartesEnMain.remove(index[i]);
		}
	}
	
	public void piocher(Cartes cartes) {
		if(cartesEnMain.size() == 7) {
			return;
		}
		while(cartesEnMain.size() < 7) {
			cartesEnMain.add(cartes.returnCarte());
		}
		
	}
	public void utiliser() {
		
	}
	public void sacrifier() {
		
	}
	public void capaciter() {
		
	}
	public int lancerDeCosnologie() {
		Random random = new Random();
		return random.nextInt(3);
	}
	public void choisirUneOperation(int n) {
		switch (n) {
		case 0:
			defausser();
			break;
		case 1:
			piocher(Partie.getPartie().getCartes());
			break;
		case 2:
			utiliser();
			break;
		case 3:
			sacrifier();
			break;
		case 4:
			capaciter();
			break;
		default:
			//
			break;
		}
	}
	
	public void process() {
		this.process.start();
	}
	
	
	
	
	//---------------------------------
	
	public int getNbPriere() {
		return nbPriere;
	}
	public String getOrigineDivinite() {
		return carteDivinite.getOrigine();
	}

	public int getPointActionJour() {
		return pointActionJour;
	}

	public void setPointActionJour(int pointActionJour) {
		this.pointActionJour = pointActionJour;
	}

	public int getPointActionNeant() {
		return pointActionNeant;
	}

	public void setPointActionNeant(int pointActionNeant) {
		this.pointActionNeant = pointActionNeant;
	}

	public int getPointActionNuit() {
		return pointActionNuit;
	}

	public void setPointActionNuit(int pointActionNuit) {
		this.pointActionNuit = pointActionNuit;
	}

	public Joueur getNextJoueur() {
		return nextJoueur;
	}

	public void setNextJoueur(Joueur nextJoueur) {
		this.nextJoueur = nextJoueur;
	}
 }














