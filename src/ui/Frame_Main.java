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
	
	public Frame_Main(int n) {
		super();
		this.setTitle("傻逼游戏");
		this.setSize(1366, 768);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(new FlowLayout());
		
		Partie.getPartie().setNbJoueurs(n);
		Partie.getPartie().commencerPartie();
		this.main = new Panel_main(Partie.getPartie().getNbJoueurs() - 1);
		
		this.setContentPane(main);
		
		this.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Partie.getPartie().start();
	}

	
	
}






