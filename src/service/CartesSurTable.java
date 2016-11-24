package service;

import java.util.ArrayList;

import pandoncreon.*;

public class CartesSurTable {
	private static CartesSurTable cartesSurTable;
	private ArrayList<CarteAction> croyantPublic;
	private ArrayList<CarteAction> guides;
	private CartesSurTable() {
		croyantPublic = new ArrayList<CarteAction>();
		guides = new ArrayList<CarteAction>();
	}
	public static CartesSurTable getCartesSurTable() {
		cartesSurTable = new CartesSurTable();
		return cartesSurTable;
	}
}
