package vue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetreCharges;
import modele.BienLouable;
import modele.ChargesGenerales;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;

import java.sql.SQLException;
import java.util.List;
import java.awt.Font;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FenetreCharges extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private GestionFenetreCharges gestionClic;
	private String fenetreAvant;
	private JLabel lbltotalentretien;
	private JLabel lbltotalorduremenageres;
	private JLabel lbltotalascenceur;
	private JLabel lbl1er;
	private JLabel lbl2nde;
	private JLabel lbl3eme;
	private JLabel lblchargesmoyen;
	private JComboBox comboBoxMois;
	private JComboBox comboBoxAnnee;
	private BienLouable bl;
	private JButton btnAjouter;

	/**
	 * Création de la vue
	 */
	public FenetreCharges(String FenetreAvant, List<ChargesGenerales> list, BienLouable bl) throws SQLException {
		super();
		this.bl = bl;
		this.fenetreAvant = FenetreAvant;
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.setJMenuBar(createHeader());

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel mainPanel = new JPanel(new BorderLayout(0, 0));
		contentPane.add(mainPanel, BorderLayout.CENTER);
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(2, 1, 0, 0));
		mainPanel.add(topPanel, BorderLayout.NORTH);

		JPanel panel_10 = new JPanel();
		topPanel.add(panel_10);

		JLabel lblTitre = new JLabel("Charges");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_10.add(lblTitre);

		JPanel panel_11 = new JPanel();
		topPanel.add(panel_11);

		comboBoxMois = new JComboBox();
		comboBoxMois.setModel(new DefaultComboBoxModel(new String[] { "Mois", "Janvier", "Fevrier", "Mars", "Avril",
				"Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Decembre" }));
		panel_11.add(comboBoxMois);

		comboBoxAnnee = new JComboBox();
		comboBoxAnnee.setModel(new DefaultComboBoxModel(
				new String[] { "Année", "2022", "2023", "2024", "2025", "                 " }));
		panel_11.add(comboBoxAnnee);

		JPanel tablePanel = new JPanel();
		mainPanel.add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new GridLayout(2, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		tablePanel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(this.gestionClic);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "Types charges", "Montant Total", "Pourcentage", "Quotite", "Montant", "Date" }) {
			Class[] columnTypes = new Class[] { String.class, Float.class, Float.class, String.class, String.class,
					Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { true, true, true, true, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.setEnabled(true);

		JPanel panel = new JPanel();
		tablePanel.add(panel);
		panel.setLayout(new GridLayout(1, 3, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Type Charges",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Entretien",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		JLabel imageEntretien = new JLabel("");
		panel_8.add(imageEntretien, BorderLayout.NORTH);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
				"Ordures M\u00E9nag\u00E8res", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		JLabel imageNettoyage = new JLabel("");
		panel_9.add(imageNettoyage, BorderLayout.NORTH);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Ascenceur",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		JLabel imageAscenceur = new JLabel("");
		panel_7.add(imageAscenceur, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
				"Trois Biens Avec Les Plus Haut Charges", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("  Première : ");
		panel_5.add(lblNewLabel_1, BorderLayout.NORTH);

		lbl1er = new JLabel("Bien 2");
		lbl1er.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lbl1er.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lbl1er, BorderLayout.CENTER);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("Seconde: ");
		panel_6.add(lblNewLabel_2, BorderLayout.NORTH);

		lbl2nde = new JLabel("Bien 8");
		lbl2nde.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lbl2nde.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lbl2nde, BorderLayout.CENTER);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_3 = new JLabel("Troisième: ");
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);

		lbl3eme = new JLabel("Bien 4");
		lbl3eme.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lbl3eme.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lbl3eme, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
				"Charges Moyen Par Bien", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		lblchargesmoyen = new JLabel("\r\n238");
		lblchargesmoyen.setHorizontalAlignment(SwingConstants.CENTER);
		lblchargesmoyen.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel_3.add(lblchargesmoyen, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		btnAjouter = new JButton("Ajouter charge");
		buttonPanel.add(btnAjouter);

		JButton btnMAJ = new JButton("Mettre à jour");
		buttonPanel.add(btnMAJ);

		JButton btnRetirer = new JButton("Retirer");

		buttonPanel.add(btnRetirer);

		JButton btnRetour = new JButton("Retour");
		buttonPanel.add(btnRetour);

		JPanel footerPanel = new JPanel(new BorderLayout());
		contentPane.add(footerPanel, BorderLayout.SOUTH);
		footerPanel.add(createFooter(), BorderLayout.NORTH);

		ImageIcon entretienIcon = new ImageIcon("img/entretien.png");
		Image imgentretien = entretienIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageEntretien.setIcon(new ImageIcon(imgentretien));
		imageEntretien.setHorizontalAlignment(JLabel.LEFT);

		lbltotalentretien = new JLabel("200");
		lbltotalentretien.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lbltotalentretien.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lbltotalentretien, BorderLayout.CENTER);

		ImageIcon nettoyageIcom = new ImageIcon("img/nettoyage.png");
		Image imgNettoyage = nettoyageIcom.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageNettoyage.setIcon(new ImageIcon(imgNettoyage));
		imageNettoyage.setHorizontalAlignment(JLabel.LEFT);

		lbltotalorduremenageres = new JLabel("300");
		lbltotalorduremenageres.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lbltotalorduremenageres.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lbltotalorduremenageres, BorderLayout.CENTER);

		ImageIcon lifticon = new ImageIcon("img/lift.png");
		Image imglift = lifticon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageAscenceur.setIcon(new ImageIcon(imglift));
		imageAscenceur.setHorizontalAlignment(JLabel.LEFT);

		lbltotalascenceur = new JLabel("250");
		lbltotalascenceur.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lbltotalascenceur.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lbltotalascenceur, BorderLayout.CENTER);

		this.gestionClic = new GestionFenetreCharges(this, list);
		this.gestionClic.initialize();
		this.gestionClic.chargerDonnees();
		this.gestionClic.initialiserFiltrage();
		comboBoxMois.addActionListener(this.gestionClic);
		comboBoxAnnee.addActionListener(this.gestionClic);
		btnAjouter.addActionListener(this.gestionClic);
		btnMAJ.addActionListener(this.gestionClic);
		btnRetirer.addActionListener(this.gestionClic);
		btnRetour.addActionListener(this.gestionClic);

	}

	/**
	 * Retourne le bouton permettant d'ajouter un nouvel élément.
	 *
	 * @return le bouton "Ajouter"
	 */
	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	/**
	 * Retourne la ComboBox permettant de sélectionner un mois.
	 *
	 * @return la JComboBox des mois
	 */
	public JComboBox getComboBoxMois() {
		return comboBoxMois;
	}

	/**
	 * Définit la ComboBox permettant de sélectionner un mois.
	 *
	 * @param comboBoxMois la JComboBox des mois à définir
	 */
	public void setComboBoxMois(JComboBox comboBoxMois) {
		this.comboBoxMois = comboBoxMois;
	}

	/**
	 * Retourne la ComboBox permettant de sélectionner une année.
	 *
	 * @return la JComboBox des années
	 */
	public JComboBox getComboBoxAnnee() {
		return comboBoxAnnee;
	}

	/**
	 * Définit la ComboBox permettant de sélectionner une année.
	 *
	 * @param comboBoxAnnee la JComboBox des années à définir
	 */
	public void setComboBoxAnnee(JComboBox comboBoxAnnee) {
		this.comboBoxAnnee = comboBoxAnnee;
	}

	/**
	 * Retourne le nom de la fenêtre précédente.
	 *
	 * @return le nom de la fenêtre avant
	 */
	public String getFenetreAvant() {
		return fenetreAvant;
	}

	/**
	 * Retourne la table affichant les données.
	 *
	 * @return la JTable principale
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * Définit la table affichant les données.
	 *
	 * @param table la JTable à définir
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * Retourne le label affichant le total des charges d'entretien.
	 *
	 * @return le JLabel du total entretien
	 */
	public JLabel getLbltotalentretien() {
		return lbltotalentretien;
	}

	/**
	 * Définit le label affichant le total des charges d'entretien.
	 *
	 * @param lbltotalentretien le JLabel à définir
	 */
	public void setLbltotalentretien(JLabel lbltotalentretien) {
		this.lbltotalentretien = lbltotalentretien;
	}

	/**
	 * Retourne le label affichant le total des charges d'ordures ménagères.
	 *
	 * @return le JLabel du total ordures ménagères
	 */
	public JLabel getLbltotalorduremenageres() {
		return lbltotalorduremenageres;
	}

	/**
	 * Définit le label affichant le total des charges d'ordures ménagères.
	 *
	 * @param lbltotalorduremenageres le JLabel à définir
	 */
	public void setLbltotalorduremenageres(JLabel lbltotalorduremenageres) {
		this.lbltotalorduremenageres = lbltotalorduremenageres;
	}

	/**
	 * Retourne le label affichant le total des charges d'ascenseur.
	 *
	 * @return le JLabel du total ascenseur
	 */
	public JLabel getLbltotalascenceur() {
		return lbltotalascenceur;
	}

	/**
	 * Définit le label affichant le total des charges d'ascenseur.
	 *
	 * @param lbltotalascenceur le JLabel à définir
	 */
	public void setLbltotalascenceur(JLabel lbltotalascenceur) {
		this.lbltotalascenceur = lbltotalascenceur;
	}

	/**
	 * Retourne le label affichant le montant ou valeur du 1er étage.
	 *
	 * @return le JLabel du 1er étage
	 */
	public JLabel getLbl1er() {
		return lbl1er;
	}

	/**
	 * Définit le label affichant le montant ou valeur du 1er étage.
	 *
	 * @param lbl1er le JLabel à définir
	 */
	public void setLbl1er(JLabel lbl1er) {
		this.lbl1er = lbl1er;
	}

	/**
	 * Retourne le label affichant le montant ou valeur du 2nde étage.
	 *
	 * @return le JLabel du 2nde étage
	 */
	public JLabel getLbl2nde() {
		return lbl2nde;
	}

	/**
	 * Définit le label affichant le montant ou valeur du 2nde étage.
	 *
	 * @param lbl2nde le JLabel à définir
	 */
	public void setLbl2nde(JLabel lbl2nde) {
		this.lbl2nde = lbl2nde;
	}

	/**
	 * Retourne le label affichant le montant ou valeur du 3ème étage.
	 *
	 * @return le JLabel du 3ème étage
	 */
	public JLabel getLbl3eme() {
		return lbl3eme;
	}

	/**
	 * Définit le label affichant le montant ou valeur du 3ème étage.
	 *
	 * @param lbl3eme le JLabel à définir
	 */
	public void setLbl3eme(JLabel lbl3eme) {
		this.lbl3eme = lbl3eme;
	}

	/**
	 * Retourne le label affichant le montant moyen des charges.
	 *
	 * @return le JLabel des charges moyennes
	 */
	public JLabel getLblchargesmoyen() {
		return lblchargesmoyen;
	}

	/**
	 * Définit le label affichant le montant moyen des charges.
	 *
	 * @param lblchargesmoyen le JLabel à définir
	 */
	public void setLblchargesmoyen(JLabel lblchargesmoyen) {
		this.lblchargesmoyen = lblchargesmoyen;
	}

	/**
	 * Retourne le bien louable associé à cette vue.
	 *
	 * @return le bien louable
	 */
	public BienLouable getBl() {
		return bl;
	}

}
