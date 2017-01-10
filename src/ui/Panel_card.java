package ui;

import java.awt.event.MouseListener;

import javax.swing.JPanel;

import carteModule.Carte;

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
	
	public Panel_card(Carte carte) {
		super();
		this.carte = carte;
		this.isSelected = false;
		
		
	}
	
	
}







