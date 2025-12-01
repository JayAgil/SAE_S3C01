package vue;

import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel_12 = new JPanel();
        getContentPane().add(panel_12, BorderLayout.SOUTH);

        JPanel footerPanel = new JPanel();
        footerPanel.setPreferredSize(new Dimension(584, 30));
        footerPanel.setBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
        footerPanel.setBackground(new Color(214, 214, 214));
        panel_12.add(footerPanel);

        JLabel footerLabel = new JLabel(
            "Developpé par Koshua, Jay, Aneesa, Luca et Franck");
        footerPanel.add(footerLabel);
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JLabel lblNumFacture = new JLabel("Numéro facture :");
        lblNumFacture.setBounds(66, 76, 86, 14);
        panel.add(lblNumFacture);
        
        JLabel lblMontant = new JLabel("Montant :");
        lblMontant.setBounds(66, 107, 104, 14);
        panel.add(lblMontant);
        
        champNumFac = new JTextField();
        champNumFac.setBounds(203, 73, 86, 20);
        panel.add(champNumFac);
        champNumFac.setColumns(10);
        
        champMontant = new JTextField();
        champMontant.setBounds(203, 104, 86, 20);
        panel.add(champMontant);
        champMontant.setColumns(10);
        
        JLabel lblDateFacture = new JLabel("Date de facture :");
        lblDateFacture.setBounds(66, 138, 86, 14);
        panel.add(lblDateFacture);
        
        champDateFac = new JTextField();
        champDateFac.setBounds(203, 135, 86, 20);
        panel.add(champDateFac);
        champDateFac.setColumns(10);
        
        JLabel lblCB = new JLabel("Compte bancaire :");
        lblCB.setBounds(66, 169, 104, 14);
        panel.add(lblCB);
        
        champCB = new JTextField();
        champCB.setColumns(10);
        champCB.setBounds(203, 166, 86, 20);
        panel.add(champCB);
        
        JLabel lblTitre = new JLabel("Ajouter travaux");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitre.setBounds(224, 22, 163, 14);
        panel.add(lblTitre);
        
        this.gestionClic = new GestionAjouterTravaux(this);
        
        JButton btnValider = new JButton("Valider");
        btnValider.addActionListener(this.gestionClic);
        btnValider.setBounds(101, 296, 89, 23);
        panel.add(btnValider);
        
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this.gestionClic);
        btnAnnuler.setBounds(259, 296, 89, 23);
        panel.add(btnAnnuler);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this.gestionClic);
        btnRetour.setBounds(406, 296, 89, 23);
        panel.add(btnRetour);
        
        JLabel lblMontantDevis = new JLabel("Montant devis :");
        lblMontantDevis.setBounds(66, 200, 75, 14);
        panel.add(lblMontantDevis);
        
        champDevis = new JTextField();
        champDevis.setBounds(203, 197, 86, 20);
        panel.add(champDevis);
        champDevis.setColumns(10);
        
        champDatePaiement = new JTextField();
        champDatePaiement.setBounds(203, 228, 86, 20);
        panel.add(champDatePaiement);
        champDatePaiement.setColumns(10);
        
        champDesignationTravaux = new JTextField();
        champDesignationTravaux.setBounds(448, 73, 86, 20);
        panel.add(champDesignationTravaux);
        champDesignationTravaux.setColumns(10);
        
        JLabel lblDatePaiement = new JLabel("Date de paiement : ");
        lblDatePaiement.setBounds(66, 231, 104, 14);
        panel.add(lblDatePaiement);
        
        JLabel lblDesignationTravaux = new JLabel("Désignation travaux :");
        lblDesignationTravaux.setBounds(318, 76, 104, 14);
        panel.add(lblDesignationTravaux);
        
        JLabel lblEntreprise = new JLabel("Entreprise :");
        lblEntreprise.setBounds(318, 107, 86, 14);
        panel.add(lblEntreprise);
        
        comboBoxEntreprise = new JComboBox();
        comboBoxEntreprise.setBounds(448, 103, 86, 22);
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
