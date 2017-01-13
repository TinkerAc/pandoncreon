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
	 * 玩家的操作按钮
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
		
		
		
		this.piocher = createButton("摸牌");
		this.defausser = createButton("弃牌");
		this.utiliser = createButton("出牌");
		this.sacrifier = createButton("牺牲");
		this.capaciter = createButton("超能力");
		
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
		System.out.println("按钮组创建完成");
	}
	
	
	private JButton createButton(String name) {
		JButton btn = new JButton(name);
		return btn;
	}
	
	
	
}
