package service;

import java.util.Scanner;

public class Process {
	private Joueur joueur;
	
	Process(Joueur j) {
		this.joueur = j;
		
	}
	
	/*
	 *����
	 * */
	public void start() {
		Scanner sc = new Scanner(System.in);
		//���Դ��� ���ú�ɾ��������
		System.out.println("���" + this.joueur.getNumj());
		System.out.println("ѡ��һ��������0�����ƣ�1�����ƣ�2�����ƣ�3��������4��������");
		joueur.choisirUneOperation(sc.nextInt());
		joueur.setDone(true);
		pass();
	}
	public void pass() {
		if(joueur.getNextJoueur().isDone() == false) {
			joueur.getNextJoueur().process();
		}
	}
	
}




















