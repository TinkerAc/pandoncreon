package carteModule.deuxEx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import carteModule.Carte;
import carteModule.CarteAction;
import carteModule.Croyant;
import carteModule.DeuxEx;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.CartesSurTable;
import service.Partie;

public class ColereDivineJour extends DeuxEx {
	
	public ColereDivineJour(){
		super();
		this.nom = "Col¨¨re Divine";
		this.origine = Carte.JOUR;
		this.description = "D¨¦truit une carte Guide Spirituel d'Origine Nuit ou N¨¦ant, dont la capacit¨¦ sp¨¦ciale n'a pas effet. Les Croyants attach¨¦s reviennent au centre de la table.";
	}

	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		System.out.println("D¨¦truire une carte Guide Spirituel d'Origine Nuit ou N¨¦ant:");
		System.out.print("choisir un joueur: ");
		for(int i = 0; i < js.size(); i++){
			System.out.print(i + " ");
		}
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		Iterator<GuideSpirituel> it;
		it = js.get(n1).getGuides().iterator();
		System.out.println("choisir un Guide Spirituel:");
		int count = 0;
		while(it.hasNext()){
			if((it.next().getOrigine().equals("neant")) || (it.next().getOrigine().equals("nuit"))){
				System.out.println(count + ":");
				System.out.println(it.next().toString());
			}
			count++;
		}
		int n2 = sc.nextInt();
		GuideSpirituel gs = js.get(n1).getGuides().get(n2);
		CartesSurTable cst = parite.getCarteSurTable();
		Iterator<Croyant> it2 = gs.getCroyants().iterator();
		while(it2.hasNext()){
			cst.getCroyantPublic().add(it2.next());
		}
		js.get(n1).getGuides().remove(gs);
		this.joueur.getCartesEnMain().remove(this);
	}

}
