package service;

import java.util.Scanner;

public class Process {
	private Joueur joueur;
	
	/*
	 *½øÈë
	 * */
	public void start() {
		Scanner sc = new Scanner(System.in);
		joueur.choisirUneOperation(sc.nextInt());
		pass();
	}
	public void pass() {
		joueur.getNextJoueur().process();
	}
	
}




















