package service;

import java.util.ArrayList;
import java.util.Iterator;

public class Partie {
	
	private static Partie partie = new Partie();
	
	private int nbJoueurs;
	private ArrayList<Joueur> joueurs;
	private Cartes cartes;
	private Tour tour;
	private CartesSurTable carteSurTable;
	
	private Partie() {
		this.setNbJoueurs(0);
		this.joueurs = new ArrayList<Joueur>();
		this.cartes = Cartes.getInstance();
		this.setCarteSurTable(CartesSurTable.getCartesSurTable());
	}
	public static Partie getPartie() {
		
		return partie;
	}
	
	/*-----------------------------*/
	public void addJoueurs() {
		joueurs.add(new Joueur());
		this.setNbJoueurs(this.getNbJoueurs() + 1);
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
		
		//测试代码 ，用后删除！！！
		this.addJoueurs();
		this.addJoueurs();
		this.addJoueurs();
		
		Iterator<Joueur> it = joueurs.iterator();
		
		while(it.hasNext()) {
			Joueur j = it.next();
			if(it.hasNext()) {
				j.setNextJoueur(it.next());;
			}else {
				j.setNextJoueur(joueurs.get(0));
			}
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
	public int getNbJoueurs() {
		return nbJoueurs;
	}
	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}
	public CartesSurTable getCarteSurTable() {
		return carteSurTable;
	}
	public void setCarteSurTable(CartesSurTable carteSurTable) {
		this.carteSurTable = carteSurTable;
	}
	public ArrayList<Joueur> getJoueurs() {
		return this.joueurs;
	}
}







