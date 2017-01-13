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

public class Shaman extends GuideSpirituel {

	public Shaman(){
		super();
		this.nom = "Shaman";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{"symboles","nature"};
		this.description = "Sacrifie tous les Croyants d'Origine N¨¦ant d'une Divinit¨¦ ayant le Dogme Humain. Les capacit¨¦s sp¨¦cials sont jou¨¦es normalement.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = parite.getJoueurs();
		ArrayList<Integer> jsAuChoix = new ArrayList<Integer>();
		
		System.out.println("Sacrifier tous les Croyants d'Origine N¨¦ant d'une Divinit¨¦ ayant le Dogme Humain:");
		for(int i = 0; i < js.size(); i++){
			boolean b = false;
			String[] dogme = js.get(i).getCarteDivinite().getDogmes();
			for (String d : dogme) {
				if(d.equals("humain")){
					b = true;
					System.out.print(i + " ");
				}
			}
			if(b){
				jsAuChoix.add(i);
			}
		}
		System.out.println();
		
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
			
			Iterator<Croyant> it = js.get(n1).getCroyants().iterator();
			while(it.hasNext()){
				if(it.next().getOrigine().equals("neant")){
					it.next().sacrifier(js.get(n1));
				}
			}
			
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
