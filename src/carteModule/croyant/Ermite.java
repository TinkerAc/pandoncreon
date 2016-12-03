package carteModule.croyant;

import java.util.ArrayList;
import java.util.Scanner;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;
import service.ProcessSacrifier;

public class Ermite extends Croyant {

	public Ermite() {
		super();
		this.nbPriere = 1;
		this.nom = "Ermite";
		this.origine = Carte.JOUR;
		this.description = "Impose le sacrifice d'un Croyant d'un autre joueur, qui choisit la carte. La capacit¨¦ sp¨¦ciale du sacrifice est jou¨¦e.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = parite.getJoueurs();
		System.out.print("choisir un joueur: ");
		for(int i = 0; i < js.size(); i++) {
			if(i != js.indexOf(this.joueur)) {
				System.out.print(i + " ");
			}
		}
		System.out.print('\n');
		
		Scanner sc = new Scanner(System.in);
		Joueur j1 = js.get(sc.nextInt());
		
		new ProcessSacrifier(j1).start();;
	}

}







