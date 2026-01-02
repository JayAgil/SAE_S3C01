package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.util.List;

public abstract class GestionButtonFenetreAjouter implements ActionListener {
    
    protected abstract List<JTextField> getTextFields();
    
    protected abstract JInternalFrame getFrame();
    
    protected abstract void gererAction();
    
    public void actionPerformed(ActionEvent e) {
        String texte = ((JButton) e.getSource()).getText(); 
        switch(texte) {
            case "Vider":
                for (JTextField field : getTextFields()) {
                    field.setText(""); 
                }
                break;
            case "Retour":
                 getFrame().dispose();
                break;
            case "Ajouter":
            	gererAction();
                break;
        }
    }
    
}