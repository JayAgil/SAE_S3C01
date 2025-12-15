package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import modele.Locataire;
import modele.dao.DaoLocataire;
import vue.*;

public class GestionFenetreBienLouable extends GestionHeaderEtFooter implements MouseListener {

	private FenetreBienLouable fenetrebienlouable;

	public GestionFenetreBienLouable(FenetreBienLouable fenetre) {
		super(fenetre);
		this.fenetrebienlouable = fenetre;
	}

	@Override
	protected void gererBoutonSpecifique(String texte) throws SQLException {
		switch (texte) {

		case "Diagnostics":
			new FenetreDiagnostic().setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Contrat":
			new FenetreContratLocation("FenBienLouable").setVisible(true);
			fenetrebienlouable.dispose();
			break;
        case "Charges":
            new FenetreCharges("FenetreBienLouable", null).setVisible(true);
            fenetrebienlouable.dispose();
            break;
		case "Travaux":
			new FenetreTravaux().setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Compteur":
			new FenetreCompteurs("FenereBienLouable").setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Revaloriser":
			break;
		}
	}

	public void mouseClicked(MouseEvent e) {

	    if (e.getClickCount() == 2 && e.getSource() instanceof JTable) {

	        JTable table = (JTable) e.getSource();
	        int row = table.rowAtPoint(e.getPoint());
	        int column = table.columnAtPoint(e.getPoint());

	        int targetColumn = 0;

	        if (row != -1 && column == targetColumn) {

	            String idBien = (String) table.getValueAt(row, 0);

	            try {
	                DaoLocataire dl = new DaoLocataire();
	                List<Locataire> locataires = dl.findLocataireByBienLouable(idBien);
	                FenetreLocataire fen = new FenetreLocataire("FenetreLocataire",locataires);
	                fen.setVisible(true);
	                fenetre.dispose();

	            } catch (Exception ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Erreur lors du chargement des locataires");
	            }
	        }
	    }
	}

    

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	@Override
	protected void gererBoutonRetour(String texte) {
		if ("Retour".equals(texte)) {
			fenetre.dispose();
			FenetrePrincipale fp = new FenetrePrincipale();
			fp.setVisible(true);
		}
	}
}
