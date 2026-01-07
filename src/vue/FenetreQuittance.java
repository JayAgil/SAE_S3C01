package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import modele.Paiement;
import modele.ContratLocation;

public class FenetreQuittance extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    public FenetreQuittance(Paiement paiement) {

        ContratLocation contrat = paiement.getContratLocation();

        setTitle("Quittance de loyer");
        setSize(600, 500);
        setClosable(true); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelInfos = new JPanel(new GridLayout(5, 1, 5, 5));
        panelInfos.setBorder(new TitledBorder("Détails de la quittance"));

        panelInfos.add(createField("Période",
                contrat.getDateDebut() + " → " + contrat.getDateFin()));

        panelInfos.add(createField("Adresse du bien",
                contrat.getBienLouable().getAdresse()));

        panelInfos.add(createField("Loyer",
                String.format("%.2f €", paiement.getMontant())));

        panelInfos.add(createField("Charges",
                String.format("%.2f €", contrat.getProvisionCharge())));

        double total = paiement.getMontant();
        panelInfos.add(createField("Total payé",
                String.format("%.2f €", total)));
        
        double reste = total - (contrat.getProvisionCharge() + contrat.getMontantMensuel());
        panelInfos.add(createField("Reste à payer",
                String.format("%.2f €", reste)));

        JTextArea areaBas = new JTextArea(
                "Payé le : " + paiement.getDatepaiement() +
                "\nPaiement n° : " + paiement.getId_paiement()
        );
        areaBas.setEditable(false);
        areaBas.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaBas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(panelInfos, BorderLayout.NORTH);
        add(new JScrollPane(areaBas), BorderLayout.CENTER);
    }

    private JPanel createField(String label, String value) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel(label + " : ");
        lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
        JLabel val = new JLabel(value);
        panel.add(lbl, BorderLayout.WEST);
        panel.add(val, BorderLayout.CENTER);
        return panel;
    }
}
