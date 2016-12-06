package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import carteManager.Cartes;
import carteManager.CartesDivinite;
import carteModule.Croyant;
import player.Joueur;

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
	
	/**
	 * 返回拥有最大经文数的玩家索引
	 * */
	public int compareNbPriere() {
		if(this.getNbJoueurs() <= 3) {
			int max= joueurs.get(0).getNbPriere();
			int index = 0;
			int tmp = 0;
			int i = 1;
			while(i < joueurs.size()) {
				tmp = joueurs.get(i).getNbPriere();
				if(tmp >= max) {
					max = tmp;
					index = i;
				}
				i++;
			}
			i = 0;
			while(i < joueurs.size()) {
				if(i != index) {
					if(max == joueurs.get(i).getNbPriere()) {
						return -1;
					}
				}
			}
			return index;
		}else {
			int min= joueurs.get(0).getNbPriere();
			int index = 0;
			int tmp = 0;
			int i = 1;
			while(i < joueurs.size()) {
				tmp = joueurs.get(i).getNbPriere();
				if(tmp <= min) {
					min = tmp;
					index = i;
				}
				i++;
			}
			i = 0;
			while(i < joueurs.size()) {
				if(i != index) {
					if(min == joueurs.get(i).getNbPriere()) {
						return -1;
					}
				}
			}
			return index;
		}
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
		System.out.println("初始化玩家数：");
		Scanner sc = new Scanner(System.in);
		int n = 0;
		boolean FLAG = false;
		while(!FLAG) {
			try {
				n = sc.nextInt();
				FLAG = true;
			}catch(Exception e) {
				System.out.println("非法输入！！！请重新输入！！！");
				sc.next();
				FLAG = false;
			}
		}
		//添加玩家
		for(int i = 0;i < n; i++) {
			this.addJoueurs();
		}
		
		Iterator<Joueur> it = joueurs.iterator();
		
		while(it.hasNext()) {
			Joueur j = it.next();
			j.piocher(cartes);
			
			if(it.hasNext()) {
				j.setNextJoueur(joueurs.get(j.getNumj() + 1));
				System.out.println("玩家" + j.getNumj() +"设置下家成功！");
			}else {
				j.setNextJoueur(joueurs.get(0));
				System.out.println("玩家" + j.getNumj() +"设置下家循环完成！");
			}
		}
		tour = new Tour(joueurs, 0);
		//测试代码 ，用后删除！！！
		System.out.println("进入第一圈");
		tour.commencerNouveauTour();
	}
	
	
	
	public void terminerPartie() {
		
	}
	/*
	 * 
	 * 代码有些重复
	 * 暂时先这样了。。
	 * 
	 * */
	public void ApocalypseProcess(Joueur j) {
		int index = this.compareNbPriere();
		if(this.getNbJoueurs() <= 3) {
			if(index != -1) {
				System.out.println("玩家" + this.joueurs.get(index).getNumj() + "获胜！！！");
				this.terminerPartie();
			}else {
				System.out.println("世界末日无效！");
				System.gc();
				this.tour = new Tour(this.joueurs, j.getNumj());
				tour.setEnableApocalypse(false);
				System.out.println("进入下一回合！");
				tour.commencerNouveauTour();
			}
		}else {
			if(index != -1) {
				Joueur jF = this.getJoueurs().get(index); //失败玩家
				System.out.println("玩家" + j.getNumj() + "滚蛋！！！");
				Iterator<Croyant> itCroyantDeJF = jF.getCroyants().iterator();
				while(itCroyantDeJF.hasNext()) {
					this.carteSurTable.getCroyantPublic().add(itCroyantDeJF.next());
				}
				this.eliminerJoueur(this.getJoueurs().get(index));
				System.gc();
				this.tour = new Tour(this.joueurs, j.getNumj());
				tour.setEnableApocalypse(false);
				System.out.println("进入下一回合！");
				tour.commencerNouveauTour();
			}else {
				System.out.println("世界末日无效！");
				System.gc();
				this.tour = new Tour(this.joueurs, j.getNumj());
				tour.setEnableApocalypse(false);
				System.out.println("进入下一回合！");
				tour.commencerNouveauTour();
			}
		}
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







