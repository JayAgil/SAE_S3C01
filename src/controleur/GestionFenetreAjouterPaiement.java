package controleur;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.ContratLocation;
import modele.Locataire;
import modele.Paiement;
import modele.dao.DaoContratLocation;
import modele.dao.DaoPaiement;
import vue.FenetreAjouterPaiement;

public class GestionFenetreAjouterPaiement extends GestionButtonFenetreAjouter {

	private FenetreAjouterPaiement fenetre;
	private GestionFenetrePaiement parent;
	private Locataire locataireSelectionne;
	
	public GestionFenetreAjouterPaiement(FenetreAjouterPaiement fenetre, GestionFenetrePaiement parent, Locataire locataireSelectionne) {
		this.fenetre = fenetre;
		this.parent = parent;
		this.locataireSelectionne = locataireSelectionne;
		chargerComboBoxContratLocation();
	}

	@Override
	protected List<JTextField> getTextFields() {
		return fenetre.getPaiementTextFields();
	}

	@Override
	protected JInternalFrame getFrame() {
		return fenetre;
	}

	@Override
	protected void gererAction() {
		try {
			DaoPaiement dao = new DaoPaiement();
			JComboBox<ContratLocation> comboBox = this.fenetre.getComboBox();
			List<JTextField> donnees = this.getTextFields();
			Paiement p = new Paiement(donnees.get(0).getText(),	Double.parseDouble(donnees.get(1).getText()),		
					Date.valueOf(donnees.get(2).getText()),donnees.get(3).getText(),(ContratLocation)comboBox.getSelectedItem());        
			
			if (dao.create(p) == 1) {
			    JOptionPane.showMessageDialog(
			        null, 
			        "Paiement ajoutée avec succès !", 
			        "Succès", 
			        JOptionPane.INFORMATION_MESSAGE
			    );
			    this.parent.setPaiements(dao.findPaiementsByLocataire(locataireSelectionne.getIdLocataire()));
			    this.parent.chargerDonnees();
				this.fenetre.dispose();

			} else {
			    JOptionPane.showMessageDialog(
			        null, 
			        "Échec de l'ajout du paiement.", 
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
		            "Ce paiement existe déjà (clé primaire).",
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

	public void chargerComboBoxContratLocation() {
		JComboBox<ContratLocation> comboBox = this.fenetre.getComboBox();
		comboBox.removeAllItems();
		DaoContratLocation dao;
		try {
			dao = new DaoContratLocation();
			for (ContratLocation c : dao.findAll()) {
				comboBox.addItem(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
