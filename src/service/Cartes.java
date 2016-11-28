package service;

import java.util.ArrayList;

import pandoncreon.*;

public class Cartes {
	private ArrayList<CarteAction> cartes;
	private int nbCartes;
	private static Cartes pile;
	
	private Cartes() {
		cartes = new ArrayList<CarteAction>();
		
		
		
		nbCartes = cartes.size();
	}
	public void melanger() {
		
	}
	public CarteAction returnCarte() {
		return null;
	}
	
	
	/*-----------------------------------*/
	public static Cartes getInstance() {
		if(pile == null) {
			pile = new Cartes();
		}
		return pile;
	}
	public int getNbCartes() {
		return this.nbCartes;
	}
	public ArrayList<CarteAction> getCartes() {
		return this.cartes;
	}
	
	
}
