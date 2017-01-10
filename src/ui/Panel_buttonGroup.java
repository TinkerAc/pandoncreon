package ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

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
		
		this.setVisible(true);
		System.out.println("按钮组创建完成");
	}
	
	
	private JButton createButton(String name) {
		JButton btn = new JButton(name);
		return btn;
	}
	
	
	
}
