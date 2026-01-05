package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetreCharges;
import modele.ChargesGenerales;

import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JLabel getLbltotalentretien() {
		return lbltotalentretien;
	}

	public void setLbltotalentretien(JLabel lbltotalentretien) {
		this.lbltotalentretien = lbltotalentretien;
	}

	public JLabel getLbltotalorduremenageres() {
		return lbltotalorduremenageres;
	}

	public void setLbltotalorduremenageres(JLabel lbltotalorduremenageres) {
		this.lbltotalorduremenageres = lbltotalorduremenageres;
	}

	public JLabel getLbltotalascenceur() {
		return lbltotalascenceur;
	}

	public void setLbltotalascenceur(JLabel lbltotalascenceur) {
		this.lbltotalascenceur = lbltotalascenceur;
	}

	public JLabel getLbl1er() {
		return lbl1er;
	}

	public void setLbl1er(JLabel lbl1er) {
		this.lbl1er = lbl1er;
	}

	public JLabel getLbl2nde() {
		return lbl2nde;
	}

	public void setLbl2nde(JLabel lbl2nde) {
		this.lbl2nde = lbl2nde;
	}

	public JLabel getLbl3eme() {
		return lbl3eme;
	}

	public void setLbl3eme(JLabel lbl3eme) {
		this.lbl3eme = lbl3eme;
	}

	public JLabel getLblchargesmoyen() {
		return lblchargesmoyen;
	}

	public void setLblchargesmoyen(JLabel lblchargesmoyen) {
		this.lblchargesmoyen = lblchargesmoyen;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreCharges frame = new FenetreCharges("", null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public FenetreCharges(String FenetreAvant, List<ChargesGenerales> list) throws SQLException {
		super();
		this.fenetreAvant = FenetreAvant;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.gestionClic = new GestionFenetreCharges(this, list);

		// Header
		this.setJMenuBar(createHeader());

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Main panel with BorderLayout
		JPanel mainPanel = new JPanel(new BorderLayout(0, 0));
		contentPane.add(mainPanel, BorderLayout.CENTER);

		// Top panel (e.g., title or summary)
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
		comboBoxMois.setModel(new DefaultComboBoxModel(new String[] {"Mois", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		panel_11.add(comboBoxMois);
		
		comboBoxAnnee = new JComboBox();
		comboBoxAnnee.setModel(new DefaultComboBoxModel(new String[] {"Année", "2023", "2024", "2025"}));
		panel_11.add(comboBoxAnnee);

		// Center panel to hold the table and scroll pane
		JPanel tablePanel = new JPanel();
		mainPanel.add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new GridLayout(2, 1, 0, 0));

		// Scroll pane and table
		JScrollPane scrollPane = new JScrollPane();
		tablePanel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[16][6], // your placeholder data
				new String[] { "Types charges", "Montant Total", "Pourcentage", "Quotite", "Montant", "Mois" }) {
			Class[] columnTypes = new Class[] { String.class, Float.class, Float.class, String.class, Object.class,
					Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.setEnabled(false);

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

		// Bottom panel for buttons
		JPanel buttonPanel = new JPanel();
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		JButton btnAjouter = new JButton("Ajouter charge");
		btnAjouter.addActionListener(this.gestionClic);
		buttonPanel.add(btnAjouter);

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this.gestionClic);
		buttonPanel.add(btnRetour);

		// Footer panel (if needed)
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
		comboBoxMois.addActionListener(this.gestionClic);
		comboBoxAnnee.addActionListener(this.gestionClic);
		this.gestionClic.initialize();
		this.gestionClic.chargerDonnees();

	}

	public JComboBox getComboBoxMois() {
		return comboBoxMois;
	}

	public void setComboBoxMois(JComboBox comboBoxMois) {
		this.comboBoxMois = comboBoxMois;
	}

	public JComboBox getComboBoxAnnee() {
		return comboBoxAnnee;
	}

	public void setComboBoxAnnee(JComboBox comboBoxAnnee) {
		this.comboBoxAnnee = comboBoxAnnee;
	}

	public String getFenetreAvant() {
		return fenetreAvant;
	}

}
