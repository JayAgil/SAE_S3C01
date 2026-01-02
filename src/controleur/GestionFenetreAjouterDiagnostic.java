package controleur;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import vue.FenetreAjouterDiagnostic;

public class GestionFenetreAjouterDiagnostic extends GestionButtonFenetreAjouter {

    private FenetreAjouterDiagnostic fenetre;

    public GestionFenetreAjouterDiagnostic(FenetreAjouterDiagnostic fenetre) {
        this.fenetre = fenetre;
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