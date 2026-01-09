package controleur;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.BienLouable;
import modele.Compteur;
import modele.Facture;
import modele.dao.DaoBienLouable;
import modele.dao.DaoCompteur;
import modele.dao.DaoFacture;
import vue.*;

public class GestionFenetreCompteurs extends GestionHeaderEtFooter {

    private FenetreCompteurs fenetre;
    private List<Compteur> cpt;

	@SuppressWarnings("deprecation")
	public GestionFenetreCompteurs(FenetreCompteurs fenetre, List<Compteur> cpt) {
        super(fenetre);
        this.fenetre = fenetre;
        this.cpt = cpt;
        if (this.fenetre.getFenetreAvant().equals("FenPrincipale")) {
        	this.fenetre.getBtnAjouterCompteur().hide();
        }
    }
    
    public void initialize() {
        remplirTableCompteurs();
        calculerTotaux();
    }
    
    public void remplirTableCompteurs() {
        DefaultTableModel model =
            (DefaultTableModel) fenetre.getTableCompteurs().getModel();
        model.setRowCount(0); 
        if (cpt == null || cpt.isEmpty()) {
            return;
        }
        for (Compteur c : cpt) {
            double consommation = c.getIndexNouveau() - c.getIndexAncien();
            model.addRow(new Object[] {
                c.getType(),                                   
                c.getDateInstallation(),                     
                c.getBienLouable().getIdBienLouable(),       
                c.getIndexAncien(),                          
                c.getIndexNouveau(),                          
                consommation,                                  
                String.format("%.2f €", c.getPartieVariable()), 
                String.format("%.2f €", c.getPartieFixe()),    
                String.format("%.2f €", c.getTotal())               
            });
        }
    }
    
    
    private void calculerTotaux() {
        double totalEau = 0;
        double totalElec = 0;
        double totalGaz = 0;
        if (cpt == null || cpt.isEmpty()) {
            return;
        }
        for (Compteur c : cpt) {
            double total = c.getTotal();
            switch (c.getType().toUpperCase()) {
                case "EAU":
                    totalEau += total;
                    break;
                case "ELECTRICITE":
                    totalElec += total;
                    break;
                case "GAZ":
                    totalGaz += total;
                    break;
            }
        }
        fenetre.getLbltotaleau().setText(String.format("%.2f €", totalEau));
        fenetre.getLnltotalelec().setText(String.format("%.2f €", totalElec));
        fenetre.getLbltotalgaz().setText(String.format("%.2f €", totalGaz));
    }
    
    
    
    
    @Override
    protected void gererBoutonSpecifique(String texte) throws SQLException {
        switch (texte) {
            case "Ajouter compteur":
                FenetreAjouterCompteur fenAjouterCompteur = new FenetreAjouterCompteur(this.fenetre.getB(),this);
                fenetre.getLayeredPane().add(fenAjouterCompteur);
                fenAjouterCompteur.setVisible(true);
                break;
            case "Mettre à jour" :
            	JTable table = fenetre.getTableCompteurs();
            	int row = table.getSelectedRow();
            	if (row != -1) {
            		Compteur c = this.cpt.get(row);
            		DaoCompteur daoCompteur = new DaoCompteur();
            		c.setType(table.getValueAt(row, 0).toString());
            		c.setIndexNouveau(Double.parseDouble(table.getValueAt(row, 4).toString()));
            		c.setPartieVariable(Double.parseDouble(table.getValueAt(row, 6).toString()));
            		daoCompteur.update(c);
            	}
            	break;
        }
    }
    
    @Override
    protected void gererBoutonRetour(String texte) throws SQLException {
    	if ("Retour".equals(texte)) {
    	    fenetre.dispose();
    	    String fenAvant = fenetre.getFenetreAvant();
    	    switch (fenAvant) {
    	        case "FenPrincipale":
    	            FenetrePrincipale fp1 = new FenetrePrincipale();
    	            fp1.setVisible(true);
    	            break;
    	        case "FenetreBienLouable":
    	        	DaoBienLouable dBL = new DaoBienLouable();
    	        	BienLouable data = dBL.findByIdCompteur(cpt.get(0).getIdCompteur());
    	            FenetreBienLouable fp2 = new FenetreBienLouable("FenPrincipale", data);
    	            fp2.setVisible(true);
    	            break;
    	        case "Retirer":
    	        	JTable table = this.fenetre.getTableCompteurs();
    	        	int row = table.getSelectedRow();
    	        	if (row != -1) {
    	        		Compteur compt = this.cpt.get(row);
    	        		DaoCompteur dC;
    					try {
    						dC = new DaoCompteur();
    						dC.delete(compt);
    						this.cpt.remove(compt);
    						this.remplirTableCompteurs();
    					} catch (SQLException e1) {
    						e1.printStackTrace();
    					}
    	        		
    	        	}
    	    }
    	}
    		
    }
    public void setCpt(List<Compteur> cpt) {
		this.cpt = cpt;
	}
}
