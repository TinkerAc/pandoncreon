package ui;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import player.Joueur;

/**
 * ��ҿ������
 * @author л꿳�
 * 
 * */

public class Panel_control extends JPanel {
	
	//����ģ��
	Joueur player;
	//��ť����
	Panel_buttonGroup buttonGroup;
	//��������
	Panel_handCard handCard;
	//��Ϣ����
	Panel_info info;
	//����������
	Panel_main main;
	//����ͼƬ
	BufferedImage bgimg;
	
	/**
	 * ������
	 * @param player
	 * */
	public Panel_control(Joueur player, Panel_main main) {
		this.main = main;
		this.player = player;
		
		buttonGroup = new Panel_buttonGroup();
		handCard = new Panel_handCard();
		info = new Panel_info();
		
		
		
		
		this.add(buttonGroup);
		
		
		
		this.add(handCard);
		
		
		
		this.add(info);
		
		
		
		
	}
}















