package vue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionFenetreAjouterEntreprise;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;

public class FenetreAjouterEntreprise extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldSiret;
	private JTextField textFieldNom;
	private JTextField textFieldAdresse;
	private JTextField textFieldVille;
	private JTextField textFieldCodePostal;
	private JTextField textFieldTel;
	private JTextField textFieldSpecialite;

	public FenetreAjouterEntreprise() {
		setResizable(false);
		GestionFenetreAjouterEntreprise gestionClic = new GestionFenetreAjouterEntreprise(this);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(50, 50, 450, 500);
		setTitle("Ajouter Entreprise");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitre = new JLabel("Ajouter Entreprise");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitre.setBounds(0, 22, 434, 30);
		contentPane.add(lblTitre);

		JLabel lblSiret = new JLabel("Numéro SIRET :");
		lblSiret.setBounds(52, 85, 100, 25);
		contentPane.add(lblSiret);

		textFieldSiret = new JTextField();
		textFieldSiret.setBounds(175, 85, 200, 25);
		contentPane.add(textFieldSiret);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(52, 127, 100, 25);
		contentPane.add(lblNom);

		textFieldNom = new JTextField();
		textFieldNom.setBounds(175, 127, 200, 25);
		contentPane.add(textFieldNom);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(52, 167, 100, 25);
		contentPane.add(lblAdresse);

		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(175, 167, 200, 25);
		contentPane.add(textFieldAdresse);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(52, 205, 100, 25);
		contentPane.add(lblVille);

		textFieldVille = new JTextField();
		textFieldVille.setBounds(175, 205, 200, 25);
		contentPane.add(textFieldVille);

		JLabel lblCodePostal = new JLabel("Code postal :");
		lblCodePostal.setBounds(52, 241, 100, 25);
		contentPane.add(lblCodePostal);

		textFieldCodePostal = new JTextField();
		textFieldCodePostal.setBounds(175, 241, 200, 25);
		contentPane.add(textFieldCodePostal);

		JLabel lblTel = new JLabel("Numéro de téléphone :");
		lblTel.setBounds(52, 277, 140, 25);
		contentPane.add(lblTel);

		textFieldTel = new JTextField();
		textFieldTel.setBounds(175, 277, 200, 25);
		contentPane.add(textFieldTel);

		JLabel lblSpecialite = new JLabel("Spécialité :");
		lblSpecialite.setBounds(52, 313, 100, 25);
		contentPane.add(lblSpecialite);

		textFieldSpecialite = new JTextField();
		textFieldSpecialite.setBounds(175, 315, 200, 25);
		contentPane.add(textFieldSpecialite);

		JButton btnVider = new JButton("Vider");
		btnVider.addActionListener(gestionClic);
		btnVider.setBounds(171, 390, 100, 30);
		contentPane.add(btnVider);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(gestionClic);
		btnAjouter.setBounds(52, 390, 100, 30);
		contentPane.add(btnAjouter);

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(gestionClic);
		btnRetour.setBounds(294, 390, 100, 30);
		contentPane.add(btnRetour);
	}

	public List<JTextField> getAllEntrepriseTextFields() {
		List<JTextField> fields = new ArrayList<>();
		fields.add(textFieldSiret);
		fields.add(textFieldAdresse);
		fields.add(textFieldVille);
		fields.add(textFieldCodePostal);
		fields.add(textFieldNom);
		fields.add(textFieldTel);
		fields.add(textFieldSpecialite);
		return fields;
	}

}
