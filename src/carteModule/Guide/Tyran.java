package carteModule.Guide;

import java.util.Arrays;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.CarteAction;
import carteModule.Croyant;
import carteModule.GuideSpirituel;
import player.Joueur;
import service.CartesSurTable;
import service.Partie;

public class Tyran extends GuideSpirituel {

	public Tyran(){
		super();
		this.nom = "Tyran";
		this.origine = Carte.NEANT;
		this.dogmes = new String[]{"symboles","chaos"};
		this.description = "D¨¦fausse tous les Croyants ayant le Dogme Mystique actuellement au centre de la table.";
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		CartesSurTable cst = Partie.getPartie().getCarteSurTable();
		Iterator<CarteAction> it = cst.getCroyantPublic().iterator();
		while(it.hasNext()){
			if(Arrays.asList(it.next().getDogmes()).contains("mystique")){
				cst.getCroyantPublic().remove(it.next());
			}
		}
		
		Iterator<Croyant> it2 = this.getCroyants().iterator();
		while(it2.hasNext()){
			cst.getCroyantPublic().add(it2.next());
			this.getCroyants().remove(it2.next());
			this.setNbCroyant(this.getNbCroyant() - 1);
			this.joueur.getCroyants().remove(it2.next());
			this.joueur.setNbPriere(this.joueur.getNbPriere() - it2.next().getNbPriere());
			it2.next().setJoueur(null);
		}
		this.joueur.getGuides().remove(this);
		this.joueur = null;
	}

}
