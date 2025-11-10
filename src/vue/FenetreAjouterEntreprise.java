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
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(50, 50, 441, 440);
		setTitle("Ajouter Entreprise");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitre = new JLabel("Ajouter Entreprise");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitre.setBounds(50, 10, 300, 30);
		contentPane.add(lblTitre);

		JLabel lblSiret = new JLabel("Numéro Siret :");
		lblSiret.setBounds(50, 60, 100, 25);
		contentPane.add(lblSiret);

		textFieldSiret = new JTextField();
		textFieldSiret.setBounds(160, 60, 200, 25);
		contentPane.add(textFieldSiret);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(50, 100, 100, 25);
		contentPane.add(lblNom);

		textFieldNom = new JTextField();
		textFieldNom.setBounds(160, 100, 200, 25);
		contentPane.add(textFieldNom);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(50, 140, 100, 25);
		contentPane.add(lblAdresse);

		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(160, 140, 200, 25);
		contentPane.add(textFieldAdresse);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(50, 180, 100, 25);
		contentPane.add(lblVille);

		textFieldVille = new JTextField();
		textFieldVille.setBounds(160, 180, 200, 25);
		contentPane.add(textFieldVille);

		JLabel lblCodePostal = new JLabel("Code Postal :");
		lblCodePostal.setBounds(50, 220, 100, 25);
		contentPane.add(lblCodePostal);

		textFieldCodePostal = new JTextField();
		textFieldCodePostal.setBounds(160, 220, 200, 25);
		contentPane.add(textFieldCodePostal);

		JLabel lblTel = new JLabel("Numéro de téléphone :");
		lblTel.setBounds(50, 260, 140, 25);
		contentPane.add(lblTel);

		textFieldTel = new JTextField();
		textFieldTel.setBounds(160, 260, 200, 25);
		contentPane.add(textFieldTel);

		JLabel lblSpecialite = new JLabel("Spécialité :");
		lblSpecialite.setBounds(50, 300, 100, 25);
		contentPane.add(lblSpecialite);

		textFieldSpecialite = new JTextField();
		textFieldSpecialite.setBounds(160, 300, 200, 25);
		contentPane.add(textFieldSpecialite);

		JButton btnRetour = new JButton("Annuler");
		btnRetour.setBounds(90, 345, 100, 30);
		contentPane.add(btnRetour);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(214, 345, 100, 30);
		contentPane.add(btnAjouter);
	}
}
