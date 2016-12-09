package carteModule.croyant;

import java.util.ArrayList;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;
import service.Partie;
import util.Input;

public class Aliene2 extends Croyant {
	
	public Aliene2() {
		super();
		this.setNbPriere(2);
		this.nom = "Aliéné";
		this.origine = Carte.NEANT;
		this.dogmes = new String[]{Carte.CHAOS,Carte.HUMAIN,Carte.SYMBOLES};
		this.description = "Empêche une Divinité possédant le Dogme Chaos ou Mystique de sacrifier un de ses Guides Spirituels ";
		
	}
	
	@Override
	public void sacrifier(Joueur joueur) {
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		ArrayList<Joueur> jsPourChoisir = new ArrayList<Joueur>();
		
		Iterator<Joueur> it = js.iterator();
		
		
		while(it.hasNext()) {
			Joueur j = it.next();
			String origine = j.getOrigineDivinite();
			if(origine == Carte.HUMAIN
					 || origine == Carte.SYMBOLES) {
				jsPourChoisir.add(j);
				System.out.println("可选玩家：" + j.getNumj());
			}
		}
		
		System.out.println("请选择一名玩家：");
		while(true) {
			int i = Input.getInt();
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
				System.out.println("该玩家不可选！！！请重新选择！！！");
			}
		}
		
		
	}

}
