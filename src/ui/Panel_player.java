package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

import player.Joueur;
import service.Partie;

public class Panel_player extends JPanel {

	private JPanel information;
	private JPanel divinite;
	private JPanel guide;
	private JLabel joueur;
	private JLabel pointsDAction;
	private JLabel jour;
	private JLabel nuit;
	private JLabel neant;
	private JLabel priere;
	private JLabel enMain;
	private JLabel nbJour;
	private JLabel nbNuit;
	private JLabel nbNeant;
	private JLabel nbPriere;
	private JLabel nbEnMain;
	private Joueur j;
	
	public Panel_player(int numJoueur, Joueur j){
		this.j = j;
		setSize(241, 193);
		setLayout(null);
//		information = new JPanel();
//		information.setBounds(0, 0, 73, 91);
//		information.setBackground(Color.ORANGE);
//		information.setLayout(null);
//		add(information);
//		
//		this.divinite = new JPanel() {
//			public void paintComponent(Graphics g) {
//				ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/" + j.getCarteDivinite().getName() +".png"));
//				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
//			}
//		};
//		divinite.setBounds(73, 91, 168, 91);
//		add(divinite);
//		
//		
//		guide = new JPanel();
//		guide.setBounds(0, 91, 241, 102);
//		add(guide);
//		
//		joueur = new JLabel("Joueur" + numJoueur);
//		joueur.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		joueur.setBounds(0, 0, 56, 18);
//		information.add(joueur);
//		
//		pointsDAction = new JLabel("Points d'action");
//		pointsDAction.setFont(new Font("SansSerif", Font.BOLD, 10));
//		pointsDAction.setBounds(0, 37, 72, 18);
//		information.add(pointsDAction);
//		
//		jour = new JLabel("Jour");
//		jour.setFont(new Font("SansSerif", Font.BOLD, 15));
//		jour.setBounds(0, 47, 72, 18);
//		information.add(jour);
//		
//		nuit = new JLabel("Nuit");
//		nuit.setFont(new Font("SansSerif", Font.BOLD, 15));
//		nuit.setBounds(0, 60, 72, 18);
//		information.add(nuit);
//		
//		neant = new JLabel("N¨¦ant");
//		neant.setFont(new Font("SansSerif", Font.BOLD, 15));
//		neant.setBounds(0, 73, 72, 18);
//		information.add(neant);
//		
//		priere = new JLabel("NbPri¨¨re");
//		priere.setFont(new Font("SansSerif", Font.BOLD, 15));
//		priere.setBounds(0, 13, 72, 18);
//		information.add(priere);
//		
//		enMain = new JLabel("en main");
//		enMain.setFont(new Font("SansSerif", Font.BOLD, 15));
//		enMain.setBounds(0, 25, 59, 18);
//		information.add(enMain);
//		
//		nbPriere = new JLabel();
//		nbPriere.setText(j.getNbPriere() + "");
//		nbPriere.setFont(new Font("SansSerif", Font.PLAIN, 15));
//		nbPriere.setBounds(64, 13, 8, 18);
//		information.add(nbPriere);
//		
//		nbEnMain = new JLabel();
//		nbEnMain.setText(j.getCartesEnMain().size() + "");
//		nbEnMain.setFont(new Font("SansSerif", Font.PLAIN, 15));
//		nbEnMain.setBounds(64, 25, 8, 18);
//		information.add(nbEnMain);
//		
//		nbJour = new JLabel();
//		nbJour.setText(j.getPointActionJour() + "");
//		nbJour.setFont(new Font("SansSerif", Font.PLAIN, 15));
//		nbJour.setBounds(64, 47, 8, 18);
//		information.add(nbJour);
//		
//		nbNuit = new JLabel();
//		nbNuit.setText(j.getPointActionNuit() + "");
//		nbNuit.setFont(new Font("SansSerif", Font.PLAIN, 15));
//		nbNuit.setBounds(64, 60, 8, 18);
//		information.add(nbNuit);
//		
//		nbNeant = new JLabel();
//		nbNeant.setText(j.getPointActionNeant() + "");
//		nbNeant.setFont(new Font("SansSerif", Font.PLAIN, 15));
//		nbNeant.setBounds(64, 73, 8, 18);
//		information.add(nbNeant);
	}
	
	public void paintComponent(Graphics g){
		removeAll();
		information = new JPanel();
		information.setBounds(0, 0, 73, 91);
		information.setBackground(Color.ORANGE);
		information.setLayout(null);
		add(information);
		
		this.divinite = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("img/" + j.getCarteDivinite().getName() +".png"));
				g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
			}
		};
		divinite.setBounds(73, 0, 168, 91);
		add(divinite);
		
		
		guide = new JPanel();
		guide.setBounds(0, 91, 241, 102);
		add(guide);
		
		joueur = new JLabel("Joueur" + Partie.getPartie().getJoueurs().indexOf(j));
		joueur.setFont(new Font("Times New Roman", Font.BOLD, 15));
		joueur.setBounds(0, 0, 56, 18);
		information.add(joueur);
		
		pointsDAction = new JLabel("Points d'action");
		pointsDAction.setFont(new Font("SansSerif", Font.BOLD, 10));
		pointsDAction.setBounds(0, 37, 72, 18);
		information.add(pointsDAction);
		
		jour = new JLabel("Jour");
		jour.setFont(new Font("SansSerif", Font.BOLD, 15));
		jour.setBounds(0, 47, 72, 18);
		information.add(jour);
		
		nuit = new JLabel("Nuit");
		nuit.setFont(new Font("SansSerif", Font.BOLD, 15));
		nuit.setBounds(0, 60, 72, 18);
		information.add(nuit);
		
		neant = new JLabel("N¨¦ant");
		neant.setFont(new Font("SansSerif", Font.BOLD, 15));
		neant.setBounds(0, 73, 72, 18);
		information.add(neant);
		
		priere = new JLabel("NbPri¨¨re");
		priere.setFont(new Font("SansSerif", Font.BOLD, 15));
		priere.setBounds(0, 13, 72, 18);
		information.add(priere);
		
		enMain = new JLabel("en main");
		enMain.setFont(new Font("SansSerif", Font.BOLD, 15));
		enMain.setBounds(0, 25, 59, 18);
		information.add(enMain);
		
		nbPriere = new JLabel();
		nbPriere.setText(j.getNbPriere() + "");
		nbPriere.setFont(new Font("SansSerif", Font.PLAIN, 15));
		nbPriere.setBounds(64, 13, 8, 18);
		information.add(nbPriere);
		
		nbEnMain = new JLabel();
		nbEnMain.setText(j.getCartesEnMain().size() + "");
		nbEnMain.setFont(new Font("SansSerif", Font.PLAIN, 15));
		nbEnMain.setBounds(64, 25, 8, 18);
		information.add(nbEnMain);
		
		nbJour = new JLabel();
		nbJour.setText(j.getPointActionJour() + "");
		nbJour.setFont(new Font("SansSerif", Font.PLAIN, 15));
		nbJour.setBounds(64, 47, 8, 18);
		information.add(nbJour);
		
		nbNuit = new JLabel();
		nbNuit.setText(j.getPointActionNuit() + "");
		nbNuit.setFont(new Font("SansSerif", Font.PLAIN, 15));
		nbNuit.setBounds(64, 60, 8, 18);
		information.add(nbNuit);
		
		nbNeant = new JLabel();
		nbNeant.setText(j.getPointActionNeant() + "");
		nbNeant.setFont(new Font("SansSerif", Font.PLAIN, 15));
		nbNeant.setBounds(64, 73, 8, 18);
		information.add(nbNeant);
		validate();
	}
}
