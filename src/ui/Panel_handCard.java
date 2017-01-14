package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import carteModule.CarteAction;
import player.Joueur;

public class Panel_handCard extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����ģ��
	Joueur player;
	//����
	List<Panel_card> listCards;
	
	private Image image;
	
	public Panel_handCard(Joueur player) {
		super();
		this.setSize(773, 107);
		this.setLayout(new GridLayout(0, 7, 0, 0));
		this.setBackground(Color.CYAN);
		
		this.player = player;
//		listCards = new ArrayList<Panel_card>();
//		
//		Iterator<CarteAction> it = player.getCartesEnMain().iterator();
//		while(it.hasNext()) {
//			CarteAction c = (CarteAction)it.next();
//			listCards.add(new Panel_card(c));
//		}
//		Iterator<Panel_card> ic = listCards.iterator();
//		while(ic.hasNext()) {
//			this.add((Panel_card)ic.next());
//		}
		
	}
	
	private void drawBufferedImage() {
		// ��������������
	    image = createImage(this.getWidth(), this.getHeight());
	    
	    removeAll();
		listCards = new ArrayList<Panel_card>();
		
		Iterator<CarteAction> it = player.getCartesEnMain().iterator();
		while(it.hasNext()) {
			CarteAction c = (CarteAction)it.next();
			listCards.add(new Panel_card(c));
		}
		Iterator<Panel_card> ic = listCards.iterator();
		while(ic.hasNext()) {
			this.add((Panel_card)ic.next());
		}
		validate();
	}
	
	public void paintComponent(Graphics g){
		drawBufferedImage();
	    g.drawImage(image, 0, 0, this);
		
	}
	
	
}












