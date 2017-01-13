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
	
	
	public Panel_main(int nbAI) {
		super();
		this.setLayout(null);
		this.setSize(1366, 768);
		
		ctrl = new Panel_control(Partie.getPartie().getJoueurs().get(0), this);
		ctrl.setLocation(0, 468);
		//ctrl = new Panel_control(new JoueurPhysique(), this);
		listPPlayer = new ArrayList<Panel_player>();
		
		Panel_player j1Panel = new Panel_player(1);
		j1Panel.setLocation(14, 232);
		add(j1Panel);
		listPPlayer.add(j1Panel);
		
		if(nbAI>1){
			Panel_player j2Panel = new Panel_player(2);
			j2Panel.setLocation(14, 13);
			add(j2Panel);
			listPPlayer.add(j2Panel);
		}
		
		if(nbAI>2){
			Panel_player j3Panel = new Panel_player(3);
			j3Panel.setLocation(277, 13);
			add(j3Panel);
			listPPlayer.add(j3Panel);
		}
		
		if(nbAI>3){
			Panel_player j4Panel = new Panel_player(4);
			j4Panel.setLocation(544, 13);
			add(j4Panel);
			listPPlayer.add(j4Panel);
		}
		
		if(nbAI>4){
			Panel_player j5Panel = new Panel_player(5);
			j5Panel.setLocation(809, 13);
			add(j5Panel);
			listPPlayer.add(j5Panel);
		}
		
		if(nbAI>5){
			Panel_player j6Panel = new Panel_player(6);
			j6Panel.setLocation(1074, 13);
			add(j6Panel);
			listPPlayer.add(j6Panel);
		}
		
		if(nbAI>6){
			Panel_player j7Panel = new Panel_player(7);
			j7Panel.setLocation(1074, 232);
			add(j7Panel);
			listPPlayer.add(j7Panel);
		}
		
		pCroyant = new Panel_croyantPublic();
		pCroyant.setBounds(277, 219, 773, 201);
		pGuide = new Panel_guide((JoueurPhysique)Partie.getPartie().getJoueurs().get(0));
		pGuide.setBounds(277, 429, 773, 89);
		
		this.add(ctrl);
		this.add(pCroyant);
		this.add(pGuide);
		
		this.setVisible(true);
		System.out.println("主面板创建完成");
	}
	
	
}











