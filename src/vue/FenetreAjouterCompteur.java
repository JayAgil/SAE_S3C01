package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.GestionFenetreAjouterCompteur;
import controleur.GestionFenetreCompteurs;
import modele.BienLouable;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JComboBox;

public class FenetreAjouterCompteur extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JTextField txtPartieFixe;
	private JTextField txtPartieVariable;
	private JTextField txtTotal;
	private JTextField txtDate;
	private GestionFenetreAjouterCompteur gestionClic;
	private JTextField txtIdCompteur;
	private JComboBox<String> comboType;
	private JTextField txtIndexAncien;
	private JTextField txtIndexNouveau;
	private BienLouable b;
	private GestionFenetreCompteurs parent;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				JFrame frame = new JFrame();
				frame.setBounds(100, 100, 450, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JDesktopPane desktopPane = new JDesktopPane();
				frame.setContentPane(desktopPane);

				FenetreAjouterCompteur internalFrame = new FenetreAjouterCompteur(null, null);
				internalFrame.setVisible(true);
				desktopPane.add(internalFrame);
				frame.setResizable(false);

				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FenetreAjouterCompteur(BienLouable b, GestionFenetreCompteurs parent) {
		this.b = b;
		this.parent = parent;
		gestionClic = new GestionFenetreAjouterCompteur(this, b, parent);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(50, 50, 450, 500);
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

		GridBagConstraints idLabel = new GridBagConstraints();
		idLabel.insets = pad;
		idLabel.anchor = GridBagConstraints.LINE_END;
		idLabel.gridx = 0;
		idLabel.gridy = 0;
		JLabel label = new JLabel("ID Compteur :");
		panelCenter.add(label, idLabel);

		GridBagConstraints gbc_txtIdCompteur = new GridBagConstraints();
		gbc_txtIdCompteur.insets = pad;
		gbc_txtIdCompteur.anchor = GridBagConstraints.LINE_START;
		gbc_txtIdCompteur.gridx = 1;
		gbc_txtIdCompteur.gridy = 0;
		txtIdCompteur = new JTextField(15);
		panelCenter.add(txtIdCompteur, gbc_txtIdCompteur);

		GridBagConstraints c1 = new GridBagConstraints();
		c1.insets = pad;
		c1.anchor = GridBagConstraints.LINE_END;
		c1.gridx = 0;
		c1.gridy = 1;
		panelCenter.add(new JLabel("Partie Fixe :"), c1);

		GridBagConstraints gbc_txtPartieFixe = new GridBagConstraints();
		gbc_txtPartieFixe.insets = pad;
		gbc_txtPartieFixe.anchor = GridBagConstraints.LINE_START;
		gbc_txtPartieFixe.gridx = 1;
		gbc_txtPartieFixe.gridy = 1;
		txtPartieFixe = new JTextField(15);
		panelCenter.add(txtPartieFixe, gbc_txtPartieFixe);

		GridBagConstraints c3 = new GridBagConstraints();
		c3.insets = pad;
		c3.anchor = GridBagConstraints.LINE_END;
		c3.gridx = 0;
		c3.gridy = 2;
		panelCenter.add(new JLabel("Partie variable :"), c3);

		GridBagConstraints gbc_txtPartieVariable = new GridBagConstraints();
		gbc_txtPartieVariable.insets = pad;
		gbc_txtPartieVariable.anchor = GridBagConstraints.LINE_START;
		gbc_txtPartieVariable.gridx = 1;
		gbc_txtPartieVariable.gridy = 2;
		txtPartieVariable = new JTextField(15);
		panelCenter.add(txtPartieVariable, gbc_txtPartieVariable);

		GridBagConstraints c5 = new GridBagConstraints();
		c5.insets = pad;
		c5.anchor = GridBagConstraints.LINE_END;
		c5.gridx = 0;
		c5.gridy = 3;
		panelCenter.add(new JLabel("Total :"), c5);

		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = pad;
		gbc_lblType.anchor = GridBagConstraints.LINE_END;
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 4;
		JLabel lblType = new JLabel("Type : ");
		panelCenter.add(lblType, gbc_lblType);

		GridBagConstraints gbc_comboType = new GridBagConstraints();
		gbc_comboType.insets = pad;
		gbc_comboType.anchor = GridBagConstraints.LINE_START;
		gbc_comboType.gridx = 1;
		gbc_comboType.gridy = 4;

		String[] types = { "Eau", "Électricité", "Gaz", "Chauffage" };
		comboType = new javax.swing.JComboBox<>(types);
		comboType.setModel(new DefaultComboBoxModel(new String[] { "Eau", "Électricité", "Gaz" }));
		panelCenter.add(comboType, gbc_comboType);

		GridBagConstraints c7 = new GridBagConstraints();
		c7.insets = pad;
		c7.anchor = GridBagConstraints.LINE_END;
		c7.gridx = 0;
		c7.gridy = 5;
		panelCenter.add(new JLabel("Date installation :"), c7);

		GridBagConstraints gbc_txtDate = new GridBagConstraints();
		gbc_txtDate.insets = pad;
		gbc_txtDate.anchor = GridBagConstraints.LINE_START;
		gbc_txtDate.gridx = 1;
		gbc_txtDate.gridy = 5;
		txtDate = new JTextField(15);
		panelCenter.add(txtDate, gbc_txtDate);

		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.insets = pad;
		gbc_txtTotal.anchor = GridBagConstraints.LINE_START;
		gbc_txtTotal.gridx = 1;
		gbc_txtTotal.gridy = 3;
		txtTotal = new JTextField(15);
		txtTotal.setEditable(false);
		txtTotal.setBackground(new Color(255, 255, 255));
		panelCenter.add(txtTotal, gbc_txtTotal);

		GridBagConstraints c9 = new GridBagConstraints();
		c9.insets = pad;
		c9.anchor = GridBagConstraints.LINE_END;
		c9.gridx = 0;
		c9.gridy = 6;
		panelCenter.add(new JLabel("Index ancien :"), c9);

		GridBagConstraints gbc_txtIndexAncien = new GridBagConstraints();
		gbc_txtIndexAncien.insets = pad;
		gbc_txtIndexAncien.anchor = GridBagConstraints.LINE_START;
		gbc_txtIndexAncien.gridx = 1;
		gbc_txtIndexAncien.gridy = 6;
		txtIndexAncien = new JTextField(15);
		panelCenter.add(txtIndexAncien, gbc_txtIndexAncien);

		GridBagConstraints c11 = new GridBagConstraints();
		c11.insets = pad;
		c11.anchor = GridBagConstraints.LINE_END;
		c11.gridx = 0;
		c11.gridy = 7;
		panelCenter.add(new JLabel("Index nouveau :"), c11);

		GridBagConstraints gbc_txtIndexNouveau = new GridBagConstraints();
		gbc_txtIndexNouveau.insets = pad;
		gbc_txtIndexNouveau.anchor = GridBagConstraints.LINE_START;
		gbc_txtIndexNouveau.gridx = 1;
		gbc_txtIndexNouveau.gridy = 7;
		txtIndexNouveau = new JTextField(15);
		panelCenter.add(txtIndexNouveau, gbc_txtIndexNouveau);

		JPanel panelFooter = new JPanel();

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this.gestionClic);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this.gestionClic);
		panelFooter.add(btnAjouter);

		JButton btnVider = new JButton("Vider");
		btnVider.addActionListener(this.gestionClic);
		panelFooter.add(btnVider);

		panelFooter.add(btnRetour);

		getContentPane().add(panelFooter, BorderLayout.SOUTH);
	}

	public JComboBox<String> getComboType() {
		return comboType;
	}

	public List<JTextField> getAllCompteurTextFields() {
		List<JTextField> fields = new ArrayList<>();
		fields.add(txtIdCompteur);
		fields.add(txtPartieFixe);
		fields.add(txtPartieVariable);
		fields.add(txtTotal);
		fields.add(txtDate);
		fields.add(txtIndexAncien);
		fields.add(txtIndexNouveau);
		return fields;
	}

}
