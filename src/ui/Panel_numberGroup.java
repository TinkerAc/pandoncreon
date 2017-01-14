package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

import util.AideGUI;

public class Panel_numberGroup extends JPanel {

	Panel_main pm;
	private JButton n0;
	private JButton n1;
	private JButton n2;
	private JButton n3;
	private JButton n4;
	private JButton n5;
	private JButton n6;
	private JButton n7;
	private JButton n8;
	private JButton n9;
	private JButton n10;
	private JButton n11;
	private JButton n12;
	private JButton n13;
	private JButton n14;
	
	
	public Panel_numberGroup(Panel_main pm){
		this.pm = pm;
		setSize(277, 43);
		setLayout(new GridLayout(0, 5, 0, 0));
		
		n0 = new JButton("0");
		n1 = new JButton("1");
		n2 = new JButton("2");
		n3 = new JButton("3");
		n4 = new JButton("4");
		n5 = new JButton("5");
		n6 = new JButton("6");
		n7 = new JButton("7");
		n8 = new JButton("8");
		n9 = new JButton("9");
		n10 = new JButton("10");
		n11 = new JButton("11");
		n12 = new JButton("12");
		n13 = new JButton("13");
		n14 = new JButton("14");
		
		
		add(n0);
		add(n1);
		add(n2);
		add(n3);
		add(n4);
		add(n5);
		add(n6);
		add(n7);
		add(n8);
		add(n9);
		add(n10);
		add(n11);
		add(n12);
		add(n13);
		add(n14);
		
		
		n0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(0);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(2);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(3);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(4);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(5);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(6);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(7);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(8);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(9);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(11);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(12);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(13);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		n14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AideGUI.getInstance().deposerInt(14);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pm.ctrl.handCard.repaint();
				pm.ctrl.info.repaint();
				pm.pGuide.repaint();
				pm.pCroyant.repaint();
				Iterator<Panel_player> it = pm.listPPlayer.iterator();
				while(it.hasNext()){
					it.next().repaint();
				}
			}
		});
		
		
	}
}
