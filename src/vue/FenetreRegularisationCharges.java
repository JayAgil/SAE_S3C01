package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import modele.ContratLocation;
import modele.dao.DaoContratLocation;

public class FenetreRegularisationCharges extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DaoContratLocation dao;
	private ContratLocation contrat;
	private String message;
	private float element;

	public FenetreRegularisationCharges(DaoContratLocation dao, ContratLocation contrat, float element) {
		this.dao = dao;
		this.contrat = contrat;
		this.element = element;

		if (element > 0) {
			message = "Le montant obtenu étant de " + element
					+ ", \nle montant mensuel de ce contrat \nva augmenter de " + (element / 12);
		} else if (element < 0) {
			message = "Le montant obtenu étant de " + element + ", \nle montant mensuel de ce contrat \nva diminuer de "
					+ (element / 12);
		} else {
			message = "Le montant obtenu est null, \nil n'y a pas d'écart";
			this.dispose();
		}

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 409, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnValider = new JButton("Continuer");
		btnValider.addActionListener(this);
		btnValider.setBounds(76, 103, 98, 21);
		contentPane.add(btnValider);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(209, 103, 98, 21);
		contentPane.add(btnAnnuler);

		JTextArea txtrTest = new JTextArea();
		txtrTest.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtrTest.setText(message);
		txtrTest.setRows(3);
		txtrTest.setBackground(new Color(240, 240, 240));
		txtrTest.setBounds(21, 20, 334, 73);
		contentPane.add(txtrTest);
		if (element == 0) {
            btnValider.setEnabled(false);
        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
		case "Continuer":
			contrat.setMontantMensuel(contrat.getMontantMensuel() + element / 12);
			try {
				dao.update(contrat);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.dispose();
		case "Annuler":
			this.dispose();
		}
	}
}
