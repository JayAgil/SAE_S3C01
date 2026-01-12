package vue;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public abstract class FenetreBase extends JFrame {

	public JMenu mnProfil;
	public JMenu mnBatiment;
	public JMenu mnBienLouable;
	public JMenu mnPaiement;
	public JMenuItem mntmDeconnecter;
	public JMenuItem mntmAjouterBat;
	public JMenuItem mntmCompteur;
	public JMenuItem mntmCharge;
	public JMenuItem mntmContratLocation;
	public JMenuItem mntmTravaux;
	public JMenuItem mntmLocataire;
	public JMenuItem mntmHistorique;
	public JMenuItem mntmAjout;

	public FenetreBase() {

		mnProfil = new JMenu("Profil");
		mnBatiment = new JMenu("Batiment");
		mnBienLouable = new JMenu("Bien louable");
		mnPaiement = new JMenu("Paiement");
		mntmDeconnecter = new JMenuItem("Déconnecter");
		mntmCompteur = new JMenuItem("Compteurs");
		mntmCharge = new JMenuItem("Charges");
		mntmContratLocation = new JMenuItem("Contrat location");
		mntmTravaux = new JMenuItem("Travaux");
		mntmLocataire = new JMenuItem("Locataires");
		mntmHistorique = new JMenuItem("Historique de paiement");
	}

	/**
	 * Crée et configure la barre de menu principale de la fenêtre.
	 * 
	 * @return la JMenuBar créée et configurée
	 */
	protected JMenuBar createHeader() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(214, 214, 214));
		setJMenuBar(menuBar);

		menuBar.add(mnProfil);
		mnProfil.add(mntmDeconnecter);

		menuBar.add(mnBatiment);
		mnBatiment.add(mntmCompteur);
		mnBatiment.add(mntmCharge);

		menuBar.add(mnBienLouable);
		mnBienLouable.add(mntmContratLocation);
		mnBienLouable.add(mntmTravaux);
		mnBienLouable.add(mntmLocataire);

		menuBar.add(mnPaiement);
		mnPaiement.add(mntmHistorique);

		return menuBar;
	}

	/**
	 * Crée et configure le panneau de pied de page (footer) de la fenêtre.
	 *
	 * @return le JPanel représentant le footer
	 */
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
