package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import vue.FenetreRegularisationCharges;

public class GestionFenetreRegularisationCharges implements ActionListener {
	
	private FenetreRegularisationCharges fen;

	public GestionFenetreRegularisationCharges(FenetreRegularisationCharges fen) {
		this.fen = fen;
	}

	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
		case "Continuer":
			this.fen.getContrat().setMontantMensuel(this.fen.getContrat().getMontantMensuel() + this.fen.getElement() / 12);
			try {
				this.fen.getDao().update(this.fen.getContrat());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.fen.dispose();
		case "Annuler":
			this.fen.dispose();
		}
	}
}
