package service;

import java.util.ArrayList;

import carteModule.*;

public class CartesSurTable {
	private static CartesSurTable cartesSurTable;
	private ArrayList<CarteAction> croyantPublic;
	private ArrayList<CarteAction> guides;
	private CartesSurTable() {
		setCroyantPublic(new ArrayList<CarteAction>());
		setGuides(new ArrayList<CarteAction>());
	}
	public static CartesSurTable getCartesSurTable() {
		cartesSurTable = new CartesSurTable();
		return cartesSurTable;
	}
	
	
	/*---------------------------------------------*/
	public ArrayList<CarteAction> getCroyantPublic() {
		return croyantPublic;
	}
	public void setCroyantPublic(ArrayList<CarteAction> croyantPublic) {
		this.croyantPublic = croyantPublic;
	}
	public ArrayList<CarteAction> getGuides() {
		return guides;
	}
	public void setGuides(ArrayList<CarteAction> guides) {
		this.guides = guides;
	}
}
