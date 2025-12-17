package controleur;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.ContratLocation;
import modele.dao.DaoContratLocation;
import vue.*;

public class GestionFenetreContratLocation extends GestionHeaderEtFooter implements MouseListener{

    private FenetreContratLocation fenetre;
    private ContratLocation cl;
    private List<ContratLocation> contrats;

    public GestionFenetreContratLocation(FenetreContratLocation fenetre, ContratLocation cl) throws SQLException {
        super(fenetre);
        this.fenetre = fenetre;
        this.cl = cl;
        this.contrats = new ArrayList<>(this.getDonneesContrats());
    }
    
    public List<ContratLocation> getDonneesContrats() throws SQLException{
    	DaoContratLocation dCl = new DaoContratLocation();
    	return dCl.findByContrat(this.cl.getNumeroDeContrat());
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {
        switch (texte) {
            case "Ajouter":
                FenetreAjouterContratLocation fACL = new FenetreAjouterContratLocation();
                fenetre.getLayeredPane().add(fACL).setVisible(true);
                break;
            case "Annuler":
                fenetre.dispose();
                break;
        }
    }
    @Override
    protected void gererMenuSpecifique(String texte) {
    }
    
    @Override
    protected void gererBoutonRetour(String texte) throws SQLException {
        if ("Retour".equals(texte)) {
        	if(fenetre.getFenDavant().equals("FenBienLouable")) {
	            FenetreBienLouable fp = new FenetreBienLouable(null, null);
	            fp.setVisible(true);
	            fenetre.dispose();
        	}
        	if(fenetre.getFenDavant().equals("FenPrincipale")) {
	            FenetrePrincipale fp = new FenetrePrincipale();
	            fp.setVisible(true);
	            fenetre.dispose();
        	}
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		 if (e.getSource() instanceof JTable) {
	        JTable table = (JTable) e.getSource();
	        int row = table.getSelectedRow();

	        if (row >= 0) {
	            ContratLocation contratSelectionne = contrats.get(row);
	            afficherContrat(contratSelectionne);
	        }
	        if (e.getClickCount() == 2 && row >= 0) {
	            fenetre.dispose();
	            FenetreLocataire fen = new FenetreLocataire("FenContratLocation", null);
	            fen.setVisible(true);
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
	
	public void initialize() {
	    remplirTable();
		if (!contrats.isEmpty()) {
		    afficherContrat(cl);
		}
	}
	
	private void remplirTable() {
	    DefaultTableModel model = (DefaultTableModel) this.fenetre.getTable().getModel();
	    model.setRowCount(0); 

	    for (ContratLocation c : contrats) {
	        model.addRow(new Object[] {
	            "—", 
	            c.getNumeroDeContrat(),
	            c.getDateFin(),
	            c.getMontantMensuel(),
	            c.getSolde()
	        });
	    }
	}
	
	private void afficherContrat(ContratLocation c) {
	    fenetre.getTextFieldNdC().setText(c.getNumeroDeContrat());
	    fenetre.getTextFieldPeriode().setText(
	        c.getDateDebut() + " → " + c.getDateFin()
	    );
	    fenetre.getTextFieldMontantC().setText(String.valueOf(c.getMontantDeCaution()));
	    fenetre.getTextFieldProvCharge().setText(String.valueOf(c.getProvisionCharge()));
	    fenetre.getTextFieldLoyerMen().setText(String.valueOf(c.getMontantMensuel()));
	    fenetre.getTextFieldCptEau().setText(String.valueOf(c.getIndexCompteurEau()));
	    fenetre.getTextFieldCptElec().setText(String.valueOf(c.getIndexCompteurElectricite()));
	    fenetre.getTextFieldCptGaz().setText(String.valueOf(c.getIndexCompteurGaz()));
	    fenetre.getTextFieldSolde().setText(String.valueOf(c.getSolde()));
	}



}
