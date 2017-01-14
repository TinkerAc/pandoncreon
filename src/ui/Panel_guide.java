package ui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import carteModule.GuideSpirituel;
import player.JoueurPhysique;

public class Panel_guide extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JoueurPhysique player;
	private List<Panel_card> lCards;
	private List<JPanel> unit;
	
	public Panel_guide(JoueurPhysique player) {
		super();
		this.player = player;
		setLayout(new GridLayout(0, 10, 0, 0));
//		lCards = new ArrayList<Panel_card>();
//		unit = new ArrayList<JPanel>();
//		
//		Iterator<GuideSpirituel> it = player.getGuides().iterator();
//		while(it.hasNext()) {
//			GuideSpirituel g = it.next();
//			lCards.add(new Panel_card((GuideSpirituel)g));
//			unit.add(new Panel_card(g));
//			unit.add(new Panel_card(g.getCroyants()));
//		}
//
//		Iterator<JPanel> it2  = unit.iterator();
//		while(it.hasNext()) {
//			this.add((JPanel)it2.next());
//		}
	}
	
	public void paintComponent(){
		removeAll();
		lCards = new ArrayList<Panel_card>();
		unit = new ArrayList<JPanel>();
		
		Iterator<GuideSpirituel> it = player.getGuides().iterator();
		while(it.hasNext()) {
			GuideSpirituel g = it.next();
			lCards.add(new Panel_card((GuideSpirituel)g));
			unit.add(new Panel_card(g));
			unit.add(new Panel_card(g.getCroyants()));
		}

		Iterator<JPanel> it2  = unit.iterator();
		while(it.hasNext()) {
			this.add((JPanel)it2.next());
		}
		validate();
	}

}















