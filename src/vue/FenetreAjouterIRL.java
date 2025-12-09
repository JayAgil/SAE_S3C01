package vue;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionAjouterIRL;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class FenetreAjouterIRL extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldAnnee;
	private JTextField textFieldVal;
	private GestionAjouterIRL gestionClic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAjouterIRL frame = new FenetreAjouterIRL();
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
	public FenetreAjouterIRL() {
		setResizable(false);
		this.gestionClic = new GestionAjouterIRL(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitre = new JLabel("Ajouter IRL");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setBounds(0, 78, 434, 29);
		contentPane.add(lblTitre);

		JLabel lblAnnee = new JLabel("Année :");
		lblAnnee.setBounds(90, 159, 119, 13);
		contentPane.add(lblAnnee);

		textFieldAnnee = new JTextField();
		textFieldAnnee.setBounds(219, 156, 96, 19);
		contentPane.add(textFieldAnnee);
		textFieldAnnee.setColumns(10);

		JLabel lblVal = new JLabel("Valeur :");
		lblVal.setBounds(90, 247, 48, 13);
		contentPane.add(lblVal);

		textFieldVal = new JTextField();
		textFieldVal.setBounds(219, 243, 96, 19);
		contentPane.add(textFieldVal);
		textFieldVal.setColumns(10);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(81, 325, 85, 21);
		contentPane.add(btnAjouter);

		JButton btnVider = new JButton("Vider");
		btnVider.setBounds(179, 325, 85, 21);
		contentPane.add(btnVider);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(274, 325, 85, 21);
		contentPane.add(btnRetour);

		btnVider.addActionListener(this.gestionClic);
		btnAjouter.addActionListener(this.gestionClic);
		btnRetour.addActionListener(this.gestionClic);

	}
	
	public List<JTextField> getAllTextFields() {
	    List<JTextField> fields = new ArrayList<>();
	    fields.add(textFieldAnnee);
	    fields.add(textFieldVal);
	
	    return fields;
	}
}
