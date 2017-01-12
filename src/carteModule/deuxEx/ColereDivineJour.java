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
import service.CartesSurTable;
import service.Partie;

public class ColereDivineJour extends DeuxEx {
	
	public ColereDivineJour(){
		super();
		this.nom = "Col¨¨reDivineJour";
		this.origine = Carte.JOUR;
		this.description = "D¨¦truit une carte Guide Spirituel d'Origine Nuit ou N¨¦ant, dont la capacit¨¦ sp¨¦ciale n'a pas effet. Les Croyants attach¨¦s reviennent au centre de la table.";
	}

	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Integer> jsAuChoix = new ArrayList<Integer>();
		System.out.println("D¨¦truire une carte Guide Spirituel d'Origine Nuit ou N¨¦ant:");
		for(int i = 0; i < js.size(); i++){
			int count = 0;
			boolean b = false;
			Iterator<GuideSpirituel> it = js.get(i).getGuides().iterator();
			System.out.println("joueur" + i + ":");
			while(it.hasNext()){
				if((it.next().getOrigine().equals("neant")) || (it.next().getOrigine().equals("nuit"))){
					b = true;
					System.out.println("Guide Spirituel " + count + ":");
					System.out.println(it.next().toString());
				}
				count++;
			}
			if(b){
				jsAuChoix.add(i);
			}
		}
		
		if(jsAuChoix.isEmpty()){
			System.out.println("Personne a un Guide Spirituel.");
		}
		else{
			System.out.println("choisir un joueur:");
			Scanner sc = new Scanner(System.in);
			int n1;
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
			
			Iterator<GuideSpirituel> it;
			it = js.get(n1).getGuides().iterator();
			ArrayList<Integer> gsAuChoix = new ArrayList<Integer>();
			int count2 = 0;
			while(it.hasNext()){
				if((it.next().getOrigine().equals("neant")) || (it.next().getOrigine().equals("nuit"))){
					gsAuChoix.add(count2);
				}
				count2++;
			}
			
			System.out.println("choisir un Guide Spirituel:");
			int n2;
			while(true){
				try{
					n2 = sc.nextInt();
				}catch(InputMismatchException e){
					System.out.println("input ill¨¦gal, importer un nombre entier:");
					sc.nextLine();
					continue;
				}
				if(gsAuChoix.contains(n2)){
					break;
				}
				else{
					System.out.println("Ce Guide Spirituel ne peut pas ¨ºtre choisi, choisir un autre Guide Spirituel:");
				}
			}
			
			GuideSpirituel gs = js.get(n1).getGuides().get(n2);
			CartesSurTable cst = Partie.getPartie().getCarteSurTable();
			Iterator<Croyant> it2 = gs.getCroyants().iterator();
			while(it2.hasNext()){
				cst.getCroyantPublic().add(it2.next());
				gs.getCroyants().remove(it2.next());
				gs.setNbCroyant(gs.getNbCroyant() - 1);
				js.get(n1).getCroyants().remove(it2.next());
				js.get(n1).setNbPriere(js.get(n1).getNbPriere() - it2.next().getNbPriere());
				it2.next().setJoueur(null);
			}
			js.get(n1).getGuides().remove(gs);
			gs.setJoueur(null);
			this.joueur.getCartesEnMain().remove(this);
			this.setJoueur(null);
		}
	}

}
