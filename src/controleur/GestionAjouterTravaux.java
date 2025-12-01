package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import vue.FenetreAjouterTravaux;
import vue.FenetreTravaux;

public class GestionAjouterTravaux implements ActionListener {
	
	private FenetreAjouterTravaux fenetreAjouterTravaux;
	private Connection connection;
	
	public GestionAjouterTravaux(FenetreAjouterTravaux fenetreAjouterTravaux) {
		this.fenetreAjouterTravaux = fenetreAjouterTravaux;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(((JButton)e.getSource()).getText()) {
		case "Valider":
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
				
			break;
		case "Annuler" :
			for (JTextField field : fenetreAjouterTravaux.getTravauxTextFields()) {
			    field.setText(""); 
			}
			break;
		case "Retour" :
			this.fenetreAjouterTravaux.dispose();
			break;
		}
	}
	
	

}
