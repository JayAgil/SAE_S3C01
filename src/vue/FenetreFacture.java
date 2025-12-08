package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.print.*;

public class FenetreFacture extends JFrame {

    private Object[] data;
    private String[] columnNames;
    private String source;

    public FenetreFacture(Object[] rowData, String[] columnNames, String source) {

        this.data = rowData;
        this.columnNames = columnNames;
        this.source = source;

        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String titre;
        if (source.equals("Travaux")) {
            titre = "Facture Travaux";
        } else {
            titre = "Facture Paiement";
        }

        JLabel titleLabel = new JLabel(titre, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);
        JPanel contentPanel = new JPanel(new GridLayout(0, 2, 15, 15));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        for (int i = 0; i < data.length; i++) {
            String label = (i < columnNames.length) ? columnNames[i] : "Champ " + (i + 1);
            contentPanel.add(new JLabel(label + " :"));
            contentPanel.add(new JLabel(String.valueOf(data[i])));
        }

        add(contentPanel, BorderLayout.CENTER);

        JButton btnPrint = new JButton("Imprimer facture");
        btnPrint.addActionListener(e -> {

            PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Facture");

            job.setPrintable((graphics, pageFormat, pageIndex) -> {

                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) graphics;
                g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                this.printAll(g2);

                return Printable.PAGE_EXISTS;
            });

            boolean ok = job.printDialog();
            if (ok) {
                try {
                    job.print();
                    JOptionPane.showMessageDialog(this, "Impression réussie !");
                } catch (PrinterException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erreur d'impression.");
                }
            }
        });

        JPanel footer = new JPanel();
        footer.add(btnPrint);
        add(footer, BorderLayout.SOUTH);
    }
}
