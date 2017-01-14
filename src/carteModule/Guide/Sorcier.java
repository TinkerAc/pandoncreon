package carteModule.Guide;

import java.util.ArrayList;
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

public class Sorcier extends GuideSpirituel {

	public Sorcier(){
		super();
		this.nom = "Sorcier";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{"symboles","mystique"};
		this.setNbCroyantMax(3);
		this.description = "Echangez l'un de vos Guides Spirituels avec un d'une autre Divinit谷. Vous choisissez les deux guides Spirituels en question. Les Croyants restent attach谷s aux m那mes cartes.";
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
//			Scanner sc = new Scanner(System.in);
			int n1;
			while(true){
//				try{
//					n1 = sc.nextInt();
//				}catch(InputMismatchException e){
//					System.out.println("input ill谷gal, importer un nombre entier:");
//					sc.nextLine();
//					continue;
//				}
				n1 = AideGUI.getInstance().lireInt();
				if(n1 >= 0 && n1 < this.joueur.getGuides().size()){
					break;
				}
				else{
					System.out.println("Ce Guide Spirituel ne peut pas 那tre choisi, choisir un autre Guide Spirituel:");
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
//					try{
//						n2 = sc.nextInt();
//					}catch(InputMismatchException e){
//						System.out.println("input ill谷gal, importer un nombre entier:");
//						sc.nextLine();
//						continue;
//					}
					n2 = AideGUI.getInstance().lireInt();
					if(jsAuChoix.contains(n2)){
						break;
					}
					else{
						System.out.println("Ce joueur ne peut pas 那tre choisi, choisir un autre joueur:");
					}
				}
				
				System.out.println("choisir un Guide Spirituel:");
				int n3;
				while(true){
//					try{
//						n3 = sc.nextInt();
//					}catch(InputMismatchException e){
//						System.out.println("input ill谷gal, importer un nombre entier:");
//						sc.nextLine();
//						continue;
//					}
					n3 = AideGUI.getInstance().lireInt();
					if(n3 >= 0 && n3 < js.get(n2).getGuides().size()){
						break;
					}
					else{
						System.out.println("Ce Guide Spirituel ne peut pas 那tre choisi, choisir un autre Guide Spirituel:");
					}
				}
				GuideSpirituel gs2 = js.get(n2).getGuides().get(n3);
				
				this.joueur.getGuides().remove(gs);
				this.joueur.getGuides().add(gs2);
				js.get(n2).getGuides().remove(gs2);
				js.get(n2).getGuides().add(gs);
				Iterator<Croyant> it3 = gs.getCroyants().iterator();
				Iterator<Croyant> it4 = gs2.getCroyants().iterator();
				while(it3.hasNext()){
					this.joueur.getCroyants().remove(it3.next());
					this.joueur.setNbPriere(this.joueur.getNbPriere() - it3.next().getNbPriere());
					js.get(n2).getCroyants().add(it3.next());
					js.get(n2).setNbPriere(js.get(n2).getNbPriere() + it3.next().getNbPriere());
					it3.next().setJoueur(js.get(n2));
				}
				while(it4.hasNext()){
					this.joueur.getCroyants().add(it4.next());
					this.joueur.setNbPriere(this.joueur.getNbPriere() + it4.next().getNbPriere());
					js.get(n2).getCroyants().remove(it3.next());
					js.get(n2).setNbPriere(js.get(n2).getNbPriere() - it4.next().getNbPriere());
					it4.next().setJoueur(this.joueur);
				}
				gs.setJoueur(js.get(n2));
				gs2.setJoueur(this.joueur);
				
				CartesSurTable cst = Partie.getPartie().getCarteSurTable();
				Iterator<Croyant> it5 = this.getCroyants().iterator();
				while(it5.hasNext()){
					cst.getCroyantPublic().add(it5.next());
					this.getCroyants().remove(it5.next());
					this.setNbCroyant(this.getNbCroyant() - 1);
					this.joueur.getCroyants().remove(it5.next());
					this.joueur.setNbPriere(this.joueur.getNbPriere() - it5.next().getNbPriere());
					it5.next().setJoueur(null);
				}
				this.joueur.getGuides().remove(this);
				this.joueur = null;
			}
		}
			
	}

}
