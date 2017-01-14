package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import util.AideGUI;

public class Panel_ConTer extends JPanel{

	private JButton continuer;
	private JButton terminer;
	
	public Panel_ConTer(){
		setSize(300, 43);
		setLayout(new FlowLayout());
		
		continuer = new JButton("continuer");
		terminer = new JButton("terminer");
		
		add(continuer);
		add(terminer);
		
		continuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(66);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		terminer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(88);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
