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

public class Exorciste extends GuideSpirituel {

	public Exorciste(){
		super();
		this.nom = "Exorciste";
		this.origine = Carte.JOUR;
		this.dogmes = new String[]{"chaos","mystique"};
		this.description = "Une Divinit¨¦ d'Origine Nuit ou ayant les Dogmes Mystique et Chaos reprend dans sa main l'un de ses Guides Spirituels. Les Croyants qui y ¨¦taient attach¨¦s sont d¨¦fauss¨¦s.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Integer> jsAuChoix = new ArrayList<Integer>();
		int count;
		System.out.println("Rendre un Guide Spirituel ¨¤ sa Divinit¨¦ d'Origine Nuit ou ayant les Dogmes Mystique et Chaos:");
		for(int i = 0; i < js.size(); i++){
			boolean b = false;
			count = 0;
			if(js.get(i).getCarteDivinite().getOrigine().equals("nuit") 
				|| (Arrays.asList(js.get(i).getCarteDivinite().getDogmes()).contains("mystique") 
					&& Arrays.asList(js.get(i).getCarteDivinite().getDogmes()).contains("chaos"))){
				System.out.println("joueur" + i + ":");
				Iterator<GuideSpirituel> it = js.get(i).getGuides().iterator();
				while(it.hasNext()){
					b = true;
					System.out.println("Guide Spirituel " + count + " :");
					System.out.println(it.next().toString());
					count++;
				}
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
				if(n2 > 0 && n2 < js.get(n1).getGuides().size()){
					break;
				}
				else{
					System.out.println("Ce Guide Spirituel ne peut pas ¨ºtre choisi, choisir un Guide Spirituel:");
				}
			}
			GuideSpirituel gs = js.get(n1).getGuides().get(n2);
			
			Iterator<Croyant> it2 = gs.getCroyants().iterator();
			while(it2.hasNext()){
				gs.getCroyants().remove(it2.next());
				gs.setNbCroyant(gs.getNbCroyant() - 1);
				js.get(n1).getCroyants().remove(it2.next());
				js.get(n1).setNbPriere(js.get(n1).getNbPriere() - it2.next().getNbPriere());
				it2.next().setJoueur(null);
			}
			js.get(n1).getCartesEnMain().add(gs);
			
			CartesSurTable cst = Partie.getPartie().getCarteSurTable();
			Iterator<Croyant> it3 = this.getCroyants().iterator();
			while(it3.hasNext()){
				cst.getCroyantPublic().add(it3.next());
				this.getCroyants().remove(it3.next());
				this.setNbCroyant(this.getNbCroyant() - 1);
				this.joueur.getCroyants().remove(it3.next());
				this.joueur.setNbPriere(this.joueur.getNbPriere() - it3.next().getNbPriere());
				it3.next().setJoueur(null);
			}
			this.joueur.getGuides().remove(this);
			this.joueur = null;
		}
		
	}

}
