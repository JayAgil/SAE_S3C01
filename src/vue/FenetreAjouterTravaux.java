package vue;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import controleur.GestionAjouterTravaux;
import modele.Entreprise;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;

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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAjouterTravaux frame = new FenetreAjouterTravaux();
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
	public FenetreAjouterTravaux() {
		setResizable(false);
		this.gestionClic = new GestionAjouterTravaux(this);
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JLabel lblNumFacture = new JLabel("Numéro facture :");
        lblNumFacture.setBounds(94, 103, 86, 14);
        panel.add(lblNumFacture);
        
        JLabel lblMontant = new JLabel("Montant :");
        lblMontant.setBounds(94, 134, 104, 14);
        panel.add(lblMontant);
        
        champNumFac = new JTextField();
        champNumFac.setBounds(240, 100, 86, 20);
        panel.add(champNumFac);
        champNumFac.setColumns(10);
        
        champMontant = new JTextField();
        champMontant.setBounds(240, 131, 86, 20);
        panel.add(champMontant);
        champMontant.setColumns(10);
        
        JLabel lblDateFacture = new JLabel("Date de facture :");
        lblDateFacture.setBounds(94, 165, 86, 14);
        panel.add(lblDateFacture);
        
        champDateFac = new JTextField();
        champDateFac.setBounds(240, 162, 86, 20);
        panel.add(champDateFac);
        champDateFac.setColumns(10);
        
        JLabel lblCB = new JLabel("Compte bancaire :");
        lblCB.setBounds(94, 196, 104, 14);
        panel.add(lblCB);
        
        champCB = new JTextField();
        champCB.setColumns(10);
        champCB.setBounds(240, 193, 86, 20);
        panel.add(champCB);
        
        JLabel lblTitre = new JLabel("Ajouter travaux");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitre.setBounds(139, 23, 163, 20);
        panel.add(lblTitre);
        
        this.gestionClic = new GestionAjouterTravaux(this);
        
        JButton btnValider = new JButton("Valider");
        btnValider.addActionListener(this.gestionClic);
        btnValider.setBounds(47, 395, 89, 23);
        panel.add(btnValider);
        
        JButton btnVider = new JButton("Vider");
        btnVider.addActionListener(this.gestionClic);
        btnVider.setBounds(175, 395, 89, 23);
        panel.add(btnVider);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this.gestionClic);
        btnRetour.setBounds(299, 395, 89, 23);
        panel.add(btnRetour);
        
        JLabel lblMontantDevis = new JLabel("Montant devis :");
        lblMontantDevis.setBounds(94, 227, 75, 14);
        panel.add(lblMontantDevis);
        
        champDevis = new JTextField();
        champDevis.setBounds(240, 224, 86, 20);
        panel.add(champDevis);
        champDevis.setColumns(10);
        
        champDatePaiement = new JTextField();
        champDatePaiement.setBounds(240, 255, 86, 20);
        panel.add(champDatePaiement);
        champDatePaiement.setColumns(10);
        
        champDesignationTravaux = new JTextField();
        champDesignationTravaux.setBounds(240, 289, 86, 20);
        panel.add(champDesignationTravaux);
        champDesignationTravaux.setColumns(10);
        
        JLabel lblDatePaiement = new JLabel("Date de paiement : ");
        lblDatePaiement.setBounds(94, 258, 104, 14);
        panel.add(lblDatePaiement);
        
        JLabel lblDesignationTravaux = new JLabel("Désignation travaux :");
        lblDesignationTravaux.setBounds(94, 292, 120, 14);
        panel.add(lblDesignationTravaux);
        
        JLabel lblEntreprise = new JLabel("Entreprise :");
        lblEntreprise.setBounds(94, 328, 120, 14);
        panel.add(lblEntreprise);
        
        comboBoxEntreprise = new JComboBox();
        comboBoxEntreprise.setBounds(240, 324, 86, 22);
        panel.add(comboBoxEntreprise);
        
	}
	
	public Entreprise getSelectedEntreprise() {
		return (Entreprise) comboBoxEntreprise.getSelectedItem();
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
