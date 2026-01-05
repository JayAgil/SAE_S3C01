package controleur;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.BienLouable;
import modele.ContratLocation;
import modele.IRL;
import modele.Locataire;
import modele.dao.DaoBienLouable;
import modele.dao.DaoContratLocation;
import modele.dao.DaoIRL;
import modele.dao.DaoLocataire;
import vue.*;

public class GestionFenetreContratLocation extends GestionHeaderEtFooter implements MouseListener{

    private FenetreContratLocation fenetre;
    private ContratLocation cl;
    private List<ContratLocation> contrats;
    
    private ContratLocation selected;

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
    protected void gererBoutonSpecifique(String texte) throws SQLException {
        switch (texte) {
            case "Ajouter":
                FenetreAjouterContratLocation fACL = new FenetreAjouterContratLocation();
                fenetre.getLayeredPane().add(fACL).setVisible(true);
                break;
            case "Annuler":
                fenetre.dispose();
                break;
            case "Revaloriser":
            	String id1 = String.valueOf(Year.now().getValue());
            	String id2 = String.valueOf(Year.now().getValue() - 1);

            	DaoIRL dIRL = new DaoIRL();
            	DaoContratLocation dCL = new DaoContratLocation();

            	IRL courant = dIRL.findById(id1);
            	IRL precedent = dIRL.findById(id2);

            	if(courant == null || precedent == null) {
            	    JOptionPane.showMessageDialog(null,
            	        "IRL non trouvée. Ajouter IRL avant de revaloriser",
            	        "Error", JOptionPane.ERROR_MESSAGE);
            	    break;
            	}

            	double val1 = courant.getIRL();
            	double val2 = precedent.getIRL();

            	double min = this.selected.getMontantMensuel();
            	double max = min * (val1 / val2);

            	String input = JOptionPane.showInputDialog(null,
            	    String.format("Veuillez entrer le loyer entre %.2f et %.2f", min, max),
            	    "Input", JOptionPane.INFORMATION_MESSAGE);

            	if(input != null && !input.trim().isEmpty()) {
            	    double inputValue;
            	    try {
            	        inputValue = Double.parseDouble(input);
            	    } catch (NumberFormatException ex) {
            	        JOptionPane.showMessageDialog(null,
            	            "Entrée invalide. Veuillez entrer un nombre.",
            	            "Error", JOptionPane.ERROR_MESSAGE);
            	        break;
            	    }

            	    if(inputValue < min || inputValue > max) {
            	        JOptionPane.showMessageDialog(null,
            	            String.format("Le loyer doit être compris entre %.2f et %.2f", min, max),
            	            "Error", JOptionPane.ERROR_MESSAGE);
            	    } else {
            	        inputValue = Math.round(inputValue * 100.0) / 100.0;
            	        this.selected.setMontantMensuel(inputValue);
            	        dCL.update(selected);
            	        JOptionPane.showMessageDialog(null, 
            	            "Loyer mis à jour avec succès : " + inputValue + " €");
            	    }
            	}
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
        		DaoBienLouable dBL = new DaoBienLouable();
        		BienLouable bL = dBL.findByIdContrat(this.cl.getNumeroDeContrat());
	            FenetreBienLouable fp = new FenetreBienLouable("FenPrincipale", bL);
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
            if (row >= 0 && row < contrats.size()) {
                ContratLocation contratSelectionne = contrats.get(row);
                this.selected = contrats.get(row);
                afficherContrat(contratSelectionne);
                if (e.getClickCount() == 2) {
                    fenetre.dispose();
                    FenetreLocataire fen = new FenetreLocataire("FenContratLocation", null, null);
                    fen.setVisible(true);
                }
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
	    try {
	        remplirTable();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    if (!contrats.isEmpty()) {
	        fenetre.getTable().setRowSelectionInterval(0, 0); 
	        afficherContrat(contrats.get(0));                 
	    }
	    fenetre.getTable().addMouseListener(this);
	}

	
	private void remplirTable() throws SQLException {
	    DefaultTableModel model = (DefaultTableModel) this.fenetre.getTable().getModel();
	    model.setRowCount(0); 
	    DaoLocataire dL = new DaoLocataire();
	    for (ContratLocation c : contrats) {
	    	String nomLoc = dL.findLocataireByContrat(c.getNumeroDeContrat()).get(0).getNom();
	        model.addRow(new Object[] {
	            nomLoc, 
	            c.getNumeroDeContrat(),
	            c.getDateFin(),
	            c.getMontantMensuel(),
	            c.getSolde()
	        });
	    }
	    fenetre.getTable().addMouseListener(this);
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

	    try {
	        DaoLocataire dL = new DaoLocataire();
	        List<Locataire> locataires = dL.findLocataireByContrat(c.getNumeroDeContrat());
	        if (!locataires.isEmpty()) {
	            fenetre.getTextFieldNomLoc().setText(locataires.get(0).getNom());
	        } else {
	            fenetre.getTextFieldNomLoc().setText("");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        fenetre.getTextFieldNomLoc().setText("");
	    }
	}




}
