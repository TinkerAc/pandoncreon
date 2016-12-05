package carteModule.deuxEx;

import java.util.ArrayList;
import java.util.Scanner;

import carteModule.Carte;
import carteModule.CarteAction;
import carteModule.DeuxEx;
import player.Joueur;

public class Diversion extends DeuxEx {

	public Diversion(){
		super();
		this.nom = "Diversion";
		this.origine = Carte.NUIT;
		this.description = "Prenez 3 cartes dans la main d'un autre joueur et incluez-les ид votre main.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = parite.getJoueurs();
		System.out.println("Prendre 3 cartes dans la main d'un autre joueur:");
		System.out.println("choisir un joueur:");
		for(int i = 0; i < js.size(); i++) {
			if(i != js.indexOf(this.joueur)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		ArrayList<CarteAction> cem = js.get(n1).getCartesEnMain();
		System.out.println("choisir 3 cartes:");
		for(int j = 0; j < cem.size(); j++){
			System.out.print("carte" + j + " ");
		}
		System.out.println();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		int n4 = sc.nextInt();
		CarteAction ca1 = cem.get(n2);
		CarteAction ca2 = cem.get(n3);
		CarteAction ca3 = cem.get(n4);
		this.joueur.getCartesEnMain().add(ca1);
		this.joueur.getCartesEnMain().add(ca2);
		this.joueur.getCartesEnMain().add(ca3);
		js.get(n1).getCartesEnMain().remove(ca1);
		js.get(n1).getCartesEnMain().remove(ca2);
		js.get(n1).getCartesEnMain().remove(ca3);
		this.joueur.getCartesEnMain().remove(this);
	}

}
