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
	
	Joueur() {
		cartesEnMain = new ArrayList<CarteAction>();
		carteDivinite = new Divinite();
		pointActionJour = 0;
		pointActionNeant = 0;
		pointActionNuit = 0;
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
		switch(random.nextInt(3)) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 2;
		default:
			return -1;
		}
	}
	public void choisirUneOperation(int n) {
		
	}
	
	public int getNbPriere() {
		return nbPriere;
	}
 }














