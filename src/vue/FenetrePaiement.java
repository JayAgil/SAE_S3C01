package vue;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetrePaiement;
<<<<<<< HEAD
=======
import modele.Facture;
import modele.Locataire;
>>>>>>> f4d78edcdbd736dc31da42b3d82936a873d53807

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetrePaiement extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestionFenetrePaiement gestionClic;
	private JTable table;
	private JProgressBar progressBar;
	private JLabel lblTotalPaiementAnnees;
	private JLabel lblTotalPaiementMois;
	private JLabel lblDateDernierPaiement;
	private String idLocataire;
	private JLabel lblValDate;
	private JLabel lblValPaiement;
	private JComboBox comboBoxMois;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FenetrePaiement frame = new FenetrePaiement(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FenetrePaiement(String idLocataire) {
		super();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		gestionClic = new GestionFenetrePaiement(this, idLocataire);
		this.idLocataire = idLocataire;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setTitle("Application Gestion");

		// header
		this.setJMenuBar(createHeader());

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.gestionClic.initialize();

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new BorderLayout());

<<<<<<< HEAD
		contentPane.add(mainPanel, BorderLayout.CENTER);
=======
        contentPane.add(mainPanel, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        mainPanel.add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(2, 2, 0, 5));
        
        JPanel panel_4 = new JPanel();
        panel.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel panel_1 = new JPanel();
        panel_4.add(panel_1);
        
        JLabel lblDatePaiement = new JLabel("Date paiement :");
        panel_1.add(lblDatePaiement);
        
        JLabel lblValDate = new JLabel("ValDate");
        panel_1.add(lblValDate);
        
        Component horizontalStrut = Box.createHorizontalStrut(600);
        panel_1.add(horizontalStrut);
        
        JPanel panel_2 = new JPanel();
        panel.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel panel_5 = new JPanel();
        panel_2.add(panel_5);
        
        JLabel lblMontant = new JLabel("Montant paiement :");
        panel_5.add(lblMontant);
        
        JLabel lblValPaiement = new JLabel("euro");
        panel_5.add(lblValPaiement);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(600);
        panel_5.add(horizontalStrut_1);
        
        JPanel panelButtons = new JPanel();
        mainPanel.add(panelButtons, BorderLayout.SOUTH);
        
        JButton btnAjouterPaiement = new JButton("Ajouter paiement");
        btnAjouterPaiement.addActionListener(this.gestionClic);
        panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelButtons.add(btnAjouterPaiement);
        
        JButton btnRetour = new JButton("Retour");
        panelButtons.add(btnRetour);
        
        JPanel panel_7 = new JPanel();
        mainPanel.add(panel_7, BorderLayout.CENTER);
        panel_7.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_8 = new JPanel();
        panel_7.add(panel_8, BorderLayout.NORTH);
        
        JComboBox comboBoxMois = new JComboBox();
        comboBoxMois.setModel(new DefaultComboBoxModel(new String[] {"Mois", "Janvier", "Février", "Mars", "Avril ", "Mai", "Juin Juillet", "Août", "Septembre", "Octobre", "Novembre", "Decembre"}));
        panel_8.add(comboBoxMois);
        
        JComboBox comboBoxLocataire = new JComboBox();
        comboBoxLocataire.setModel(new DefaultComboBoxModel(new String[] {"Locataire", "Koshua", "Aneesa", "Luca", "Frank"}));
        panel_8.add(comboBoxLocataire);
        
        JPanel panel_9 = new JPanel();
        panel_7.add(panel_9, BorderLayout.CENTER);
        panel_9.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane_1 = new JScrollPane();
        panel_9.add(scrollPane_1);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"Nom Locataire", "Batiment", "Montant", "Id Contrat", "Designation"
        	}
        ));
        scrollPane_1.setViewportView(table);
        
        JPanel panel_10 = new JPanel();
        panel_7.add(panel_10, BorderLayout.SOUTH);
        GridBagLayout gbl_panel_10 = new GridBagLayout();
        gbl_panel_10.columnWidths = new int[] {200, 200, 200};
        gbl_panel_10.rowHeights = new int[] {100, 200};
        gbl_panel_10.columnWeights = new double[]{1.0, 1.0, 1.0};
        gbl_panel_10.rowWeights = new double[]{0.0};
        panel_10.setLayout(gbl_panel_10);
        
        JPanel panel_12 = new JPanel();
        panel_12.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Totals Paiements Recu Ann\u00E9es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagConstraints gbc_panel_12 = new GridBagConstraints();
        gbc_panel_12.insets = new Insets(0, 0, 5, 5);
        gbc_panel_12.fill = GridBagConstraints.BOTH;
        gbc_panel_12.gridx = 0;
        gbc_panel_12.gridy = 0;
        panel_10.add(panel_12, gbc_panel_12);
        
        lblNewLabel_1 = new JLabel("3600");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 99));
        panel_12.add(lblNewLabel_1);
        
        JPanel panel_13 = new JPanel();
        panel_13.setBorder(new TitledBorder(null, "Totals Paiements Recu Ce Mois", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagConstraints gbc_panel_13 = new GridBagConstraints();
        gbc_panel_13.insets = new Insets(0, 0, 5, 5);
        gbc_panel_13.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel_13.gridx = 1;
        gbc_panel_13.gridy = 0;
        panel_10.add(panel_13, gbc_panel_13);
        
        lblNewLabel_2 = new JLabel("1200");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 99));
        panel_13.add(lblNewLabel_2);
        
        JPanel panel_11 = new JPanel();
        panel_11.setBorder(new TitledBorder(null, "Montant Total Pr\u00E9vu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagConstraints gbc_panel_11 = new GridBagConstraints();
        gbc_panel_11.insets = new Insets(0, 0, 5, 0);
        gbc_panel_11.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel_11.gridx = 2;
        gbc_panel_11.gridy = 0;
        panel_10.add(panel_11, gbc_panel_11);
        
        lblNewLabel = new JLabel("1300");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
        panel_11.add(lblNewLabel);
        
        progressBar = new JProgressBar();
        progressBar.setToolTipText("");
        progressBar.setValue(20);
        GridBagConstraints gbc_progressBar = new GridBagConstraints();
        gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
        gbc_progressBar.insets = new Insets(0, 0, 0, 5);
        gbc_progressBar.gridx = 1;
        gbc_progressBar.gridy = 1;
        panel_10.add(progressBar, gbc_progressBar);
        progressBar.setStringPainted(true);
        setString("30 Pourcent de paiement reçus");
>>>>>>> f4d78edcdbd736dc31da42b3d82936a873d53807

		JPanel panel = new JPanel();
		mainPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 2, 0, 5));

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);

		JLabel lblDatePaiement = new JLabel("Date paiement :");
		panel_1.add(lblDatePaiement);

		lblValDate = new JLabel("ValDate");
		panel_1.add(lblValDate);

		Component horizontalStrut = Box.createHorizontalStrut(600);
		panel_1.add(horizontalStrut);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);

		JLabel lblMontant = new JLabel("Montant paiement :");
		panel_5.add(lblMontant);

		lblValPaiement = new JLabel("euro");
		panel_5.add(lblValPaiement);

		Component horizontalStrut_1 = Box.createHorizontalStrut(600);
		panel_5.add(horizontalStrut_1);

		JPanel panelButtons = new JPanel();
		mainPanel.add(panelButtons, BorderLayout.SOUTH);

		JButton btnAjouterPaiement = new JButton("Ajouter paiement");
		btnAjouterPaiement.addActionListener(this.gestionClic);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelButtons.add(btnAjouterPaiement);

		JButton btnRetour = new JButton("Retour");
		panelButtons.add(btnRetour);

		JPanel panel_7 = new JPanel();
		mainPanel.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.NORTH);

		comboBoxMois = new JComboBox();
		comboBoxMois.addActionListener(gestionClic);
		comboBoxMois.setModel(new DefaultComboBoxModel(new String[] { "Mois", "Janvier", "Février", "Mars", "Avril ",
				"Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Decembre" }));
		panel_8.add(comboBoxMois);

		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_9.add(scrollPane_1);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "ID Paiement", "ID Contrat", "Date Paiement", "Montant" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table);

		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[] { 200, 200, 200 };
		gbl_panel_10.rowHeights = new int[] { 100, 200 };
		gbl_panel_10.columnWeights = new double[] { 1.0, 1.0, 1.0 };
		gbl_panel_10.rowWeights = new double[] { 0.0 };
		panel_10.setLayout(gbl_panel_10);

		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Totals Paiements Recu Ann\u00E9e", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.insets = new Insets(0, 0, 5, 5);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 0;
		panel_10.add(panel_12, gbc_panel_12);

		lblTotalPaiementAnnees = new JLabel("3600");
		lblTotalPaiementAnnees.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel_12.add(lblTotalPaiementAnnees);

		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new TitledBorder(null, "Totals Paiements Recu Ce Mois", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.insets = new Insets(0, 0, 5, 5);
		gbc_panel_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_13.gridx = 1;
		gbc_panel_13.gridy = 0;
		panel_10.add(panel_13, gbc_panel_13);

		lblTotalPaiementMois = new JLabel("1200");
		lblTotalPaiementMois.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel_13.add(lblTotalPaiementMois);

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Date Dernier Paiement", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 0);
		gbc_panel_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_11.gridx = 2;
		gbc_panel_11.gridy = 0;
		panel_10.add(panel_11, gbc_panel_11);

		lblDateDernierPaiement = new JLabel("1300");
		lblDateDernierPaiement.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel_11.add(lblDateDernierPaiement);

		progressBar = new JProgressBar();
		progressBar.setToolTipText("");
		progressBar.setValue(20);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.insets = new Insets(0, 0, 0, 5);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 1;
		panel_10.add(progressBar, gbc_progressBar);
		progressBar.setStringPainted(true);
		setString("30 Pourcent de paiement reçus");

		contentPane.add(createFooter(), BorderLayout.SOUTH);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.NORTH);

		JLabel lblTitre = new JLabel("Paiement");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_3.add(lblTitre);

		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.SOUTH);

		btnRetour.addActionListener(gestionClic);
	}

	public JComboBox getComboBoxMois() {
		return comboBoxMois;
	}

	public void disableMenuItems(boolean actif) {
		this.mnBatiment.setEnabled(actif);
		this.mntmChargesBL.setEnabled(actif);
		this.mntmCompteurBL.setEnabled(actif);
		this.mntmContratLocation.setEnabled(actif);
		this.mntmDiagnostic.setEnabled(actif);
		this.mntmHistorique.setEnabled(actif);
		this.mntmTravaux.setEnabled(actif);

	}

	public JTable getTable() {
		return table;
	}

	public void setString(String s) {
		progressBar.setString(s);
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	public JLabel getLblTotalPaiementAnnees() {
		return lblTotalPaiementAnnees;
	}

	public JLabel getLblPaiementMois() {
		return lblTotalPaiementMois;
	}

	public JLabel getLblDateDernierPaiement() {
		return lblDateDernierPaiement;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JLabel getLblValDate() {
		return lblValDate;
	}

	public JLabel getLblValPaiement() {
		return lblValPaiement;
	}

}
