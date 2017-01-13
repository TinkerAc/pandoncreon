package service;

import player.Joueur;

public class ProcessPlayer extends Process {

	public ProcessPlayer(Joueur j) {
		super(j);
		
	}

	public void start() {
		
		
		//joueur.setDone(true);
		
		Runnable run = new Runnable() {
			@Override
			public void run() {
				while(!joueur.isDone()){}
				
			}
			
		};
		new Thread(run).start();
		pass();
	}
	
}
