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
		this.nom = "Int¨¦gristes";
		this.origine = Carte.NUIT;
		this.dogmes = new String[]{Carte.NATURE,Carte.HUMAIN,Carte.CHAOS};
		this.description = "Retirez tous les Croyants attach¨¦s ¨¤ l'un des Guides Spirituels d'une autre Divinit¨¦. Les Croyants reviennent au milieu de la table, le Guide Spirituel est d¨¦fauss¨¦.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = parite.getJoueurs();
		Iterator<Joueur> it = js.iterator();
		System.out.print("choisir un joueur: ");
		while(it.hasNext()) {
			Joueur j = it.next();
			if(j.getGuides().size() != 0) {
				System.out.println("joueur" + j.getNumj());
			}
		
		}
		int i = Input.getInt();
		ArrayList<GuideSpirituel> gs = (ArrayList<GuideSpirituel> )js.get(i).getGuides();
		int count = 0;
		Iterator<GuideSpirituel> ig = gs.iterator();
		while(ig.hasNext()) {
			System.out.println("Guide Spirituel " + count + " :");
			System.out.println(ig.next().toString());
			count++;
		}
		
		System.out.println("choisir un Guide Spirituel :");
		int n = Input.getInt();
		ArrayList<Croyant> cs = (ArrayList<Croyant>)gs.get(n).getCroyants();
		Iterator<Croyant> ic = cs.iterator();
		CartesSurTable cst = CartesSurTable.getCartesSurTable();
		while(ic.hasNext()){
			cst.getCroyantPublic().add(ic.next());
			js.get(i).getCroyants().remove(ic.next());
			js.get(i).setNbPriere(js.get(i).getNbPriere() - ic.next().getNbPriere());
			cs.remove(ic.next());
			gs.get(n).setNbCroyant(gs.get(n).getNbCroyant() - 1);
			ic.next().setJoueur(null);
		}
		GuideSpirituel g = gs.get(n);
		gs.remove(g);
		g.setJoueur(null);
		
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
