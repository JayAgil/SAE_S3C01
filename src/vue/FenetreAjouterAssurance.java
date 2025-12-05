package vue;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionFenetreAjouterAssurance;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class FenetreAjouterAssurance extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNumAssurance;
	private JTextField textFieldPrime;
	private JTextField textFieldMontant;
	private JTextField textFieldTypeAssurance;
	private JTextField textFieldAgence;
	private JTextField textFieldAddrAgence;
	private JTextField textFieldTelAgence;
	private GestionFenetreAjouterAssurance gestionClic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAjouterAssurance frame = new FenetreAjouterAssurance();
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
	public FenetreAjouterAssurance() {
		setResizable(false);
		this.gestionClic = new GestionFenetreAjouterAssurance(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitre = new JLabel("Ajouter assurance");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setBounds(0, 29, 434, 29);
		contentPane.add(lblTitre);

		JLabel lblNumAssurance = new JLabel("Numéro Assurance :");
		lblNumAssurance.setBounds(90, 92, 119, 13);
		contentPane.add(lblNumAssurance);

		textFieldNumAssurance = new JTextField();
		textFieldNumAssurance.setBounds(219, 89, 96, 19);
		contentPane.add(textFieldNumAssurance);
		textFieldNumAssurance.setColumns(10);

		JLabel lblPrime = new JLabel("Prime :");
		lblPrime.setBounds(90, 142, 34, 13);
		contentPane.add(lblPrime);

		textFieldPrime = new JTextField();
		textFieldPrime.setBounds(219, 138, 96, 19);
		contentPane.add(textFieldPrime);
		textFieldPrime.setColumns(10);

		textFieldMontant = new JTextField();
		textFieldMontant.setColumns(10);
		textFieldMontant.setBounds(219, 184, 96, 19);
		contentPane.add(textFieldMontant);

		textFieldTypeAssurance = new JTextField();
		textFieldTypeAssurance.setColumns(10);
		textFieldTypeAssurance.setBounds(219, 232, 96, 19);
		contentPane.add(textFieldTypeAssurance);

		textFieldAgence = new JTextField();
		textFieldAgence.setColumns(10);
		textFieldAgence.setBounds(219, 275, 96, 19);
		contentPane.add(textFieldAgence);

		textFieldAddrAgence = new JTextField();
		textFieldAddrAgence.setColumns(10);
		textFieldAddrAgence.setBounds(219, 321, 96, 19);
		contentPane.add(textFieldAddrAgence);

		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMontant.setBounds(84, 188, 54, 13);
		contentPane.add(lblMontant);

		JLabel lblTypeAssurance = new JLabel("Type assurance :");
		lblTypeAssurance.setBounds(90, 236, 95, 13);
		contentPane.add(lblTypeAssurance);

		JLabel lblAgence = new JLabel("Agence :");
		lblAgence.setBounds(90, 279, 71, 13);
		contentPane.add(lblAgence);

		JLabel lblAddrAgence = new JLabel("Adresse agence :");
		lblAddrAgence.setBounds(90, 325, 95, 13);
		contentPane.add(lblAddrAgence);

		JLabel lblTelAgence = new JLabel("Tèl Agence :");
		lblTelAgence.setBounds(90, 368, 96, 13);
		contentPane.add(lblTelAgence);

		textFieldTelAgence = new JTextField();
		textFieldTelAgence.setColumns(10);
		textFieldTelAgence.setBounds(219, 365, 96, 19);
		contentPane.add(textFieldTelAgence);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(90, 432, 85, 21);
		contentPane.add(btnAjouter);

		JButton btnVider = new JButton("Vider");
		btnVider.setBounds(188, 432, 85, 21);
		contentPane.add(btnVider);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(283, 432, 85, 21);
		contentPane.add(btnRetour);

		btnVider.addActionListener(this.gestionClic);
		btnAjouter.addActionListener(this.gestionClic);
		btnRetour.addActionListener(this.gestionClic);

	}
	
	public List<JTextField> getAllTextFields() {
	    List<JTextField> fields = new ArrayList<>();
	    fields.add(textFieldNumAssurance);
	    fields.add(textFieldPrime);
	    fields.add(textFieldMontant);
	    fields.add(textFieldTypeAssurance);
	    fields.add(textFieldAgence);
	    fields.add(textFieldAddrAgence);
	    fields.add(textFieldTelAgence);
	    return fields;
	}
}
