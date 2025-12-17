package vue;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modele.Facture;

public class FenetreFacture extends JFrame {

    private static final long serialVersionUID = 1L;

    public FenetreFacture(Facture facture) {

        setTitle("Facture " + facture.getNumeroFacture());
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea(facture.getTexteFacture());
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 13));

        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}
