package test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import carteModule.Apocalypse;
import service.Partie;
import ui.Frame_Main;
import ui.InitFrame;
import ui.MainFrame;
import ui.Panel_buttonGroup;
import ui.Panel_card;
import ui.Panel_control;

public class UITest {

public static void main(String args[]) {
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				InitFrame f = new InitFrame();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
				
		Partie partie = Partie.getPartie();
		partie.commencerPartie();
				
		//Frame_Main f = new Frame_Main(2);
		//f.add(new Panel_buttonGroup());
	}

}
