package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import modele.Entreprise;
import modele.Paiement;

public class FenetreQuittance extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public FenetreQuittance(Paiement paiement) {
		

		Entreprise entreprise = facture.getEntreprise();

        setTitle("Facture " + facture.getNumeroFacture());
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Quittance de loyer"));

        panel.add(createField("Periode", paiement.getContratLocation());
        panel.add(createField("Adresse", entreprise.getNom()));
        panel.add(createField("Loyer", entreprise.getAdresse()));
        panel.add(createField("Charges", entreprise.getSpecialite()));
        panel.add(createField("Total", entreprise.getSpecialite()));

        JTextArea areaFacture = new JTextArea(paiement.getId_paiement());
        areaFacture.setEditable(false);
        areaFacture.setFont(new Font("Monospaced", Font.PLAIN, 13));

        add(panelEntreprise, BorderLayout.NORTH);
        add(new JScrollPane(areaFacture), BorderLayout.CENTER);
	}

}
