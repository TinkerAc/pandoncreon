package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel J1Information = new JPanel();
		J1Information.setBounds(14, 232, 73, 91);
		contentPane.add(J1Information);
		J1Information.setBackground(Color.ORANGE);
		J1Information.setLayout(null);
		
		JLabel lblJoueur1 = new JLabel("Joueur1");
		lblJoueur1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblJoueur1.setBounds(0, 0, 56, 18);
		J1Information.add(lblJoueur1);
		
		JLabel lblPointsDaction1 = new JLabel("Points d'action:");
		lblPointsDaction1.setFont(new Font("SansSerif", Font.BOLD, 10));
		lblPointsDaction1.setBounds(0, 37, 106, 18);
		J1Information.add(lblPointsDaction1);
		
		JLabel lblJour1 = new JLabel("Jour");
		lblJour1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblJour1.setBounds(0, 47, 72, 18);
		J1Information.add(lblJour1);
		
		JLabel lblNuit1 = new JLabel("Nuit");
		lblNuit1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNuit1.setBounds(0, 60, 72, 18);
		J1Information.add(lblNuit1);
		
		JLabel lblNeant1 = new JLabel("N¨¦ant");
		lblNeant1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNeant1.setBounds(0, 73, 72, 18);
		J1Information.add(lblNeant1);
		
		JLabel lblNbpriere1 = new JLabel("NbPri¨¨re");
		lblNbpriere1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNbpriere1.setBounds(0, 13, 72, 18);
		J1Information.add(lblNbpriere1);
		
		JLabel lblCartesEnMain1 = new JLabel("en main");
		lblCartesEnMain1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCartesEnMain1.setBounds(0, 25, 59, 18);
		J1Information.add(lblCartesEnMain1);
		
		JLabel nbPriere1 = new JLabel("9");
		nbPriere1.setBounds(64, 13, 8, 18);
		J1Information.add(nbPriere1);
		
		JLabel nbCartesEnMain1 = new JLabel("9");
		nbCartesEnMain1.setBounds(64, 25, 8, 18);
		J1Information.add(nbCartesEnMain1);
		
		JLabel nbJour1 = new JLabel("9");
		nbJour1.setBounds(64, 47, 8, 18);
		J1Information.add(nbJour1);
		
		JLabel nbNuit1 = new JLabel("9");
		nbNuit1.setBounds(64, 60, 8, 18);
		J1Information.add(nbNuit1);
		
		JLabel nbNeant1 = new JLabel("9");
		nbNeant1.setBounds(64, 73, 8, 18);
		J1Information.add(nbNeant1);
		
		JPanel J1Divinite = new JPanel();
		J1Divinite.setBounds(86, 232, 169, 91);
		contentPane.add(J1Divinite);
		
		JPanel J1Cartes = new JPanel();
		J1Cartes.setBounds(14, 323, 241, 102);
		contentPane.add(J1Cartes);
		J1Cartes.setLayout(new GridLayout(2, 5, 0, 0));
		
		JPanel J2Information = new JPanel();
		J2Information.setBounds(14, 13, 73, 91);
		contentPane.add(J2Information);
		J2Information.setBackground(Color.ORANGE);
		J2Information.setLayout(null);
		
		JLabel lblJoueur2 = new JLabel("Joueur2");
		lblJoueur2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblJoueur2.setBounds(0, 0, 56, 18);
		J2Information.add(lblJoueur2);
		
		JLabel lblPointsDaction2 = new JLabel("Points d'action:");
		lblPointsDaction2.setFont(new Font("SansSerif", Font.BOLD, 10));
		lblPointsDaction2.setBounds(0, 37, 106, 18);
		J2Information.add(lblPointsDaction2);
		
		JLabel lblJour2 = new JLabel("Jour");
		lblJour2.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblJour2.setBounds(0, 47, 72, 18);
		J2Information.add(lblJour2);
		
		JLabel lblNuit2 = new JLabel("Nuit");
		lblNuit2.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNuit2.setBounds(0, 60, 72, 18);
		J2Information.add(lblNuit2);
		
		JLabel lblNeant2 = new JLabel("N¨¦ant");
		lblNeant2.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNeant2.setBounds(0, 73, 72, 18);
		J2Information.add(lblNeant2);
		
		JLabel lblNbpriere2 = new JLabel("NbPri¨¨re");
		lblNbpriere2.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNbpriere2.setBounds(0, 13, 72, 18);
		J2Information.add(lblNbpriere2);
		
		JLabel lblCartesEnMain2 = new JLabel("en main");
		lblCartesEnMain2.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCartesEnMain2.setBounds(0, 25, 59, 18);
		J2Information.add(lblCartesEnMain2);
		
		JLabel nbPriere2 = new JLabel("9");
		nbPriere2.setBounds(64, 13, 8, 18);
		J2Information.add(nbPriere2);
		
		JLabel nbCartesEnMain2 = new JLabel("9");
		nbCartesEnMain2.setBounds(64, 25, 8, 18);
		J2Information.add(nbCartesEnMain2);
		
		JLabel nbJour2 = new JLabel("9");
		nbJour2.setBounds(64, 47, 8, 18);
		J2Information.add(nbJour2);
		
		JLabel nbNuit2 = new JLabel("9");
		nbNuit2.setBounds(64, 60, 8, 18);
		J2Information.add(nbNuit2);
		
		JLabel nbNeant2 = new JLabel("9");
		nbNeant2.setBounds(64, 73, 8, 18);
		J2Information.add(nbNeant2);
		
		JPanel J2Divinite = new JPanel();
		J2Divinite.setBounds(86, 13, 169, 91);
		contentPane.add(J2Divinite);
		
		JPanel J2Cartes = new JPanel();
		J2Cartes.setBounds(14, 104, 241, 102);
		contentPane.add(J2Cartes);
		J2Cartes.setLayout(new GridLayout(2, 5, 0, 0));
		
		JPanel J3Information = new JPanel();
		J3Information.setBounds(277, 13, 73, 91);
		contentPane.add(J3Information);
		J3Information.setBackground(Color.ORANGE);
		J3Information.setLayout(null);
		
		JLabel lblJoueur3 = new JLabel("Joueur3");
		lblJoueur3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblJoueur3.setBounds(0, 0, 56, 18);
		J3Information.add(lblJoueur3);
		
		JLabel lblPointsDaction3 = new JLabel("Points d'action:");
		lblPointsDaction3.setFont(new Font("SansSerif", Font.BOLD, 10));
		lblPointsDaction3.setBounds(0, 37, 106, 18);
		J3Information.add(lblPointsDaction3);
		
		JLabel lblJour3 = new JLabel("Jour");
		lblJour3.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblJour3.setBounds(0, 47, 72, 18);
		J3Information.add(lblJour3);
		
		JLabel lblNuit3 = new JLabel("Nuit");
		lblNuit3.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNuit3.setBounds(0, 60, 72, 18);
		J3Information.add(lblNuit3);
		
		JLabel lblNeant3 = new JLabel("N¨¦ant");
		lblNeant3.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNeant3.setBounds(0, 73, 72, 18);
		J3Information.add(lblNeant3);
		
		JLabel lblNbpriere3 = new JLabel("NbPri¨¨re");
		lblNbpriere3.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNbpriere3.setBounds(0, 13, 72, 18);
		J3Information.add(lblNbpriere3);
		
		JLabel lblCartesEnMain3 = new JLabel("en main");
		lblCartesEnMain3.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCartesEnMain3.setBounds(0, 25, 59, 18);
		J3Information.add(lblCartesEnMain3);
		
		JLabel nbPriere3 = new JLabel("9");
		nbPriere3.setBounds(64, 13, 8, 18);
		J3Information.add(nbPriere3);
		
		JLabel nbCartesEnMain3 = new JLabel("9");
		nbCartesEnMain3.setBounds(64, 25, 8, 18);
		J3Information.add(nbCartesEnMain3);
		
		JLabel nbJour3 = new JLabel("9");
		nbJour3.setBounds(64, 47, 8, 18);
		J3Information.add(nbJour3);
		
		JLabel nbNuit3 = new JLabel("9");
		nbNuit3.setBounds(64, 60, 8, 18);
		J3Information.add(nbNuit3);
		
		JLabel nbNeant3 = new JLabel("9");
		nbNeant3.setBounds(64, 73, 8, 18);
		J3Information.add(nbNeant3);
		
		JPanel J3Divinite = new JPanel();
		J3Divinite.setBounds(349, 13, 169, 91);
		contentPane.add(J3Divinite);
		
		JPanel J3Cartes = new JPanel();
		J3Cartes.setBounds(277, 104, 241, 102);
		contentPane.add(J3Cartes);
		J3Cartes.setLayout(new GridLayout(2, 5, 0, 0));
		
		JPanel J4Information = new JPanel();
		J4Information.setBounds(544, 13, 73, 91);
		contentPane.add(J4Information);
		J4Information.setBackground(Color.ORANGE);
		J4Information.setLayout(null);
		
		JLabel lblJoueur4 = new JLabel("Joueur4");
		lblJoueur4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblJoueur4.setBounds(0, 0, 56, 18);
		J4Information.add(lblJoueur4);
		
		JLabel lblPointsDaction4 = new JLabel("Points d'action:");
		lblPointsDaction4.setFont(new Font("SansSerif", Font.BOLD, 10));
		lblPointsDaction4.setBounds(0, 37, 106, 18);
		J4Information.add(lblPointsDaction4);
		
		JLabel lblJour4 = new JLabel("Jour");
		lblJour4.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblJour4.setBounds(0, 47, 72, 18);
		J4Information.add(lblJour4);
		
		JLabel lblNuit4 = new JLabel("Nuit");
		lblNuit4.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNuit4.setBounds(0, 60, 72, 18);
		J4Information.add(lblNuit4);
		
		JLabel lblNeant4 = new JLabel("N¨¦ant");
		lblNeant4.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNeant4.setBounds(0, 73, 72, 18);
		J4Information.add(lblNeant4);
		
		JLabel lblNbpriere4 = new JLabel("NbPri¨¨re");
		lblNbpriere4.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNbpriere4.setBounds(0, 13, 72, 18);
		J4Information.add(lblNbpriere4);
		
		JLabel lblCartesEnMain4 = new JLabel("en main");
		lblCartesEnMain4.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCartesEnMain4.setBounds(0, 25, 59, 18);
		J4Information.add(lblCartesEnMain4);
		
		JLabel nbPriere4 = new JLabel("9");
		nbPriere4.setBounds(64, 13, 8, 18);
		J4Information.add(nbPriere4);
		
		JLabel nbCartesEnMain4 = new JLabel("9");
		nbCartesEnMain4.setBounds(64, 25, 8, 18);
		J4Information.add(nbCartesEnMain4);
		
		JLabel nbJour4 = new JLabel("9");
		nbJour4.setBounds(64, 47, 8, 18);
		J4Information.add(nbJour4);
		
		JLabel nbNuit4 = new JLabel("9");
		nbNuit4.setBounds(64, 60, 8, 18);
		J4Information.add(nbNuit4);
		
		JLabel nbNeant4 = new JLabel("9");
		nbNeant4.setBounds(64, 73, 8, 18);
		J4Information.add(nbNeant4);
		
		JPanel J4Divinite = new JPanel();
		J4Divinite.setBounds(616, 13, 169, 91);
		contentPane.add(J4Divinite);
		
		JPanel J4Cartes = new JPanel();
		J4Cartes.setBounds(544, 104, 241, 102);
		contentPane.add(J4Cartes);
		J4Cartes.setLayout(new GridLayout(2, 5, 0, 0));
		
		JPanel J5Information = new JPanel();
		J5Information.setBounds(809, 13, 73, 91);
		contentPane.add(J5Information);
		J5Information.setBackground(Color.ORANGE);
		J5Information.setLayout(null);
		
		JLabel lblJoueur5 = new JLabel("Joueur5");
		lblJoueur5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblJoueur5.setBounds(0, 0, 56, 18);
		J5Information.add(lblJoueur5);
		
		JLabel lblPointsDaction5 = new JLabel("Points d'action:");
		lblPointsDaction5.setFont(new Font("SansSerif", Font.BOLD, 10));
		lblPointsDaction5.setBounds(0, 37, 106, 18);
		J5Information.add(lblPointsDaction5);
		
		JLabel lblJour5 = new JLabel("Jour");
		lblJour5.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblJour5.setBounds(0, 47, 72, 18);
		J5Information.add(lblJour5);
		
		JLabel lblNuit5 = new JLabel("Nuit");
		lblNuit5.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNuit5.setBounds(0, 60, 72, 18);
		J5Information.add(lblNuit5);
		
		JLabel lblNeant5 = new JLabel("N¨¦ant");
		lblNeant5.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNeant5.setBounds(0, 73, 72, 18);
		J5Information.add(lblNeant5);
		
		JLabel lblNbpriere5 = new JLabel("NbPri¨¨re");
		lblNbpriere5.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNbpriere5.setBounds(0, 13, 72, 18);
		J5Information.add(lblNbpriere5);
		
		JLabel lblCartesEnMain5 = new JLabel("en main");
		lblCartesEnMain5.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCartesEnMain5.setBounds(0, 25, 59, 18);
		J5Information.add(lblCartesEnMain5);
		
		JLabel nbPriere5 = new JLabel("9");
		nbPriere5.setBounds(64, 13, 8, 18);
		J5Information.add(nbPriere5);
		
		JLabel nbCartesEnMain5 = new JLabel("9");
		nbCartesEnMain5.setBounds(64, 25, 8, 18);
		J5Information.add(nbCartesEnMain5);
		
		JLabel nbJour5 = new JLabel("9");
		nbJour5.setBounds(64, 47, 8, 18);
		J5Information.add(nbJour5);
		
		JLabel nbNuit5 = new JLabel("9");
		nbNuit5.setBounds(64, 60, 8, 18);
		J5Information.add(nbNuit5);
		
		JLabel nbNeant5 = new JLabel("9");
		nbNeant5.setBounds(64, 73, 8, 18);
		J5Information.add(nbNeant5);
		
		JPanel J5Divinite = new JPanel();
		J5Divinite.setBounds(881, 13, 169, 91);
		contentPane.add(J5Divinite);
		
		JPanel J5Cartes = new JPanel();
		J5Cartes.setBounds(809, 104, 241, 102);
		contentPane.add(J5Cartes);
		J5Cartes.setLayout(new GridLayout(2, 5, 0, 0));
		
		JPanel J6Information = new JPanel();
		J6Information.setBounds(1074, 13, 73, 91);
		contentPane.add(J6Information);
		J6Information.setBackground(Color.ORANGE);
		J6Information.setLayout(null);
		
		JLabel lblJoueur6 = new JLabel("Joueur6");
		lblJoueur6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblJoueur6.setBounds(0, 0, 56, 18);
		J6Information.add(lblJoueur6);
		
		JLabel lblPointsDaction6 = new JLabel("Points d'action:");
		lblPointsDaction6.setFont(new Font("SansSerif", Font.BOLD, 10));
		lblPointsDaction6.setBounds(0, 37, 106, 18);
		J6Information.add(lblPointsDaction6);
		
		JLabel lblJour6 = new JLabel("Jour");
		lblJour6.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblJour6.setBounds(0, 47, 72, 18);
		J6Information.add(lblJour6);
		
		JLabel lblNuit6 = new JLabel("Nuit");
		lblNuit6.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNuit6.setBounds(0, 60, 72, 18);
		J6Information.add(lblNuit6);
		
		JLabel lblNeant6 = new JLabel("N¨¦ant");
		lblNeant6.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNeant6.setBounds(0, 73, 72, 18);
		J6Information.add(lblNeant6);
		
		JLabel lblNbpriere6 = new JLabel("NbPri¨¨re");
		lblNbpriere6.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNbpriere6.setBounds(0, 13, 72, 18);
		J6Information.add(lblNbpriere6);
		
		JLabel lblCartesEnMain6 = new JLabel("en main");
		lblCartesEnMain6.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCartesEnMain6.setBounds(0, 25, 59, 18);
		J6Information.add(lblCartesEnMain6);
		
		JLabel nbPriere6 = new JLabel("9");
		nbPriere6.setBounds(64, 13, 8, 18);
		J6Information.add(nbPriere6);
		
		JLabel nbCartesEnMain6 = new JLabel("9");
		nbCartesEnMain6.setBounds(64, 25, 8, 18);
		J6Information.add(nbCartesEnMain6);
		
		JLabel nbJour6 = new JLabel("9");
		nbJour6.setBounds(64, 47, 8, 18);
		J6Information.add(nbJour6);
		
		JLabel nbNuit6 = new JLabel("9");
		nbNuit6.setBounds(64, 60, 8, 18);
		J6Information.add(nbNuit6);
		
		JLabel nbNeant6 = new JLabel("9");
		nbNeant6.setBounds(64, 73, 8, 18);
		J6Information.add(nbNeant6);
		
		JPanel J6Divinite = new JPanel();
		J6Divinite.setBounds(1146, 13, 169, 91);
		contentPane.add(J6Divinite);
		
		JPanel J6Cartes = new JPanel();
		J6Cartes.setBounds(1074, 104, 241, 102);
		contentPane.add(J6Cartes);
		J6Cartes.setLayout(new GridLayout(2, 5, 0, 0));
		
		JPanel J7Information = new JPanel();
		J7Information.setBounds(1074, 232, 73, 91);
		contentPane.add(J7Information);
		J7Information.setBackground(Color.ORANGE);
		J7Information.setLayout(null);
		
		JLabel lblJoueur7 = new JLabel("Joueur7");
		lblJoueur7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblJoueur7.setBounds(0, 0, 56, 18);
		J7Information.add(lblJoueur7);
		
		JLabel lblPointsDaction7 = new JLabel("Points d'action:");
		lblPointsDaction7.setFont(new Font("SansSerif", Font.BOLD, 10));
		lblPointsDaction7.setBounds(0, 37, 106, 18);
		J7Information.add(lblPointsDaction7);
		
		JLabel lblJour7 = new JLabel("Jour");
		lblJour7.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblJour7.setBounds(0, 47, 72, 18);
		J7Information.add(lblJour7);
		
		JLabel lblNuit7 = new JLabel("Nuit");
		lblNuit7.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNuit7.setBounds(0, 60, 72, 18);
		J7Information.add(lblNuit7);
		
		JLabel lblNeant7 = new JLabel("N¨¦ant");
		lblNeant7.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNeant7.setBounds(0, 73, 72, 18);
		J7Information.add(lblNeant7);
		
		JLabel lblNbpriere7 = new JLabel("NbPri¨¨re");
		lblNbpriere7.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNbpriere7.setBounds(0, 13, 72, 18);
		J7Information.add(lblNbpriere7);
		
		JLabel lblCartesEnMain7 = new JLabel("en main");
		lblCartesEnMain7.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCartesEnMain7.setBounds(0, 25, 59, 18);
		J7Information.add(lblCartesEnMain7);
		
		JLabel nbPriere7 = new JLabel("9");
		nbPriere7.setBounds(64, 13, 8, 18);
		J7Information.add(nbPriere7);
		
		JLabel nbCartesEnMain7 = new JLabel("9");
		nbCartesEnMain7.setBounds(64, 25, 8, 18);
		J7Information.add(nbCartesEnMain7);
		
		JLabel nbJour7 = new JLabel("9");
		nbJour7.setBounds(64, 47, 8, 18);
		J7Information.add(nbJour7);
		
		JLabel nbNuit7 = new JLabel("9");
		nbNuit7.setBounds(64, 60, 8, 18);
		J7Information.add(nbNuit7);
		
		JLabel nbNeant7 = new JLabel("9");
		nbNeant7.setBounds(64, 73, 8, 18);
		J7Information.add(nbNeant7);
		
		JPanel J7Divinite = new JPanel();
		J7Divinite.setBounds(1146, 232, 169, 91);
		contentPane.add(J7Divinite);
		
		JPanel J7Cartes = new JPanel();
		J7Cartes.setBounds(1074, 323, 241, 102);
		contentPane.add(J7Cartes);
		J7Cartes.setLayout(new GridLayout(2, 5, 0, 0));
		
		JPanel CartesEnMain = new JPanel();
		CartesEnMain.setBounds(203, 567, 1143, 153);
		contentPane.add(CartesEnMain);
		CartesEnMain.setLayout(new GridLayout(1, 10, 0, 0));
		
		JPanel Divinite = new JPanel();
		Divinite.setBounds(46, 629, 158, 91);
		contentPane.add(Divinite);
		
		JPanel Information = new JPanel();
		Information.setBackground(Color.MAGENTA);
		Information.setBounds(46, 568, 158, 62);
		contentPane.add(Information);
		Information.setLayout(null);
		
		JLabel lblPointsDaction = new JLabel("Points d'action");
		lblPointsDaction.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblPointsDaction.setBounds(0, 0, 126, 18);
		Information.add(lblPointsDaction);
		
		JLabel lblNuit = new JLabel("Nuit");
		lblNuit.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNuit.setBounds(0, 31, 72, 18);
		Information.add(lblNuit);
		
		JLabel lblJour = new JLabel("Jour");
		lblJour.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblJour.setBounds(0, 13, 39, 18);
		Information.add(lblJour);
		
		JLabel lblNant = new JLabel("N\u00E9ant");
		lblNant.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNant.setBounds(0, 44, 72, 18);
		Information.add(lblNant);
		
		JLabel nbJour = new JLabel("9");
		nbJour.setBounds(53, 13, 16, 18);
		Information.add(nbJour);
		
		JLabel nbNuit = new JLabel("9");
		nbNuit.setFont(new Font("SimSun", Font.PLAIN, 15));
		nbNuit.setBounds(54, 31, 16, 18);
		Information.add(nbNuit);
		
		JLabel nbNeant = new JLabel("9");
		nbNeant.setBounds(54, 44, 16, 18);
		Information.add(nbNeant);
		
		JLabel lblNbprire = new JLabel("nbPri\u00E8re");
		lblNbprire.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNbprire.setBounds(86, 31, 72, 18);
		Information.add(lblNbprire);
		
		JLabel nbPriere = new JLabel("9");
		nbPriere.setBounds(110, 44, 16, 18);
		Information.add(nbPriere);
		
		JPanel Buttons = new JPanel();
		Buttons.setBounds(311, 536, 692, 32);
		contentPane.add(Buttons);
		Buttons.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton defausser = new JButton("d¨¦fausser");
		defausser.setFont(new Font("SansSerif", Font.PLAIN, 15));
		Buttons.add(defausser);
		
		JButton piocher = new JButton("piocher");
		piocher.setFont(new Font("SansSerif", Font.PLAIN, 15));
		Buttons.add(piocher);
		
		JButton utiliser = new JButton("utiliser");
		utiliser.setFont(new Font("SansSerif", Font.PLAIN, 15));
		Buttons.add(utiliser);
		
		JButton sacrifier = new JButton("sacrifier");
		sacrifier.setFont(new Font("SansSerif", Font.PLAIN, 15));
		Buttons.add(sacrifier);
		
		JButton capacite = new JButton("capacit¨¦");
		capacite.setFont(new Font("SansSerif", Font.PLAIN, 15));
		Buttons.add(capacite);
		
		JPanel Cartes = new JPanel();
		Cartes.setBounds(277, 429, 773, 107);
		contentPane.add(Cartes);
		Cartes.setLayout(new GridLayout(1, 10, 0, 0));
		
		JPanel CartesSurTable = new JPanel();
		CartesSurTable.setBounds(277, 219, 773, 201);
		contentPane.add(CartesSurTable);
		CartesSurTable.setLayout(new GridLayout(3, 12, 0, 0));
	}
}
