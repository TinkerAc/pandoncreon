package service;

import java.util.ArrayList;
import java.util.Iterator;

public class Tour {
	private ArrayList<Joueur> joueurs;
	private int premiereJoueur;
	private Tour nextTour;
	
	
	
	Tour(ArrayList<Joueur> joueurs, Tour tourAvant) {
		this.joueurs = joueurs;
		for(Iterator<Joueur> it = joueurs.iterator();it.hasNext();) {
			it.next().setDone(false);
		}
		this.premiereJoueur = tourAvant.getPremiereJoueur();
	}
	Tour(ArrayList<Joueur> joueurs, int premiere) {
		this.joueurs = joueurs;
		this.premiereJoueur = premiere;
	}
	
	public void commencerNouveauTour() {
		distribuerPointAction();
		joueurs.get(premiereJoueur).process();
		terminerLeTour();
	}
	public void terminerLeTour() {
		nextTour = new Tour(joueurs, this.premiereJoueur);
		
		//���Դ��� ���ú�ɾ��������
		System.out.println("������һȦ");
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
}







