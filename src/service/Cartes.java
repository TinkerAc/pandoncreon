package service;

import java.util.ArrayList;
import java.util.Random;

import pandoncreon.*;
import pandoncreon.croyant.*;

public class Cartes {
	private ArrayList<CarteAction> cartes;
	private int nbCartes;
	private static Cartes pile;
	
	private Cartes() {
		cartes = new ArrayList<CarteAction>();
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new DeuxEx());
		cartes.add(new DeuxEx());
		cartes.add(new DeuxEx());
		cartes.add(new Demon());
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		cartes.add(new Esprits());
		cartes.add(new Demon());
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		cartes.add(new Esprits());
		cartes.add(new Demon());
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		cartes.add(new Esprits());
		cartes.add(new Demon());
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		cartes.add(new Esprits());
		cartes.add(new Demon());
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		cartes.add(new Esprits());
		cartes.add(new Demon());
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		cartes.add(new Esprits());
		
		
		nbCartes = cartes.size();
	}
	public void melanger() {
		
	}
	public CarteAction returnCarte() {
		return cartes.get(new Random().nextInt(cartes.size()));
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
