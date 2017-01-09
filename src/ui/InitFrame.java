package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.Partie;

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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitFrame frame = new InitFrame();
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
	public InitFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPandocreon = new JLabel("Pandocreon");
		lblPandocreon.setFont(new Font("Times New Roman", Font.BOLD, 84));
		lblPandocreon.setBounds(449, 157, 430, 77);
		contentPane.add(lblPandocreon);
		
		JLabel lblChoisirLeNombre = new JLabel("choisir le nombre de AI");
		lblChoisirLeNombre.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		lblChoisirLeNombre.setBounds(466, 334, 341, 32);
		contentPane.add(lblChoisirLeNombre);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(821, 334, 37, 32);
		spinner.setModel(new SpinnerNumberModel(1, 1, 7, 1));
		contentPane.add(spinner);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nomJ = (int)spinner.getValue();
				setVisible(false);
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
		});
		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 48));
		btnStart.setBounds(564, 461, 209, 58);
		contentPane.add(btnStart);
	}
}