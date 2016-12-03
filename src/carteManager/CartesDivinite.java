package carteManager;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import pandoncreon.Divinite;
import pandoncreon.Divinites.*;

public class CartesDivinite {
	private static List<Divinite> pile = new LinkedList<Divinite>();
	private static CartesDivinite CD = new CartesDivinite();
	
	private CartesDivinite() {
		pile.add(new Brewalen());
		pile.add(new Drinded());
		pile.add(new Gorpa());
		pile.add(new Gwenghelen());
		pile.add(new Killinstred());
		pile.add(new Llewella());
		pile.add(new PuiTera());
		pile.add(new Romtec());
		pile.add(new Shingva());
		pile.add(new Yarstur());
	}
	
	public static CartesDivinite getInstance() {
		return CD;
	}
	
	public Divinite returnDivinite() {
		return pile.remove(new Random().nextInt(pile.size()));
	}
	
	public List<Divinite> getPile() {
		return CartesDivinite.pile;
	}
	
	
}
