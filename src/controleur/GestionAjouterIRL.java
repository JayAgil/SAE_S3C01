package controleur;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import vue.FenetreAjouterIRL;
import vue.FenetreAjouterTravaux;

public class GestionAjouterIRL extends GestionButtonFenetreAjouter {
    
    private FenetreAjouterIRL fenetreAjouterIRL;
    private Connection connection;
    
    public GestionAjouterIRL(FenetreAjouterIRL fenetreAjouterIRL) {
        this.fenetreAjouterIRL = fenetreAjouterIRL;
    }
    
    @Override
    protected List<JTextField> getTextFields() {
        return fenetreAjouterIRL.getAllTextFields();
    }
    
    @Override
    protected JInternalFrame getFrame() {
        return this.fenetreAjouterIRL;
    }
    
    @Override
    protected void GererAction(String buttonText, ActionEvent e) {
        if ("Ajouter".equals(buttonText)) {
            try {
            
            } catch (Exception exc) {
                exc.printStackTrace();    
            }                
        }
    }
}