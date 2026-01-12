package controleur;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.BienLouable;
import modele.Entreprise;
import modele.Facture;
import modele.dao.DaoEntreprise;
import modele.dao.DaoFacture;
import vue.FenetreAjouterTravaux;

public class GestionAjouterTravaux extends GestionButtonFenetreAjouter {

	private FenetreAjouterTravaux fenetreAjouterTravaux;
	private GestionFenetreTravaux parent;
	private BienLouable bl;

	public GestionAjouterTravaux(FenetreAjouterTravaux fenetreAjouterTravaux, GestionFenetreTravaux parent, BienLouable bl) {
		this.fenetreAjouterTravaux = fenetreAjouterTravaux;
		this.parent = parent;
		this.bl = bl;
		chargerComboBoxEntreprise();
	}
	
	/**
     * Retourne la fenêtre interne associée.
     */
	@Override
	protected JInternalFrame getFrame() {
		return this.fenetreAjouterTravaux;
	}
	
	/**
     * Gère l'action de création d'une facture/travaux.
     * - Récupère les données saisies dans les champs texte et combo box
     * - Crée un objet Facture
     * - Tente l'insertion en base via DaoFacture
     * - Affiche un message de succès ou d'erreur
     * - Met à jour la liste des factures du parent
     */
	@Override
	protected void gererAction() {
		try {
			DaoFacture daoFac = new DaoFacture();
			JComboBox<Entreprise> comboBox = this.fenetreAjouterTravaux.getComboBoxEntreprise();
			List<JTextField> donnees = this.getTextFields();
			Facture f = new Facture(
				    donnees.get(0).getText(),                          
				    Double.parseDouble(donnees.get(1).getText()),      
				    Date.valueOf(donnees.get(2).getText()),            
				    donnees.get(3).getText(),                          
				    Double.parseDouble(donnees.get(4).getText()),      
				    Date.valueOf(donnees.get(5).getText()),            
				    donnees.get(6).getText(),                          
				    bl,                                                
				    (Entreprise) comboBox.getSelectedItem()            
				);
			
			if (daoFac.create(f) == 1) {
			    JOptionPane.showMessageDialog(
			        null, 
			        "Facture ajoutée avec succès !", 
			        "Succès", 
			        JOptionPane.INFORMATION_MESSAGE
			    );
			    this.parent.setListe(daoFac.findFactureByBienLouable(this.bl.getIdBienLouable()));
			    this.parent.chargerDonnes();
				this.fenetreAjouterTravaux.dispose();

			} else {
			    JOptionPane.showMessageDialog(
			        null, 
			        "Échec de l'ajout de la facture.", 
			        "Erreur", 
			        JOptionPane.ERROR_MESSAGE
			    );
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (e.getErrorCode() == 1) { 
		        JOptionPane.showMessageDialog(
		            null,
		            "Ce travaux existe déjà (clé primaire).",
		            "Doublon",
		            JOptionPane.WARNING_MESSAGE
		        );
		    } else {
		        JOptionPane.showMessageDialog(
		            null,
		            "Erreur SQL : " + e.getMessage(),
		            "Erreur base de données",
		            JOptionPane.ERROR_MESSAGE
		        );
		    }
		}
		
	}
	
	/**
     * Charge les entreprises disponibles dans la combo box de la fenêtre.
     */
	public void chargerComboBoxEntreprise() {
		JComboBox<Entreprise> comboBox = this.fenetreAjouterTravaux.getComboBoxEntreprise();
		comboBox.removeAllItems();
		DaoEntreprise dao;
		try {
			dao = new DaoEntreprise();
			for (Entreprise e : dao.findAll()) {
				comboBox.addItem(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/**
     * Récupère tous les JTextFields de la fenêtre pour lire les données saisies.
     */
	@Override
	protected List<JTextField> getTextFields() {
		return this.fenetreAjouterTravaux.getTravauxTextFields();
	}
}