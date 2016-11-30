package service;

import java.util.Iterator;
import java.util.Scanner;

import pandoncreon.CarteAction;

/**
 * 
 * ∂‘”¶–≈ÕΩø®  Ermite Vampire R®¶volutionnaires 
 * 
 * */

public class ProcessSacrifier {
	Joueur joueur;
	public ProcessSacrifier(Joueur joueur) {
		this.joueur = joueur;
	}
	public void start() {
		Scanner sc = new Scanner(System.in);
		for(Iterator<CarteAction> it = joueur.getCartesEnMain().iterator(); it.hasNext(); ) {
			if(it.next().getType() == "croyant") {
				System.out.println(it.toString());
			}
		}
		System.out.println("choisir une croyants:");
		int n1 = sc.nextInt();
		joueur.getCartesEnMain().remove(n1).sacrifier(joueur);
	}
}






