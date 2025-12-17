package controleur;

import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.Date;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import modele.Paiement;
import modele.dao.DaoPaiement;
import vue.FenetreAjouterBatiment;
import vue.FenetreAjouterPaiement;
import vue.FenetreAssurance;
import vue.FenetreCharges;
import vue.FenetreCompteurs;

public class GestionFenetreAjouterPaiement extends GestionButtonFenetreAjouter {

    private FenetreAjouterPaiement fenetre;

    public GestionFenetreAjouterPaiement(FenetreAjouterPaiement fenetre) {
        this.fenetre = fenetre;
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
    protected void GererAction(String buttonText, ActionEvent e) {
    	switch (buttonText) {
        case "Ajouter":
        	try {
        		List<JTextField> fields = fenetre.getPaiementTextFields();

        	    // Respect de l'ordre défini dans la vue
        	    String dateStr = fields.get(0).getText();
        	    String montantStr = fields.get(1).getText();
        	    String idPaiement = fields.get(2).getText();

        	    double montant = Double.parseDouble(montantStr);
        	    Date datePaiement = Date.valueOf(dateStr); // yyyy-MM-dd

        	    Paiement paiement = new Paiement(
        	        idPaiement,
        	        montant,
        	        datePaiement,
        	        null // contrat à gérer plus tard
        	    );

        	    DaoPaiement daoPaiement = new DaoPaiement();
        	    daoPaiement.create(paiement);

        	    System.out.println("Paiement inséré avec succès");
            } catch (Exception ex) {
                ex.printStackTrace();
            
            }
    
    	}
    }


}
