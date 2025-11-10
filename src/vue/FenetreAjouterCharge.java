package vue;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FenetreAjouterCharge extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMontant;
	private JTextField textFieldPourcentage;
	private JTextField textFieldQuotite;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				// For testing only: you need a JFrame + JDesktopPane to show JInternalFrame
				javax.swing.JFrame frame = new javax.swing.JFrame();
				frame.setBounds(100, 100, 600, 400);
				frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

				javax.swing.JDesktopPane desktopPane = new javax.swing.JDesktopPane();
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
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(50, 50, 400, 300);
		setTitle("Ajouter Charge");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitre = new JLabel("Ajouter Charge");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitre.setBounds(50, 10, 300, 30);
		contentPane.add(lblTitre);

		JLabel lblTypeCharge = new JLabel("Type charge :");
		lblTypeCharge.setBounds(50, 60, 100, 25);
		contentPane.add(lblTypeCharge);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Eau", "Électricité", "Gaz"}));
		comboBox.setBounds(160, 60, 150, 25);
		contentPane.add(comboBox);

		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setBounds(50, 100, 100, 25);
		contentPane.add(lblMontant);

		textFieldMontant = new JTextField();
		textFieldMontant.setBounds(160, 100, 150, 25);
		contentPane.add(textFieldMontant);

		JLabel lblPourcentage = new JLabel("Pourcentage :");
		lblPourcentage.setBounds(50, 140, 100, 25);
		contentPane.add(lblPourcentage);

		textFieldPourcentage = new JTextField();
		textFieldPourcentage.setBounds(160, 140, 150, 25);
		contentPane.add(textFieldPourcentage);

		JLabel lblQuotite = new JLabel("Quotité :");
		lblQuotite.setBounds(50, 180, 100, 25);
		contentPane.add(lblQuotite);

		textFieldQuotite = new JTextField();
		textFieldQuotite.setBounds(160, 180, 150, 25);
		contentPane.add(textFieldQuotite);

		JButton btnRetour = new JButton("Annuler");
		btnRetour.setBounds(80, 220, 100, 30);
		contentPane.add(btnRetour);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(200, 220, 100, 30);
		contentPane.add(btnAjouter);
	}
}
