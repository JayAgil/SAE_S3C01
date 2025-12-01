package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import vue.FenetreAjouterDiagnostic;
import vue.FenetrePrincipale;

public class GestionFenetreAjouterDiagnostic implements ActionListener {

    private FenetreAjouterDiagnostic fenetre;

    public GestionFenetreAjouterDiagnostic(FenetreAjouterDiagnostic fenetre) {
        this.fenetre = fenetre;
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
        case "Ajouter":
            break;
        case "Annuler":
			for (JTextField field : fenetre.getAllDiagnosticTextFields()) {
			    field.setText(""); 
			}
            break;     
        case "Retour" :
        	fenetre.dispose();
        	FenetrePrincipale fenPrincipale = new FenetrePrincipale();
        	fenPrincipale.setVisible(true);
        	break;
        }
    }

}