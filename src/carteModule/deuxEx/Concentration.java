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

public class Concentration extends DeuxEx {
	
	public Concentration(){
		super();
		this.nom = "Concentration";
		this.origine = Carte.NEANT;
		this.description = "Vous r¨¦cup¨¦rez un des Guides Spirituels pos¨¦s devant une autre Divinit¨¦ et le placez devant vous avec les Croyants qui y sont attach¨¦s.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Integer> jsAuChoix = new ArrayList<Integer>();
		System.out.println("R¨¦cup¨¦rer un des Guides Spirituels pos¨¦s devant une autre Divinit¨¦:");

		for(int i = 0; i < js.size(); i++) {
			int count = 0;
			if(i != js.indexOf(this.joueur)) {
				if(js.get(i).getGuides().size() > 0){
					System.out.println("joueur" + i + ":");
					jsAuChoix.add(i);
					Iterator<GuideSpirituel> it = js.get(i).getGuides().iterator();
					while(it.hasNext()){
						System.out.println("Guide Spirituel " + count + ":");
						System.out.println(it.next().toString());
						count++;
					}
				}
			}
		}

		if(jsAuChoix.isEmpty()){
			System.out.println("Personne a un Guide Spirituel.");
		}
		else{
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
			
			Iterator<GuideSpirituel> it2;
			it2 = js.get(n1).getGuides().iterator();
			ArrayList<Integer> gsAuChoix = new ArrayList<Integer>();
			int count2 = 0;
			while(it2.hasNext()){
				gsAuChoix.add(count2);
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
			Iterator<Croyant> it3 = gs.getCroyants().iterator();
			this.joueur.getGuides().add(gs);
			js.get(n1).getGuides().remove(gs);
			gs.setJoueur(this.joueur);
			while(it3.hasNext()){
				this.joueur.getCroyants().add(it3.next());
				this.joueur.setNbPriere(this.joueur.getNbPriere() + it3.next().getNbPriere());
				js.get(n1).getCroyants().remove(it3.next());
				js.get(n1).setNbPriere(js.get(n1).getNbPriere() - it3.next().getNbPriere());
				it3.next().setJoueur(this.joueur);
			}
			this.joueur.getCartesEnMain().remove(this);
			this.setJoueur(null);
		}
	}
}
