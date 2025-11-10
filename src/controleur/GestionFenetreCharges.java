package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreCharges;

public class GestionFenetreCharges implements ActionListener{
	
	private FenetreCharges fenetreCharges;
	
	
	
	public GestionFenetreCharges(FenetreCharges fenetre) {
        this.fenetreCharges = fenetre;
    }
	public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Quitter":
            fenetreCharges.dispose();
            break;
        }
    }
}
