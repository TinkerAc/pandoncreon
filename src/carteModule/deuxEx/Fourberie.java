package carteModule.deuxEx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.DeuxEx;
import carteModule.GuideSpirituel;
import player.Joueur;

public class Fourberie extends DeuxEx {

	public Fourberie(){
		super();
		this.nom = "Fourberie";
		this.origine = Carte.NUIT;
		this.description = "Sacrifiez 2 cartes Croyants d'une autre Divinit¨¦. Les capacit¨¦s sp¨¦ciales ne sont pas jou¨¦es.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = parite.getJoueurs();
		Iterator<Croyant> it;
		int count;
		System.out.println("D¨¦truire 2 cartes Croyants d'une autre Divinit¨¦:");
		for(int i = 0; i < js.size(); i++) {
			if(i != js.indexOf(this.joueur)) {
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
		System.out.println("choisir 2 Croyants:");
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		Croyant c1 = js.get(n1).getCroyants().get(n2);
		Croyant c2 = js.get(n1).getCroyants().get(n3);
		js.get(n1).getCroyants().remove(c1);
		js.get(n1).getCroyants().remove(c2);
		Iterator<GuideSpirituel> it2 = js.get(n1).getGuides().iterator();
		while(it2.hasNext()){
			if(it2.next().getCroyants().contains(c1)){
				it2.next().getCroyants().remove(c1);
			}
			if(it2.next().getCroyants().contains(c2)){
				it2.next().getCroyants().remove(c2);
			}
		}
	}

}
