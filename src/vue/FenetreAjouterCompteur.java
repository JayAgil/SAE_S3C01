package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;

public class FenetreAjouterCompteur extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAjouterCompteur frame = new FenetreAjouterCompteur();
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
	public FenetreAjouterCompteur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInformation = new JPanel();
		contentPane.add(panelInformation, BorderLayout.CENTER);
		panelInformation.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelButton = new JPanel();
		contentPane.add(panelButton, BorderLayout.SOUTH);
		
		JButton btnAnnuler = new JButton("Annuler");
		panelButton.add(btnAnnuler);
		
		JButton btnAjouter = new JButton("Ajouter");
		panelButton.add(btnAjouter);
	}

}
