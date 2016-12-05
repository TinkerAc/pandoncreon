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
		System.out.println("��ʼһ����Ϸ");
		
		//���Դ��� ���ú�ɾ��������
		System.out.println("��ʼ���������");
		Scanner sc = new Scanner(System.in);
		int n = 0;
		boolean FLAG = false;
		while(!FLAG) {
			try {
				n = sc.nextInt();
				FLAG = true;
			}catch(Exception e) {
				System.out.println("�Ƿ����룡�������������룡����");
				FLAG = false;
			}
		}
		//������
		for(int i = 0;i < n; i++) {
			this.addJoueurs();
		}
		
		Iterator<Joueur> it = joueurs.iterator();
		
		while(it.hasNext()) {
			Joueur j = it.next();
			j.piocher(cartes);
			
			if(it.hasNext()) {
				j.setNextJoueur(joueurs.get(j.getNumj() + 1));
				System.out.println("���" + j.getNumj() +"�����¼ҳɹ���");
			}else {
				j.setNextJoueur(joueurs.get(0));
				System.out.println("���" + j.getNumj() +"�����¼�ѭ����ɣ�");
			}
		}
		tour = new Tour(joueurs, 0);
		//���Դ��� ���ú�ɾ��������
		System.out.println("�����һȦ");
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
				System.out.println("���" + this.joueurs.get(index).getNumj() + "��ʤ������");
				this.terminerPartie();
			}else {
				System.out.println("����ĩ����Ч��");
				System.gc();
				this.tour = new Tour(this.joueurs, j.getNumj());
				tour.setEnableApocalypse(false);
				System.out.println("������һ�غϣ�");
				tour.commencerNouveauTour();
			}
		}else {
			if(index != -1) {
				Joueur jF = this.getJoueurs().get(index); //ʧ�����
				System.out.println("���" + j.getNumj() + "����������");
				Iterator<Croyant> itCroyantDeJF = jF.getCroyants().iterator();
				while(itCroyantDeJF.hasNext()) {
					this.carteSurTable.getCroyantPublic().add(itCroyantDeJF.next());
				}
				this.eliminerJoueur(this.getJoueurs().get(index));
				System.gc();
				this.tour = new Tour(this.joueurs, j.getNumj());
				tour.setEnableApocalypse(false);
				System.out.println("������һ�غϣ�");
				tour.commencerNouveauTour();
			}else {
				System.out.println("����ĩ����Ч��");
				System.gc();
				this.tour = new Tour(this.joueurs, j.getNumj());
				tour.setEnableApocalypse(false);
				System.out.println("������һ�غϣ�");
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







