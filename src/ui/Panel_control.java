package ui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import player.Joueur;

/**
 * ��ҿ������
 * @author л꿳�
 * 
 * */

public class Panel_control extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		super();
		this.setSize(main.getWidth(), 250);
		setLayout(null);
		
		this.main = main;
		this.player = player;
		
		buttonGroup = new Panel_buttonGroup();
		buttonGroup.setBounds(311, 0, 692, 32);
		handCard = new Panel_handCard(this.player);
		handCard.setBounds(266, 32, 1100, 218);
		info = new Panel_info(this.player);
		info.setBounds(0, 32, 266, 218);
		
		//BoxLayout layout=new BoxLayout(this, BoxLayout.X_AXIS);
//		this.setLayout(new FlowLayout());
		this.add(buttonGroup);
		this.add(info);
		this.add(handCard);
		this.setVisible(true);
		System.out.println("������崴�����");
	}
	
	
	
}















