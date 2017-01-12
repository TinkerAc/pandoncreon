package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import carteManager.Cartes;
import carteManager.CartesDivinite;
import carteModule.Croyant;
import player.Joueur;
import player.JoueurAI;
import player.JoueurPhysique;

public class Partie {
	
	private static Partie partie = new Partie();
	
	private int nbJoueurs;
	private ArrayList<Joueur> joueurs;
	private Cartes cartes;
	private Tour tour;
	private Tour currentTour;
	private CartesSurTable carteSurTable;
	private CartesDivinite cartesDivinites = CartesDivinite.getInstance();
	
	private Partie() {
		this.joueurs = new ArrayList<Joueur>();
		this.cartes = Cartes.getInstance();
		this.setCarteSurTable(CartesSurTable.getCartesSurTable());
		//this.commencerPartie();
	}
	public static Partie getPartie() {
		return partie;
	}
	
	/*-----------------------------*/
	
	public void addJoueurs() {
		joueurs.add(new JoueurAI());
	}
	
	public void deleteJoueurs() {
		joueurs.remove(joueurs.size() - 1);
	}
	
	/**
	 * ����ӵ������������������
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
	 * ��ʼһ����Ϸ
	 * */
	public void commencerPartie() {
		//���Դ��� ���ú�ɾ�������� 
		System.out.println("Une nouvelle partie commence");
		
		//���Դ��� ���ú�ɾ��������
		System.out.println("Initialiser le nombre de joueurs:");
		
		/*Scanner sc = new Scanner(System.in);
		int n = 0;
		boolean FLAG = false;
		while(!FLAG) {
			try {
				n = sc.nextInt();
				FLAG = true;
			}catch(Exception e) {
				System.out.println("input ill��gal, importer encore une fois!");
				sc.next();
				FLAG = false;
			}
		}*/
		this.joueurs.add(new JoueurPhysique());
		
		//������
		for(int i = 0;i < this.nbJoueurs - 1; i++) {
			this.addJoueurs();
		}
		
		Iterator<Joueur> it = joueurs.iterator();
		
		while(it.hasNext()) {
			Joueur j = it.next();
			j.piocher(cartes);
			
			if(it.hasNext()) {
				j.setNextJoueur(joueurs.get(j.getNumj() + 1));
				System.out.println("joueur" + j.getNumj() +" a r��ussi d'installer le joueur prochain");
			}else {
				j.setNextJoueur(joueurs.get(0));
				System.out.println("joueur" + j.getNumj() +" a r��ussi d'installer une boucle de joueurs prochains!");
			}
		}
		/*tour = new Tour(joueurs, 0);
		//���Դ��� ���ú�ɾ��������
		System.out.println("le premier tour commence");
		tour.commencerNouveauTour();*/
	}
	
	public void start() {
		tour = new Tour(joueurs, 0);
		tour.commencerNouveauTour();
	}
	
	
	public void terminerPartie() {
		
	}
	/*
	 * 
	 * ������Щ�ظ�
	 * ��ʱ�������ˡ���
	 * 
	 * */
	public void ApocalypseProcess(Joueur j) {
		int index = this.compareNbPriere();
		if(this.getNbJoueurs() <= 3) {
			if(index != -1) {
				System.out.println("joueur" + this.joueurs.get(index).getNumj() + "gagne!!!");
				this.terminerPartie();
			}else {
				System.out.println("Apocalypse n'a pas d'effet!");
				System.gc();
				this.tour = new Tour(this.joueurs, j.getNumj());
				tour.setEnableApocalypse(false);
				System.out.println("un nouveau tour commence!");
				tour.commencerNouveauTour();
			}
		}else {
			if(index != -1) {
				Joueur jF = this.getJoueurs().get(index); //ʧ�����
				System.out.println("joueur" + jF.getNumj() + "est ��limin��");
				Iterator<Croyant> itCroyantDeJF = jF.getCroyants().iterator();
				while(itCroyantDeJF.hasNext()) {
					this.carteSurTable.getCroyantPublic().add(itCroyantDeJF.next());
					itCroyantDeJF.next().setJoueur(null);
				}
				this.eliminerJoueur(this.getJoueurs().get(index));
				System.gc();
				this.tour = new Tour(this.joueurs, j.getNumj());
				tour.setEnableApocalypse(false);
				System.out.println("un nouveau tour commence!");
				tour.commencerNouveauTour();
			}else {
				System.out.println("Apocalypse n'a pas d'effet!");
				System.gc();
				this.tour = new Tour(this.joueurs, j.getNumj());
				tour.setEnableApocalypse(false);
				System.out.println("un nouveau tour commence!");
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
	public Tour getCurrentTour2() {
		return this.currentTour;
	}
	public void setCurrentTour(Tour currentTour) {
		this.currentTour = currentTour;
	}
}







