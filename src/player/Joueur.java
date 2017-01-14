package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import carteManager.Cartes;
import carteManager.CartesDivinite;
import carteModule.CarteAction;
import carteModule.Croyant;
import carteModule.Divinite;
import carteModule.GuideSpirituel;
import service.CartesSurTable;
import service.Partie;
import service.Process;

/**
 * 玩家的抽象类
 * 
 * 组合：玩家的基本信息，控制流程类
 * 
 * 包含：玩家的通用方法
 * 
 * @author XIE Xinchen
 * 
 * */

public abstract class Joueur extends Observable{
	protected ArrayList<CarteAction> cartesEnMain;
	protected Divinite carteDivinite;
	protected int pointActionJour;
	protected int pointActionNeant;
	protected int pointActionNuit;
	protected int nbPriere;
	protected List<Croyant> croyants = new ArrayList<Croyant>();
	protected List<GuideSpirituel> guides = new ArrayList<GuideSpirituel>();
	protected int numj;
	protected static int NombreJ = 0;
	protected Process process;
	protected Joueur nextJoueur;
	protected CartesSurTable CST = Partie.getPartie().getCarteSurTable();
	protected boolean isDone; //判断一圈游戏中是否已经操作结束
	protected boolean EnableSacrifier;
	protected boolean EnableGetPoint;
	
	public Joueur() {
		setCartesEnMain(new ArrayList<CarteAction>());
		setPointActionJour(0);
		setPointActionNeant(0);
		setPointActionNuit(0);
		nbPriere = 0;
		this.setNumj(NombreJ);
		this.carteDivinite = CartesDivinite.getInstance().returnDivinite();
		NombreJ ++;
		this.setEnableSacrifier(true);
	}
	
	public abstract void defausser();
	
	public void piocher(Cartes cartes) {
		System.out.println("piocher cartes");
		if(cartesEnMain.size() >= 7) {
			return;
		}
		while(cartesEnMain.size() < 7) {
			CarteAction ca = cartes.returnCarte();
			cartes.getCartes().remove(ca);
			cartesEnMain.add(ca);
			ca.setJoueur(this);
		}
	}
	
	public abstract void utiliser();
	
	public abstract void sacrifier();
	
	public abstract void capaciter();
	
	public int lancerDeCosnologie() {
		Random random = new Random();
		return random.nextInt(3);
	}
	
	public abstract void choisirUneOperation();
	
	public void showCards() {
		for(int i = 0; i < cartesEnMain.size(); i++) {
			System.out.println(i);
			System.out.println(cartesEnMain.get(i).toString());
		}
	}
	public void showPointAction() {
		System.out.println("l'Origine du joueur: " + this.getOrigineDivinite());
		System.out.println("Point d'Action Jour:" + this.getPointActionJour());
		System.out.println("Point d'Action Néant:" + this.getPointActionNeant() );
		System.out.println("Point d'Action Nuit:" + this.getPointActionNuit());
	}
	

	public void process() {
		this.process = new Process((Joueur) this);
		this.process.start();
	}
	
	public abstract void poserCroyant(Croyant c);
	public abstract void poserGuide(GuideSpirituel g);
	
	public abstract void sacrifierCroyant();
	public abstract void sacrifierGuide(GuideSpirituel g);
	
	
	
	
	/*-----------------------------------------*/
	public ArrayList<CarteAction> getCartesEnMain() {
		return cartesEnMain;
	}
	public void setCartesEnMain(ArrayList<CarteAction> cartesEnMain) {
		this.cartesEnMain = cartesEnMain;
	}
	public Divinite getCarteDivinite() {
		return carteDivinite;
	}
	public void setCarteDivinite(Divinite carteDivinite) {
		this.carteDivinite = carteDivinite;
	}
	public int getPointActionJour() {
		return pointActionJour;
	}
	public void setPointActionJour(int pointActionJour) {
		this.pointActionJour = pointActionJour;
		setChanged();
		notifyObservers();
	}
	public int getPointActionNeant() {
		return pointActionNeant;
	}
	public void setPointActionNeant(int pointActionNeant) {
		this.pointActionNeant = pointActionNeant;
		setChanged();
		notifyObservers();
	}
	public int getPointActionNuit() {
		return pointActionNuit;
	}
	public void setPointActionNuit(int pointActionNuit) {
		this.pointActionNuit = pointActionNuit;
		setChanged();
		notifyObservers();
	}
	public int getNbPriere() {
		return nbPriere;
	}
	public void setNbPriere(int nbPriere) {
		this.nbPriere = nbPriere;
		setChanged();
		notifyObservers();
	}
	public List<Croyant> getCroyants() {
		return croyants;
	}
	public void setCroyants(List<Croyant> croyants) {
		this.croyants = croyants;
	}
	public List<GuideSpirituel> getGuides() {
		return guides;
	}
	public void setGuides(List<GuideSpirituel> guides) {
		this.guides = guides;
	}
	public int getNumj() {
		return numj;
	}
	public void setNumj(int numj) {
		this.numj = numj;
	}
	
	public String getOrigineDivinite() {
		return carteDivinite.getOrigine();
	}

	public Joueur getNextJoueur() {
		return nextJoueur;
	}

	public void setNextJoueur(Joueur nextJoueur) {
		this.nextJoueur = nextJoueur;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public boolean isEnableSacrifier() {
		return EnableSacrifier;
	}

	public void setEnableSacrifier(boolean enableSacrifier) {
		EnableSacrifier = enableSacrifier;
	}

	public boolean isEnableGetPoint() {
		return EnableGetPoint;
	}

	public void setEnableGetPoint(boolean enableGetPoint) {
		EnableGetPoint = enableGetPoint;
	}


	
	
}
