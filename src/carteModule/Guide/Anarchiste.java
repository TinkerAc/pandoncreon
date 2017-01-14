package carteModule.Guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.CartesSurTable;
import service.Partie;
import util.AideGUI;

public class Anarchiste extends GuideSpirituel {

	public Anarchiste(){
		super();
		this.nom = "Anarchiste";
		this.origine = Carte.NEANT;
		this.dogmes = new String[]{"chaos","humain"};
		this.setNbCroyantMax(3);
		this.description = "Sacrifie un Guide Spirituel, si lui ou sa Divinit¨¦ ne croit pas au Dogme Chaos. Les capacit¨¦s sp¨¦ciales sont jou¨¦es normalement.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Integer> jsAuChoix = new ArrayList<Integer>();
		Iterator<GuideSpirituel> it;
		int count;
		System.out.println("Sacrifier un Guide Spirituel, si lui ou sa Divinit¨¦ ne croit pas au Dogme Chaos:");		
		for(int i = 0; i < js.size(); i++){
			count = 0;
			boolean b = false;
			it = js.get(i).getGuides().iterator();
			System.out.println("joueur" + i + ":");
			if(!Arrays.asList(js.get(i).getCarteDivinite().getDogmes()).contains("chaos")){
				while(it.hasNext()){
					b = true;
					System.out.println("Guide Spirituel " + count + " :");
					System.out.println(it.next().toString());
					count++;
				}
			}
			else{
				while(it.hasNext()){
					if(!Arrays.asList(it.next().getDogmes()).contains("chaos")){
						b = true;
						System.out.println("Guide Spirituel " + count + " :");
						System.out.println(it.next().toString());
						count++;
					}
				}
			}
			if(b){
				jsAuChoix.add(i);
			}
		}		
		
		if(jsAuChoix.isEmpty()){
			System.out.println("Personne peut ¨ºtre choisie.");
		}
		else{
			System.out.println("choisir un joueur:");
//			Scanner sc = new Scanner(System.in);
			int n1;
			while(true){
//				try{
//					n1 = sc.nextInt();
//				}catch(InputMismatchException e){
//					System.out.println("input ill¨¦gal, importer un nombre entier:");
//					sc.nextLine();
//					continue;
//				}
				n1 = AideGUI.getInstance().lireInt();
				if(jsAuChoix.contains(n1)){
					break;
				}
				else{
					System.out.println("Ce joueur ne peut pas ¨ºtre choisi, choisir un autre joueur:");
				}
			}
			ArrayList<Integer> gsAuChoix = new ArrayList<Integer>();
			it = js.get(n1).getGuides().iterator();
			int count2 = 0;
			if(!Arrays.asList(js.get(n1).getCarteDivinite().getDogmes()).contains("chaos")){
				while(it.hasNext()){
					gsAuChoix.add(count2);
					count2++;
				}
			}
			else{
				while(it.hasNext()){
					if(!Arrays.asList(it.next().getDogmes()).contains("chaos")){
						gsAuChoix.add(count2);
						count2++;
					}
				}
			}
			
			System.out.println("choisir un Guide Spirituel:");
			int n2;
			while(true){
//				try{
//					n2 = sc.nextInt();
//				}catch(InputMismatchException e){
//					System.out.println("input ill¨¦gal, importer un nombre entier:");
//					sc.nextLine();
//					continue;
//				}
				n2 = AideGUI.getInstance().lireInt();
				if(gsAuChoix.contains(n2)){
					break;
				}
				else{
					System.out.println("Ce Guide Spirituel ne peut pas ¨ºtre choisi, choisir un autre Guide Spirituel:");
				}
			}
			GuideSpirituel gs = js.get(n1).getGuides().get(n2);
			gs.sacrifier(js.get(n1));
			
			CartesSurTable cst = Partie.getPartie().getCarteSurTable();
			Iterator<Croyant> it2 = this.getCroyants().iterator();
			while(it2.hasNext()){
				cst.getCroyantPublic().add(it2.next());
				this.getCroyants().remove(it2.next());
				this.setNbCroyant(this.getNbCroyant() - 1);
				this.joueur.getCroyants().remove(it2.next());
				this.joueur.setNbPriere(this.joueur.getNbPriere() - it2.next().getNbPriere());
				it2.next().setJoueur(null);
			}
			this.joueur.getGuides().remove(this);
			this.joueur = null;
		}
		
	}

}
