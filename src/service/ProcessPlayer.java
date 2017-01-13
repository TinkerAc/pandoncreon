package service;

import player.Joueur;

public class ProcessPlayer extends Process {

	public ProcessPlayer(Joueur j) {
		super(j);
		
	}

	public void start() {
		
		
		joueur.choisirUneOperation();
		
		joueur.setDone(true);
		pass();
	}
	
}
