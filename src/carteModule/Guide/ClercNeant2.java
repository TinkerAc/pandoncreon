package carteModule.Guide;

import java.util.Iterator;
import java.util.Scanner;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.CartesSurTable;
import service.Partie;
import util.AideGUI;

public class ClercNeant2 extends GuideSpirituel {

	public ClercNeant2(){
		super();
		this.nom = "ClercN¨¦ant2";
		this.origine = Carte.NEANT;
		this.dogmes = new String[]{"symboles","chaos"};
		this.description = "Fait gagner un nombre de points d'Action ¨¦gal au nombre de cartes de Croyants rattach¨¦es. L'Origine des points d'Action est au choix du joueur.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		int a = this.getNbCroyant();
		System.out.println("gagner " + a + " points d'Action, choisir de quel Origine : '0' pour Jour, '1' pour Nuit, '2' pour Neant");
//		Scanner sc = new Scanner(System.in);
		int s;
		while(true){
			s = AideGUI.getInstance().lireInt();
			if(s == 0){
				this.joueur.setPointActionJour(this.joueur.getPointActionJour() + a);
				break;
			}
			else if(s == 1){
				this.joueur.setPointActionJour(this.joueur.getPointActionNuit() + a);
				break;
			}
			else if(s == 2){
				this.joueur.setPointActionJour(this.joueur.getPointActionNeant() + a);
				break;
			}
			else{
				System.out.println("input ill¨¦gal, importer '0' ou '1' ou '2'");
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
