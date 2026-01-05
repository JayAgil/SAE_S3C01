package controleur;

import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import modele.BienLouable;
import modele.Diagnostics;
import modele.dao.DaoDiagnostics;
import vue.FenetreAjouterDiagnostic;

public class GestionFenetreAjouterDiagnostic extends GestionButtonFenetreAjouter {

    private FenetreAjouterDiagnostic fenetre;
    private BienLouable b;
    private GestionFenetreDiagnostic parent;

    public GestionFenetreAjouterDiagnostic(FenetreAjouterDiagnostic fenetre, BienLouable b, GestionFenetreDiagnostic parent) {
        this.fenetre = fenetre;
        this.b = b;
        this.parent = parent;
    }
    
    @Override
    protected List<JTextField> getTextFields() {
        return fenetre.getAllDiagnosticTextFields();
    }
    
    @Override
    protected JInternalFrame getFrame() {
        return fenetre;
    }
    
    @Override
	protected void gererAction() {
    	try {
			DaoDiagnostics dao = new DaoDiagnostics();
			List<JTextField> donnees = this.getTextFields();
			Diagnostics d = new Diagnostics (donnees.get(0).getText(),donnees.get(1).getText(),	    
					Date.valueOf(donnees.get(2).getText()),Date.valueOf(donnees.get(3).getText()),donnees.get(4).getText(),b);
			
			if (dao.create(d) == 1) {
			    JOptionPane.showMessageDialog(
			        null, 
			        "Diagnostic ajoutée avec succès !", 
			        "Succès", 
			        JOptionPane.INFORMATION_MESSAGE
			    );
			    this.parent.chargerDonnees();;
				this.fenetre.dispose();

			} else {
			    JOptionPane.showMessageDialog(
			        null, 
			        "Échec de l'ajout du diagnostic.", 
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
		            "Ce diagnostic existe déjà (clé primaire).",
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

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Choisir":
        	JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                fenetre.getTextFieldFichier().setText(selectedFile.getAbsolutePath());
            }
            break;
        }
    }

}