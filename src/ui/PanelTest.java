package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

public class PanelTest extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTest() {
		setBounds(new Rectangle(0, 0, 1000, 250));
		setForeground(Color.DARK_GRAY);
		setBackground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		setLayout(gridBagLayout);

	}

}
