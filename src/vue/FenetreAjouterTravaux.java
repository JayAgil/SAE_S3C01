package vue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import controleur.GestionAjouterTravaux;
import controleur.GestionFenetreTravaux;
import modele.BienLouable;
import modele.Entreprise;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class FenetreAjouterTravaux extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField champNumFac;
	private JTextField champMontant;
	private JTextField champDateFac;
	private JTextField champCB;
	private GestionAjouterTravaux gestionClic;
	private JTextField champDevis;
	private JTextField champDatePaiement;
	private JTextField champDesignationTravaux;
	private JComboBox<Entreprise> comboBoxEntreprise;
	private BienLouable bl;
	private GestionFenetreTravaux fen;

	public FenetreAjouterTravaux(GestionFenetreTravaux fen, BienLouable bl) {
		this.bl = bl;
		this.fen = fen;
		setResizable(false);
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNumFacture = new JLabel("Numéro facture :");
		lblNumFacture.setBounds(65, 104, 86, 14);
		panel.add(lblNumFacture);

		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setBounds(65, 135, 104, 14);
		panel.add(lblMontant);

		champNumFac = new JTextField();
		champNumFac.setBounds(211, 101, 134, 20);
		panel.add(champNumFac);
		champNumFac.setColumns(10);

		champMontant = new JTextField();
		champMontant.setBounds(211, 132, 134, 20);
		panel.add(champMontant);
		champMontant.setColumns(10);

		JLabel lblDateFacture = new JLabel("Date de facture :");
		lblDateFacture.setBounds(65, 166, 86, 14);
		panel.add(lblDateFacture);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormatter dateFormatter = new DateFormatter(format);
		champDateFac = new JFormattedTextField(dateFormatter);
		champDateFac.setBounds(211, 163, 134, 20);
		panel.add(champDateFac);
		champDateFac.setColumns(10);
		champDateFac.setToolTipText("Format attendu : yyyy-MM-dd");

		JLabel lblCB = new JLabel("Compte bancaire :");
		lblCB.setBounds(65, 197, 104, 14);
		panel.add(lblCB);

		champCB = new JTextField();
		champCB.setColumns(10);
		champCB.setBounds(211, 194, 134, 20);
		panel.add(champCB);

		JLabel lblTitre = new JLabel("Ajouter travaux");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitre.setBounds(139, 23, 163, 20);
		panel.add(lblTitre);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(47, 395, 89, 23);
		panel.add(btnAjouter);

		JButton btnVider = new JButton("Vider");
		btnVider.setBounds(175, 395, 89, 23);
		panel.add(btnVider);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(299, 395, 89, 23);
		panel.add(btnRetour);

		JLabel lblMontantDevis = new JLabel("Montant devis :");
		lblMontantDevis.setBounds(65, 228, 75, 14);
		panel.add(lblMontantDevis);

		champDevis = new JTextField();
		champDevis.setBounds(211, 225, 134, 20);
		panel.add(champDevis);
		champDevis.setColumns(10);

		champDatePaiement = new JFormattedTextField(dateFormatter);
		champDatePaiement.setBounds(211, 256, 134, 20);
		champDatePaiement.setColumns(10);
		panel.add(champDatePaiement);

		champDesignationTravaux = new JTextField();
		champDesignationTravaux.setBounds(211, 290, 134, 20);
		panel.add(champDesignationTravaux);
		champDesignationTravaux.setColumns(10);

		JLabel lblDatePaiement = new JLabel("Date de paiement : ");
		lblDatePaiement.setBounds(65, 259, 104, 14);
		panel.add(lblDatePaiement);

		JLabel lblDesignationTravaux = new JLabel("Désignation travaux :");
		lblDesignationTravaux.setBounds(65, 293, 120, 14);
		panel.add(lblDesignationTravaux);

		JLabel lblEntreprise = new JLabel("Entreprise :");
		lblEntreprise.setBounds(65, 329, 120, 14);
		panel.add(lblEntreprise);

		comboBoxEntreprise = new JComboBox<Entreprise>();
		comboBoxEntreprise.setBounds(211, 325, 134, 22);
		panel.add(comboBoxEntreprise);

		this.gestionClic = new GestionAjouterTravaux(this, this.fen, bl);
		btnAjouter.addActionListener(this.gestionClic);
		btnVider.addActionListener(this.gestionClic);
		btnRetour.addActionListener(this.gestionClic);

	}

	public JComboBox<Entreprise> getComboBoxEntreprise() {
		return comboBoxEntreprise;
	}

	public JTextField getChampNumFac() {
		return champNumFac;
	}

	public JTextField getChampMontant() {
		return champMontant;
	}

	public JTextField getChampDateFac() {
		return champDateFac;
	}

	public JTextField getChampCB() {
		return champCB;
	}

	public JTextField getChampDevis() {
		return champDevis;
	}

	public JTextField getChampDatePaiement() {
		return champDatePaiement;
	}

	public JTextField getChampDesignationTravaux() {
		return champDesignationTravaux;
	}

	public BienLouable getBl() {
		return bl;
	}

	public List<JTextField> getTravauxTextFields() {
		List<JTextField> fields = new ArrayList<>();
		fields.add(champNumFac);
		fields.add(champMontant);
		fields.add(champDateFac);
		fields.add(champCB);
		fields.add(champDevis);
		fields.add(champDatePaiement);
		fields.add(champDesignationTravaux);
		return fields;
	}

}
