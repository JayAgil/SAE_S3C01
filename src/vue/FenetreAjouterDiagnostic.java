package vue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import controleur.GestionFenetreAjouterDiagnostic;
import controleur.GestionFenetreDiagnostic;
import modele.BienLouable;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class FenetreAjouterDiagnostic extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldIdDiagnostic;
	private JTextField textFieldType;
	private JTextField textFieldDateRealisation;
	private JTextField textFieldDateValidité;
	private JTextField textFieldFichier;
	private BienLouable b;
	private GestionFenetreDiagnostic parent;

	private GestionFenetreAjouterDiagnostic gestionClic;

	public FenetreAjouterDiagnostic(BienLouable b, GestionFenetreDiagnostic parent) {
		setResizable(false);
		this.b = b;
		this.parent = parent;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitre = new JLabel("Ajouter un diagnostic");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setBounds(0, 37, 434, 29);
		contentPane.add(lblTitre);

		int labelX = 40;
		int labelW = 110;
		int fieldX = 160;
		int fieldW = 180;
		int fieldH = 22;

		JLabel lblId = new JLabel("ID Diagnostic :");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(27, 115, labelW, 20);
		contentPane.add(lblId);

		textFieldIdDiagnostic = new JTextField();
		textFieldIdDiagnostic.setBounds(fieldX, 114, fieldW, fieldH);
		contentPane.add(textFieldIdDiagnostic);

		JLabel lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(27, 163, labelW, 20);
		contentPane.add(lblType);

		textFieldType = new JTextField();
		textFieldType.setBounds(fieldX, 163, fieldW, fieldH);
		contentPane.add(textFieldType);

		JLabel lblDateRealisation = new JLabel("Date réalisation :");
		lblDateRealisation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateRealisation.setBounds(27, 209, labelW, 20);
		contentPane.add(lblDateRealisation);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormatter dateFormatter = new DateFormatter(format);
		dateFormatter.setAllowsInvalid(false);

		textFieldDateRealisation = new JFormattedTextField(dateFormatter);
		textFieldDateRealisation.setBounds(fieldX, 209, fieldW, fieldH);
		textFieldDateRealisation.setToolTipText("Format attendu : yyyy-MM-dd");
		contentPane.add(textFieldDateRealisation);

		JLabel lblTypeDateValidite = new JLabel("Date Validité :");
		lblTypeDateValidite.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTypeDateValidite.setBounds(27, 257, 110, 20);
		contentPane.add(lblTypeDateValidite);

		textFieldDateValidité = new JFormattedTextField(dateFormatter);
		textFieldDateValidité.setBounds(fieldX, 257, fieldW, fieldH);
		textFieldDateValidité.setToolTipText("Format attendu : yyyy-MM-dd");
		contentPane.add(textFieldDateValidité);

		JLabel lblFichier = new JLabel("Fichier : ");
		lblFichier.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFichier.setBounds(27, 300, labelW, 20);
		contentPane.add(lblFichier);

		textFieldFichier = new JTextField();
		textFieldFichier.setBounds(160, 300, 180, 22);
		contentPane.add(textFieldFichier);

		JButton btnChoisir = new JButton("Choisir");
		btnChoisir.setBounds(255, 332, 85, 22);
		contentPane.add(btnChoisir);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(50, 397, 100, 25);
		contentPane.add(btnAjouter);

		JButton btnVider = new JButton("Vider");
		btnVider.setBounds(171, 397, 100, 25);
		contentPane.add(btnVider);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(289, 397, 100, 25);
		contentPane.add(btnRetour);
		
		this.gestionClic = new GestionFenetreAjouterDiagnostic(this, b, parent);
		btnChoisir.addActionListener(this.gestionClic);
		btnVider.addActionListener(this.gestionClic);
		btnAjouter.addActionListener(this.gestionClic);
		btnRetour.addActionListener(this.gestionClic);
	}

	public List<JTextField> getAllDiagnosticTextFields() {
		List<JTextField> fields = new ArrayList<>();
		fields.add(textFieldIdDiagnostic);
		fields.add(textFieldType);
		fields.add(textFieldDateRealisation);
		fields.add(textFieldDateValidité);
		fields.add(textFieldFichier);
		return fields;
	}

	public JTextField getTextFieldFichier() {
		return textFieldFichier;
	}

	public void setTextFieldFichier(JTextField textFieldFichier) {
		this.textFieldFichier = textFieldFichier;
	}

}
