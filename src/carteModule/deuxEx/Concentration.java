package carteModule.deuxEx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import carteModule.Carte;
import carteModule.DeuxEx;
import carteModule.GuideSpirituel;
import player.Joueur;

public class Concentration extends DeuxEx {
	
	public Concentration(){
		super();
		this.nom = "Concentration";
		this.origine = Carte.NEANT;
		this.description = "Vous r¨¦cup¨¦rez un des Guides Spirituels pos¨¦s devant une autre Divinit¨¦ et le placez devant vous avec les Croyants qui y sont attach¨¦s.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = parite.getJoueurs();
		System.out.println("R¨¦cup¨¦rer un des Guides Spirituels pos¨¦s devant une autre Divinit¨¦:");
		System.out.println("choisir un joueur:");
		for(int i = 0; i < js.size(); i++) {
			if(i != js.indexOf(this.joueur)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		Iterator<GuideSpirituel> it;
		it = js.get(n1).getGuides().iterator();
		System.out.println("choisir un Guide Spirituel:");
		int count = 0;
		while(it.hasNext()){
			System.out.println(count + ":");
			System.out.println(it.next().toString());
			count++;
		}
		int n2 = sc.nextInt();
		GuideSpirituel gs = js.get(n1).getGuides().get(n2);
		this.joueur.getGuides().add(gs);
		js.get(n1).getGuides().remove(gs);
		this.joueur.getCartesEnMain().remove(this);
	}
}
