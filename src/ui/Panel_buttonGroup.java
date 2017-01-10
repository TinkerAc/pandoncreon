package ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel_buttonGroup extends JPanel {
	
	private JButton piocher;
	private JButton defausser;
	private JButton utiliser;
	private JButton sacrifier;
	private JButton capaciter;
	
	public Panel_buttonGroup() {
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
		
		
	}
	
	
	private JButton createButton(String name) {
		JButton btn = new JButton(name);
		return btn;
	}
	
	
	
}
