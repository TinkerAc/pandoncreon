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
	
	//玩家控制面板
	Panel_control ctrl;
	//其他玩家面板
	List<Panel_player> listPPlayer;
	//信徒面板
	Panel_croyantPublic pCroyant;
	//精神引领面板
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
		System.out.println("主面板创建完成");
	}
	
	
}











