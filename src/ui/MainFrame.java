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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		J1Information.setBackground(Color.ORANGE);
		J1Information.setBounds(14, 232, 73, 91);
		contentPane.add(J1Information);
		J1Information.setLayout(null);
		
		JLabel lblJoueur = new JLabel("Joueur1");
		lblJoueur.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblJoueur.setBounds(0, 0, 56, 18);
		J1Information.add(lblJoueur);
		
		JLabel lblPointsDaction = new JLabel("Points d'action:");
		lblPointsDaction.setFont(new Font("SansSerif", Font.BOLD, 10));
		lblPointsDaction.setBounds(0, 37, 106, 18);
		J1Information.add(lblPointsDaction);
		
		JLabel lblJour = new JLabel("Jour");
		lblJour.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblJour.setBounds(0, 47, 72, 18);
		J1Information.add(lblJour);
		
		JLabel lblNuit = new JLabel("Nuit");
		lblNuit.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNuit.setBounds(0, 60, 72, 18);
		J1Information.add(lblNuit);
		
		JLabel lblNant = new JLabel("N\u00E9ant");
		lblNant.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNant.setBounds(0, 73, 72, 18);
		J1Information.add(lblNant);
		
		JLabel lblNbprire = new JLabel("NbPriere");
		lblNbprire.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNbprire.setBounds(0, 13, 72, 18);
		J1Information.add(lblNbprire);
		
		JLabel lblCartesEnMain = new JLabel("en main");
		lblCartesEnMain.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCartesEnMain.setBounds(0, 25, 59, 18);
		J1Information.add(lblCartesEnMain);
		
		JLabel label = new JLabel("9");
		label.setBounds(64, 13, 8, 18);
		J1Information.add(label);
		
		JLabel label_1 = new JLabel("9");
		label_1.setBounds(64, 25, 8, 18);
		J1Information.add(label_1);
		
		JLabel label_2 = new JLabel("9");
		label_2.setBounds(64, 47, 8, 18);
		J1Information.add(label_2);
		
		JLabel label_3 = new JLabel("9");
		label_3.setBounds(64, 60, 8, 18);
		J1Information.add(label_3);
		
		JLabel label_4 = new JLabel("9");
		label_4.setBounds(64, 73, 8, 18);
		J1Information.add(label_4);
		
		JPanel J1Divinite = new JPanel();
		J1Divinite.setBounds(86, 232, 169, 91);
		contentPane.add(J1Divinite);
		
		JPanel J1Cartes = new JPanel();
		J1Cartes.setBounds(14, 323, 241, 102);
		contentPane.add(J1Cartes);
		
		JPanel J2Information = new JPanel();
		J2Information.setBounds(14, 13, 73, 91);
		contentPane.add(J2Information);
		
		JPanel J2Divinite = new JPanel();
		J2Divinite.setBounds(86, 13, 169, 91);
		contentPane.add(J2Divinite);
		
		JPanel J2Cartes = new JPanel();
		J2Cartes.setBounds(14, 104, 241, 102);
		contentPane.add(J2Cartes);
		
		JPanel J3Information = new JPanel();
		J3Information.setBounds(277, 13, 73, 91);
		contentPane.add(J3Information);
		
		JPanel J3Divinite = new JPanel();
		J3Divinite.setBounds(349, 13, 169, 91);
		contentPane.add(J3Divinite);
		
		JPanel J3Cartes = new JPanel();
		J3Cartes.setBounds(277, 104, 241, 102);
		contentPane.add(J3Cartes);
		
		JPanel J4Information = new JPanel();
		J4Information.setBounds(544, 13, 73, 91);
		contentPane.add(J4Information);
		
		JPanel J4Divinite = new JPanel();
		J4Divinite.setBounds(616, 13, 169, 91);
		contentPane.add(J4Divinite);
		
		JPanel J4Cartes = new JPanel();
		J4Cartes.setBounds(544, 104, 241, 102);
		contentPane.add(J4Cartes);
		
		JPanel J5Information = new JPanel();
		J5Information.setBounds(809, 13, 73, 91);
		contentPane.add(J5Information);
		
		JPanel J5Divinite = new JPanel();
		J5Divinite.setBounds(881, 13, 169, 91);
		contentPane.add(J5Divinite);
		
		JPanel J5Cartes = new JPanel();
		J5Cartes.setBounds(809, 104, 241, 102);
		contentPane.add(J5Cartes);
		
		JPanel J6Information = new JPanel();
		J6Information.setBounds(1074, 13, 73, 91);
		contentPane.add(J6Information);
		
		JPanel J6Divinite = new JPanel();
		J6Divinite.setBounds(1146, 13, 169, 91);
		contentPane.add(J6Divinite);
		
		JPanel J6Cartes = new JPanel();
		J6Cartes.setBounds(1074, 104, 241, 102);
		contentPane.add(J6Cartes);
		
		JPanel J7Information = new JPanel();
		J7Information.setBounds(1074, 232, 73, 91);
		contentPane.add(J7Information);
		
		JPanel J7Divinite = new JPanel();
		J7Divinite.setBounds(1146, 232, 169, 91);
		contentPane.add(J7Divinite);
		
		JPanel J7Cartes = new JPanel();
		J7Cartes.setBounds(1074, 323, 241, 102);
		contentPane.add(J7Cartes);
		
		JPanel CartesEnMain = new JPanel();
		CartesEnMain.setBounds(203, 567, 942, 153);
		contentPane.add(CartesEnMain);
		CartesEnMain.setLayout(null);
		
		JPanel Divinite = new JPanel();
		Divinite.setBounds(46, 629, 158, 91);
		contentPane.add(Divinite);
		
		JPanel Information = new JPanel();
		Information.setBounds(46, 568, 158, 62);
		contentPane.add(Information);
		
		JPanel Buttons = new JPanel();
		Buttons.setBounds(311, 536, 692, 32);
		contentPane.add(Buttons);
		Buttons.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton defausser = new JButton("d\u00E9fausser");
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
		
		JButton capacite = new JButton("capacit\u00E9");
		capacite.setFont(new Font("SansSerif", Font.PLAIN, 15));
		Buttons.add(capacite);
		
		JPanel Cartes = new JPanel();
		Cartes.setBounds(311, 429, 692, 107);
		contentPane.add(Cartes);
		
		JPanel CartesSurTable = new JPanel();
		CartesSurTable.setBounds(277, 219, 773, 201);
		contentPane.add(CartesSurTable);
	}
}
