package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import carteModule.CarteAction;
import player.Joueur;

public class Panel_info extends JPanel implements Observer{
	
	//������Ϣ���
	private JPanel info;
	//���������
	private JPanel divinite;
	//�ж����ǩ
	private JLabel title;
	private JLabel nJour;
	private JLabel nNeant;
	private JLabel nNuit;
	//����ģ��
	private Joueur player;
	//�ж�����ؼ�
	private JTable pointAction;
	private JScrollPane scr;
	//��������ǩ
	private JLabel priere;
	private JLabel nPriere;
	private Image image;
	
	public Panel_info(Joueur player) {
		super();
		this.setLayout(null);
		
		this.player = player;
		player.addObserver(this);
		
		this.info = new JPanel();
		info.setBounds(0, 0, 266, 50);
		String[] headers = {"Jour","Neant","Nuit"};	
		Object[][] points = new Object[][]{{player.getPointActionJour(), player.getPointActionNeant(), player.getPointActionNuit()}};
		this.pointAction = new JTable(points, headers);
		pointAction.setPreferredScrollableViewportSize(new Dimension(150,20));
		pointAction.getTableHeader().setReorderingAllowed(false);
		scr = new JScrollPane(pointAction);
		scr.setSize(200, 20);
		scr.setLocation(0, 20);
		
		this.priere = new JLabel("nbPriere:");
		priere.setBounds(150, 0, 100, 20);
		this.nPriere = new JLabel(new Integer(player.getNbPriere()).toString());
		nPriere.setBounds(250, 0, 16, 20);
		info.add(scr);
		info.add(priere);
		info.add(nPriere);
		
		this.divinite = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/" + player.getCarteDivinite().getName() +".png"));
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
			}
		};
		divinite.setBounds(0, 50, 266, 168);
		
		this.add(info);
		this.add(divinite);
	}
	

	
	private void drawBufferedImage() {
		// ��������������
	    image = createImage(this.getWidth(), this.getHeight());
	    
	    removeAll();
		this.info = new JPanel();
		info.setBounds(0, 0, 266, 50);
		String[] headers = {"Jour","Neant","Nuit"};	
		Object[][] points = new Object[][]{{player.getPointActionJour(), player.getPointActionNeant(), player.getPointActionNuit()}};
		this.pointAction = new JTable(points, headers);
		pointAction.setPreferredScrollableViewportSize(new Dimension(150,20));
		pointAction.getTableHeader().setReorderingAllowed(false);
		scr = new JScrollPane(pointAction);
		scr.setSize(200, 20);
		scr.setLocation(0, 20);
		
		this.priere = new JLabel("nbPriere:");
		priere.setBounds(150, 0, 100, 20);
		this.nPriere = new JLabel(new Integer(player.getNbPriere()).toString());
		nPriere.setBounds(250, 0, 16, 20);
		info.add(scr);
		info.add(priere);
		info.add(nPriere);
		
		this.divinite = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/" + player.getCarteDivinite().getName() +".png"));
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
			}
		};
		divinite.setBounds(0, 50, 266, 168);
		
		this.add(info);
		this.add(divinite);
		validate();
	}
	
	public void paintComponent(Graphics g){
		drawBufferedImage();
	    g.drawImage(image, 0, 0, this);
		
	}



	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}
	
}













