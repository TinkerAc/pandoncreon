package service;

import java.util.Scanner;

import player.Joueur;

public class Process {
	private Joueur joueur;
	
	public Process(Joueur j) {
		this.joueur = j;
		
	}
	
	/*
	 *����
	 * */
	public void start() {
		
		//���Դ��� ���ú�ɾ��������
		System.out.println("���" + this.joueur.getNumj());
		joueur.choisirUneOperation();
		joueur.setDone(true);
		pass();
	}
	public void pass() {
		if(joueur.getNextJoueur().isDone() == false) {
			joueur.getNextJoueur().process();
		}
	}
	
}




















