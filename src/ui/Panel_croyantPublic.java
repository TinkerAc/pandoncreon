package ui;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import carteModule.CarteAction;
import service.CartesSurTable;
import service.Partie;

public class Panel_croyantPublic extends JPanel {
	
	private CartesSurTable CST;
	
	private Image image;
	
	public Panel_croyantPublic() {
		super();
		this.setLayout(new GridLayout(0, 6, 0, 0));
		
//		ArrayList<CarteAction> listCroyants = CST.getCroyantPublic();
//		Iterator<CarteAction> it = listCroyants.iterator();
//		while(it.hasNext()) {
//			this.add(new Panel_card(it.next()));
//		}
		
	}
	
	
	private void drawBufferedImage() {
		// 创建缓冲区对象
	    image = createImage(this.getWidth(), this.getHeight());
	    
	    removeAll();
		CST = Partie.getPartie().getCarteSurTable();
		ArrayList<CarteAction> listCroyants = CST.getCroyantPublic();
		Iterator<CarteAction> it = listCroyants.iterator();
		while(it.hasNext()) {
			this.add(new Panel_card(it.next()));
		}
		validate();
	}
	
	public void paintComponent(Graphics g){
		drawBufferedImage();
	    g.drawImage(image, 0, 0, this);
		
	}
}









