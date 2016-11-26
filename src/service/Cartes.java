package service;

import pandoncreon.*;

public class Cartes {
	private CarteAction[] cartes;
	private int nbCartes;
	private static Cartes pile;
	
	private Cartes() {
		
	}
	public void melanger() {
		
	}
	public CarteAction returnCarte() {
		return null;
	}
	
	public static Cartes getInstance() {
		pile = new Cartes();
		return pile;
	}
	public int getNbCartes() {
		return this.nbCartes;
	}
	public CarteAction[] getCartes() {
		return this.cartes;
	}
	
	
}
