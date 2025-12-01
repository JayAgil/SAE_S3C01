package vue;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionFenetreAjouterLocataire;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FenetreAjouterLocataire extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse;
	private JTextField textFieldTel;
	private JTextField textFieldEmail;
	private JTextField textFieldCodePostal;
	private JTextField textFieldVille;
	private JTextField textFieldDateNaissance;
	private JTextField textFieldLieuNaissance;
	private JTextField textFieldSalaire;
	private JTextField textFieldProfession;
	private JTextField textFieldSituationFamiliale;

	private JTextField textFieldGarantNom;
	private JTextField textFieldGarantPrenom;
	private JTextField textFieldGarantAdresse;
	private JTextField textFieldGarantTel;
	private JTextField textIdLoc;
	
	private GestionFenetreAjouterLocataire gestionClic;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				javax.swing.JFrame frame = new javax.swing.JFrame();
				frame.setBounds(100, 100, 1000, 650);
				frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

				javax.swing.JDesktopPane desktopPane = new javax.swing.JDesktopPane();
				frame.setContentPane(desktopPane);

				FenetreAjouterLocataire internalFrame = new FenetreAjouterLocataire();
				internalFrame.setVisible(true);
				desktopPane.add(internalFrame);
				frame.setResizable(false); 
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FenetreAjouterLocataire() {
		setResizable(false);
		gestionClic = new GestionFenetreAjouterLocataire(this);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(50, 50, 450, 500);
		setTitle("Ajouter Locataire");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLocataire = new JLabel("Informations Locataire");
		lblLocataire.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocataire.setBounds(0, 0, 431, 30);
		contentPane.add(lblLocataire);

		JLabel lblGarant = new JLabel("Informations Garant");
		lblGarant.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGarant.setHorizontalAlignment(SwingConstants.CENTER);
		lblGarant.setBounds(0, 278, 431, 38);
		contentPane.add(lblGarant);

		// Locataire
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(23, 36, 40, 25);
		contentPane.add(lblNom);
		textFieldNom = new JTextField();
		textFieldNom.setBounds(85, 36, 105, 25);
		contentPane.add(textFieldNom);

		JLabel lblPrenom = new JLabel("Prénom :");
		lblPrenom.setBounds(23, 72, 120, 25);
		contentPane.add(lblPrenom);
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(85, 72, 105, 25);
		contentPane.add(textFieldPrenom);

		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(23, 108, 120, 25);
		contentPane.add(lblAdresse);
		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(85, 108, 105, 25);
		contentPane.add(textFieldAdresse);

		JLabel lblTel = new JLabel("Tel :");
		lblTel.setBounds(200, 36, 120, 25);
		contentPane.add(lblTel);
		textFieldTel = new JTextField();
		textFieldTel.setBounds(85, 144, 105, 25);
		contentPane.add(textFieldTel);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(23, 216, 120, 25);
		contentPane.add(lblEmail);
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(85, 180, 105, 25);
		contentPane.add(textFieldEmail);

		JLabel lblCodePostal = new JLabel("Code postal :");
		lblCodePostal.setBounds(23, 180, 120, 25);
		contentPane.add(lblCodePostal);
		textFieldCodePostal = new JTextField();
		textFieldCodePostal.setBounds(85, 216, 105, 25);
		contentPane.add(textFieldCodePostal);

		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(23, 144, 40, 25);
		contentPane.add(lblVille);
		textFieldVille = new JTextField();
		textFieldVille.setBounds(291, 36, 110, 25);
		contentPane.add(textFieldVille);

		JLabel lblDateNaissance = new JLabel("Date naissance :");
		lblDateNaissance.setBounds(200, 72, 120, 25);
		contentPane.add(lblDateNaissance);
		textFieldDateNaissance = new JTextField();
		textFieldDateNaissance.setBounds(291, 72, 110, 25);
		contentPane.add(textFieldDateNaissance);

		JLabel lblLieuNaissance = new JLabel("Lieu naissance :");
		lblLieuNaissance.setBounds(200, 108, 120, 25);
		contentPane.add(lblLieuNaissance);
		textFieldLieuNaissance = new JTextField();
		textFieldLieuNaissance.setBounds(291, 108, 110, 25);
		contentPane.add(textFieldLieuNaissance);

		JLabel lblSalaire = new JLabel("Salaire :");
		lblSalaire.setBounds(200, 144, 47, 25);
		contentPane.add(lblSalaire);
		textFieldSalaire = new JTextField();
		textFieldSalaire.setBounds(291, 144, 110, 25);
		contentPane.add(textFieldSalaire);

		JLabel lblProfession = new JLabel("Profession :");
		lblProfession.setBounds(200, 180, 120, 25);
		contentPane.add(lblProfession);
		textFieldProfession = new JTextField();
		textFieldProfession.setBounds(291, 180, 110, 25);
		contentPane.add(textFieldProfession);

		JLabel lblSituationFamiliale = new JLabel("Situation familiale :");
		lblSituationFamiliale.setBounds(200, 216, 92, 25);
		contentPane.add(lblSituationFamiliale);
		textFieldSituationFamiliale = new JTextField();
		textFieldSituationFamiliale.setBounds(291, 216, 110, 25);
		contentPane.add(textFieldSituationFamiliale);

		// Garant
		JLabel lblGarantNom = new JLabel("Nom :");
		lblGarantNom.setBounds(23, 319, 120, 25);
		contentPane.add(lblGarantNom);
		textFieldGarantNom = new JTextField();
		textFieldGarantNom.setBounds(85, 319, 105, 25);
		contentPane.add(textFieldGarantNom);

		JLabel lblGarantPrenom = new JLabel("Prénom :");
		lblGarantPrenom.setBounds(23, 355, 120, 25);
		contentPane.add(lblGarantPrenom);
		textFieldGarantPrenom = new JTextField();
		textFieldGarantPrenom.setBounds(85, 355, 105, 25);
		contentPane.add(textFieldGarantPrenom);

		JLabel lblGarantAdresse = new JLabel("Adresse :");
		lblGarantAdresse.setBounds(200, 319, 120, 25);
		contentPane.add(lblGarantAdresse);
		textFieldGarantAdresse = new JTextField();
		textFieldGarantAdresse.setBounds(296, 319, 105, 25);
		contentPane.add(textFieldGarantAdresse);

		JLabel lblGarantTel = new JLabel("Tel :");
		lblGarantTel.setBounds(200, 355, 120, 25);
		contentPane.add(lblGarantTel);
		textFieldGarantTel = new JTextField();
		textFieldGarantTel.setBounds(296, 355, 105, 25);
		contentPane.add(textFieldGarantTel);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this.gestionClic);
		btnAjouter.setBounds(44, 415, 98, 30);
		contentPane.add(btnAjouter);

		JButton btnVider = new JButton("Vider");
		btnVider.addActionListener(this.gestionClic);
		btnVider.setBounds(175, 415, 98, 30);
		contentPane.add(btnVider);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(this.gestionClic);
		btnRetour.setBounds(303, 415, 98, 30);
		contentPane.add(btnRetour);
		
		textIdLoc = new JTextField();
		textIdLoc.setBounds(85, 252, 105, 25);
		contentPane.add(textIdLoc);
		
		JLabel lblIdLoc = new JLabel("ID locataire : ");
		lblIdLoc.setBounds(23, 252, 120, 25);
		contentPane.add(lblIdLoc);
		
		
	}
	
	public List<JTextField> getAllLocataireTextFields() {
	    List<JTextField> fields = new ArrayList<>();
	    
	    fields.add(textFieldNom);
	    fields.add(textFieldPrenom);
	    fields.add(textFieldAdresse);
	    fields.add(textFieldTel);
	    fields.add(textFieldEmail);
	    fields.add(textFieldCodePostal);
	    fields.add(textFieldVille);
	    fields.add(textFieldDateNaissance);
	    fields.add(textFieldLieuNaissance);
	    fields.add(textFieldSalaire);
	    fields.add(textFieldProfession);
	    fields.add(textFieldSituationFamiliale);

	    fields.add(textFieldGarantNom);
	    fields.add(textFieldGarantPrenom);
	    fields.add(textFieldGarantAdresse);
	    fields.add(textFieldGarantTel);
	    fields.add(textIdLoc);
	    
	    return fields;
	}
	
}
