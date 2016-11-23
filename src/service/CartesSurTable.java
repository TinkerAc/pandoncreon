package service;

import pandoncreon.*;

public class CartesSurTable {
	private static CartesSurTable cartesSurTable;
	private CarteAction[] croyantPublic;
	private CarteAction[] guides;
	private CartesSurTable() {
	}
	public static CartesSurTable getCartesSurTable() {
		cartesSurTable = new CartesSurTable();
		return cartesSurTable;
	}
}
