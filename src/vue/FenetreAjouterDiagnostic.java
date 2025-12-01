package vue;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionFenetreAjouterDiagnostic;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class FenetreAjouterDiagnostic extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldIdDiagnostic;
    private JTextField textFieldType;
    private JTextField textFieldDateRealisation;
    private JTextField textFieldDateValidité;
    private JTextField textFieldFichier;

    public JTextField getTextFieldFichier() {
        return textFieldFichier;
    }

    public void setTextFieldFichier(JTextField textFieldFichier) {
        this.textFieldFichier = textFieldFichier;
    }

    private GestionFenetreAjouterDiagnostic gestionClic;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenetreAjouterDiagnostic frame = new FenetreAjouterDiagnostic();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FenetreAjouterDiagnostic() {
    	setResizable(false);
        this.gestionClic = new GestionFenetreAjouterDiagnostic(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitre = new JLabel("Ajouter un diagnostic");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitre.setBounds(0, 37, 434, 29);
        contentPane.add(lblTitre);

        int labelX = 40;
        int labelW = 110;
        int fieldX = 160;
        int fieldW = 180;
        int fieldH = 22;

        JLabel lblId = new JLabel("ID Diagnostic :");
        lblId.setHorizontalAlignment(SwingConstants.RIGHT);
        lblId.setBounds(27, 115, labelW, 20);
        contentPane.add(lblId);

        textFieldIdDiagnostic = new JTextField();
        textFieldIdDiagnostic.setBounds(fieldX, 114, fieldW, fieldH);
        contentPane.add(textFieldIdDiagnostic);

        JLabel lblType = new JLabel("Type :");
        lblType.setHorizontalAlignment(SwingConstants.RIGHT);
        lblType.setBounds(-12, 164, labelW, 20);
        contentPane.add(lblType);

        textFieldType = new JTextField();
        textFieldType.setBounds(fieldX, 163, fieldW, fieldH);
        contentPane.add(textFieldType);

        JLabel lblDateRealisation = new JLabel("Date réalisation :");
        lblDateRealisation.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDateRealisation.setBounds(labelX, 209, labelW, 20);
        contentPane.add(lblDateRealisation);

        textFieldDateRealisation = new JTextField();
        textFieldDateRealisation.setBounds(fieldX, 209, fieldW, fieldH);
        contentPane.add(textFieldDateRealisation);

        JLabel lblTypeDateValidite = new JLabel("Date Validité :");
        lblTypeDateValidite.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTypeDateValidite.setBounds(27, 258, 110, 20);
        contentPane.add(lblTypeDateValidite);

        textFieldDateValidité = new JTextField();
        textFieldDateValidité.setBounds(fieldX, 257, fieldW, fieldH);
        contentPane.add(textFieldDateValidité);

        JLabel lblFichier = new JLabel("Fichier : ");
        lblFichier.setHorizontalAlignment(SwingConstants.RIGHT);
        lblFichier.setBounds(0, 301, labelW, 20);
        contentPane.add(lblFichier);

        textFieldFichier = new JTextField();
        textFieldFichier.setBounds(160, 300, 180, 22);
        contentPane.add(textFieldFichier);

        JButton btnChoisir = new JButton("Choisir");
        btnChoisir.setBounds(255, 332, 85, 22);
        contentPane.add(btnChoisir);

        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.setBounds(50, 397, 100, 25);
        contentPane.add(btnAjouter);

        JButton btnVider = new JButton("Vider");
        btnVider.setBounds(171, 397, 100, 25);
        contentPane.add(btnVider);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(289, 397, 100, 25);
        contentPane.add(btnRetour);

        btnChoisir.addActionListener(this.gestionClic);
        btnVider.addActionListener(this.gestionClic);
        btnAjouter.addActionListener(this.gestionClic);
        btnRetour.addActionListener(this.gestionClic);
    }
    
    public List<JTextField> getAllDiagnosticTextFields() {
        List<JTextField> fields = new ArrayList<>();
        fields.add(textFieldIdDiagnostic);
        fields.add(textFieldType);
        fields.add(textFieldDateRealisation);
        fields.add(textFieldDateValidité);
        fields.add(textFieldFichier);
        return fields;
    }
}
