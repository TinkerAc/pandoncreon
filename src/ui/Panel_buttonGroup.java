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
		
		this.piocher = createButton("ÃşÅÆ");
		this.defausser = createButton("ÆúÅÆ");
		this.utiliser = createButton("³öÅÆ");
		this.sacrifier = createButton("ÎşÉü");
		this.capaciter = createButton("³¬ÄÜÁ¦");
		
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
