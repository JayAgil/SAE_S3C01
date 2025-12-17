package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetreLocataire;
import modele.Locataire;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

public class FenetreLocataire extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse;
	private JTextField textFieldTel;
	private JTextField textFieldEmail;
	private JTextField textFieldDateNaissance;
	private JTextField textFieldLieuNaissance;
	private JTextField textFieldSalaire;
	private JTextField textFieldProfession;
	private JTextField textFieldSituationFamiliale;
	private GestionFenetreLocataire gestionClic;
	private JTable table;
	private String nomFenAvant;
	private JScrollPane scrollPane;
	private List<Locataire> liste;
	private JLabel lblPhoto;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FenetreLocataire frame = new FenetreLocataire("a",null);
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
	public FenetreLocataire(String nomFenAvant, List<Locataire> locataires) {
		super();
		this.nomFenAvant = nomFenAvant;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.gestionClic = new GestionFenetreLocataire(this,locataires);
		gestionClic.chargerDonnes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);

		// header
		this.setJMenuBar(createHeader());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel bottomContainer = new JPanel(new BorderLayout());
		this.gestionClic.initialize();

		// === BUTTONS PANEL ===
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new EmptyBorder(10, 10, 10, 10));
		JButton btnAjouterLocataire = new JButton("Ajouter locataire");
		btnAjouterLocataire.addActionListener(this.gestionClic);

		JButton btnPaiement = new JButton("Paiement");
		btnPaiement.addActionListener(this.gestionClic);
		panelButtons.add(btnPaiement);
		panelButtons.add(btnAjouterLocataire);

		// Add buttons to top
		bottomContainer.add(panelButtons, BorderLayout.NORTH);

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this.gestionClic);
		panelButtons.add(btnRetour);

		// === FOOTER PANEL ===
		bottomContainer.add(createFooter(), BorderLayout.SOUTH);

		// === ADD BOTH TO THE FRAME ===
		getContentPane().add(bottomContainer, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblTitre = new JLabel("Informations locataire");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTitre, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 476, 700, 0 };
		gbl_panel_2.rowHeights = new int[] { 355, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		lblPhoto = new JLabel("Photo");
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.fill = GridBagConstraints.BOTH;
		gbc_lblPhoto.insets = new Insets(0, 0, 0, 5);
		gbc_lblPhoto.gridx = 0;
		gbc_lblPhoto.gridy = 0;
		panel_2.add(lblPhoto, gbc_lblPhoto);

		Insets insets = new Insets(0, 0, 5, 5);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		// set column widths and row heights (rowHeights can remain as is)
		gbl_panel_3.columnWidths = new int[] { 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 31, 31, 31, 31, 31, 31, 31, 31, 31, 31 };
		gbl_panel_3.columnWeights = new double[] { 0.2, 0.8 }; // 20% for labels, 80% for text fields
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel_3.setLayout(gbl_panel_3);

		// Row 0
		JLabel lblNom = new JLabel("Nom :");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = insets;
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 0;
		gbc_lblNom.weightx = 0.2;
		panel_3.add(lblNom, gbc_lblNom);

		textFieldNom = new JTextField();
		textFieldNom.setEditable(false);
		textFieldNom.setBorder(null);
		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNom.gridx = 1;
		gbc_textFieldNom.gridy = 0;
		gbc_textFieldNom.weightx = 0.8;
		panel_3.add(textFieldNom, gbc_textFieldNom);

		// Row 1
		JLabel lblPrenom = new JLabel("Prénom :");
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.anchor = GridBagConstraints.EAST;
		gbc_lblPrenom.insets = insets;
		gbc_lblPrenom.gridx = 0;
		gbc_lblPrenom.gridy = 1;
		gbc_lblPrenom.weightx = 0.2;
		panel_3.add(lblPrenom, gbc_lblPrenom);

		textFieldPrenom = new JTextField();
		textFieldPrenom.setEditable(false);
		textFieldPrenom.setBorder(null);
		GridBagConstraints gbc_textFieldPrenom = new GridBagConstraints();
		gbc_textFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenom.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPrenom.gridx = 1;
		gbc_textFieldPrenom.gridy = 1;
		gbc_textFieldPrenom.weightx = 0.8;
		panel_3.add(textFieldPrenom, gbc_textFieldPrenom);

		// Row 2
		JLabel lblAdresse = new JLabel("Adresse :");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.EAST;
		gbc_lblAdresse.insets = insets;
		gbc_lblAdresse.gridx = 0;
		gbc_lblAdresse.gridy = 2;
		gbc_lblAdresse.weightx = 0.2;
		panel_3.add(lblAdresse, gbc_lblAdresse);

		textFieldAdresse = new JTextField();
		textFieldAdresse.setEditable(false);
		textFieldAdresse.setBorder(null);
		GridBagConstraints gbc_textFieldAdresse = new GridBagConstraints();
		gbc_textFieldAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAdresse.gridx = 1;
		gbc_textFieldAdresse.gridy = 2;
		gbc_textFieldAdresse.weightx = 0.8;
		panel_3.add(textFieldAdresse, gbc_textFieldAdresse);

		// Repeat the same pattern for the remaining rows
		// Tél
		JLabel lblTel = new JLabel("Tél :");
		GridBagConstraints gbc_lblTel = new GridBagConstraints();
		gbc_lblTel.anchor = GridBagConstraints.EAST;
		gbc_lblTel.insets = insets;
		gbc_lblTel.gridx = 0;
		gbc_lblTel.gridy = 3;
		gbc_lblTel.weightx = 0.2;
		panel_3.add(lblTel, gbc_lblTel);

		textFieldTel = new JTextField();
		textFieldTel.setEditable(false);
		textFieldTel.setBorder(null);
		GridBagConstraints gbc_textFieldTel = new GridBagConstraints();
		gbc_textFieldTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTel.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTel.gridx = 1;
		gbc_textFieldTel.gridy = 3;
		gbc_textFieldTel.weightx = 0.8;
		panel_3.add(textFieldTel, gbc_textFieldTel);

		// Email
		JLabel lblEmail = new JLabel("Email :");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = insets;
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		gbc_lblEmail.weightx = 0.2;
		panel_3.add(lblEmail, gbc_lblEmail);
		

		textFieldEmail = new JTextField();
		textFieldEmail.setBorder(null);
		textFieldEmail.setEditable(false);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 4;
		gbc_textFieldEmail.weightx = 0.8;
		panel_3.add(textFieldEmail, gbc_textFieldEmail);

		// Date de naissance
		JLabel lblDateNaissance = new JLabel("Date de naissance :");
		GridBagConstraints gbc_lblDateNaissance = new GridBagConstraints();
		gbc_lblDateNaissance.anchor = GridBagConstraints.EAST;
		gbc_lblDateNaissance.insets = insets;
		gbc_lblDateNaissance.gridx = 0;
		gbc_lblDateNaissance.gridy = 5;
		gbc_lblDateNaissance.weightx = 0.2;
		panel_3.add(lblDateNaissance, gbc_lblDateNaissance);
		

		textFieldDateNaissance = new JTextField();
		textFieldDateNaissance.setBorder(null);
		textFieldDateNaissance.setEditable(false);
		GridBagConstraints gbc_textFieldDateNaissance = new GridBagConstraints();
		gbc_textFieldDateNaissance.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDateNaissance.insets = insets;
		gbc_textFieldDateNaissance.gridx = 1;
		gbc_textFieldDateNaissance.gridy = 5;
		gbc_textFieldDateNaissance.weightx = 0.8;
		panel_3.add(textFieldDateNaissance, gbc_textFieldDateNaissance);

		// Lieu de naissance
		JLabel lblLieuNaissance = new JLabel("Lieu de naissance :");
		GridBagConstraints gbc_lblLieuNaissance = new GridBagConstraints();
		gbc_lblLieuNaissance.anchor = GridBagConstraints.EAST;
		gbc_lblLieuNaissance.insets = insets;
		gbc_lblLieuNaissance.gridx = 0;
		gbc_lblLieuNaissance.gridy = 6;
		gbc_lblLieuNaissance.weightx = 0.2;
		panel_3.add(lblLieuNaissance, gbc_lblLieuNaissance);
		
	
		textFieldLieuNaissance = new JTextField();
		textFieldLieuNaissance.setBorder(null);
		textFieldLieuNaissance.setEditable(false);
		GridBagConstraints gbc_textFieldLieuNaissance = new GridBagConstraints();
		gbc_textFieldLieuNaissance.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLieuNaissance.insets = insets;
		gbc_textFieldLieuNaissance.gridx = 1;
		gbc_textFieldLieuNaissance.gridy = 6;
		gbc_textFieldLieuNaissance.weightx = 0.8;
		panel_3.add(textFieldLieuNaissance, gbc_textFieldLieuNaissance);

		// Salaire
		JLabel lblSalaire = new JLabel("Salaire :");
		GridBagConstraints gbc_lblSalaire = new GridBagConstraints();
		gbc_lblSalaire.anchor = GridBagConstraints.EAST;
		gbc_lblSalaire.insets = insets;
		gbc_lblSalaire.gridx = 0;
		gbc_lblSalaire.gridy = 7;
		gbc_lblSalaire.weightx = 0.2;
		panel_3.add(lblSalaire, gbc_lblSalaire);
		

		textFieldSalaire = new JTextField();
		textFieldSalaire.setBorder(null);
		textFieldSalaire.setEditable(false);
		GridBagConstraints gbc_textFieldSalaire = new GridBagConstraints();
		gbc_textFieldSalaire.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSalaire.insets = insets;
		gbc_textFieldSalaire.gridx = 1;
		gbc_textFieldSalaire.gridy = 7;
		gbc_textFieldSalaire.weightx = 0.8;
		panel_3.add(textFieldSalaire, gbc_textFieldSalaire);

		// Profession
		JLabel lblProfession = new JLabel("Profession :");
		GridBagConstraints gbc_lblProfession = new GridBagConstraints();
		gbc_lblProfession.anchor = GridBagConstraints.EAST;
		gbc_lblProfession.insets = insets;
		gbc_lblProfession.gridx = 0;
		gbc_lblProfession.gridy = 8;
		gbc_lblProfession.weightx = 0.2;
		panel_3.add(lblProfession, gbc_lblProfession);
		
		
		textFieldProfession = new JTextField();
		textFieldProfession.setBorder(null);
		textFieldProfession.setEditable(false);
		GridBagConstraints gbc_textFieldProfession = new GridBagConstraints();
		gbc_textFieldProfession.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProfession.insets = insets;
		gbc_textFieldProfession.gridx = 1;
		gbc_textFieldProfession.gridy = 8;
		gbc_textFieldProfession.weightx = 0.8;
		panel_3.add(textFieldProfession, gbc_textFieldProfession);

		// Situation familiale
		JLabel lblSituationFamiliale = new JLabel("Situation familiale :");
		GridBagConstraints gbc_lblSituationFamiliale = new GridBagConstraints();
		gbc_lblSituationFamiliale.anchor = GridBagConstraints.EAST;
		gbc_lblSituationFamiliale.insets = insets;
		gbc_lblSituationFamiliale.gridx = 0;
		gbc_lblSituationFamiliale.gridy = 9;
		gbc_lblSituationFamiliale.weightx = 0.2;
		panel_3.add(lblSituationFamiliale, gbc_lblSituationFamiliale);
		
		textFieldSituationFamiliale = new JTextField();
		textFieldSituationFamiliale.setBorder(null);
		textFieldSituationFamiliale.setEditable(false);
		GridBagConstraints gbc_textFieldSituationFamiliale = new GridBagConstraints();
		gbc_textFieldSituationFamiliale.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSituationFamiliale.insets = insets;
		gbc_textFieldSituationFamiliale.gridx = 1;
		gbc_textFieldSituationFamiliale.gridy = 9;
		gbc_textFieldSituationFamiliale.weightx = 0.8;
		panel_3.add(textFieldSituationFamiliale, gbc_textFieldSituationFamiliale);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_5.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "Id Locataire", "Nom", "Prenom", "Adresse", "Tel", "Email" }));
		scrollPane.setViewportView(table);

	}
	

	public JLabel getLblPhoto() {
		return lblPhoto;
	}

	public List<Locataire> getListe() {
		return liste;
	}

	public void setListe(List<Locataire> liste) {
		this.liste = liste;
	}

	public void disableMenuItems(boolean actif) {

		if (this.nomFenAvant == "FenetrePrincipale") {
			this.mnBatiment.setEnabled(actif);
		}
		if (this.nomFenAvant == "FenetreBienLouable") {
			this.mnBatiment.setEnabled(actif);
			this.mntmLocataire.setEnabled(actif);
		}
	}

	public JTextField getTextFieldNom() {
		return textFieldNom;
	}

	public void setTextFieldNom(JTextField textFieldNom) {
		this.textFieldNom = textFieldNom;
	}

	public JTextField getTextFieldPrenom() {
		return textFieldPrenom;
	}

	public void setTextFieldPrenom(JTextField textFieldPrenom) {
		this.textFieldPrenom = textFieldPrenom;
	}

	public JTextField getTextFieldAdresse() {
		return textFieldAdresse;
	}

	public void setTextFieldAdresse(JTextField textField) {
		this.textFieldAdresse = textField;
	}

	public JTextField getTextFieldTel() {
		return textFieldTel;
	}

	public void setTextFieldTel(JTextField textFieldTel) {
		this.textFieldTel = textFieldTel;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public void setTextFieldEmail(JTextField textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}

	public JTextField getTextFieldDateNaissance() {
		return textFieldDateNaissance;
	}

	public void setTextFieldDateNaissance(JTextField textFieldDateNaissance) {
		this.textFieldDateNaissance = textFieldDateNaissance;
	}

	public JTextField getTextFieldLieuNaissance() {
		return textFieldLieuNaissance;
	}

	public void setTextFieldLieuNaissance(JTextField textFieldLieuNaissance) {
		this.textFieldLieuNaissance = textFieldLieuNaissance;
	}

	public JTextField getTextFieldSalaire() {
		return textFieldSalaire;
	}

	public void setTextFieldSalaire(JTextField textFieldSalaire) {
		this.textFieldSalaire = textFieldSalaire;
	}

	public JTextField getTextFieldProfession() {
		return textFieldProfession;
	}

	public void setTextFieldProfession(JTextField textFieldProfession) {
		this.textFieldProfession = textFieldProfession;
	}

	public JTextField getTextFieldSituationFamiliale() {
		return textFieldSituationFamiliale;
	}

	public void setTextFieldSituationFamiliale(JTextField textFieldSituationFamiliale) {
		this.textFieldSituationFamiliale = textFieldSituationFamiliale;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	public String getNomFenAvant() {
		return this.nomFenAvant;
	}
	
	

}