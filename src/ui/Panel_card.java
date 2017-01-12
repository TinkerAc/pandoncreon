package ui;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import carteModule.Carte;
import carteModule.CarteAction;
import util.ImgUtil;

public class Panel_card extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//手牌模型
	private Carte carte;
	//是否被选择
	private boolean isSelected;
	//是否可用
	boolean enableToUse;
	//鼠标监听
	MouseListener listener;
	//背景图片
	BufferedImage bgimg;
	
	public Panel_card(CarteAction carte) {
		super();
		this.carte = carte;
		this.isSelected = false;
		
		
	}
	
	public void paintComponent(Graphics g) {
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/" + carte.getName() +".png"));
		g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
	}
	
	
	
}







