package ui;

import java.awt.event.MouseListener;

import javax.swing.JPanel;

import carteModule.Carte;

public class Panel_card extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//����ģ��
	private Carte carte;
	//�Ƿ�ѡ��
	private boolean isSelected;
	//�Ƿ����
	boolean enableToUse;
	//������
	MouseListener listener;
	
	public Panel_card(Carte carte) {
		super();
		this.carte = carte;
		this.isSelected = false;
		
		
	}
	
	
}







