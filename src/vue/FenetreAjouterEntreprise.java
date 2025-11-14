package vue;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionFenetreAjouterEntreprise;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;


public class FenetreAjouterEntreprise extends JInternalFrame  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldSiret;
	private JTextField textFieldNom;
	private JTextField textFieldAdresse;
	private JTextField textFieldVille;
	private JTextField textFieldCodePostal;
	private JTextField textFieldTel;
	private JTextField textFieldSpecialite;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				javax.swing.JFrame frame = new javax.swing.JFrame();
				frame.setBounds(100, 100, 700, 600);
				frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

				javax.swing.JDesktopPane desktopPane = new javax.swing.JDesktopPane();
				frame.setContentPane(desktopPane);

				FenetreAjouterEntreprise internalFrame = new FenetreAjouterEntreprise();
				internalFrame.setVisible(true);
				desktopPane.add(internalFrame);

				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FenetreAjouterEntreprise() {
		GestionFenetreAjouterEntreprise gestionClic = new GestionFenetreAjouterEntreprise(this);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(50, 50, 400, 451);
		setTitle("Ajouter Entreprise");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitre = new JLabel("Ajouter Entreprise");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitre.setBounds(0, 22, 384, 30);
		contentPane.add(lblTitre);

		JLabel lblSiret = new JLabel("Numéro SIRET :");
		lblSiret.setBounds(33, 73, 100, 25);
		contentPane.add(lblSiret);

		textFieldSiret = new JTextField();
		textFieldSiret.setBounds(150, 73, 200, 25);
		contentPane.add(textFieldSiret);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(33, 109, 100, 25);
		contentPane.add(lblNom);

		textFieldNom = new JTextField();
		textFieldNom.setBounds(150, 109, 200, 25);
		contentPane.add(textFieldNom);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(33, 145, 100, 25);
		contentPane.add(lblAdresse);

		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(150, 145, 200, 25);
		contentPane.add(textFieldAdresse);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(33, 181, 100, 25);
		contentPane.add(lblVille);

		textFieldVille = new JTextField();
		textFieldVille.setBounds(150, 181, 200, 25);
		contentPane.add(textFieldVille);

		JLabel lblCodePostal = new JLabel("Code postal :");
		lblCodePostal.setBounds(33, 217, 100, 25);
		contentPane.add(lblCodePostal);

		textFieldCodePostal = new JTextField();
		textFieldCodePostal.setBounds(150, 217, 200, 25);
		contentPane.add(textFieldCodePostal);

		JLabel lblTel = new JLabel("Numéro de téléphone :");
		lblTel.setBounds(33, 253, 140, 25);
		contentPane.add(lblTel);

		textFieldTel = new JTextField();
		textFieldTel.setBounds(150, 253, 200, 25);
		contentPane.add(textFieldTel);

		JLabel lblSpecialite = new JLabel("Spécialité :");
		lblSpecialite.setBounds(33, 289, 100, 25);
		contentPane.add(lblSpecialite);

		textFieldSpecialite = new JTextField();
		textFieldSpecialite.setBounds(150, 289, 200, 25);
		contentPane.add(textFieldSpecialite);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(gestionClic);
		btnAnnuler.setBounds(65, 357, 100, 30);
		contentPane.add(btnAnnuler);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(gestionClic);
		btnAjouter.setBounds(211, 357, 100, 30);
		contentPane.add(btnAjouter);
	}
	
}
