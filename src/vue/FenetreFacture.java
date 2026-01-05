package vue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modele.Entreprise;
import modele.Facture;

public class FenetreFacture extends JFrame {

    private static final long serialVersionUID = 1L;

    public FenetreFacture(Facture facture) {

        Entreprise entreprise = facture.getEntreprise();

        setTitle("Facture " + facture.getNumeroFacture());
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panelEntreprise = new JPanel(new GridLayout(4, 1, 5, 5));
        panelEntreprise.setBorder(BorderFactory.createTitledBorder("Entreprise"));

        panelEntreprise.add(createField("SIRET", entreprise.getNumSiret()));
        panelEntreprise.add(createField("Nom", entreprise.getNom()));
        panelEntreprise.add(createField("Adresse", entreprise.getAdresse()));
        panelEntreprise.add(createField("Spécialité", entreprise.getSpecialite()));

        JTextArea areaFacture = new JTextArea(facture.getTexteFacture());
        areaFacture.setEditable(false);
        areaFacture.setFont(new Font("Monospaced", Font.PLAIN, 13));

        add(panelEntreprise, BorderLayout.NORTH);
        add(new JScrollPane(areaFacture), BorderLayout.CENTER);
    }

    private JTextArea createField(String label, String value) {
        JTextArea area = new JTextArea(label + " : " + value);
        area.setEditable(false);
        area.setOpaque(false);
        area.setFont(new Font("SansSerif", Font.PLAIN, 12));
        return area;
    }
}
