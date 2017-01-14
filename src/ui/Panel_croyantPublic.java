package ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import carteModule.CarteAction;
import service.CartesSurTable;

public class Panel_croyantPublic extends JPanel {
	
	private CartesSurTable CST = CartesSurTable.getCartesSurTable();
	
	public Panel_croyantPublic() {
		super();
		this.setLayout(new GridLayout(3, 12, 0, 0));
//		ArrayList<CarteAction> listCroyants = CST.getCroyantPublic();
//		Iterator<CarteAction> it = listCroyants.iterator();
//		while(it.hasNext()) {
//			this.add(new Panel_card(it.next()));
//		}
		
	}
	
	public void paintComponent(){
		removeAll();
		ArrayList<CarteAction> listCroyants = CST.getCroyantPublic();
		Iterator<CarteAction> it = listCroyants.iterator();
		while(it.hasNext()) {
			this.add(new Panel_card(it.next()));
		}
		validate();
	}
}









