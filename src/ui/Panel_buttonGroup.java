package ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import util.AideGUI;

public class Panel_buttonGroup extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton piocher;
	private JButton defausser;
	private JButton utiliser;
	private JButton sacrifier;
	private JButton capaciter;
	
	public Panel_buttonGroup() {
		super();
		this.setLayout(new FlowLayout());
		
		this.piocher = createButton("piocher");
		this.defausser = createButton("défausser");
		this.utiliser = createButton("utiliser");
		this.sacrifier = createButton("sacrifier");
		this.capaciter = createButton("capacité");
		
		this.add(defausser);
		this.add(piocher);
		this.add(utiliser);
		this.add(sacrifier);
		this.add(capaciter);
		
		defausser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(0);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		piocher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		
		utiliser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(2);
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		sacrifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(3);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		capaciter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(4);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
