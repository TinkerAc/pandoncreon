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

public class Ascete extends GuideSpirituel {

	public Ascete(){
		super();
		this.nom = "Asc¨¨te";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{"symboles","humain"};
		this.description = "Sacrifie 2 cartes Croyants d'une Divinit¨¦ ayant le Dogme Humain ou Symboles. Les capacit¨¦s sp¨¦ciales sont jou¨¦es normalement.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Integer> jsAuChoix = new ArrayList<Integer>();
		int count;
		System.out.println("Sacrifier 2 cartes Croyants d'une Divinit¨¦ ayant le Dogme Humain ou Symboles.");
		for(int i = 0; i < js.size(); i++){
			count = 0;
			if(Arrays.asList(js.get(i).getCarteDivinite().getDogmes()).contains("humain")||
				Arrays.asList(js.get(i).getCarteDivinite().getDogmes()).contains("humain")){
				jsAuChoix.add(i);
				System.out.println("joueur" + i + ":");
				Iterator<Croyant> it = js.get(i).getCroyants().iterator();
				while(it.hasNext()){
					System.out.println("Croyant" + count + ":");
					System.out.println(it.next().toString());
					count++;
				}
			}
		}
		
		if(jsAuChoix.isEmpty()){
			System.out.println("Personne peut ¨ºtre choisie.");
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
			
			if(js.get(n1).getCroyants().size() < 2){
				System.out.println("Ce joueur n'a pas assez de Croyants, ils vont tous ¨ºtre sacrifi¨¦s");
				Iterator<Croyant> it2 = js.get(n1).getCroyants().iterator();
				while(it2.hasNext()){
					it2.next().sacrifier(js.get(n1));
				}
			}
			else{
				System.out.println("choisir 2 Croyants:");
				int n2;
				int n3;
				while(true){
					try{
						n2 = sc.nextInt();
					}catch(InputMismatchException e){
						System.out.println("input ill¨¦gal, importer un nombre entier:");
						sc.nextLine();
						continue;
					}
					if(n2 >= 0 && n2 < js.get(n1).getCroyants().size()){
						break;
					}
					else{
						System.out.println("Ce Croyant ne peut pas ¨ºtre choisi, choisir un autre Croyant:");
					}
				}
				while(true){
					try{
						n3 = sc.nextInt();
					}catch(InputMismatchException e){
						System.out.println("input ill¨¦gal, importer un nombre entier:");
						sc.nextLine();
						continue;
					}
					if(n3 >= 0 && n3 < js.get(n1).getCroyants().size() && n3 != n2){
						break;
					}
					else{
						System.out.println("Ce Croyant ne peut pas ¨ºtre choisi, choisir un autre Croyant:");
					}
				}
				
				js.get(n1).getCroyants().get(n2).sacrifier(js.get(n1));
				js.get(n1).getCroyants().get(n3).sacrifier(js.get(n1));
			}
			
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
