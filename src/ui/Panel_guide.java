package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import carteModule.CarteAction;
import carteModule.GuideSpirituel;
import player.JoueurPhysique;
import service.Partie;

public class Panel_guide extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JoueurPhysique player;
	private List<Panel_card> lCards;
	private List<JPanel> unit;
	private Image image;
	
	public Panel_guide(JoueurPhysique player) {
		super();
		this.player = player;
		setLayout(new GridLayout(0, 8, 0, 0));
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
	

	
	private void drawBufferedImage() {
		// 创建缓冲区对象
	    image = createImage(this.getWidth(), this.getHeight());
	    
	    removeAll();
		lCards = new ArrayList<Panel_card>();
		unit = new ArrayList<JPanel>();
		
		Iterator<GuideSpirituel> it = player.getGuides().iterator();
		while(it.hasNext()) {
			GuideSpirituel g = it.next();
			lCards.add(new Panel_card((GuideSpirituel)g));
			unit.add(new Panel_card(g));
//			unit.add(new Panel_card(g.getCroyants()));
		}

		Iterator<JPanel> it2  = unit.iterator();
		while(it2.hasNext()) {
			this.add((JPanel)it2.next());
		}
		validate();
	}
	
	public void paintComponent(Graphics g){
		drawBufferedImage();
	    g.drawImage(image, 0, 0, this);
	    setBackground(Color.BLACK);
	}

}















