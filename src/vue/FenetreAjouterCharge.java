package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import controleur.GestionFenetreAjouterCharge;

import java.awt.Component;
import javax.swing.Box;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FenetreAjouterCharge extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JTextField txtTypeCharge;
	private JTextField txtMontant;
	private JTextField txtPourcentage;
	private JTextField txtQuotite;
	private GestionFenetreAjouterCharge gestionClic;
	private JTextField txtIdCharge;

	private JTextField textFieldDateCharge;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				JFrame frame = new JFrame();
				frame.setBounds(100, 100, 450, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JDesktopPane desktopPane = new JDesktopPane();
				frame.setContentPane(desktopPane);

				FenetreAjouterCharge internalFrame = new FenetreAjouterCharge();
				internalFrame.setVisible(true);
				desktopPane.add(internalFrame);

				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FenetreAjouterCharge() {
		gestionClic = new GestionFenetreAjouterCharge(this);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(50, 50, 450, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelHeader = new JPanel();
		JLabel lblTitre = new JLabel("Ajouter charge");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelHeader.add(lblTitre);

		Component verticalStrut = Box.createVerticalStrut(50);
		panelHeader.add(verticalStrut);

		getContentPane().add(panelHeader, BorderLayout.NORTH);

		JPanel panelCenter = new JPanel();
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[] { 180, 120 };
		gbl_panelCenter.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panelCenter.columnWeights = new double[] { 0.0, 1.0 };
		panelCenter.setLayout(gbl_panelCenter);
		getContentPane().add(panelCenter, BorderLayout.CENTER);

		Insets pad = new Insets(10, 10, 10, 10);

		GridBagConstraints idLabel = new GridBagConstraints();
		idLabel.anchor = GridBagConstraints.EAST;
		idLabel.insets = pad;
		idLabel.gridx = 0;
		idLabel.gridy = 0;
		JLabel label = new JLabel("ID Charge :");
		panelCenter.add(label, idLabel);

		GridBagConstraints gbc_txtIdCharge = new GridBagConstraints();
		gbc_txtIdCharge.insets = pad;
		gbc_txtIdCharge.anchor = GridBagConstraints.LINE_START;
		gbc_txtIdCharge.gridx = 1;
		gbc_txtIdCharge.gridy = 0;
		txtIdCharge = new JTextField(15);
		panelCenter.add(txtIdCharge, gbc_txtIdCharge);

		GridBagConstraints c1 = new GridBagConstraints();
		c1.insets = pad;
		c1.anchor = GridBagConstraints.LINE_END;
		c1.gridx = 0;
		c1.gridy = 1;
		panelCenter.add(new JLabel("Type charge :"), c1);

		GridBagConstraints c2 = new GridBagConstraints();
		c2.insets = pad;
		c2.anchor = GridBagConstraints.LINE_START;
		c2.gridx = 1;
		c2.gridy = 1;
		txtTypeCharge = new JTextField(15);
		panelCenter.add(txtTypeCharge, c2);

		GridBagConstraints c3 = new GridBagConstraints();
		c3.insets = pad;
		c3.anchor = GridBagConstraints.LINE_END;
		c3.gridx = 0;
		c3.gridy = 2;
		panelCenter.add(new JLabel("Montant :"), c3);

		GridBagConstraints c4 = new GridBagConstraints();
		c4.insets = pad;
		c4.anchor = GridBagConstraints.LINE_START;
		c4.gridx = 1;
		c4.gridy = 2;
		txtMontant = new JTextField(15);
		panelCenter.add(txtMontant, c4);

		GridBagConstraints c5 = new GridBagConstraints();
		c5.insets = pad;
		c5.anchor = GridBagConstraints.LINE_END;
		c5.gridx = 0;
		c5.gridy = 3;
		panelCenter.add(new JLabel("Pourcentage :"), c5);

		GridBagConstraints gbc_txtPourcentage = new GridBagConstraints();
		gbc_txtPourcentage.insets = pad;
		gbc_txtPourcentage.anchor = GridBagConstraints.LINE_START;
		gbc_txtPourcentage.gridx = 1;
		gbc_txtPourcentage.gridy = 3;
		txtPourcentage = new JTextField(15);
		panelCenter.add(txtPourcentage, gbc_txtPourcentage);

		GridBagConstraints c7 = new GridBagConstraints();
		c7.insets = pad;
		c7.anchor = GridBagConstraints.LINE_END;
		c7.gridx = 0;
		c7.gridy = 4;
		panelCenter.add(new JLabel("Quotité :"), c7);

		GridBagConstraints gbc_txtQuotite = new GridBagConstraints();
		gbc_txtQuotite.anchor = GridBagConstraints.WEST;
		gbc_txtQuotite.insets = pad;
		gbc_txtQuotite.gridx = 1;
		gbc_txtQuotite.gridy = 4;
		txtQuotite = new JTextField(15);
		panelCenter.add(txtQuotite, gbc_txtQuotite);

		JLabel lblDateCharge = new JLabel("Date charge :");
		GridBagConstraints gbc_lblDateCharge = new GridBagConstraints();
		gbc_lblDateCharge.anchor = GridBagConstraints.EAST;
		gbc_lblDateCharge.insets = new Insets(0, 0, 0, 5);
		gbc_lblDateCharge.gridx = 0;
		gbc_lblDateCharge.gridy = 5;
		panelCenter.add(lblDateCharge, gbc_lblDateCharge);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormatter dateFormatter = new DateFormatter(format);

		textFieldDateCharge = new JFormattedTextField(dateFormatter);
		textFieldDateCharge.setColumns(15);
		textFieldDateCharge.setToolTipText("Format attendu : yyyy-MM-dd");

		GridBagConstraints gbc_textFieldDateCharge = new GridBagConstraints();
		gbc_textFieldDateCharge.insets = new Insets(10, 10, 10, 10);
		gbc_textFieldDateCharge.anchor = GridBagConstraints.WEST;
		gbc_textFieldDateCharge.gridx = 1;
		gbc_textFieldDateCharge.gridy = 5;

		panelCenter.add(textFieldDateCharge, gbc_textFieldDateCharge);

		JPanel panelFooter = new JPanel();

		JButton btnVider = new JButton("Vider");
		btnVider.addActionListener(this.gestionClic);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this.gestionClic);
		panelFooter.add(btnAjouter);
		panelFooter.add(btnVider);

		getContentPane().add(panelFooter, BorderLayout.SOUTH);

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this.gestionClic);

		panelFooter.add(btnRetour);
	}

	public List<JTextField> getAllChargeTextFields() {
		List<JTextField> fields = new ArrayList<>();
		fields.add(txtIdCharge);
		fields.add(txtTypeCharge);
		fields.add(txtMontant);
		fields.add(txtPourcentage);
		fields.add(txtQuotite);
		fields.add(textFieldDateCharge);
		return fields;
	}
}
