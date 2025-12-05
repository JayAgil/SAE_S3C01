package controleur;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vue.*;

public class GestionFenetrePaiement extends GestionHeaderEtFooter implements MouseListener {

    private FenetrePaiement fenetre;

    public GestionFenetrePaiement(FenetrePaiement fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {

        switch (texte) {

            case "Ajouter paiement":
                FenetreAjouterPaiement fenAjouterPaiement = new FenetreAjouterPaiement();
                fenetre.getLayeredPane().add(fenAjouterPaiement);
                fenAjouterPaiement.setVisible(true);
                break;

            case "Générer facture":
            	int selectedRow = fenetre.getTable().getSelectedRow();
            	if (selectedRow == -1) {
            	    JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne.");
            	    return;
            	}
            	DefaultTableModel model = (DefaultTableModel) fenetre.getTable().getModel();
            	Object[] rowData = new Object[model.getColumnCount()];
            	String[] columnNames = new String[model.getColumnCount()];
            	for (int i = 0; i < model.getColumnCount(); i++) {
            	    rowData[i] = model.getValueAt(selectedRow, i);
            	    columnNames[i] = model.getColumnName(i);
            	}
            	FenetreFacture fenFacture = new FenetreFacture(rowData, columnNames, "Paiement");
            	fenFacture.setVisible(true);
            	break;

        }
    }
    
    @Override
    protected void gererBoutonRetour(String texte) {
        if ("Retour".equals(texte)) {
            FenetreLocataire fen = new FenetreLocataire("Paiement");
            fen.setVisible(true);
            fenetre.dispose();
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
                FenetreFacture fenFacture = new FenetreFacture(rowData, columnNames, "Paiement");
                fenFacture.setVisible(true);
            }
        }
    }


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
