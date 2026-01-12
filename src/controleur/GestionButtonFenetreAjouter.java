package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.util.List;

public abstract class GestionButtonFenetreAjouter implements ActionListener {

	/**
	 * Méthode abstraite pour récupérer tous les JTextField de la fenêtre.
	 * 
	 * @return liste des champs texte à gérer
	 */
	protected abstract List<JTextField> getTextFields();

	/**
	 * Méthode abstraite pour récupérer la fenêtre interne associée.
	 * 
	 * @return JInternalFrame correspondant à la fenêtre
	 */
	protected abstract JInternalFrame getFrame();

	/**
	 * Méthode abstraite qui définit l'action à exécuter lorsqu'on clique sur
	 * "Ajouter". La logique d'ajout spécifique doit être implémentée dans la
	 * sous-classe.
	 */
	protected abstract void gererAction();

	/**
	 * Gestionnaire d'événements pour les boutons de la fenêtre d'ajout. Selon le
	 * texte du bouton, exécute l'action correspondante : - "Vider" : vide tous les
	 * JTextField - "Retour" : ferme la fenêtre - "Ajouter" : appelle la méthode
	 * gererAction()
	 */
	public void actionPerformed(ActionEvent e) {
		String texte = ((JButton) e.getSource()).getText();
		switch (texte) {
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