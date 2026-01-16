package vue;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import controleur.GestionFenetreTravaux;
import modele.BienLouable;
import modele.Facture;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FenetreTravaux extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private GestionFenetreTravaux gestionClic;

	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblMontantTotal;
	private JLabel lblNbTravaux;
	private List<Facture> factures;
	private JComboBox comboBox_Mois;
	private JComboBox comboBox_Annee;
	private BienLouable bien;
	private String fenetreAvant;
	private JButton btnAjouterTravaux;

	/**
	 * Construit la fenêtre des travaux pour un bien louable. Cette fenêtre permet
	 * d'afficher, filtrer et gérer les factures de travaux associées à un bien.
	 *
	 * @param fenAvant le nom de la fenêtre précédente (pour la navigation)
	 * @param liste    la liste des factures de travaux associées au bien
	 * @param bien     le bien louable concerné
	 */
	public FenetreTravaux(String fenAvant, List<Facture> liste, BienLouable bien) {
		super();
		this.fenetreAvant = fenAvant;
		this.bien = bien;
		this.factures = liste;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1200, 800);
		getContentPane().setLayout(new BorderLayout(0, 0));

		this.setJMenuBar(createHeader());

		JPanel panel_12 = new JPanel();
		getContentPane().add(panel_12, BorderLayout.SOUTH);
		panel_12.add(createFooter());
		panel_12.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		btnAjouterTravaux = new JButton("Ajouter travaux");
		panel_1.add(btnAjouterTravaux);

		JButton btnAjouterEntreprise = new JButton("Ajouter entreprise");
		panel_1.add(btnAjouterEntreprise);

		JButton btnMAJ = new JButton("Mettre à jour");
		panel_1.add(btnMAJ);

		JButton btnGenFacture = new JButton("Visualiser facture");
		panel_1.add(btnGenFacture);

		JButton btnRetirer = new JButton("Retirer");

		panel_1.add(btnRetirer);

		JButton btnRetour = new JButton("Retour");
		panel_1.add(btnRetour);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);

		JLabel lblTravaux = new JLabel("Travaux");
		lblTravaux.setHorizontalAlignment(SwingConstants.CENTER);
		lblTravaux.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblTravaux);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		scrollPane = new JScrollPane();
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Num\u00E9ro facture", "Montant", "Date de facture", "Compte bancaire", "Montant devis", "Date de paiement", "D\u00E9signation travaux", "Entreprise"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Float.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(58);
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane.setViewportView(table);
		panel_3.add(scrollPane, BorderLayout.NORTH);

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 100, 100 };
		gbl_panel_4.rowHeights = new int[] { 50 };
		gbl_panel_4.columnWeights = new double[] { 1.0, 1.0 };
		gbl_panel_4.rowWeights = new double[] { 1.0 };
		panel_4.setLayout(gbl_panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Montant Total", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_4.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		lblMontantTotal = new JLabel("14,200");
		lblMontantTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontantTotal.setFont(new Font("Tahoma", Font.BOLD, 95));
		panel_5.add(lblMontantTotal);

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setVgap(15);
		flowLayout_1.setHgap(10);
		panel_5.add(panel_8, BorderLayout.NORTH);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Nombre de travaux effectu\u00E9s", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 0;
		panel_4.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		lblNbTravaux = new JLabel("3");
		lblNbTravaux.setFont(new Font("Tahoma", Font.BOLD, 95));
		lblNbTravaux.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNbTravaux);

		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_7, BorderLayout.NORTH);

		JLabel lblMois = new JLabel("Mois : ");
		panel_7.add(lblMois);

		comboBox_Mois = new JComboBox();
		comboBox_Mois.setModel(new DefaultComboBoxModel(new String[] { "Tous", "Janvier", "Février", "Mars", "Avril",
				"Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" }));
		panel_7.add(comboBox_Mois);

		JLabel lblAnnee = new JLabel("Annee :");
		panel_7.add(lblAnnee);

		comboBox_Annee = new JComboBox();
		comboBox_Annee.setModel(new DefaultComboBoxModel(new String[] {"Tous", "2021", "2022", "2023", "2024", "2025", "2026"}));
		panel_7.add(comboBox_Annee);

		this.gestionClic = new GestionFenetreTravaux(this, this.factures);
		btnAjouterTravaux.addActionListener(this.gestionClic);
		btnAjouterEntreprise.addActionListener(this.gestionClic);
		btnGenFacture.addActionListener(this.gestionClic);
		comboBox_Mois.addActionListener(this.gestionClic);
		comboBox_Annee.addActionListener(this.gestionClic);
		this.gestionClic.initialize();
		btnMAJ.addActionListener(this.gestionClic);
		btnRetirer.addActionListener(this.gestionClic);
		btnRetour.addActionListener(this.gestionClic);

	}

	/**
	 * Retourne le bouton permettant d'ajouter un nouveau travail.
	 *
	 * @return le bouton "Ajouter travaux"
	 */
	public JButton getBtnAjouterTravaux() {
		return btnAjouterTravaux;
	}

	/**
	 * Retourne la ComboBox permettant de filtrer les travaux par mois.
	 *
	 * @return la ComboBox des mois
	 */
	public JComboBox getComboBox_Mois() {
		return comboBox_Mois;
	}

	/**
	 * Définit la ComboBox utilisée pour le filtrage par mois.
	 *
	 * @param comboBox_Mois la ComboBox des mois à définir
	 */
	public void setComboBox_Mois(JComboBox comboBox_Mois) {
		this.comboBox_Mois = comboBox_Mois;
	}

	/**
	 * Retourne la ComboBox permettant de filtrer les travaux par année.
	 *
	 * @return la ComboBox des années
	 */
	public JComboBox getComboBox_Annee() {
		return comboBox_Annee;
	}

	/**
	 * Définit la ComboBox utilisée pour le filtrage par année.
	 *
	 * @param comboBox_Annee la ComboBox des années à définir
	 */
	public void setComboBox_Annee(JComboBox comboBox_Annee) {
		this.comboBox_Annee = comboBox_Annee;
	}

	/**
	 * Retourne la table affichant les factures de travaux.
	 *
	 * @return la JTable des travaux
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * Retourne le label affichant le montant total des travaux.
	 *
	 * @return le label du montant total
	 */
	public JLabel getLblMontantTotal() {
		return lblMontantTotal;
	}

	/**
	 * Définit le label affichant le montant total des travaux.
	 *
	 * @param lblMontantTotal le label à définir
	 */
	public void setLblMontantTotal(JLabel lblMontantTotal) {
		this.lblMontantTotal = lblMontantTotal;
	}

	/**
	 * Retourne le label affichant le nombre total de travaux.
	 *
	 * @return le label du nombre de travaux
	 */
	public JLabel getLblNbTravaux() {
		return lblNbTravaux;
	}

	/**
	 * Définit le label affichant le nombre de travaux.
	 *
	 * @param lblNewLabel le label à définir
	 */
	public void setLblNbTravaux(JLabel lblNewLabel) {
		this.lblNbTravaux = lblNewLabel;
	}

	/**
	 * Définit la table des travaux.
	 *
	 * @param table la JTable à définir
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * Retourne la liste des factures de travaux.
	 *
	 * @return la liste des factures
	 */
	public List<Facture> getFactures() {
		return factures;
	}

	/**
	 * Retourne le bien louable concerné par les travaux.
	 *
	 * @return le bien louable
	 */
	public BienLouable getBien() {
		return bien;
	}

	/**
	 * Retourne le nom de la fenêtre précédente.
	 *
	 * @return le nom de la fenêtre précédente
	 */
	public String getFenetreAvant() {
		return fenetreAvant;
	}

}
