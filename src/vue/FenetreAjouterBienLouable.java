package vue;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionFenetreAjouterAssurance;
import controleur.GestionFenetreAjouterBienLouable;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class FenetreAjouterBienLouable extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFieldBienLouable;
	private JTextField textFieldNumFiscale;
	private JTextField textFieldAddr;
	private JTextField txtFieldSurface;
	private JTextField textFieldNbPieces;
	private JTextField textFieldType;
	private GestionFenetreAjouterBienLouable gestionClic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAjouterBienLouable frame = new FenetreAjouterBienLouable();
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
	public FenetreAjouterBienLouable() {
		setResizable(false);
		this.gestionClic = new GestionFenetreAjouterBienLouable(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -17, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitre = new JLabel("Ajouter Bien Louable");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setBounds(131, 29, 187, 29);
		contentPane.add(lblTitre);

		JLabel lblIDBienLouable = new JLabel("ID Bien Louable :");
		lblIDBienLouable.setBounds(106, 92, 80, 13);
		contentPane.add(lblIDBienLouable);

		txtFieldBienLouable = new JTextField();
		txtFieldBienLouable.setBounds(219, 89, 96, 19);
		contentPane.add(txtFieldBienLouable);
		txtFieldBienLouable.setColumns(10);

		JLabel lblNumFiscale = new JLabel("Numéro Fiscale :");
		lblNumFiscale.setBounds(106, 141, 79, 13);
		contentPane.add(lblNumFiscale);

		textFieldNumFiscale = new JTextField();
		textFieldNumFiscale.setBounds(219, 138, 96, 19);
		contentPane.add(textFieldNumFiscale);
		textFieldNumFiscale.setColumns(10);

		textFieldAddr = new JTextField();
		textFieldAddr.setColumns(10);
		textFieldAddr.setBounds(219, 184, 96, 19);
		contentPane.add(textFieldAddr);

		txtFieldSurface = new JTextField();
		txtFieldSurface.setColumns(10);
		txtFieldSurface.setBounds(219, 232, 96, 19);
		contentPane.add(txtFieldSurface);

		textFieldNbPieces = new JTextField();
		textFieldNbPieces.setColumns(10);
		textFieldNbPieces.setBounds(219, 275, 96, 19);
		contentPane.add(textFieldNbPieces);

		textFieldType = new JTextField();
		textFieldType.setColumns(10);
		textFieldType.setBounds(219, 321, 96, 19);
		contentPane.add(textFieldType);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAdresse.setBounds(131, 187, 54, 13);
		contentPane.add(lblAdresse);

		JLabel lblSurface = new JLabel("Surface d'habituable :");
		lblSurface.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurface.setBounds(23, 235, 162, 13);
		contentPane.add(lblSurface);

		JLabel lblNbPiece = new JLabel("Nombre de pieces :");
		lblNbPiece.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNbPiece.setBounds(90, 278, 95, 13);
		contentPane.add(lblNbPiece);

		JLabel lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(105, 324, 80, 13);
		contentPane.add(lblType);

		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(90, 414, 85, 21);
		contentPane.add(btnValider);

		JButton btnAnnuler = new JButton("Annuler ");
		btnAnnuler.setBounds(188, 414, 85, 21);
		contentPane.add(btnAnnuler);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(283, 414, 85, 21);
		contentPane.add(btnRetour);

		btnAnnuler.addActionListener(this.gestionClic);
		btnValider.addActionListener(this.gestionClic);
		btnRetour.addActionListener(this.gestionClic);

	}
}
