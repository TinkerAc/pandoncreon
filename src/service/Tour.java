package service;

import java.util.ArrayList;
import java.util.Iterator;

import player.Joueur;

public class Tour {
	private ArrayList<Joueur> joueurs;
	private int premiereJoueur;
	private Tour nextTour;
	private boolean enableApocalypse;
	private static int nTour = 1;
	private String rsDeLancer;
	
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
			Joueur j = it.next();
			j.setDone(false);
			j.setEnableGetPoint(true);
		}
		if(nTour == 1) {
			this.enableApocalypse = false;
		}
		Partie.getPartie().setCurrentTour(this);
	}
	
	public void commencerNouveauTour() {
		distribuerPointAction();
		joueurs.get(premiereJoueur).process();
		terminerLeTour();
	}
	public void terminerLeTour() {
		nextTour = new Tour(joueurs, this);
		
		//���Դ��� ���ú�ɾ��������
		System.out.println("un nouvel tour commence");
		
		Iterator<Joueur> it = joueurs.iterator();
		while(it.hasNext()) {
			it.next().setEnableSacrifier(true);
		}
		nextTour.commencerNouveauTour();
	}
	private void distribuerPointAction() {
		int n = joueurs.get(premiereJoueur).lancerDeCosnologie();
		switch(n) {
		case 0:
			System.out.println("jour");
			this.setRsDeLancer("jour");
			int i = 0;
			while(i < joueurs.size()) {
				Joueur j = joueurs.get(i);
				if(j.getOrigineDivinite() == "jour") {
					j.setPointActionJour(j.getPointActionJour() + 2);
				} else if(j.getOrigineDivinite() == "aube") {
					j.setPointActionJour(j.getPointActionJour() + 1);
				}
				i++;
			}
			break;
		case 1:
			System.out.println("neant");
			this.setRsDeLancer("neant");
			int k = 0;
			while(k < joueurs.size()) {
				Joueur j = joueurs.get(k);
				if(j.getOrigineDivinite() == "aube" || j.getOrigineDivinite() == "crepuscule") {
					j.setPointActionNeant(j.getPointActionNeant() + 1);
				}
				k++;
			}
			break;
		case 2:
			System.out.println("nuit");
			this.setRsDeLancer("nuit");
			int i1 = 0;
			while(i1 < joueurs.size()) {
				Joueur j = joueurs.get(i1);
				if(j.getOrigineDivinite() == "nuit") {
					j.setPointActionNuit(j.getPointActionNuit() + 2);
				}else if(j.getOrigineDivinite() == "crepuscule") {
					j.setPointActionNuit(j.getPointActionNuit() + 1);
				}
				i1++;
			}
			break;
		default:
			System.out.println("distribution ��chou��e!");
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
	public String getRsDeLancer() {
		return rsDeLancer;
	}
	public void setRsDeLancer(String rsDeLancer) {
		this.rsDeLancer = rsDeLancer;
	}
}







