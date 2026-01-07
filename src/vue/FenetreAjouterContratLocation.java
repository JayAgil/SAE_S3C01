package vue;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import controleur.GestionFenetreAjouterContratLocation;
import controleur.GestionFenetreContratLocation;
import modele.BienLouable;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.awt.Dimension;

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
    private BienLouable bl;
    private GestionFenetreContratLocation parent;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenetreAjouterContratLocation frame = new FenetreAjouterContratLocation(null,null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FenetreAjouterContratLocation(GestionFenetreContratLocation parent, BienLouable bl) {
    	this.bl = bl;
    	this.parent = parent;
        setResizable(false);
        this.gestionClic = new GestionFenetreAjouterContratLocation(this,bl,parent);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, -17, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 15, 10, 15));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] {5};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
        contentPane.setLayout(gbl_contentPane);
        
        Dimension fieldSize = new Dimension(150, 25);

        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.gridx = 0;
        gbcTitle.gridy = 0;
        gbcTitle.gridwidth = 6;
        gbcTitle.insets = new Insets(0, 0, 15, 0);
        gbcTitle.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel lblTitre = new JLabel("Ajouter Contrat Location");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitre, gbcTitle);
        
        GridBagConstraints gbcLabel1 = new GridBagConstraints();
        gbcLabel1.anchor = GridBagConstraints.EAST;
        gbcLabel1.gridx = 0;
        gbcLabel1.gridy = 1;
        gbcLabel1.fill = GridBagConstraints.NONE;
        gbcLabel1.insets = new Insets(2, 5, 5, 5);
        gbcLabel1.weightx = 0.4;
        JLabel lblNumContrat = new JLabel("Numéro de contrat :");
        lblNumContrat.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblNumContrat, gbcLabel1);

        GridBagConstraints gbcField1 = new GridBagConstraints();
        gbcField1.gridwidth = 2;
        gbcField1.gridx = 1;
        gbcField1.gridy = 1;
        gbcField1.fill = GridBagConstraints.HORIZONTAL;
        gbcField1.insets = new Insets(2, 5, 5, 0);
        gbcField1.weightx = 0.6;
        gbcField1.ipadx = 5;
        txtFieldNumContrat = new JTextField();
        txtFieldNumContrat.setPreferredSize(fieldSize);
        contentPane.add(txtFieldNumContrat, gbcField1);

        GridBagConstraints gbcLabel2 = new GridBagConstraints();
        gbcLabel2.anchor = GridBagConstraints.EAST;
        gbcLabel2.gridx = 0;
        gbcLabel2.gridy = 2;
        gbcLabel2.fill = GridBagConstraints.NONE;
        gbcLabel2.insets = new Insets(2, 5, 5, 5);
        gbcLabel2.weightx = 0.4;
        JLabel lblDateDebut = new JLabel("Date début :");
        lblDateDebut.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblDateDebut, gbcLabel2);

        GridBagConstraints gbcField2 = new GridBagConstraints();
        gbcField2.gridwidth = 2;
        gbcField2.gridx = 1;
        gbcField2.gridy = 2;
        gbcField2.fill = GridBagConstraints.HORIZONTAL;
        gbcField2.insets = new Insets(2, 5, 5, 0);
        gbcField2.weightx = 0.6;
        gbcField2.ipadx = 5;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DateFormatter dateFormatter = new DateFormatter(format);
		textFieldDateDebut = new JFormattedTextField(dateFormatter);
		textFieldDateDebut.setToolTipText("Format attendu : yyyy-MM-dd");
        textFieldDateDebut.setPreferredSize(fieldSize);
        contentPane.add(textFieldDateDebut, gbcField2);

        GridBagConstraints gbcLabel3 = new GridBagConstraints();
        gbcLabel3.anchor = GridBagConstraints.EAST;
        gbcLabel3.gridx = 0;
        gbcLabel3.gridy = 3;
        gbcLabel3.fill = GridBagConstraints.NONE;
        gbcLabel3.insets = new Insets(2, 5, 5, 5);
        gbcLabel3.weightx = 0.4;
        JLabel lblDateFin = new JLabel("Date fin :");
        lblDateFin.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblDateFin, gbcLabel3);

        GridBagConstraints gbcField3 = new GridBagConstraints();
        gbcField3.gridwidth = 2;
        gbcField3.gridx = 1;
        gbcField3.gridy = 3;
        gbcField3.fill = GridBagConstraints.HORIZONTAL;
        gbcField3.insets = new Insets(2, 5, 5, 0);
        gbcField3.weightx = 0.6;
        gbcField3.ipadx = 5;
        textFieldADateFin = new JFormattedTextField(dateFormatter);
        textFieldADateFin.setToolTipText("Format attendu : yyyy-MM-dd");
        textFieldADateFin.setPreferredSize(fieldSize);
        contentPane.add(textFieldADateFin, gbcField3);

        GridBagConstraints gbcLabel4 = new GridBagConstraints();
        gbcLabel4.anchor = GridBagConstraints.EAST;
        gbcLabel4.gridx = 0;
        gbcLabel4.gridy = 4;
        gbcLabel4.fill = GridBagConstraints.NONE;
        gbcLabel4.insets = new Insets(2, 5, 5, 5);
        gbcLabel4.weightx = 0.4;
        JLabel lblMontant = new JLabel("Montant de caution :");
        lblMontant.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblMontant, gbcLabel4);

        GridBagConstraints gbcField4 = new GridBagConstraints();
        gbcField4.gridwidth = 2;
        gbcField4.gridx = 1;
        gbcField4.gridy = 4;
        gbcField4.fill = GridBagConstraints.HORIZONTAL;
        gbcField4.insets = new Insets(2, 5, 5, 0);
        gbcField4.weightx = 0.6;
        gbcField4.ipadx = 5;
        txtFieldMontant = new JTextField();
        txtFieldMontant.setPreferredSize(fieldSize);
        contentPane.add(txtFieldMontant, gbcField4);
        
        GridBagConstraints gbcLabel5 = new GridBagConstraints();
        gbcLabel5.anchor = GridBagConstraints.EAST;
        gbcLabel5.gridx = 0;
        gbcLabel5.gridy = 5;
        gbcLabel5.fill = GridBagConstraints.NONE;
        gbcLabel5.insets = new Insets(2, 5, 5, 5);
        gbcLabel5.weightx = 0.4;
        JLabel lblProvision = new JLabel("Provision charge :");
        lblProvision.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblProvision, gbcLabel5);

        GridBagConstraints gbcField5 = new GridBagConstraints();
        gbcField5.gridwidth = 2;
        gbcField5.gridx = 1;
        gbcField5.gridy = 5;
        gbcField5.fill = GridBagConstraints.HORIZONTAL;
        gbcField5.insets = new Insets(2, 5, 5, 0);
        gbcField5.weightx = 0.6;
        gbcField5.ipadx = 5;
        textFieldProvision = new JTextField();
        textFieldProvision.setPreferredSize(fieldSize);
        contentPane.add(textFieldProvision, gbcField5);

        GridBagConstraints gbcLabel6 = new GridBagConstraints();
        gbcLabel6.anchor = GridBagConstraints.EAST;
        gbcLabel6.gridx = 0;
        gbcLabel6.gridy = 6;
        gbcLabel6.fill = GridBagConstraints.NONE;
        gbcLabel6.insets = new Insets(2, 5, 5, 5);
        gbcLabel6.weightx = 0.4;
        JLabel lblSolde = new JLabel("Solde :");
        lblSolde.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblSolde, gbcLabel6);

        GridBagConstraints gbcField6 = new GridBagConstraints();
        gbcField6.gridwidth = 2;
        gbcField6.gridx = 1;
        gbcField6.gridy = 6;
        gbcField6.fill = GridBagConstraints.HORIZONTAL;
        gbcField6.insets = new Insets(2, 5, 5, 0);
        gbcField6.weightx = 0.6;
        gbcField6.ipadx = 5;
        textFieldSolde = new JTextField();
        textFieldSolde.setPreferredSize(fieldSize);
        contentPane.add(textFieldSolde, gbcField6);
        
        GridBagConstraints gbcLabel7 = new GridBagConstraints();
        gbcLabel7.anchor = GridBagConstraints.EAST;
        gbcLabel7.gridx = 0;
        gbcLabel7.gridy = 7;
        gbcLabel7.fill = GridBagConstraints.NONE;
        gbcLabel7.insets = new Insets(2, 5, 5, 5);
        gbcLabel7.weightx = 0.4;
        JLabel lblMontantMensuel = new JLabel("Montant mensuel :");
        lblMontantMensuel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblMontantMensuel, gbcLabel7);

        GridBagConstraints gbcField7 = new GridBagConstraints();
        gbcField7.gridwidth = 2;
        gbcField7.gridx = 1;
        gbcField7.gridy = 7;
        gbcField7.fill = GridBagConstraints.HORIZONTAL;
        gbcField7.insets = new Insets(2, 5, 5, 0);
        gbcField7.weightx = 0.6;
        gbcField7.ipadx = 5;
        textFieldMontantMensuel = new JTextField();
        textFieldMontantMensuel.setPreferredSize(fieldSize);
        contentPane.add(textFieldMontantMensuel, gbcField7);

        GridBagConstraints gbcLabel8 = new GridBagConstraints();
        gbcLabel8.anchor = GridBagConstraints.EAST;
        gbcLabel8.gridx = 0;
        gbcLabel8.gridy = 8;
        gbcLabel8.fill = GridBagConstraints.NONE;
        gbcLabel8.insets = new Insets(2, 5, 5, 5);
        gbcLabel8.weightx = 0.4;
        JLabel lblDateVersement = new JLabel("Date versement :");
        lblDateVersement.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblDateVersement, gbcLabel8);

        GridBagConstraints gbcField8 = new GridBagConstraints();
        gbcField8.gridwidth = 2;
        gbcField8.gridx = 1;
        gbcField8.gridy = 8;
        gbcField8.fill = GridBagConstraints.HORIZONTAL;
        gbcField8.insets = new Insets(2, 5, 5, 0);
        gbcField8.weightx = 0.6;
        gbcField8.ipadx = 5;
        textFieldDateVersement = new JTextField();
        textFieldDateVersement.setPreferredSize(fieldSize);
        contentPane.add(textFieldDateVersement, gbcField8);

        GridBagConstraints gbcLabel9 = new GridBagConstraints();
        gbcLabel9.anchor = GridBagConstraints.EAST;
        gbcLabel9.gridx = 0;
        gbcLabel9.gridy = 9;
        gbcLabel9.fill = GridBagConstraints.NONE;
        gbcLabel9.insets = new Insets(2, 5, 5, 5);
        gbcLabel9.weightx = 0.4;
        JLabel lblIdxEau = new JLabel("Index Eau :");
        lblIdxEau.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblIdxEau, gbcLabel9);

        GridBagConstraints gbcField9 = new GridBagConstraints();
        gbcField9.gridwidth = 2;
        gbcField9.gridx = 1;
        gbcField9.gridy = 9;
        gbcField9.fill = GridBagConstraints.HORIZONTAL;
        gbcField9.insets = new Insets(2, 5, 5, 0);
        gbcField9.weightx = 0.6;
        gbcField9.ipadx = 5;
        textFieldIdxEau = new JTextField();
        textFieldIdxEau.setPreferredSize(fieldSize);
        contentPane.add(textFieldIdxEau, gbcField9);


        GridBagConstraints gbcLabel10 = new GridBagConstraints();
        gbcLabel10.anchor = GridBagConstraints.EAST;
        gbcLabel10.gridx = 0;
        gbcLabel10.gridy = 10;
        gbcLabel10.fill = GridBagConstraints.NONE;
        gbcLabel10.insets = new Insets(2, 5, 5, 5);
        gbcLabel10.weightx = 0.4;
        JLabel lblIdxElectricite = new JLabel("Index Electricité :");
        lblIdxElectricite.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblIdxElectricite, gbcLabel10);

        GridBagConstraints gbcField10 = new GridBagConstraints();
        gbcField10.gridwidth = 2;
        gbcField10.gridx = 1;
        gbcField10.gridy = 10;
        gbcField10.fill = GridBagConstraints.HORIZONTAL;
        gbcField10.insets = new Insets(2, 5, 5, 0);
        gbcField10.weightx = 0.6;
        gbcField10.ipadx = 5;
        textFieldElectrcité = new JTextField();
        textFieldElectrcité.setPreferredSize(fieldSize);
        contentPane.add(textFieldElectrcité, gbcField10);

        GridBagConstraints gbcLabel11 = new GridBagConstraints();
        gbcLabel11.anchor = GridBagConstraints.EAST;
        gbcLabel11.gridx = 0;
        gbcLabel11.gridy = 11;
        gbcLabel11.fill = GridBagConstraints.NONE;
        gbcLabel11.insets = new Insets(2, 5, 5, 5);
        gbcLabel11.weightx = 0.4;
        JLabel lblIdxGaz = new JLabel("Index Gaz :");
        lblIdxGaz.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblIdxGaz, gbcLabel11);

        GridBagConstraints gbcField11 = new GridBagConstraints();
        gbcField11.gridwidth = 2;
        gbcField11.gridx = 1;
        gbcField11.gridy = 11;
        gbcField11.fill = GridBagConstraints.HORIZONTAL;
        gbcField11.insets = new Insets(2, 5, 5, 0);
        gbcField11.weightx = 0.6;
        gbcField11.ipadx = 5;
        textFieldGaz = new JTextField();
        textFieldGaz.setPreferredSize(fieldSize);
        contentPane.add(textFieldGaz, gbcField11);
        
        GridBagConstraints gbcButtonPanel = new GridBagConstraints();
        gbcButtonPanel.gridy = 13;
        gbcButtonPanel.gridx = 0;
        gbcButtonPanel.gridwidth = 6;
        gbcButtonPanel.insets = new Insets(15, 0, 0, 0);
        gbcButtonPanel.fill = GridBagConstraints.HORIZONTAL;
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, gbcButtonPanel);

        JButton btnAjouter = new JButton("Ajouter");
        buttonPanel.add(btnAjouter);

        JButton btnVider = new JButton("Vider");
        buttonPanel.add(btnVider);

        JButton btnRetour = new JButton("Retour");
        buttonPanel.add(btnRetour);

        btnVider.addActionListener(this.gestionClic);
        btnAjouter.addActionListener(this.gestionClic);
        btnRetour.addActionListener(this.gestionClic);
    }
    
    public List<JTextField> getAllContratTextFields() {
        List<JTextField> fields = new ArrayList<>();
        fields.add(txtFieldNumContrat);
        fields.add(textFieldDateDebut);
        fields.add(textFieldADateFin);
        fields.add(txtFieldMontant);
        fields.add(textFieldProvision);
        fields.add(textFieldSolde);
        fields.add(textFieldMontantMensuel);
        fields.add(textFieldDateVersement);
        fields.add(textFieldIdxEau);
        fields.add(textFieldElectrcité);
        fields.add(textFieldGaz);
        return fields;
    }
}