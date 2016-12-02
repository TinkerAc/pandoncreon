package service;

import java.util.ArrayList;
import java.util.Iterator;

public class Tour {
	private ArrayList<Joueur> joueurs;
	private int premiereJoueur;
	private Tour nextTour;
	private boolean enableApocalypse;
	private static int nTour = 1;
	
	Tour(ArrayList<Joueur> joueurs, Tour tourAvant) {
		this.joueurs = joueurs;
		this.premiereJoueur = tourAvant.getPremiereJoueur();
		if(this.premiereJoueur == joueurs.size() - 1) {
			premiereJoueur = 0;
		}else {
			premiereJoueur ++;
		}
		for(Iterator<Joueur> it = joueurs.iterator();it.hasNext();) {
			it.next().setDone(false);
		}
		if(tourAvant.isEnableApocalypse() == false) {
			this.setEnableApocalypse(true);
		}
	}
	Tour(ArrayList<Joueur> joueurs, int premiere) {
		this.joueurs = joueurs;
		this.premiereJoueur = premiere;
		for(Iterator<Joueur> it = joueurs.iterator();it.hasNext();) {
			it.next().setDone(false);
		}
		if(nTour == 1) {
			this.enableApocalypse = false;
		}
	}
	
	public void commencerNouveauTour() {
		distribuerPointAction();
		joueurs.get(premiereJoueur).process();
		terminerLeTour();
	}
	public void terminerLeTour() {
		nextTour = new Tour(joueurs, this);
		
		//测试代码 ，用后删除！！！
		System.out.println("进入下一圈");
		nextTour.commencerNouveauTour();
	}
	private void distribuerPointAction() {
		int n = joueurs.get(premiereJoueur).lancerDeCosnologie();
		switch(n) {
		case 0:
			System.out.println("jour");
			int i = 0;
			while(i < joueurs.size()) {
				Joueur j = joueurs.get(i);
				if(j.getOrigineDivinite() == "jour") {
					j.setPointActionJour(j.getPointActionJour() + 2);
				} else if(j.getOrigineDivinite() == "Aube") {
					j.setPointActionJour(j.getPointActionJour() + 1);
				}
				i++;
			}
			break;
		case 1:
			System.out.println("neant");
			int k = 0;
			while(k < joueurs.size()) {
				Joueur j = joueurs.get(k);
				if(j.getOrigineDivinite() == "Aube" || j.getOrigineDivinite()
						== "Crepuscule") {
					j.setPointActionJour(j.getPointActionJour() + 1);
				}
				k++;
			}
			break;
		case 2:
			System.out.println("nuit");
			int i1 = 0;
			while(i1 < joueurs.size()) {
				Joueur j = joueurs.get(i1);
				if(j.getOrigineDivinite() == "Nuit") {
					j.setPointActionJour(j.getPointActionJour() + 2);
				} else if(j.getOrigineDivinite() == "Crepuscule") {
					j.setPointActionJour(j.getPointActionJour() + 1);
				}
				i1++;
			}
			break;
		default:
			return;
		}
		
	}
	public int getPremiereJoueur() {
		return premiereJoueur;
	}
	public boolean isEnableApocalypse() {
		return enableApocalypse;
	}
	public void setEnableApocalypse(boolean enableApocalypse) {
		this.enableApocalypse = enableApocalypse;
	}
	public static int getnTour() {
		return nTour;
	}
	public static void setnTour(int nTour) {
		Tour.nTour = nTour;
	}
}







