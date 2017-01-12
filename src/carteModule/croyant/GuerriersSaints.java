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
		this.nom = "GuerriersSaints";
		this.origine = Carte.JOUR;
		this.dogmes = new String[]{Carte.NATURE,Carte.MYSTIQUE,Carte.SYMBOLES};
		this.description = "Un Guide Spirituel revient dans la main de sa Divinit¨¦. Ses Croyants reviennent au centre de la table.";
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
		System.out.println("choisir un Guide Spirituel:");
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
		js.get(i).getCartesEnMain().add(gs.remove(n));
		
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




