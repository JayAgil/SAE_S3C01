package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class FenetreAjouterCompteur extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JTextField txtTypeCharge;
	private JTextField txtMontant;
	private JTextField txtDate;
	private JTextField txtTotal;
	private JTextField txtCommentaire;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				JFrame frame = new JFrame();
				frame.setBounds(100, 100, 600, 450);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JDesktopPane desktopPane = new JDesktopPane();
				frame.setContentPane(desktopPane);

				FenetreAjouterCompteur internalFrame = new FenetreAjouterCompteur();
				internalFrame.setVisible(true);
				desktopPane.add(internalFrame);

				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FenetreAjouterCompteur() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(50, 50, 600, 450);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelHeader = new JPanel();
		JLabel lblTitre = new JLabel("Ajouter compteur");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelHeader.add(lblTitre);

		Component verticalStrut = Box.createVerticalStrut(50);
		panelHeader.add(verticalStrut);

		getContentPane().add(panelHeader, BorderLayout.NORTH);

		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		getContentPane().add(panelCenter, BorderLayout.CENTER);

		Insets pad = new Insets(10, 10, 10, 10);

		// Row 0 - ID Charge
		GridBagConstraints idLabel = new GridBagConstraints();
		idLabel.insets = pad;
		idLabel.anchor = GridBagConstraints.LINE_END;
		idLabel.gridx = 0;
		idLabel.gridy = 0;
		JLabel label = new JLabel("ID Compteur :");
		panelCenter.add(label, idLabel);

		GridBagConstraints idField = new GridBagConstraints();
		idField.insets = pad;
		idField.anchor = GridBagConstraints.LINE_START;
		idField.gridx = 1;
		idField.gridy = 0;
		JTextField txtIdCharge = new JTextField(15);
		panelCenter.add(txtIdCharge, idField);

		// Row 1
		GridBagConstraints c1 = new GridBagConstraints();
		c1.insets = pad;
		c1.anchor = GridBagConstraints.LINE_END;
		c1.gridx = 0;
		c1.gridy = 1;
		panelCenter.add(new JLabel("Partie Fixe :"), c1);

		GridBagConstraints c2 = new GridBagConstraints();
		c2.insets = pad;
		c2.anchor = GridBagConstraints.LINE_START;
		c2.gridx = 1;
		c2.gridy = 1;
		txtTypeCharge = new JTextField(15);
		panelCenter.add(txtTypeCharge, c2);

		// Row 2
		GridBagConstraints c3 = new GridBagConstraints();
		c3.insets = pad;
		c3.anchor = GridBagConstraints.LINE_END;
		c3.gridx = 0;
		c3.gridy = 2;
		panelCenter.add(new JLabel("Partie variable :"), c3);

		GridBagConstraints c4 = new GridBagConstraints();
		c4.insets = pad;
		c4.anchor = GridBagConstraints.LINE_START;
		c4.gridx = 1;
		c4.gridy = 2;
		txtMontant = new JTextField(15);
		panelCenter.add(txtMontant, c4);

		// Row 3
		GridBagConstraints c5 = new GridBagConstraints();
		c5.insets = pad;
		c5.anchor = GridBagConstraints.LINE_END;
		c5.gridx = 0;
		c5.gridy = 3;
		panelCenter.add(new JLabel("Total :"), c5);

		// Row 5
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = pad;
		gbc_lblType.anchor = GridBagConstraints.LINE_END;
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 4;
		JLabel lblType = new JLabel("Type : ");
		panelCenter.add(lblType, gbc_lblType);

		GridBagConstraints c6 = new GridBagConstraints();
		c6.insets = pad;
		c6.anchor = GridBagConstraints.LINE_START;
		c6.gridx = 1;
		c6.gridy = 4;

		String[] types = { "Eau", "Électricité", "Gaz", "Chauffage" };
		javax.swing.JComboBox<String> comboType = new javax.swing.JComboBox<>(types);
		comboType.setModel(new DefaultComboBoxModel(new String[] { "Eau", "Électricité", "Gaz" }));

		panelCenter.add(comboType, c6);

		// Row 4
		GridBagConstraints c7 = new GridBagConstraints();
		c7.insets = pad;
		c7.anchor = GridBagConstraints.LINE_END;
		c7.gridx = 0;
		c7.gridy = 5;
		panelCenter.add(new JLabel("Date :"), c7);

		GridBagConstraints c8 = new GridBagConstraints();
		c8.insets = pad;
		c8.anchor = GridBagConstraints.LINE_START;
		c8.gridx = 1;
		c8.gridy = 5;
		txtCommentaire = new JTextField(15);
		panelCenter.add(txtCommentaire, c8);

		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.insets = pad;
		gbc_txtTotal.anchor = GridBagConstraints.LINE_START;
		gbc_txtTotal.gridx = 1;
		gbc_txtTotal.gridy = 3;
		txtTotal = new JTextField(15);
		panelCenter.add(txtTotal, gbc_txtTotal);

		// Row 6 - Index ancien
		GridBagConstraints c9 = new GridBagConstraints();
		c9.insets = pad;
		c9.anchor = GridBagConstraints.LINE_END;
		c9.gridx = 0;
		c9.gridy = 6;
		panelCenter.add(new JLabel("Index ancien :"), c9);

		GridBagConstraints c10 = new GridBagConstraints();
		c10.insets = pad;
		c10.anchor = GridBagConstraints.LINE_START;
		c10.gridx = 1;
		c10.gridy = 6;
		JTextField txtIndexAncien = new JTextField(15);
		panelCenter.add(txtIndexAncien, c10);

		// Row 7 - Index nouveau
		GridBagConstraints c11 = new GridBagConstraints();
		c11.insets = pad;
		c11.anchor = GridBagConstraints.LINE_END;
		c11.gridx = 0;
		c11.gridy = 7;
		panelCenter.add(new JLabel("Index nouveau :"), c11);

		GridBagConstraints c12 = new GridBagConstraints();
		c12.insets = pad;
		c12.anchor = GridBagConstraints.LINE_START;
		c12.gridx = 1;
		c12.gridy = 7;
		JTextField txtIndexNouveau = new JTextField(15);
		panelCenter.add(txtIndexNouveau, c12);

		JPanel panelFooter = new JPanel();

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this);

		panelFooter.add(btnRetour);
		panelFooter.add(btnAnnuler);
		panelFooter.add(btnAjouter);

		getContentPane().add(panelFooter, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
