package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import controleur.GestionFenetreAssurance;
import modele.Assurance;

public class FenetreAssurance extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private GestionFenetreAssurance gestionClic;

	private JTextField textFieldNumAssurance;
	private JTextField txtFieldPrime;
	private JTextField txtFieldMontant;
	private JTextField txtFieldType;
	private JTextField textFieldAgence;
	private JTextField textFieldAdresseAgence;
	private JTextField textFieldTelAgence;
	private JPanel panelNombreBien;
	private JLabel lblNbBien;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAssurance frame = new FenetreAssurance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FenetreAssurance() {
		super();
		setTitle("Assurance");
		setSize(600, 650);
		setResizable(false);
		gestionClic = new GestionFenetreAssurance(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(10, 10));
		this.setJMenuBar(createHeader());

		
		this.gestionClic.initialize();
		JPanel panelCenter = new JPanel(new GridBagLayout());
		contentPane.add(panelCenter, BorderLayout.CENTER);

		int row = 0;

		JLabel lblTitre = new JLabel("Assurance");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.gridwidth = 2;
		gbc_lblTitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitre.gridx = 0;
		gbc_lblTitre.gridy = 0;
		panelCenter.add(lblTitre, gbc_lblTitre);

		panelNombreBien = new JPanel();
		panelNombreBien.setBorder(
				new TitledBorder(new EtchedBorder(), "Biens louables assurés", TitledBorder.CENTER, TitledBorder.TOP));
		panelNombreBien.setPreferredSize(new Dimension(200, 80));
		lblNbBien = new JLabel("3", SwingConstants.CENTER);
		lblNbBien.setFont(new Font("Tahoma", Font.BOLD, 24));
		panelNombreBien.add(lblNbBien);

		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.insets = new Insets(10, 10, 10, 10);
		gbcPanel.fill = GridBagConstraints.HORIZONTAL;
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		gbcPanel.gridwidth = 2;
		panelCenter.add(panelNombreBien, gbcPanel);

		row++;

		GridBagConstraints gbcLabel1 = new GridBagConstraints();
		gbcLabel1.insets = new Insets(10, 10, 10, 10);
		gbcLabel1.fill = GridBagConstraints.HORIZONTAL;
		gbcLabel1.gridx = 0;
		gbcLabel1.gridy = 2;
		gbcLabel1.anchor = GridBagConstraints.EAST;
		JLabel lblNumAssurance = new JLabel("Numéro d'assurance :");
		panelCenter.add(lblNumAssurance, gbcLabel1);

		textFieldNumAssurance = new JTextField(15);
		GridBagConstraints gbcTextField1 = new GridBagConstraints();
		gbcTextField1.insets = new Insets(10, 10, 10, 10);
		gbcTextField1.fill = GridBagConstraints.HORIZONTAL;
		gbcTextField1.gridx = 1;
		gbcTextField1.gridy = 2;
		gbcTextField1.anchor = GridBagConstraints.WEST;
		panelCenter.add(textFieldNumAssurance, gbcTextField1);
		row++;

		GridBagConstraints gbcLabel2 = new GridBagConstraints();
		gbcLabel2.insets = new Insets(10, 10, 10, 10);
		gbcLabel2.fill = GridBagConstraints.HORIZONTAL;
		gbcLabel2.gridx = 0;
		gbcLabel2.gridy = 3;
		gbcLabel2.anchor = GridBagConstraints.EAST;
		JLabel lblPrime = new JLabel("Prime :");
		panelCenter.add(lblPrime, gbcLabel2);

		txtFieldPrime = new JTextField(15);
		GridBagConstraints gbcTextField2 = new GridBagConstraints();
		gbcTextField2.insets = new Insets(10, 10, 10, 10);
		gbcTextField2.fill = GridBagConstraints.HORIZONTAL;
		gbcTextField2.gridx = 1;
		gbcTextField2.gridy = 3;
		gbcTextField2.anchor = GridBagConstraints.WEST;
		panelCenter.add(txtFieldPrime, gbcTextField2);
		row++;

		GridBagConstraints gbcLabel3 = new GridBagConstraints();
		gbcLabel3.insets = new Insets(10, 10, 10, 10);
		gbcLabel3.fill = GridBagConstraints.HORIZONTAL;
		gbcLabel3.gridx = 0;
		gbcLabel3.gridy = 4;
		gbcLabel3.anchor = GridBagConstraints.EAST;
		JLabel lblMontant = new JLabel("Montant :");
		panelCenter.add(lblMontant, gbcLabel3);

		txtFieldMontant = new JTextField(15);
		GridBagConstraints gbcTextField3 = new GridBagConstraints();
		gbcTextField3.insets = new Insets(10, 10, 10, 10);
		gbcTextField3.fill = GridBagConstraints.HORIZONTAL;
		gbcTextField3.gridx = 1;
		gbcTextField3.gridy = 4;
		gbcTextField3.anchor = GridBagConstraints.WEST;
		panelCenter.add(txtFieldMontant, gbcTextField3);
		row++;

		GridBagConstraints gbcLabel4 = new GridBagConstraints();
		gbcLabel4.insets = new Insets(10, 10, 10, 10);
		gbcLabel4.fill = GridBagConstraints.HORIZONTAL;
		gbcLabel4.gridx = 0;
		gbcLabel4.gridy = 5;
		gbcLabel4.anchor = GridBagConstraints.EAST;
		JLabel lblType = new JLabel("Type assurance :");
		panelCenter.add(lblType, gbcLabel4);

		txtFieldType = new JTextField(15);
		GridBagConstraints gbcTextField4 = new GridBagConstraints();
		gbcTextField4.insets = new Insets(10, 10, 10, 10);
		gbcTextField4.fill = GridBagConstraints.HORIZONTAL;
		gbcTextField4.gridx = 1;
		gbcTextField4.gridy = 5;
		gbcTextField4.anchor = GridBagConstraints.WEST;
		panelCenter.add(txtFieldType, gbcTextField4);
		row++;

		GridBagConstraints gbcLabel5 = new GridBagConstraints();
		gbcLabel5.insets = new Insets(10, 10, 10, 10);
		gbcLabel5.fill = GridBagConstraints.HORIZONTAL;
		gbcLabel5.gridx = 0;
		gbcLabel5.gridy = 6;
		gbcLabel5.anchor = GridBagConstraints.EAST;
		JLabel lblAgence = new JLabel("Agence :");
		panelCenter.add(lblAgence, gbcLabel5);

		textFieldAgence = new JTextField(15);
		GridBagConstraints gbcTextField5 = new GridBagConstraints();
		gbcTextField5.insets = new Insets(10, 10, 10, 10);
		gbcTextField5.fill = GridBagConstraints.HORIZONTAL;
		gbcTextField5.gridx = 1;
		gbcTextField5.gridy = 6;
		gbcTextField5.anchor = GridBagConstraints.WEST;
		panelCenter.add(textFieldAgence, gbcTextField5);
		row++;

		GridBagConstraints gbcLabel6 = new GridBagConstraints();
		gbcLabel6.insets = new Insets(10, 10, 10, 10);
		gbcLabel6.fill = GridBagConstraints.HORIZONTAL;
		gbcLabel6.gridx = 0;
		gbcLabel6.gridy = 7;
		gbcLabel6.anchor = GridBagConstraints.EAST;
		JLabel lblAdresse = new JLabel("Adresse agence :");
		panelCenter.add(lblAdresse, gbcLabel6);

		textFieldAdresseAgence = new JTextField(15);
		GridBagConstraints gbcTextField6 = new GridBagConstraints();
		gbcTextField6.insets = new Insets(10, 10, 10, 10);
		gbcTextField6.fill = GridBagConstraints.HORIZONTAL;
		gbcTextField6.gridx = 1;
		gbcTextField6.gridy = 7;
		gbcTextField6.anchor = GridBagConstraints.WEST;
		panelCenter.add(textFieldAdresseAgence, gbcTextField6);
		row++;

		GridBagConstraints gbcLabel7 = new GridBagConstraints();
		gbcLabel7.insets = new Insets(10, 10, 10, 10);
		gbcLabel7.fill = GridBagConstraints.HORIZONTAL;
		gbcLabel7.gridx = 0;
		gbcLabel7.gridy = 8;
		gbcLabel7.anchor = GridBagConstraints.EAST;
		JLabel lblTel = new JLabel("Téléphone agence :");
		panelCenter.add(lblTel, gbcLabel7);

		textFieldTelAgence = new JTextField(15);
		GridBagConstraints gbcTextField7 = new GridBagConstraints();
		gbcTextField7.insets = new Insets(10, 10, 10, 10);
		gbcTextField7.fill = GridBagConstraints.HORIZONTAL;
		gbcTextField7.gridx = 1;
		gbcTextField7.gridy = 8;
		gbcTextField7.anchor = GridBagConstraints.WEST;
		panelCenter.add(textFieldTelAgence, gbcTextField7);
		row++;

		JPanel southPanel = new JPanel(new BorderLayout());

		JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JButton btnAjouter = new JButton("Ajouter assurance");
		btnAjouter.addActionListener(gestionClic);
		panelButtons.add(btnAjouter);

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(gestionClic);
		panelButtons.add(btnRetour);

		southPanel.add(panelButtons, BorderLayout.NORTH);

		southPanel.add(createFooter(), BorderLayout.SOUTH);


		contentPane.add(southPanel, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public JTextField getTextFieldNumAssurance() {
		return textFieldNumAssurance;
	}

	public void setTextFieldNumAssurance(JTextField textFieldNumAssurance) {
		this.textFieldNumAssurance = textFieldNumAssurance;
	}

	public JTextField getTxtFieldPrime() {
		return txtFieldPrime;
	}

	public void setTxtFieldPrime(JTextField txtFieldPrime) {
		this.txtFieldPrime = txtFieldPrime;
	}

	public JTextField getTxtFieldMontant() {
		return txtFieldMontant;
	}

	public void setTxtFieldMontant(JTextField txtFieldMontant) {
		this.txtFieldMontant = txtFieldMontant;
	}

	public JTextField getTxtFieldType() {
		return txtFieldType;
	}

	public void setTxtFieldType(JTextField txtFieldType) {
		this.txtFieldType = txtFieldType;
	}

	public JTextField getTextFieldAgence() {
		return textFieldAgence;
	}

	public void setTextFieldAgence(JTextField textFieldAgence) {
		this.textFieldAgence = textFieldAgence;
	}

	public JTextField getTextFieldAdresseAgence() {
		return textFieldAdresseAgence;
	}

	public void setTextFieldAdresseAgence(JTextField textFieldAdresseAgence) {
		this.textFieldAdresseAgence = textFieldAdresseAgence;
	}

	public JTextField getTextFieldTelAgence() {
		return textFieldTelAgence;
	}

	public void setTextFieldTelAgence(JTextField textFieldTelAgence) {
		this.textFieldTelAgence = textFieldTelAgence;
	}

	public JLabel getLblNbBien() {
		return lblNbBien;
	}

	public void setLblNbBien(JLabel lblNbBien) {
		this.lblNbBien = lblNbBien;
	}

	public void disableMenuItems(boolean actif) {
		this.mntmAssurance.setEnabled(actif);
		this.mnBienLouable.setEnabled(actif);
		this.mnPaiement.setEnabled(actif);
	}
	
	public void afficherAssuranceBatiment(Assurance assurance, int nbBiens) {
	    this.textFieldNumAssurance.setText(assurance.getNumeroAssurance());
	    this.txtFieldPrime.setText(String.valueOf(assurance.getPrime()));
	    this.txtFieldType.setText(assurance.getTypeAssurance());
	    this.textFieldAgence.setText(assurance.getAgence());
	    this.textFieldAdresseAgence.setText(assurance.getAdresseAgence());
	    this.textFieldTelAgence.setText(assurance.getTelAgence());
	    lblNbBien.setText(String.valueOf(nbBiens));
	}
}