package ui;

import java.awt.Color;
import java.awt.FlowLayout;
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
	
	public Panel_handCard(Joueur player) {
		super();
		this.setSize(773, 107);
		this.setLayout(new FlowLayout());
		this.setBackground(Color.CYAN);
		
		this.player = player;
		listCards = new ArrayList<Panel_card>();
		
		Iterator<CarteAction> it = player.getCartesEnMain().iterator();
		while(it.hasNext()) {
			CarteAction c = (CarteAction)it.next();
			System.out.println(c.toString());
			listCards.add(new Panel_card(c));
		}
		Iterator<Panel_card> ic = listCards.iterator();
		while(ic.hasNext()) {
			this.add((Panel_card)ic.next());
		}
		
	}
	
	
	
}












