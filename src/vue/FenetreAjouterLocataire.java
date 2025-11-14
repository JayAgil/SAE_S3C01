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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreAjouterLocataire extends JInternalFrame implements ActionListener {

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
		setBounds(50, 50, 400, 451);
		setTitle("Ajouter Locataire");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLocataire = new JLabel("Informations Locataire");
		lblLocataire.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocataire.setBounds(0, 0, 384, 30);
		contentPane.add(lblLocataire);

		JLabel lblGarant = new JLabel("Informations Garant");
		lblGarant.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGarant.setHorizontalAlignment(SwingConstants.CENTER);
		lblGarant.setBounds(0, 257, 384, 40);
		contentPane.add(lblGarant);

		// Locataire
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(23, 29, 120, 25);
		contentPane.add(lblNom);
		textFieldNom = new JTextField();
		textFieldNom.setBounds(85, 29, 105, 25);
		contentPane.add(textFieldNom);

		JLabel lblPrenom = new JLabel("Prénom :");
		lblPrenom.setBounds(23, 65, 120, 25);
		contentPane.add(lblPrenom);
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(85, 65, 105, 25);
		contentPane.add(textFieldPrenom);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(23, 101, 120, 25);
		contentPane.add(lblAdresse);
		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(85, 101, 105, 47);
		contentPane.add(textFieldAdresse);

		JLabel lblTel = new JLabel("Tel :");
		lblTel.setBounds(23, 159, 120, 25);
		contentPane.add(lblTel);
		textFieldTel = new JTextField();
		textFieldTel.setBounds(85, 159, 105, 25);
		contentPane.add(textFieldTel);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(23, 195, 120, 25);
		contentPane.add(lblEmail);
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(85, 195, 105, 25);
		contentPane.add(textFieldEmail);

		JLabel lblCodePostal = new JLabel("Code Postal :");
		lblCodePostal.setBounds(23, 231, 120, 25);
		contentPane.add(lblCodePostal);
		textFieldCodePostal = new JTextField();
		textFieldCodePostal.setBounds(104, 231, 86, 25);
		contentPane.add(textFieldCodePostal);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(200, 29, 120, 25);
		contentPane.add(lblVille);
		textFieldVille = new JTextField();
		textFieldVille.setBounds(234, 29, 86, 25);
		contentPane.add(textFieldVille);

		JLabel lblDateNaissance = new JLabel("Date Naissance :");
		lblDateNaissance.setBounds(200, 65, 120, 25);
		contentPane.add(lblDateNaissance);
		textFieldDateNaissance = new JTextField();
		textFieldDateNaissance.setBounds(291, 65, 69, 25);
		contentPane.add(textFieldDateNaissance);

		JLabel lblLieuNaissance = new JLabel("Lieu Naissance :");
		lblLieuNaissance.setBounds(200, 101, 120, 25);
		contentPane.add(lblLieuNaissance);
		textFieldLieuNaissance = new JTextField();
		textFieldLieuNaissance.setBounds(291, 101, 69, 25);
		contentPane.add(textFieldLieuNaissance);

		JLabel lblSalaire = new JLabel("Salaire :");
		lblSalaire.setBounds(200, 137, 120, 25);
		contentPane.add(lblSalaire);
		textFieldSalaire = new JTextField();
		textFieldSalaire.setBounds(247, 137, 69, 25);
		contentPane.add(textFieldSalaire);

		JLabel lblProfession = new JLabel("Profession :");
		lblProfession.setBounds(200, 173, 120, 25);
		contentPane.add(lblProfession);
		textFieldProfession = new JTextField();
		textFieldProfession.setBounds(268, 173, 92, 25);
		contentPane.add(textFieldProfession);

		JLabel lblSituationFamiliale = new JLabel("Situation Familiale :");
		lblSituationFamiliale.setBounds(200, 209, 105, 25);
		contentPane.add(lblSituationFamiliale);
		textFieldSituationFamiliale = new JTextField();
		textFieldSituationFamiliale.setBounds(304, 208, 56, 25);
		contentPane.add(textFieldSituationFamiliale);

		// Garant
		JLabel lblGarantNom = new JLabel("Nom :");
		lblGarantNom.setBounds(23, 305, 120, 25);
		contentPane.add(lblGarantNom);
		textFieldGarantNom = new JTextField();
		textFieldGarantNom.setBounds(85, 305, 105, 25);
		contentPane.add(textFieldGarantNom);

		JLabel lblGarantPrenom = new JLabel("Prénom :");
		lblGarantPrenom.setBounds(23, 341, 120, 25);
		contentPane.add(lblGarantPrenom);
		textFieldGarantPrenom = new JTextField();
		textFieldGarantPrenom.setBounds(85, 341, 105, 25);
		contentPane.add(textFieldGarantPrenom);

		JLabel lblGarantAdresse = new JLabel("Adresse :");
		lblGarantAdresse.setBounds(200, 305, 120, 25);
		contentPane.add(lblGarantAdresse);
		textFieldGarantAdresse = new JTextField();
		textFieldGarantAdresse.setBounds(252, 305, 105, 25);
		contentPane.add(textFieldGarantAdresse);

		JLabel lblGarantTel = new JLabel("Tel :");
		lblGarantTel.setBounds(200, 341, 120, 25);
		contentPane.add(lblGarantTel);
		textFieldGarantTel = new JTextField();
		textFieldGarantTel.setBounds(252, 341, 105, 25);
		contentPane.add(textFieldGarantTel);

		// Buttons
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this);
		btnAjouter.setBounds(62, 380, 98, 30);
		contentPane.add(btnAjouter);

		JButton btnRetour = new JButton("Annuler");
		btnRetour.addActionListener(this);
		btnRetour.setBounds(234, 380, 98, 30);
		contentPane.add(btnRetour);
	}
	public void actionPerformed(ActionEvent e) {
	}
}
