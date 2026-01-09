package vue;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreDiagnostic extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private GestionFenetreDiagnostic gestionClic;
	private JTable table;
	private JLabel lblnbDiag;
	private JLabel lblnbDiagExp;
	private BienLouable bL;
	private JButton btnChoisir;

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

		JButton btnAjouter = new JButton("Ajouter");
		panel_1.add(btnAjouter);

		JButton btnModifier = new JButton("Mettre à jour");
		panel_1.add(btnModifier);

		btnChoisir = new JButton("Choisir");
		panel_1.add(btnChoisir);
		btnChoisir.setEnabled(false);

		JButton btnRetirer = new JButton("Retirer");
		panel_1.add(btnRetirer);

		JButton btnRetour = new JButton("Retour");
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
			new Object[][] {
			},
			new String[] {
				"ID Diagnostic", "Type Diagnostics", "Date R\u00E9alisation", "Date Validit\u00E9", "Fichier", "Bien Associ\u00E9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setPreferredWidth(96);

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

		this.gestionClic = new GestionFenetreDiagnostic(this);
		this.gestionClic.initialize();
		this.gestionClic.chargerDonnees();
		btnChoisir.addActionListener(this.gestionClic);
		btnRetour.addActionListener(this.gestionClic);
		btnModifier.addActionListener(this.gestionClic);
		btnAjouter.addActionListener(this.gestionClic);
		btnRetirer.addActionListener(gestionClic);


	}

	public JButton getBtnChoisir() {
		return btnChoisir;
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
