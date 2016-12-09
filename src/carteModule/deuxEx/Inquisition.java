package carteModule.deuxEx;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import carteModule.Croyant;
import carteModule.DeuxEx;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.CartesSurTable;
import service.Partie;

public class Inquisition extends DeuxEx {

	public Inquisition(){
		super();
		this.nom = "Inquisition";
		this.origine = "sans Origine";
		this.description = "Choisissez un des Guides Spirituels d'un autre joueur, et l'un des votres. Lancez le d¨¦ de Cosmogonie. Sur Jour, le Guide adverse est sacrifi¨¦, sur Nuit le votre est sacrifi¨¦, sur N¨¦ant rien ne se passe.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Integer> jsAuChoix = new ArrayList<Integer>();
		if(this.joueur.getGuides().isEmpty()){
			System.out.println("Vous n'avez pas de Guides Spirituels.");
		}
		else{
			System.out.println("choisir un Guide Spirituel de vous:");
			Iterator<GuideSpirituel> it = this.joueur.getGuides().iterator();
			int count = 0;
			while(it.hasNext()){
				System.out.println(count + ":");
				System.out.println(it.next().toString());
				count++;
			}
			
			System.out.println("choisir un nombre entier:");
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
				if(n1 >= 0 && n1 < this.joueur.getGuides().size()){
					break;
				}
				else{
					System.out.println("Ce Guide Spirituel ne peut pas ¨ºtre choisi, choisir un autre Guide Spirituel:");
				}
			}
			GuideSpirituel gs = this.joueur.getGuides().get(n1);
			
			Iterator<GuideSpirituel> it2;
			int count2;
			System.out.println("choisir un Guide Spirituel d'un autre joueur:");
			for(int i = 0; i < js.size(); i++) {
				count2 = 0;
				if(i != js.indexOf(this.joueur)) {
					if(!js.get(i).getGuides().isEmpty()){
						jsAuChoix.add(i);
						System.out.println("joueur" + i + ":");
						it2 = js.get(i).getGuides().iterator();
						while(it2.hasNext()){
							System.out.println("Guide Spirituel " + count2 + ":");
							System.out.println(it2.next().toString());
							count2++;
						}
					}
				}
			}
			if(jsAuChoix.isEmpty()){
				System.out.println("Les autres joueurs n'ont pas de Guides Spirituels.");
			}
			else{
				System.out.println("choisir un joueur:");
				int n2;
				while(true){
					try{
						n2 = sc.nextInt();
					}catch(InputMismatchException e){
						System.out.println("input ill¨¦gal, importer un nombre entier:");
						sc.nextLine();
						continue;
					}
					if(jsAuChoix.contains(n2)){
						break;
					}
					else{
						System.out.println("Ce joueur ne peut pas ¨ºtre choisi, choisir un autre joueur:");
					}
				}
				
				System.out.println("choisir un Guide Spirituel:");
				int n3;
				while(true){
					try{
						n3 = sc.nextInt();
					}catch(InputMismatchException e){
						System.out.println("input ill¨¦gal, importer un nombre entier:");
						sc.nextLine();
						continue;
					}
					if(n3 >= 0 && n3 < js.get(n2).getGuides().size()){
						break;
					}
					else{
						System.out.println("Ce Guide Spirituel ne peut pas ¨ºtre choisi, choisir un autre Guide Spirituel:");
					}
				}
				GuideSpirituel gs2 = js.get(n2).getGuides().get(n3);
				
				int point = this.joueur.lancerDeCosnologie();
				if(point == 0){
					System.out.println("face 'Jour'");
					gs.sacrifier(this.joueur);
					this.joueur.getCartesEnMain().remove(this);
					this.setJoueur(null);
				}
				if(point == 2){
					System.out.println("face 'Nuit'");
					gs2.sacrifier(js.get(n2));
					this.joueur.getCartesEnMain().remove(this);
					this.setJoueur(null);
				}
				if(point == 1){
					System.out.println("face 'Neant'");
					this.joueur.getCartesEnMain().remove(this);
					this.setJoueur(null);
				}
			}
		}
		
		
	}

}
