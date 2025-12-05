package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import controleur.GestionFenetreDiagnostic;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class FenetreDiagnostic extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private GestionFenetreDiagnostic gestionClic;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FenetreDiagnostic frame = new FenetreDiagnostic();
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
	public FenetreDiagnostic() {
		super();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.gestionClic = new GestionFenetreDiagnostic(this);
		setBounds(100, 100, 1200, 800);
		getContentPane().setLayout(new BorderLayout(0, 0));

		// header
		this.setJMenuBar(createHeader());

		this.gestionClic.initialize();

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
		btnRetour.addActionListener(this.gestionClic);

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
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Type Diagnostics", "Date R\u00E9alisation", "Date Validit\u00E9", "Fichier",
						"Bien Associ\u00E9" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(96);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);

	}

	public void disableMenuItems(boolean actif) {
		this.mnBatiment.setEnabled(actif);
		this.mnPaiement.setEnabled(actif);
		this.mntmDiagnostic.setEnabled(actif);
	}
}
