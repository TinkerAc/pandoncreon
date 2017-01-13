package test;

import service.*;
import ui.InitPage;


public class Test {

	public static void main(String[] args) {
		Partie partie = Partie.getPartie();
		//System.out.println(partie);
		partie.commencerPartie();
		
		InitPage i = new InitPage();
		i.setVisible(true);
		
	}

}
