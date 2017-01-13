package ui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import service.Partie;

public class Frame_Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//��Ϸ��̨
	private Partie parite = Partie.getPartie();
	//��Ϸ�����
	private Panel_main main;
	
	public Frame_Main(int n) {
		super();
		this.setTitle("ɵ����Ϸ");
		this.setSize(1366, 768);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(new FlowLayout());
		
		Partie.getPartie().setNbJoueurs(n);
		this.main = new Panel_main(Partie.getPartie().getNbJoueurs() - 1);
		
		this.setContentPane(main);
		
		this.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Partie.getPartie().start();
	}

	
	
}






