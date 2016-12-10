package carteModule.croyant;

import java.util.ArrayList;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.CartesSurTable;
import util.Input;

public class Lycanthropes extends Croyant {
	
	public Lycanthropes() {
		super();
		this.setNbPriere(4);
		this.nom = "Intégristes";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{Carte.NATURE,Carte.HUMAIN,Carte.CHAOS};
		this.description = "Retirez tous les Croyants attachés à l'un des Guides Spirituels d'une autre Divinité. Les Croyants reviennent au milieu de la table, le Guide Spirituel est défaussé.";
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
		gs.remove(n);
		
		
	}

}
