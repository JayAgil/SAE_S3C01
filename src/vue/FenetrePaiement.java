package vue;

import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetrePaiement;

public class FenetrePaiement extends FenetreBase {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private GestionFenetrePaiement gestionClic;

	private JTable table;
	private JProgressBar progressBar;

	private JLabel lblTotalPaiementAnnees;
	private JLabel lblTotalPaiementMois;
	private JLabel lblDateDernierPaiement;
	private JLabel lblValDate;
	private JLabel lblValPaiement;

	private JComboBox<String> comboBoxMois;
	private String idLocataire;

	public FenetrePaiement(String idLocataire) throws SQLException {
		super();
		this.idLocataire = idLocataire;
		this.gestionClic = new GestionFenetrePaiement(this, idLocataire);

		setTitle("Application Gestion");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		setJMenuBar(createHeader());

		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		gestionClic.initialize();

		JPanel header = new JPanel();
		JLabel lblTitre = new JLabel("Paiement");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		header.add(lblTitre);
		contentPane.add(header, BorderLayout.NORTH);

		JPanel mainPanel = new JPanel(new BorderLayout());
		contentPane.add(mainPanel, BorderLayout.CENTER);

		JPanel infoPanel = new JPanel(new GridLayout(1, 2));

		JPanel leftInfo = new JPanel();
		leftInfo.add(new JLabel("Date paiement : "));
		lblValDate = new JLabel("—");
		leftInfo.add(lblValDate);

		JPanel rightInfo = new JPanel();
		rightInfo.add(new JLabel("Montant paiement : "));
		lblValPaiement = new JLabel("— €");
		rightInfo.add(lblValPaiement);

		infoPanel.add(leftInfo);
		infoPanel.add(rightInfo);
		mainPanel.add(infoPanel, BorderLayout.NORTH);

		JPanel filterPanel = new JPanel();
		comboBoxMois = new JComboBox<>(new String[]{
				"Mois", "Janvier", "Février", "Mars", "Avril", "Mai",
				"Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"
		});
		comboBoxMois.addActionListener(gestionClic);
		filterPanel.add(comboBoxMois);
		mainPanel.add(filterPanel, BorderLayout.BEFORE_FIRST_LINE);

		table = new JTable(new DefaultTableModel(
				new Object[][]{},
				new String[]{"ID Paiement", "ID Contrat", "Date Paiement", "Montant"}
		));
		mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

		JPanel totals = new JPanel(new GridLayout(1, 3));

		lblTotalPaiementAnnees = createBigLabel("3600", "Total Année");
		lblTotalPaiementMois = createBigLabel("1200", "Total Mois");
		lblDateDernierPaiement = createBigLabel("—", "Dernier Paiement");

		totals.add(wrap(lblTotalPaiementAnnees, "Total Année"));
		totals.add(wrap(lblTotalPaiementMois, "Total Mois"));
		totals.add(wrap(lblDateDernierPaiement, "Dernier Paiement"));

		mainPanel.add(totals, BorderLayout.SOUTH);

		progressBar = new JProgressBar();
		progressBar.setValue(30);
		progressBar.setStringPainted(true);
		progressBar.setString("30 % de paiements reçus");
		contentPane.add(progressBar, BorderLayout.SOUTH);

		JPanel buttons = new JPanel();
		JButton btnAjouter = new JButton("Ajouter paiement");
		JButton btnRetour = new JButton("Retour");

		btnAjouter.addActionListener(gestionClic);
		btnRetour.addActionListener(gestionClic);

		buttons.add(btnAjouter);
		buttons.add(btnRetour);

		contentPane.add(buttons, BorderLayout.PAGE_END);
	}

	private JLabel createBigLabel(String text, String title) {
		JLabel lbl = new JLabel(text, SwingConstants.CENTER);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 48));
		return lbl;
	}

	private JPanel wrap(JComponent c, String title) {
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new TitledBorder(title));
		p.add(c);
		return p;
	}


	public JTable getTable() {
		return table;
	}

	public JComboBox<String> getComboBoxMois() {
		return comboBoxMois;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
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

	public JLabel getLblValDate() {
		return lblValDate;
	}

	public JLabel getLblValPaiement() {
		return lblValPaiement;
	}
}
