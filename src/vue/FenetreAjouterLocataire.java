package vue;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FenetreAjouterLocataire extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse;
	private JTextField textFieldTel;
	private JTextField textFieldEmail;
	private JTextField textFieldCodePostal;
	private JTextField textFieldVille;
	private JTextField textFieldDateNaissance;
	private JTextField textFieldLieuNaissance;
	private JTextField textFieldSalaire;
	private JTextField textFieldProfession;
	private JTextField textFieldSituationFamiliale;

	private JTextField textFieldGarantNom;
	private JTextField textFieldGarantPrenom;
	private JTextField textFieldGarantAdresse;
	private JTextField textFieldGarantTel;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				javax.swing.JFrame frame = new javax.swing.JFrame();
				frame.setBounds(100, 100, 1000, 650);
				frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

				javax.swing.JDesktopPane desktopPane = new javax.swing.JDesktopPane();
				frame.setContentPane(desktopPane);

				FenetreAjouterLocataire internalFrame = new FenetreAjouterLocataire();
				internalFrame.setVisible(true);
				desktopPane.add(internalFrame);

				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FenetreAjouterLocataire() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(0, 0, 950, 650);
		setTitle("Ajouter Locataire");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitre = new JLabel("Fenêtre Ajouter Locataire");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitre.setBounds(250, 20, 450, 30);
		contentPane.add(lblTitre);

		JLabel lblLocataire = new JLabel("Informations Locataire");
		lblLocataire.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocataire.setBounds(50, 70, 400, 30);
		contentPane.add(lblLocataire);

		JLabel lblGarant = new JLabel("Informations Garant");
		lblGarant.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGarant.setHorizontalAlignment(SwingConstants.CENTER);
		lblGarant.setBounds(500, 70, 400, 30);
		contentPane.add(lblGarant);

		// Locataire
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(50, 120, 120, 25);
		contentPane.add(lblNom);
		textFieldNom = new JTextField();
		textFieldNom.setBounds(180, 120, 200, 25);
		contentPane.add(textFieldNom);

		JLabel lblPrenom = new JLabel("Prénom :");
		lblPrenom.setBounds(50, 155, 120, 25);
		contentPane.add(lblPrenom);
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(180, 155, 200, 25);
		contentPane.add(textFieldPrenom);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(50, 190, 120, 25);
		contentPane.add(lblAdresse);
		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(180, 190, 200, 25);
		contentPane.add(textFieldAdresse);

		JLabel lblTel = new JLabel("Tel :");
		lblTel.setBounds(50, 225, 120, 25);
		contentPane.add(lblTel);
		textFieldTel = new JTextField();
		textFieldTel.setBounds(180, 225, 200, 25);
		contentPane.add(textFieldTel);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(50, 260, 120, 25);
		contentPane.add(lblEmail);
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(180, 260, 200, 25);
		contentPane.add(textFieldEmail);

		JLabel lblCodePostal = new JLabel("Code Postal :");
		lblCodePostal.setBounds(50, 295, 120, 25);
		contentPane.add(lblCodePostal);
		textFieldCodePostal = new JTextField();
		textFieldCodePostal.setBounds(180, 295, 200, 25);
		contentPane.add(textFieldCodePostal);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(50, 330, 120, 25);
		contentPane.add(lblVille);
		textFieldVille = new JTextField();
		textFieldVille.setBounds(180, 330, 200, 25);
		contentPane.add(textFieldVille);

		JLabel lblDateNaissance = new JLabel("Date Naissance :");
		lblDateNaissance.setBounds(50, 365, 120, 25);
		contentPane.add(lblDateNaissance);
		textFieldDateNaissance = new JTextField();
		textFieldDateNaissance.setBounds(180, 365, 200, 25);
		contentPane.add(textFieldDateNaissance);

		JLabel lblLieuNaissance = new JLabel("Lieu Naissance :");
		lblLieuNaissance.setBounds(50, 400, 120, 25);
		contentPane.add(lblLieuNaissance);
		textFieldLieuNaissance = new JTextField();
		textFieldLieuNaissance.setBounds(180, 400, 200, 25);
		contentPane.add(textFieldLieuNaissance);

		JLabel lblSalaire = new JLabel("Salaire :");
		lblSalaire.setBounds(50, 435, 120, 25);
		contentPane.add(lblSalaire);
		textFieldSalaire = new JTextField();
		textFieldSalaire.setBounds(180, 435, 200, 25);
		contentPane.add(textFieldSalaire);

		JLabel lblProfession = new JLabel("Profession :");
		lblProfession.setBounds(50, 470, 120, 25);
		contentPane.add(lblProfession);
		textFieldProfession = new JTextField();
		textFieldProfession.setBounds(180, 470, 200, 25);
		contentPane.add(textFieldProfession);

		JLabel lblSituationFamiliale = new JLabel("Situation Familiale :");
		lblSituationFamiliale.setBounds(50, 505, 130, 25);
		contentPane.add(lblSituationFamiliale);
		textFieldSituationFamiliale = new JTextField();
		textFieldSituationFamiliale.setBounds(180, 505, 200, 25);
		contentPane.add(textFieldSituationFamiliale);

		// Garant
		JLabel lblGarantNom = new JLabel("Nom :");
		lblGarantNom.setBounds(500, 120, 120, 25);
		contentPane.add(lblGarantNom);
		textFieldGarantNom = new JTextField();
		textFieldGarantNom.setBounds(630, 120, 200, 25);
		contentPane.add(textFieldGarantNom);

		JLabel lblGarantPrenom = new JLabel("Prénom :");
		lblGarantPrenom.setBounds(500, 155, 120, 25);
		contentPane.add(lblGarantPrenom);
		textFieldGarantPrenom = new JTextField();
		textFieldGarantPrenom.setBounds(630, 155, 200, 25);
		contentPane.add(textFieldGarantPrenom);

		JLabel lblGarantAdresse = new JLabel("Adresse :");
		lblGarantAdresse.setBounds(500, 190, 120, 25);
		contentPane.add(lblGarantAdresse);
		textFieldGarantAdresse = new JTextField();
		textFieldGarantAdresse.setBounds(630, 190, 200, 25);
		contentPane.add(textFieldGarantAdresse);

		JLabel lblGarantTel = new JLabel("Tel :");
		lblGarantTel.setBounds(500, 225, 120, 25);
		contentPane.add(lblGarantTel);
		textFieldGarantTel = new JTextField();
		textFieldGarantTel.setBounds(630, 225, 200, 25);
		contentPane.add(textFieldGarantTel);

		// Buttons
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(580, 290, 120, 30);
		contentPane.add(btnAjouter);

		JButton btnRetour = new JButton("Annuler");
		btnRetour.setBounds(720, 290, 120, 30);
		contentPane.add(btnRetour);
	}
}
