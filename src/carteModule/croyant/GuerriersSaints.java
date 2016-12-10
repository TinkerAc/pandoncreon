package carteModule.croyant;

import java.util.ArrayList;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.CartesSurTable;
import util.Input;

public class GuerriersSaints extends Croyant {
	
	public GuerriersSaints() {
		super();
		this.setNbPriere(4);
		this.nom = "Intégristes";
		this.origine = Carte.JOUR;
		this.dogmes = new String[]{Carte.NATURE,Carte.MYSTIQUE,Carte.SYMBOLES};
		this.description = "Un Guide Spirituel revient dans la main de sa Divinité. Ses Croyants reviennent au centre de la table.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = parite.getJoueurs();
		Iterator<Joueur> it = js.iterator();
		System.out.print("choisir un joueur: ");
		while(it.hasNext()) {
			Joueur j = it.next();
			if(j.getGuides().size() != 0) {
				System.out.println("玩家" + j.getNumj());
			}
		
		}
		int i = Input.getInt();
		ArrayList<GuideSpirituel> gs = (ArrayList<GuideSpirituel> )js.get(i).getGuides();
		Iterator<GuideSpirituel> ig = gs.iterator();
		while(ig.hasNext()) {
			System.out.println(ig.next().toString());
		}
		System.out.println("选择一张guide：");
		int n = Input.getInt();
		ArrayList<Croyant> cs = (ArrayList<Croyant>)gs.get(n).getCroyants();
		int index = 0;
		while(index < cs.size()) {
			CartesSurTable.getCartesSurTable().getCroyantPublic().add(cs.remove(index));
			index++;
		}
		js.get(i).getCartesEnMain().add(gs.remove(n));
	}

}




