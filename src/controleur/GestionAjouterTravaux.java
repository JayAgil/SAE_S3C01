package controleur;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import vue.FenetreAjouterTravaux;

public class GestionAjouterTravaux extends GestionButtonFenetreAjouter {
    
    private FenetreAjouterTravaux fenetreAjouterTravaux;
    private Connection connection;
    
    public GestionAjouterTravaux(FenetreAjouterTravaux fenetreAjouterTravaux) {
        this.fenetreAjouterTravaux = fenetreAjouterTravaux;
    }
    
    @Override
    protected List<JTextField> getTextFields() {
        return fenetreAjouterTravaux.getTravauxTextFields();
    }
    
    @Override
    protected JInternalFrame getFrame() {
        return this.fenetreAjouterTravaux;
    }
    
    @Override
    protected void GererAction(String buttonText, ActionEvent e) {
        if ("Ajouter".equals(buttonText)) {
            try {
                String query = "insert into Travaux (Numero Facture,Montant,"
                        + "Date de facture,Compte bancaire,Montant devis,"
                        + "Date de paiement,Designation travaux,Entreprise) "
                        + "values(?,?,?,?,?,?,?,?)";
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setString(1, fenetreAjouterTravaux.getChampNumFac().getText());
                pst.setString(2, fenetreAjouterTravaux.getChampMontant().getText());
                pst.setString(3, fenetreAjouterTravaux.getChampDateFac().getText());
                pst.setString(4, fenetreAjouterTravaux.getChampCB().getText());
                pst.setString(5, fenetreAjouterTravaux.getChampDevis().getText());
                pst.setString(6, fenetreAjouterTravaux.getChampDatePaiement().getText());
                pst.setString(7, fenetreAjouterTravaux.getChampDesignationTravaux().getText());
                pst.setString(8, fenetreAjouterTravaux.getSelectedEntreprise().getNom());
                
                ResultSet rs = pst.executeQuery();
                
                JOptionPane.showMessageDialog(fenetreAjouterTravaux, "Travaux enregistré");
                
                pst.close();
                rs.close();
            } catch (Exception exc) {
                exc.printStackTrace();    
            }                
        }
    }
}