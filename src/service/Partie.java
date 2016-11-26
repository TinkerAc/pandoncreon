package service;

import java.util.ArrayList;

public class Partie {
	
	private static Partie partie = new Partie();
	
	private int nbJoueurs;
	private ArrayList<Joueur> joueurs;
	private Cartes cartes;
	private Tour tour;
	private CartesSurTable carteSurTable;
	
	private Partie() {
		this.nbJoueurs = 0;
		this.joueurs = new ArrayList<Joueur>();
		this.cartes = Cartes.getInstance();
		this.carteSurTable = CartesSurTable.getCartesSurTable();
	}
	public static Partie getPartie() {
		if(partie == null){
			partie = new Partie();
		}
		return partie;
	}
	
	/*-----------------------------*/
	public void addJoueurs() {
		joueurs.add(new Joueur());
	}
	public void deleteJoueurs() {
		joueurs.remove(joueurs.size() - 1);
	}
	public int compareNbPriere() {
		int max= joueurs.get(0).getNbPriere();
		int index = 0;
		int tmp = 0;
		int i = 1;
		while(i < joueurs.size()) {
			tmp = joueurs.get(i).getNbPriere();
			if(tmp > max) {
				max = tmp;
				index = i;
			}
			i++;
		}
		return index;
		
	}
	public void eliminerJoueur(Joueur j) {
		joueurs.remove(j);
	}
	
	/**
	 * 开始一局游戏
	 * */
	public void commencerPartie() {
		//测试代码 ，用后删除！！！ 
		System.out.println("开始一局游戏");
		
		int i = 0;
		//测试代码 ，用后删除！！！
		this.addJoueurs();
		this.addJoueurs();
		this.addJoueurs();
		
		while(i < joueurs.size() - 1) {
			joueurs.get(i).setNextJoueur(joueurs.get(i + 1));
			i++;
		}
		tour = new Tour(joueurs, 0);
		//测试代码 ，用后删除！！！
		System.out.println("进入第一圈");
		tour.commencerNouveauTour();
	}
	
	
	
	public void terminerPartie() {
		
	}
	public Tour getCurrentTour() {
		return this.tour;
	}
	public Cartes getCartes() {
		return this.cartes;
	}
}







