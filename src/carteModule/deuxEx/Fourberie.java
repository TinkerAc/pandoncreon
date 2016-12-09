package carteModule.deuxEx;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.DeuxEx;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.Partie;

public class Fourberie extends DeuxEx {

	public Fourberie(){
		super();
		this.nom = "Fourberie";
		this.origine = Carte.NUIT;
		this.description = "Sacrifiez 2 cartes Croyants d'une autre Divinit¨¦. Les capacit¨¦s sp¨¦ciales ne sont pas jou¨¦es.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Integer> jsAuChoix = new ArrayList<Integer>();
		Iterator<Croyant> it;
		int count;
		System.out.println("D¨¦truire 2 cartes Croyants d'une autre Divinit¨¦:");
		for(int i = 0; i < js.size(); i++) {
			if(i != js.indexOf(this.joueur)) {
				jsAuChoix.add(i);
				System.out.println("joueur" + i + ":");
				it = js.get(i).getCroyants().iterator();
				count = 0;
				while(it.hasNext()){
					System.out.println("Croyant" + count + ":");
					System.out.println(it.next().toString());
					count++;
				}
			}
		}
		
		System.out.println("choisir un joueur:");
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		while(true){
			try{
				n1 = sc.nextInt();
			}catch(InputMismatchException e){
				System.out.println("input ill¨¦gal, importer un nombre entier:");
				sc.nextLine();
				continue;
			}
			if(jsAuChoix.contains(n1)){
				break;
			}
			else{
				System.out.println("Ce joueur ne peut pas ¨ºtre choisi, choisir un autre joueur:");
			}
		}
		
		if(js.get(n1).getCroyants().size() < 2){
			System.out.println("Ce joueur n'a pas assez de Croyants, donc d¨¦truire tous ses Croyants");
			Iterator<Croyant> it2 = js.get(n1).getCroyants().iterator();
			while(it2.hasNext()){
				js.get(n1).getCroyants().remove(it2.next());
				js.get(n1).setNbPriere(js.get(n1).getNbPriere() - it2.next().getNbPriere());
				it2.next().setJoueur(null);
			}
			Iterator<GuideSpirituel> it4 = js.get(n1).getGuides().iterator();
			while(it4.hasNext()){
				if(!it4.next().getCroyants().isEmpty()){
					it4.next().getCroyants().remove(0);
					it4.next().setNbCroyant(it4.next().getNbCroyant() - 1);
				}
			}
		}
		else{
			System.out.println("choisir 2 Croyants:");
			int n2;
			int n3;
			while(true){
				try{
					n2 = sc.nextInt();
				}catch(InputMismatchException e){
					System.out.println("input ill¨¦gal, importer un nombre entier:");
					sc.nextLine();
					continue;
				}
				if(n2 >= 0 && n2 < js.get(n1).getCroyants().size()){
					break;
				}
				else{
					System.out.println("Ce Croyant ne peut pas ¨ºtre choisi, choisir un autre Croyant:");
				}
			}
			while(true){
				try{
					n3 = sc.nextInt();
				}catch(InputMismatchException e){
					System.out.println("input ill¨¦gal, importer un nombre entier:");
					sc.nextLine();
					continue;
				}
				if(n3 >= 0 && n3 < js.get(n1).getCroyants().size() && n3 != n2){
					break;
				}
				else{
					System.out.println("Ce Croyant ne peut pas ¨ºtre choisi, choisir un autre Croyant:");
				}
			}
			
			Croyant c1 = js.get(n1).getCroyants().get(n2);
			Croyant c2 = js.get(n1).getCroyants().get(n3);
			js.get(n1).getCroyants().remove(c1);
			js.get(n1).getCroyants().remove(c2);
			js.get(n1).setNbPriere(js.get(n1).getNbPriere() - c1.getNbPriere());
			js.get(n1).setNbPriere(js.get(n1).getNbPriere() - c2.getNbPriere());
			
			Iterator<GuideSpirituel> it3 = js.get(n1).getGuides().iterator();
			while(it3.hasNext()){
				if(it3.next().getCroyants().contains(c1)){
					it3.next().getCroyants().remove(c1);
					it3.next().setNbCroyant(it3.next().getNbCroyant() - 1);
				}
				if(it3.next().getCroyants().contains(c2)){
					it3.next().getCroyants().remove(c2);
					it3.next().setNbCroyant(it3.next().getNbCroyant() - 1);
				}
			}
			c1.setJoueur(null);
			c2.setJoueur(null);
		}
		this.joueur.getCartesEnMain().remove(this);
		this.setJoueur(null);
	}

}
