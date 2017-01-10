package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import player.Joueur;

public class Panel_handCard extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//人物模型
	Joueur player;
	//牌组
	List<Panel_card> listCards;
	
	public Panel_handCard(Joueur player) {
		this.player = player;
		listCards = new ArrayList<Panel_card>();
	}
	
	
	
}
