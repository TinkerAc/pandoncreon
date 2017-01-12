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
	
	public Frame_Main() {
		super();
		this.setTitle("ɵ����Ϸ");
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






