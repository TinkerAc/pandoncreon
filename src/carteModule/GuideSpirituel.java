package carteModule;

import java.util.*;

import player.Joueur;

public class GuideSpirituel extends CarteAction{
	
	private int nbCroyantMax;
	private int nbCroyant;
	private List<Croyant> croyants = new ArrayList<Croyant>();
	
	
	public GuideSpirituel() {
		super();
		this.type = "Guide";
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void sacrifier(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void utiliser() {
		// TODO Auto-generated method stub
		
	}


	public int getNbCroyantMax() {
		return nbCroyantMax;
	}


	public void setNbCroyantMax(int nbCroyantMax) {
		this.nbCroyantMax = nbCroyantMax;
	}


	public int getNbCroyant() {
		return nbCroyant;
	}


	public void setNbCroyant(int nbCroyant) {
		this.nbCroyant = nbCroyant;
	}


	public List<Croyant> getCroyants() {
		return croyants;
	}


	public void setCroyants(List<Croyant> croyants) {
		this.croyants = croyants;
	}
	
	
	
}
