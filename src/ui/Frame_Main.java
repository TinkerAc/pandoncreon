package ui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import service.Partie;

public class Frame_Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//游戏后台
	private Partie parite = Partie.getPartie();
	//游戏主面板
	private Panel_main main;
	
	public Frame_Main() {
		super();
		this.setTitle("傻逼游戏");
		this.setSize(1366, 768);
		this.setLayout(new FlowLayout());
		
		
		this.main = new Panel_main(2);
		
		this.setContentPane(main);
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		start();
	}
	private void start() {
		Partie.getPartie().start();
	}
	
	
}






