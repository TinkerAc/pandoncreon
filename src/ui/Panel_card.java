package ui;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import carteModule.Carte;
import util.ImgUtil;

public class Panel_card extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//����ģ��
	private Carte carte;
	//�Ƿ�ѡ��
	private boolean isSelected;
	//�Ƿ����
	boolean enableToUse;
	//������
	MouseListener listener;
	//����ͼƬ
	BufferedImage bgimg;
	
	public Panel_card(Carte carte) {
		super();
		this.carte = carte;
		this.isSelected = false;
		
		
	}
	
	public void paintComponent(Graphics g) {
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/" + carte.getName() +".png"));
		g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
	}
	
	
	
}







