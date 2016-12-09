package carteModule.croyant;

import java.util.ArrayList;
import java.util.Iterator;

import carteModule.Carte;
import carteModule.Croyant;
import player.Joueur;
import service.Partie;
import util.Input;

public class Travailleurs3 extends Croyant {
	public Travailleurs3() {
		super();
		this.nbPriere = 2;
		this.nom = "Travailleurs";
		this.origine = Carte.JOUR;
		this.dogmes = new String[]{Carte.CHAOS,Carte.HUMAIN,Carte.MYSTIQUE};
		this.description = "Vous piochez deux cartes au hasard dans la main d'une autre Divinité.";
	}
	
	
	@Override
	public void sacrifier(Joueur joueur) {
		if(joueur.getCartesEnMain().size() == 7) {
			System.out.println("已有7张手牌，牺牲效果无效!");
			return;
		}
		
		
		ArrayList<Joueur> js = Partie.getPartie().getJoueurs();
		Iterator<Joueur> it = js.iterator();
		while(it.hasNext()) {
			Joueur j = it.next();
			if(j != joueur) {
				System.out.println("玩家" + j.getNumj() + "的手牌数：" + j.getCartesEnMain().size());
			}
		}
		
		System.out.println("请选择一名玩家：");
		while(true) {
			int i = Input.getInt();
			boolean isExist = false;
			for(int j = 0; j < js.size(); j++) {
				if(i == js.get(j).getNumj()) {
					isExist = true;
				}
			}
			if(isExist == true) {
				System.out.println("请选择要抽的牌(输入格式：a b)");
				int[] ab = new int[2];
				if(joueur.getCartesEnMain().size() == 6) {
					System.out.println("只能选择一张牌!");
					ab[0] = Input.getInt();
					joueur.getCartesEnMain().add(js.get(i).getCartesEnMain().remove(ab[0]));
				}else {
					ab[0] = Input.getInt();
					ab[1] = Input.getInt();
					joueur.getCartesEnMain().add(js.get(i).getCartesEnMain().remove(ab[0]));
					joueur.getCartesEnMain().add(js.get(i).getCartesEnMain().remove(ab[1]));
				}
				
				break;
			}else {
				System.out.println("该玩家不可选！！！请重新选择！！！");
			}
		}
		
		
		
	}

}










