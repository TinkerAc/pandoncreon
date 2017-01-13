package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import carteManager.Cartes;
import player.JoueurPhysique;

public class Panel_buttonGroup extends JPanel {
	
	/**
	 * ��ҵĲ�����ť
	 */
	private static final long serialVersionUID = 1L;
	private JButton piocher;
	private JButton defausser;
	private JButton utiliser;
	private JButton sacrifier;
	private JButton capaciter;
	private JoueurPhysique player;
	
	public Panel_buttonGroup(JoueurPhysique player) {
		super();
		this.setLayout(new FlowLayout());
		
		
		
		this.piocher = createButton("����");
		this.defausser = createButton("����");
		this.utiliser = createButton("����");
		this.sacrifier = createButton("����");
		this.capaciter = createButton("������");
		
		this.add(piocher);
		this.add(defausser);
		this.add(utiliser);
		this.add(sacrifier);
		this.add(capaciter);
		
		this.piocher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.piocher(Cartes.getInstance());
			}
			
		});
		
		this.defausser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.defausser();
			}
			
		});
		
		this.sacrifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.sacrifier();
			}
			
		});
		
		this.utiliser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.utiliser();
			}
			
		});
		
		this.capaciter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.capaciter();
			}
			
		});
		
		this.setVisible(true);
		System.out.println("��ť�鴴�����");
	}
	
	
	private JButton createButton(String name) {
		JButton btn = new JButton(name);
		return btn;
	}
	
	
	
}
