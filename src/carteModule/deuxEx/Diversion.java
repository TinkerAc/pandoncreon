package carteModule.deuxEx;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import carteModule.Carte;
import carteModule.CarteAction;
import carteModule.DeuxEx;
import player.Joueur;
import service.Partie;

public class Diversion extends DeuxEx {

	public Diversion(){
		super();
		this.nom = "Diversion";
		this.origine = Carte.NUIT;
		this.description = "Prenez 3 cartes dans la main d'un autre joueur et incluez-les 角 votre main.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Integer> jsAuChoix = new ArrayList<Integer>();
		System.out.println("Prendre 3 cartes dans la main d'un autre joueur:");
		System.out.println("choisir un joueur:");
		for(int i = 0; i < js.size(); i++) {
			if(i != js.indexOf(this.joueur)) {
				jsAuChoix.add(i);
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		int n1;
		while(true){
			try{
				n1 = sc.nextInt();
			}catch(InputMismatchException e){
				System.out.println("input ill谷gal, importer un nombre entier:");
				sc.nextLine();
				continue;
			}
			if(jsAuChoix.contains(n1)){
				break;
			}
			else{
				System.out.println("Ce joueur ne peut pas 那tre choisi, choisir un autre joueur:");
			}
		}
		
		ArrayList<CarteAction> cem = js.get(n1).getCartesEnMain();
		if(cem.size() <= 3){
			System.out.println("Ce joueur n'a pas assez de cartes en main, donc prendre toutes ses cartes en main");
			Iterator<CarteAction> it = cem.iterator();
			while(it.hasNext()){
				this.joueur.getCartesEnMain().add(it.next());
				js.get(n1).getCartesEnMain().remove(it.next());
				it.next().setJoueur(this.joueur);
			}
		}
		else{
			System.out.println("choisir 3 cartes entre:");
			for(int j = 0; j < cem.size(); j++){
				System.out.print("carte" + j + " ");
			}
			System.out.println();
			
			System.out.println("choisir 3 nombres entiers:");
			int n2;
			int n3;
			int n4;
			while(true){
				try{
					n2 = sc.nextInt();
				}catch(InputMismatchException e){
					System.out.println("input ill谷gal, importer un nombre entier:");
					sc.nextLine();
					continue;
				}
				if(n2 >= 0 && n2 < cem.size()){
					break;
				}
				else{
					System.out.println("Cette carte ne peut pas 那tre choisie, choisir une autre carte:");
				}
			}
			while(true){
				try{
					n3 = sc.nextInt();
				}catch(InputMismatchException e){
					System.out.println("input ill谷gal, importer un nombre entier:");
					sc.nextLine();
					continue;
				}
				if(n3 >= 0 && n3 < cem.size() && n3 != n2){
					break;
				}
				else{
					System.out.println("Cette carte ne peut pas 那tre choisie, choisir une autre carte:");
				}
			}
			while(true){
				try{
					n4 = sc.nextInt();
				}catch(InputMismatchException e){
					System.out.println("input ill谷gal, importer un nombre entier:");
					sc.nextLine();
					continue;
				}
				if(n4 >= 0 && n4 < cem.size() && n4 != n2 && n4 != n3){
					break;
				}
				else{
					System.out.println("Cette carte ne peut pas 那tre choisie, choisir une autre carte:");
				}
			}
			
			CarteAction ca1 = cem.get(n2);
			CarteAction ca2 = cem.get(n3);
			CarteAction ca3 = cem.get(n4);
			this.joueur.getCartesEnMain().add(ca1);
			this.joueur.getCartesEnMain().add(ca2);
			this.joueur.getCartesEnMain().add(ca3);
			js.get(n1).getCartesEnMain().remove(ca1);
			js.get(n1).getCartesEnMain().remove(ca2);
			js.get(n1).getCartesEnMain().remove(ca3);
			ca1.setJoueur(this.joueur);
			ca2.setJoueur(this.joueur);
			ca3.setJoueur(this.joueur);
		}
		
		this.joueur.getCartesEnMain().remove(this);
		this.setJoueur(null);
	}

}
