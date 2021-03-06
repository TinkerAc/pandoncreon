package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.Partie;
import util.AideGUI;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitFrame extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public InitFrame() {
		super();
		this.setVisible(true);
		setResizable(true);
		setBounds(0, 0, 1366, 768);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPandocreon = new JLabel("Pandocreon");
		lblPandocreon.setFont(new Font("Times New Roman", Font.BOLD, 84));
		lblPandocreon.setBounds(449, 157, 430, 77);
		contentPane.add(lblPandocreon);
		
		JLabel lblChoisirLeNombre = new JLabel("choisir le nombre de joueurs");
		lblChoisirLeNombre.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		lblChoisirLeNombre.setBounds(466, 334, 341, 32);
		contentPane.add(lblChoisirLeNombre);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(821, 334, 37, 32);
		spinner.setModel(new SpinnerNumberModel(2, 2, 8, 1));
		contentPane.add(spinner);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				try {
					AideGUI.getInstance().deposerInt((int)spinner.getValue());
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Frame_Main frame = new Frame_Main((int)spinner.getValue());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				
//				Partie.getPartie().start();
			}
		});
		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 48));
		btnStart.setBounds(564, 461, 209, 58);
		contentPane.add(btnStart);


	}
}