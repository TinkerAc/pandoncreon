package ui;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import player.Joueur;

/**
 * 玩家控制面板
 * @author 谢昕辰
 * 
 * */

public class Panel_control extends JPanel {
	
	//人物模型
	Joueur player;
	//按钮区域
	Panel_buttonGroup buttonGroup;
	//手牌区域
	Panel_handCard handCard;
	//信息区域
	Panel_info info;
	//主面板的引用
	Panel_main main;
	//背景图片
	BufferedImage bgimg;
	
	/**
	 * 构造器
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















