package vue;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionFenetreAjouterContratLocation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class FenetreAjouterContratLocation extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtFieldNumContrat;
    private JTextField textFieldDateDebut;
    private JTextField textFieldADateFin;
    private JTextField txtFieldMontant;
    private JTextField textFieldProvision;
    private JTextField textFieldSolde;
    private GestionFenetreAjouterContratLocation gestionClic;
    private JTextField textFieldMontantMensuel;
    private JTextField textFieldDateVersement;
    private JTextField textFieldIdxEau;
    private JTextField textFieldElectrcité;
    private JTextField textFieldGaz;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenetreAjouterContratLocation frame = new FenetreAjouterContratLocation();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FenetreAjouterContratLocation() {
    	setResizable(false);
        this.gestionClic = new GestionFenetreAjouterContratLocation(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, -17, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitre = new JLabel("Ajouter Contrat Location");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitre.setBounds(131, 29, 187, 29);
        contentPane.add(lblTitre);

        JLabel lblNumContrat = new JLabel("Numéro de contrat :");
        lblNumContrat.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNumContrat.setBounds(23, 90, 132, 13);
        contentPane.add(lblNumContrat);

        txtFieldNumContrat = new JTextField();
        txtFieldNumContrat.setBounds(219, 87, 96, 19);
        contentPane.add(txtFieldNumContrat);
        txtFieldNumContrat.setColumns(10);

        JLabel lblDateDebut = new JLabel("Date début :");
        lblDateDebut.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDateDebut.setBounds(75, 120, 79, 13);
        contentPane.add(lblDateDebut);

        textFieldDateDebut = new JTextField();
        textFieldDateDebut.setBounds(219, 117, 96, 19);
        contentPane.add(textFieldDateDebut);
        textFieldDateDebut.setColumns(10);

        textFieldADateFin = new JTextField();
        textFieldADateFin.setColumns(10);
        textFieldADateFin.setBounds(219, 147, 96, 19);
        contentPane.add(textFieldADateFin);

        txtFieldMontant = new JTextField();
        txtFieldMontant.setColumns(10);
        txtFieldMontant.setBounds(219, 177, 96, 19);
        contentPane.add(txtFieldMontant);

        textFieldProvision = new JTextField();
        textFieldProvision.setColumns(10);
        textFieldProvision.setBounds(219, 207, 96, 19);
        contentPane.add(textFieldProvision);

        textFieldSolde = new JTextField();
        textFieldSolde.setColumns(10);
        textFieldSolde.setBounds(219, 237, 96, 19);
        contentPane.add(textFieldSolde);

        JLabel lblDateFin = new JLabel("Date fin :");
        lblDateFin.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDateFin.setBounds(101, 150, 54, 13);
        contentPane.add(lblDateFin);

        JLabel lblMontant = new JLabel("Montant de caution :");
        lblMontant.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMontant.setBounds(38, 180, 117, 13);
        contentPane.add(lblMontant);

        JLabel lblProvision = new JLabel("Provision charge :");
        lblProvision.setHorizontalAlignment(SwingConstants.RIGHT);
        lblProvision.setBounds(60, 210, 95, 13);
        contentPane.add(lblProvision);

        JLabel lblSolde = new JLabel("Solde :");
        lblSolde.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSolde.setBounds(75, 240, 80, 13);
        contentPane.add(lblSolde);

        JButton btnValider = new JButton("Valider");
        btnValider.setBounds(85, 432, 85, 21);
        contentPane.add(btnValider);

        JButton btnAnnuler = new JButton("Annuler ");
        btnAnnuler.setBounds(180, 432, 85, 21);
        contentPane.add(btnAnnuler);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(275, 432, 85, 21);
        contentPane.add(btnRetour);

        JLabel lblMontantMensuel = new JLabel("Montant mensuel :");
        lblMontantMensuel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMontantMensuel.setBounds(60, 270, 95, 13);
        contentPane.add(lblMontantMensuel);

        textFieldMontantMensuel = new JTextField();
        textFieldMontantMensuel.setBounds(219, 267, 96, 19);
        contentPane.add(textFieldMontantMensuel);
        textFieldMontantMensuel.setColumns(10);

        JLabel lblDateVersement = new JLabel("Date versement :");
        lblDateVersement.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDateVersement.setBounds(75, 300, 80, 13);
        contentPane.add(lblDateVersement);

        textFieldDateVersement = new JTextField();
        textFieldDateVersement.setBounds(219, 297, 96, 19);
        contentPane.add(textFieldDateVersement);
        textFieldDateVersement.setColumns(10);

        JLabel lblIdxEau = new JLabel("Index Eau :");
        lblIdxEau.setHorizontalAlignment(SwingConstants.RIGHT);
        lblIdxEau.setBounds(101, 330, 54, 13);
        contentPane.add(lblIdxEau);

        textFieldIdxEau = new JTextField();
        textFieldIdxEau.setBounds(219, 327, 96, 19);
        contentPane.add(textFieldIdxEau);
        textFieldIdxEau.setColumns(10);

        JLabel lblIdxElectricite = new JLabel("Index Electricité :");
        lblIdxElectricite.setHorizontalAlignment(SwingConstants.RIGHT);
        lblIdxElectricite.setBounds(75, 360, 80, 13);
        contentPane.add(lblIdxElectricite);

        JLabel lblIdxGaz = new JLabel("Index Gaz :");
        lblIdxGaz.setHorizontalAlignment(SwingConstants.RIGHT);
        lblIdxGaz.setBounds(101, 390, 54, 13);
        contentPane.add(lblIdxGaz);

        textFieldElectrcité = new JTextField();
        textFieldElectrcité.setColumns(10);
        textFieldElectrcité.setBounds(219, 357, 96, 19);
        contentPane.add(textFieldElectrcité);

        textFieldGaz = new JTextField();
        textFieldGaz.setColumns(10);
        textFieldGaz.setBounds(219, 387, 96, 19);
        contentPane.add(textFieldGaz);

        btnAnnuler.addActionListener(this.gestionClic);
        btnValider.addActionListener(this.gestionClic);
        btnRetour.addActionListener(this.gestionClic);
    }
}
