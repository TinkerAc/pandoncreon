package ui;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import player.Joueur;
import player.JoueurPhysique;
import service.Partie;

public class Panel_main extends JPanel {
	
	//��ҿ������
	Panel_control ctrl;
	//����������
	List<Panel_player> listPPlayer;
	//��ͽ���
	Panel_croyantPublic pCroyant;
	//�����������
	Panel_guide pGuide;
	
	
	public Panel_main() {
		super();
		this.setLayout(new FlowLayout());
		this.setSize(1366, 768);;
		
		ctrl = new Panel_control(Partie.getPartie().getJoueurs().get(0), this);
		//ctrl = new Panel_control(new JoueurPhysique(), this);
		listPPlayer = new ArrayList<Panel_player>();
		
		
		
		pCroyant = new Panel_croyantPublic();
		pGuide = new Panel_guide();
		
		this.add(ctrl);
		this.add(pCroyant);
		this.add(pGuide);
		
		this.setVisible(true);
		System.out.println("����崴�����");
	}
	
	
}











