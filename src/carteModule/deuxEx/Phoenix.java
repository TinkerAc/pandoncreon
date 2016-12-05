package carteModule.deuxEx;

import java.util.Iterator;
import java.util.Scanner;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.DeuxEx;
import carteModule.GuideSpirituel;
import player.Joueur;

public class Phoenix extends DeuxEx {

	public Phoenix(){
		super();
		this.nom = "Phoenix";
		this.origine = Carte.NEANT;
		this.description = "Permet de b¨¦n¨¦ficier de la capacit¨¦ sp¨¦ciale de l'un de vos Croyants ou Guides Spirituels sans sacrifier la carte.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		System.out.println("choisir un Croyant ou un Guide Spirituel:");
		Iterator<GuideSpirituel> it = this.joueur.getGuides().iterator();
		Iterator<Croyant> it2;
		int count = 0;
		int count2;
		GuideSpirituel gs;
		while(it.hasNext()){
			gs = it.next();
			System.out.println("Guide Spirituel " + count + ":");
			System.out.println(gs.toString());
			count++;
			it2 = gs.getCroyants().iterator();
			count2 = 0;
			System.out.println("et ses Croyants:");
			while(it2.hasNext()){
				System.out.println("Croyant " + count2 + ":");
				System.out.println(it.next().toString());
				count2++;
			}
		}
		System.out.println("'g' pour un Guide Spirituel et 'c' pour un Croyant");
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		if(s1.equals("g")){
			System.out.println("choisir le Guide Spirituel:");
			int n1 = sc.nextInt();
			this.joueur.getGuides().get(n1).sacrifier(joueur);
			this.joueur.getCartesEnMain().remove(this);
		}
		if(s1.equals("c")){
			System.out.println("choisir d'abord de quel Guide Spirituel:");
			int n2 = sc.nextInt();
			gs = this.joueur.getGuides().get(n2);
			System.out.println("choisir le Croyant:");
			int n3 = sc.nextInt();
			gs.getCroyants().get(n3).sacrifier(joueur);
			this.joueur.getCartesEnMain().remove(this);
		}
	}

}
