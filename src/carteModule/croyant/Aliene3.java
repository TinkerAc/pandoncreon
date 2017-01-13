package carteModule.croyant;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import carteModule.Carte;
import carteModule.CarteAction;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.Partie;
import util.AideGUI;

public class Aliene3 extends Croyant {
	
	public Aliene3() {
		super();
		this.setNbPriere(2);
		this.nom = "Ali¨¦n¨¦3";
		this.origine = Carte.NEANT;
		this.dogmes = new String[]{Carte.CHAOS,Carte.HUMAIN,Carte.SYMBOLES};
		this.description = "Vous piochez deux cartes au hasard dans la main d'une autre Divinit¨¦.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Integer> jsAuChoix = new ArrayList<Integer>();
		System.out.println("Prendre 2 cartes en main d'un autre joueur:");
		System.out.println("choisir un joueur:");
		for(int i = 0; i < js.size(); i++) {
			if(i != js.indexOf(this.joueur)) {
				jsAuChoix.add(i);
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
//		Scanner sc = new Scanner(System.in);
		int n1;
		while(true){
//			try{
//				n1 = sc.nextInt();
//			}catch(InputMismatchException e){
//				System.out.println("input ill¨¦gal, importer un nombre entier:");
//				sc.nextLine();
//				continue;
//			}
			n1 = AideGUI.getInstance().lireInt();
			if(jsAuChoix.contains(n1)){
				break;
			}
			else{
				System.out.println("Ce joueur ne peut pas ¨ºtre choisi, choisir un autre joueur:");
			}
		}
		
		ArrayList<CarteAction> cem = js.get(n1).getCartesEnMain();
		if(cem.size() <= 2){
			System.out.println("Ce joueur n'a pas assez de cartes en main, donc prendre toutes ses cartes en main");
			Iterator<CarteAction> it = cem.iterator();
			while(it.hasNext()){
				this.joueur.getCartesEnMain().add(it.next());
				js.get(n1).getCartesEnMain().remove(it.next());
				it.next().setJoueur(this.joueur);
			}
		}
		else{
			System.out.println("choisir 2 cartes entre:");
			for(int j = 0; j < cem.size(); j++){
				System.out.print("carte" + j + " ");
			}
			System.out.println();
			
			System.out.println("choisir 2 nombres entiers:");
			int n2;
			int n3;
			while(true){
//				try{
//					n2 = sc.nextInt();
//				}catch(InputMismatchException e){
//					System.out.println("input ill¨¦gal, importer un nombre entier:");
//					sc.nextLine();
//					continue;
//				}
				n2 = AideGUI.getInstance().lireInt();
				if(n2 >= 0 && n2 < cem.size()){
					break;
				}
				else{
					System.out.println("Cette carte ne peut pas ¨ºtre choisie, choisir une autre carte:");
				}
			}
			while(true){
//				try{
//					n3 = sc.nextInt();
//				}catch(InputMismatchException e){
//					System.out.println("input ill¨¦gal, importer un nombre entier:");
//					sc.nextLine();
//					continue;
//				}
				n3 = AideGUI.getInstance().lireInt();
				if(n3 >= 0 && n3 < cem.size() && n3 != n2){
					break;
				}
				else{
					System.out.println("Cette carte ne peut pas ¨ºtre choisie, choisir une autre carte:");
				}
			}
			
			CarteAction ca1 = cem.get(n2);
			CarteAction ca2 = cem.get(n3);
			this.joueur.getCartesEnMain().add(ca1);
			this.joueur.getCartesEnMain().add(ca2);
			js.get(n1).getCartesEnMain().remove(ca1);
			js.get(n1).getCartesEnMain().remove(ca2);
			ca1.setJoueur(this.joueur);
			ca2.setJoueur(this.joueur);
		}
		
		this.joueur.getCroyants().remove(this);
		this.joueur.setNbPriere(this.joueur.getNbPriere() - this.getNbPriere());
		Iterator<GuideSpirituel> it2 = this.joueur.getGuides().iterator();
		while(it2.hasNext()){
			if(it2.next().getCroyants().contains(this)){
				it2.next().getCroyants().remove(this);
				it2.next().setNbCroyant(it2.next().getNbCroyant() - 1);
			}
		}
		this.setJoueur(null);

	}

}
