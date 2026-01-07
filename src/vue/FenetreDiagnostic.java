package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controleur.GestionFenetreDiagnostic;
import modele.BienLouable;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class FenetreDiagnostic extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private GestionFenetreDiagnostic gestionClic;
	private JTable table;
	private JLabel lblnbDiag;
	private JLabel lblnbDiagExp;
	private BienLouable bL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FenetreDiagnostic frame = new FenetreDiagnostic(null);
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
	public FenetreDiagnostic(BienLouable bL) throws SQLException {
		super();
		this.bL = bL;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		getContentPane().setLayout(new BorderLayout(0, 0));

		// header
		this.setJMenuBar(createHeader());

		JPanel panelFooter = new JPanel();
		getContentPane().add(panelFooter, BorderLayout.SOUTH);
		panelFooter.setLayout(new GridLayout(0, 1, 0, 0));

		panelFooter.add(createFooter());

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		JButton btnRetour = new JButton("Retour");

		JButton btnAjouter = new JButton("Ajouter");
		panel_1.add(btnAjouter);
		panel_1.add(btnRetour);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);

		JLabel lblTitre = new JLabel("Diagnostics");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblTitre);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 1186, 0 };
		gbl_panel_3.rowHeights = new int[] { 400, 208, 100 };
		gbl_panel_3.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 1.0 };
		panel_3.setLayout(gbl_panel_3);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_3.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Type Diagnostics", "Date R\u00E9alisation", "Date Validit\u00E9", "Fichier",
						"Bien Associ\u00E9" }));

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel_3.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nombre de Diagnostics Valide Aujourd'hui", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_4.add(panel_5);

		lblnbDiag = new JLabel("32");
		lblnbDiag.setFont(new Font("Tahoma", Font.PLAIN, 95));
		panel_5.add(lblnbDiag);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Diagnostics expirant ce mois", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.add(panel_6);

		lblnbDiagExp = new JLabel("33\r\n");
		lblnbDiagExp.setFont(new Font("Tahoma", Font.PLAIN, 95));
		panel_6.add(lblnbDiagExp);
		table.getColumnModel().getColumn(0).setPreferredWidth(96);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		
		this.gestionClic = new GestionFenetreDiagnostic(this);
		this.gestionClic.initialize();
		btnRetour.addActionListener(this.gestionClic);
		this.gestionClic.chargerDonnees();
	}

	public JLabel getLblnbDiag() {
		return lblnbDiag;
	}

	public void setLblnbDiag(JLabel lblnbDiag) {
		this.lblnbDiag = lblnbDiag;
	}

	public JLabel getLblnbDiagExp() {
		return lblnbDiagExp;
	}

	public void setLblnbDiagExp(JLabel lblnbDiagExp) {
		this.lblnbDiagExp = lblnbDiagExp;
	}

	public GestionFenetreDiagnostic getGestionClic() {
		return gestionClic;
	}

	public void setGestionClic(GestionFenetreDiagnostic gestionClic) {
		this.gestionClic = gestionClic;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BienLouable getBien() {
		return this.bL;
	}

}
