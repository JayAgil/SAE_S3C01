package vue;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetreTravaux;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class FenetreTravaux extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private GestionFenetreTravaux gestionClic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreTravaux frame = new FenetreTravaux();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreTravaux() {
		super();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.gestionClic = new GestionFenetreTravaux(this);
		setBounds(100, 100, 1200, 800);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel_11 = new JPanel();
		getContentPane().add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new GridLayout(0, 1, 0, 0));

		// header

		this.setJMenuBar(createHeader());
		this.gestionClic.initialize();

		JPanel panel_12 = new JPanel();
		getContentPane().add(panel_12, BorderLayout.SOUTH);

		panel_12.add(createFooter());
		panel_12.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		JButton btnAjouterTravaux = new JButton("Ajouter travaux");
		btnAjouterTravaux.addActionListener(this.gestionClic);
		panel_1.add(btnAjouterTravaux);

		JButton btnAjouterEntreprise = new JButton("Ajouter entreprise");
		btnAjouterEntreprise.addActionListener(this.gestionClic);
		panel_1.add(btnAjouterEntreprise);

		JButton btnGenFacture = new JButton("Générer facture");
		btnGenFacture.addActionListener(this.gestionClic);
		panel_1.add(btnGenFacture);

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this.gestionClic);
		panel_1.add(btnRetour);

		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, },
				new String[] { "Num\u00E9ro facture", "Montant", "Date de facture", "Compte bancaire", "Montant devis",
						"Date de paiement", "D\u00E9signation travaux", "Entreprise" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Float.class,
					String.class, String.class, String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(58);
		table.getColumnModel().getColumn(2).setPreferredWidth(91);
		table.addMouseListener(this.gestionClic);

		scrollPane.setViewportView(table);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblTravaux = new JLabel("Travaux");
		lblTravaux.setHorizontalAlignment(SwingConstants.CENTER);
		lblTravaux.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblTravaux);

	}

	public void disableMenuItems(boolean actif) {
		this.mnBatiment.setEnabled(actif);
		this.mnPaiement.setEnabled(actif);
		this.mntmTravaux.setEnabled(actif);

	}

	public JTable getTable() {
		return table;
	}

}
