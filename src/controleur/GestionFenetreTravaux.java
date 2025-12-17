package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Facture;
import vue.FenetreAjouterEntreprise;
import vue.FenetreAjouterTravaux;
import vue.FenetreBienLouable;
import vue.FenetreFacture;
import vue.FenetreTravaux;

public class GestionFenetreTravaux extends GestionHeaderEtFooter implements MouseListener {
	
	private FenetreTravaux fenetreTravaux;
	
	public GestionFenetreTravaux(FenetreTravaux fenetreTravaux) {
		super(fenetreTravaux);
        this.fenetreTravaux = fenetreTravaux;
	}
	
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		Object source = e.getSource();

		if (source instanceof JButton) {
			JButton btn = (JButton) source;
	        String texte = btn.getText();

	        switch (texte) {

			case "Ajouter travaux":
				FenetreAjouterTravaux fenAjouterTravaux = new FenetreAjouterTravaux();
				fenetreTravaux.getLayeredPane().add(fenAjouterTravaux);
				fenAjouterTravaux.setVisible(true);
				break;

			case "Ajouter entreprise":
				FenetreAjouterEntreprise fenAjouterEntreprise = new FenetreAjouterEntreprise();
				fenetreTravaux.getLayeredPane().add(fenAjouterEntreprise);
				fenAjouterEntreprise.setVisible(true);
				break;

			case "Visualiser facture":
				genererFactureDepuisSelection();
				break;
	        }
	     }
	}

	private void genererFactureDepuisSelection() {
		Facture facture = fenetreTravaux.getFactureSelectionnee();
        if (facture == null) {
            JOptionPane.showMessageDialog(
                    fenetreTravaux,
                    "Veuillez sélectionner une facture");
            return;
        }
        new FenetreFacture(facture).setVisible(true);    
	}


	@Override
	protected void gererBoutonRetour(String texte) throws SQLException {
		if ("Retour".equals(texte)) {
			FenetreBienLouable fenetreBienLouable = new FenetreBienLouable("fp", null);
			fenetreBienLouable.setVisible(true);
			fenetreTravaux.dispose();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	    if (e.getClickCount() == 2 && e.getSource() instanceof JTable) {
	        JTable table = (JTable) e.getSource();
	        int row = table.rowAtPoint(e.getPoint());

	        if (row != -1) {
	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            Object[] rowData = new Object[model.getColumnCount()];
	            String[] columnNames = new String[model.getColumnCount()];

	            for (int i = 0; i < model.getColumnCount(); i++) {
	                rowData[i] = model.getValueAt(row, i);
	                columnNames[i] = model.getColumnName(i);
	            }

	            new FenetreFacture(rowData, columnNames, "Travaux");
	        }
	    }
	}


	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
}
