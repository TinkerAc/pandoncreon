package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import player.Joueur;

public class Panel_info extends JPanel {
	
	//个人信息面板
	private JPanel info;
	//神明卡面板
	private JPanel divinite;
	//行动点标签
	private JLabel title;
	private JLabel nJour;
	private JLabel nNeant;
	private JLabel nNuit;
	//人物模型
	private Joueur player;
	//行动点表格控件
	private JTable pointAction;
	private JScrollPane scr;
	//经文数标签
	private JLabel priere;
	private JLabel nPriere;
	
	public Panel_info(Joueur player) {
		super();
		this.setLayout(new FlowLayout());
		
		this.player = player;
		
		this.info = new JPanel();
		String[] headers = {"Jour","Neant","Nuit"};	
		Object[][] points = new Object[][]{{player.getPointActionJour(), player.getPointActionNeant(), player.getPointActionNuit()}};
		this.pointAction = new JTable(points, headers);
		pointAction.setPreferredScrollableViewportSize(new Dimension(150,20));
		pointAction.getTableHeader().setReorderingAllowed(false);
		scr = new JScrollPane(pointAction);
		scr.setSize(200, 20);
		
		this.priere = new JLabel("已获经文：");
		this.nPriere = new JLabel(new Integer(player.getNbPriere()).toString());
		info.add(scr);
		info.add(priere);
		info.add(nPriere);
		
		this.divinite = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/" + player.getCarteDivinite().getName() +".png"));
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
			}
		};
		
		this.add(info);
		this.add(divinite);
	}
	
	
	
}













