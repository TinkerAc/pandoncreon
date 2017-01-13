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
 * 玩家控制面板
 * @author 谢昕辰
 * 
 * */

public class Panel_control extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		System.out.println("控制面板创建完成");
	}
	
	
	
}















