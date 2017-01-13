package carteModule.croyant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.Partie;
import util.AideGUI;
import util.Input;

public class Alchimistes2 extends Croyant {
	
	public Alchimistes2() {
		super();
		this.setNbPriere(2);
		this.nom = "Alchimiste2";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{Carte.NATURE,Carte.CHAOS,Carte.MYSTIQUE};
		this.description = "Emp¨ºche une Divinit¨¦ poss¨¦dant le Dogme Humain ou Symboles de sacrifier un de ses Guides Spirituels durant ce tour de jeu.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Joueur> jsPourChoisir = new ArrayList<Joueur>();
		
		Iterator<Joueur> it = js.iterator();
		
		
		while(it.hasNext()) {
			Joueur j = it.next();
			if(Arrays.asList(j.getCarteDivinite().getDogmes()).contains(Carte.HUMAIN)
					|| Arrays.asList(j.getCarteDivinite().getDogmes()).contains(Carte.SYMBOLES)) {
				jsPourChoisir.add(j);
				System.out.println("joueur au choix:" + j.getNumj());
			}
		}
		
		System.out.println("choisir un joueur:");
		while(true) {
//			int i = Input.getInt();
			int i = AideGUI.getInstance().lireInt();
			boolean isExist = false;
			for(int j = 0; j < jsPourChoisir.size(); j++) {
				if(i == jsPourChoisir.get(j).getNumj()) {
					isExist = true;
				}
			}
			if(isExist == true) {
				js.get(i).setEnableSacrifier(false);
				break;
			}else {
				System.out.println("Ce joueur ne peut pas ¨ºtre choisi, choisir un autre joueur:");
			}
		}
		
		this.joueur.getCroyants().remove(this);
		this.joueur.setNbPriere(this.joueur.getNbPriere() - this.getNbPriere());
		Iterator<GuideSpirituel> it2 = this.joueur.getGuides().iterator();
		while(it2.hasNext()){
			if(it2.next().getCroyants().contains(this)){
				it2.next().getCroyants().remove(this);
				it2.next().setNbCroyant(it2.next().getNbCroyant() - 1);
			}
		}
		this.setJoueur(null);


	}

}
