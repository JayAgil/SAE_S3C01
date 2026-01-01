package vue;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public abstract class FenetreBase extends JFrame {

	public JMenu mnProfil;
	public JMenu mnBatiment;
	public JMenu mnBienLouable;
	public JMenu mnPaiement;

	// ===== MENU ITEMS =====
	public JMenuItem mntmDeconnecter;
	public JMenuItem mntmAjouterBat;
	public JMenuItem mntmAssurance;
	public JMenuItem mntmCompteur;
	public JMenuItem mntmCharge;

	public JMenuItem mntmContratLocation;
	public JMenuItem mntmCompteurBL;
	public JMenuItem mntmTravaux;
	public JMenuItem mntmChargesBL;
	public JMenuItem mntmDiagnostic;
	public JMenuItem mntmLocataire;


	public JMenuItem mntmHistorique;
	public JMenuItem mntmAjout;


	public void disableMenuItems(boolean actif) {
		// default behaviour: do nothing
	}
	
	public FenetreBase() {

	    // Menus
	    mnProfil = new JMenu("Profil");
	    mnBatiment = new JMenu("Batiment");
	    mnBienLouable = new JMenu("Bien louable");
	    mnPaiement = new JMenu("Paiement");

	    // Menu items
	    mntmDeconnecter = new JMenuItem("Déconnecter");

	    mntmAjouterBat = new JMenuItem("Ajouter bâtiment");
	    mntmAssurance = new JMenuItem("Assurance");
	    mntmCompteur = new JMenuItem("Compteurs");
	    mntmCharge = new JMenuItem("Charges");

	    mntmContratLocation = new JMenuItem("Contrat location");
	    mntmTravaux = new JMenuItem("Travaux");
	    mntmDiagnostic = new JMenuItem("Diagnostics");
	    mntmLocataire = new JMenuItem("Locataires");

	    mntmHistorique = new JMenuItem("Historique de paiement");
	    mntmAjout = new JMenuItem("Ajouter paiement");
	}


	protected JMenuBar createHeader() {
	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setBackground(new Color(214, 214, 214));
	    setJMenuBar(menuBar);

	    menuBar.add(mnProfil);
	    mnProfil.add(mntmDeconnecter);

	    menuBar.add(mnBatiment);
	    mnBatiment.add(mntmAjouterBat);
	    mnBatiment.add(mntmCompteur);
	    mnBatiment.add(mntmCharge);

	    menuBar.add(mnBienLouable);
	    mnBienLouable.add(mntmContratLocation);
	    mnBienLouable.add(mntmTravaux);
	    mnBienLouable.add(mntmDiagnostic);
	    mnBienLouable.add(mntmLocataire);

	    menuBar.add(mnPaiement);
	    mnPaiement.add(mntmHistorique);
	    mnPaiement.add(mntmAjout);

	    return menuBar;
	}


	protected JPanel createFooter() {
		JPanel footerPanel = new JPanel();
		footerPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		footerPanel.setBackground(new Color(214, 214, 214));
		footerPanel.setPreferredSize(new Dimension(584, 30));
		JLabel footerLabel = new JLabel("Developpé par Koshua, Jay, Aneesa, Luca et Franck");
		footerPanel.add(footerLabel);
		return footerPanel;
	}

}
