package carteModule.Guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.CarteAction;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.CartesSurTable;
import service.Partie;

public class Paladin extends GuideSpirituel {

	public Paladin(){
		super();
		this.nom = "Paladin";
		this.origine = Carte.JOUR;
		this.dogmes = new String[]{"mystique","humain"};
		this.description = "Tous les Croyants, d'Origine Nuit ou N¨¦ant et ayant le Dogme Nature, actuellement sur la table sont d¨¦fauss¨¦s. Les capacit¨¦s sp¨¦ciales ne sont pas jou¨¦es.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = parite.getJoueurs();
		Iterator<CarteAction> it;
		Iterator<Croyant> it2;
		
		CartesSurTable cst = Partie.getPartie().getCarteSurTable();
		it = cst.getCroyantPublic().iterator();
		while(it.hasNext()){
			if((Arrays.asList(it.next().getDogmes()).contains("nature")) 
				&& ((it.next().getOrigine().equals("nuit")) 
				   || ((it.next().getOrigine().equals("neant"))))){
				cst.getCroyantPublic().remove(it.next());
			}
		}
		
		for(int i = 0; i < js.size(); i++){
			it2 = js.get(i).getCroyants().iterator();
			while(it2.hasNext()){
				if((Arrays.asList(it2.next().getDogmes()).contains("nature")) 
					&& ((it2.next().getOrigine().equals("nuit")) 
					   || ((it2.next().getOrigine().equals("neant"))))){
					js.get(i).getCroyants().remove(it2.next());
					js.get(i).setNbPriere(js.get(i).getNbPriere() - it2.next().getNbPriere());
					Iterator<GuideSpirituel> it3 = js.get(i).getGuides().iterator();
					while(it3.hasNext()){
						if(it3.next().getCroyants().contains(it2.next())){
							it3.next().getCroyants().remove(it2.next());
							it3.next().setNbCroyant(it3.next().getNbCroyant() - 1);
						}
					}
					it2.next().setJoueur(null);
				}
			}
		}
		
		Iterator<Croyant> it4 = this.getCroyants().iterator();
		while(it4.hasNext()){
			cst.getCroyantPublic().add(it4.next());
			this.getCroyants().remove(it4.next());
			this.setNbCroyant(this.getNbCroyant() - 1);
			this.joueur.getCroyants().remove(it4.next());
			this.joueur.setNbPriere(this.joueur.getNbPriere() - it4.next().getNbPriere());
			it4.next().setJoueur(null);
		}
		this.joueur.getGuides().remove(this);
		this.joueur = null;
	}

}
