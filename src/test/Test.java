package test;

import service.*;


public class Test {

	public static void main(String[] args) {
		Partie partie = Partie.getPartie();
		System.out.println(partie);
		partie.commencerPartie();
		
		
	}

}
