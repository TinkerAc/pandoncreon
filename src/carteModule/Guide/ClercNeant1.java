package carteModule.Guide;

import java.util.Iterator;
import java.util.Scanner;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.CartesSurTable;
import service.Partie;

public class ClercNeant1 extends GuideSpirituel {

	public ClercNeant1(){
		super();
		this.nom = "Clerc";
		this.origine = Carte.NEANT;
		this.dogmes = new String[]{"mystique","nature"};
		this.description = "Fait gagner un nombre de points d'Action ¨¦gal au nombre de cartes de Croyants rattach¨¦es. L'Origine des points d'Action est au choix du joueur.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		int a = this.getNbCroyant();
		System.out.println("gagner " + a + " points d'Action, choisir de quel Origine : 'j' pour Jour, 'n' pour Nuit, 'e' pour Neant");
		Scanner sc = new Scanner(System.in);
		String s;
		while(true){
			s = sc.next();
			if(s.equals("j")){
				this.joueur.setPointActionJour(this.joueur.getPointActionJour() + a);
				break;
			}
			else if(s.equals("n")){
				this.joueur.setPointActionJour(this.joueur.getPointActionNuit() + a);
				break;
			}
			else if(s.equals("e")){
				this.joueur.setPointActionJour(this.joueur.getPointActionNeant() + a);
				break;
			}
			else{
				System.out.println("input ill¨¦gal, importer 'j' ou 'n' ou 'e'");
			}
		}
		
		CartesSurTable cst = Partie.getPartie().getCarteSurTable();
		Iterator<Croyant> it = this.getCroyants().iterator();
		while(it.hasNext()){
			cst.getCroyantPublic().add(it.next());
			this.getCroyants().remove(it.next());
			this.setNbCroyant(this.getNbCroyant() - 1);
			this.joueur.getCroyants().remove(it.next());
			this.joueur.setNbPriere(this.joueur.getNbPriere() - it.next().getNbPriere());
			it.next().setJoueur(null);
		}
		this.joueur.getGuides().remove(this);
		this.joueur = null;
	}
}
