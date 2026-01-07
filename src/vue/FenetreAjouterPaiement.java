package vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import controleur.GestionFenetreAjouterPaiement;
import controleur.GestionFenetrePaiement;
import modele.ContratLocation;
import modele.Locataire;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;
import javax.swing.Box;

public class FenetreAjouterPaiement extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestionFenetreAjouterPaiement gestionClic;
	private JTextField champDate;
	private JTextField textFieldMontant;
	private JTextField textFieldIdPaiement;
	private JTextField textFieldDesignation;
	private JComboBox<ContratLocation> comboBox;
	private GestionFenetrePaiement parent;
	private Locataire locataireSelectionne;

	public FenetreAjouterPaiement(GestionFenetrePaiement parent, Locataire locataireSelectionne) {
		this.locataireSelectionne = locataireSelectionne;
		this.parent = parent;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblTitre = new JLabel("Ajouter paiement");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblTitre);

		Component verticalStrut = Box.createVerticalStrut(60);
		panel.add(verticalStrut);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);

		JButton btnRetour = new JButton("Retour");

		JButton btnAjouter = new JButton("Ajouter");
		panel_2.add(btnAjouter);

		JButton btnVider = new JButton("Vider");

		Component verticalStrut_1 = Box.createVerticalStrut(60);
		panel_2.add(verticalStrut_1);
		panel_2.add(btnVider);
		panel_2.add(btnRetour);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);

		JLabel lblMontant = new JLabel("Montant paiement :");
		lblMontant.setBounds(74, 174, 108, 13);
		panel_3.add(lblMontant);

		textFieldMontant = new JTextField();
		textFieldMontant.setBounds(234, 170, 96, 19);
		panel_3.add(textFieldMontant);
		textFieldMontant.setColumns(10);

		JLabel lblContratLocation = new JLabel("Contrat location :");
		lblContratLocation.setBounds(74, 120, 96, 13);
		panel_3.add(lblContratLocation);

		comboBox = new JComboBox<ContratLocation>();
		comboBox.setBounds(234, 116, 96, 21);
		panel_3.add(comboBox);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormatter dateFormatter = new DateFormatter(format);
		champDate = new JFormattedTextField(dateFormatter);
		champDate.setBounds(234, 220, 96, 19);
		panel_3.add(champDate);
		champDate.setColumns(10);
		champDate.setToolTipText("Format attendu : yyyy-MM-dd");

		JLabel lblDatePaiement = new JLabel("Date paiement :");
		lblDatePaiement.setBounds(75, 224, 108, 13);
		panel_3.add(lblDatePaiement);

		textFieldIdPaiement = new JTextField();
		textFieldIdPaiement.setBounds(234, 68, 96, 19);
		panel_3.add(textFieldIdPaiement);
		textFieldIdPaiement.setColumns(10);

		JLabel lblIdPaiement = new JLabel("ID Paiement :");
		lblIdPaiement.setBounds(74, 72, 96, 13);
		panel_3.add(lblIdPaiement);

		JLabel lblDesignation = new JLabel("Désignation :");
		lblDesignation.setBounds(74, 273, 82, 14);
		panel_3.add(lblDesignation);

		textFieldDesignation = new JTextField();
		textFieldDesignation.setBounds(234, 270, 96, 20);
		panel_3.add(textFieldDesignation);
		textFieldDesignation.setColumns(10);

		this.gestionClic = new GestionFenetreAjouterPaiement(this, parent, locataireSelectionne);
		btnRetour.addActionListener(this.gestionClic);
		btnAjouter.addActionListener(this.gestionClic);
		btnVider.addActionListener(this.gestionClic);

	}

	public JTextField getTextFieldDate() {
		return champDate;
	}

	public void setTextFieldDate(JTextField textFieldDate) {
		this.champDate = textFieldDate;
	}

	public JTextField getTextFieldMontant() {
		return textFieldMontant;
	}

	public void setTextFieldMontant(JTextField textFieldMontant) {
		this.textFieldMontant = textFieldMontant;
	}

	public JTextField getTextFieldIdPaiement() {
		return textFieldIdPaiement;
	}

	public void setTextFieldIdPaiement(JTextField textFieldIdPaiement) {
		this.textFieldIdPaiement = textFieldIdPaiement;
	}

	public JTextField getTextFieldDesignation() {
		return textFieldDesignation;
	}

	public void setTextFieldDesignation(JTextField textFieldDesignation) {
		this.textFieldDesignation = textFieldDesignation;
	}

	public void setComboBox(JComboBox<ContratLocation> comboBox) {
		this.comboBox = comboBox;
	}

	public JComboBox<ContratLocation> getComboBox() {
		return comboBox;
	}

	public List<JTextField> getPaiementTextFields() {
		List<JTextField> fields = new ArrayList<>();
		fields.add(textFieldIdPaiement);
		fields.add(textFieldMontant);
		fields.add(champDate);
		fields.add(textFieldDesignation);
		return fields;
	}
}