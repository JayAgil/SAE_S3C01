package vue;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import controleur.GestionFenetreRegularisationCharges;
import modele.ContratLocation;
import modele.dao.DaoContratLocation;

/**
 * Fenêtre de régularisation des charges.
 * Cette fenêtre permet d'informer l'utilisateur d'un écart entre
 * les charges réelles et les charges provisionnées d'un contrat,
 * et de proposer une mise à jour du montant mensuel.
 */
public class FenetreRegularisationCharges extends JInternalFrame  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DaoContratLocation dao;
	private ContratLocation contrat;
	private String message;
	private float element;
	
	/**
	 * Construit la fenêtre de régularisation des charges pour un contrat donné.
	 * En fonction du montant calculé, la fenêtre indique si le loyer
	 * doit augmenter, diminuer ou rester inchangé.
	 *
	 * @param dao le DAO permettant d'accéder aux contrats de location
	 * @param contrat le contrat de location concerné
	 * @param element le montant de régularisation (positif ou négatif)
	 */
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
		btnValider.setBounds(76, 103, 98, 21);
		contentPane.add(btnValider);

		JButton btnAnnuler = new JButton("Annuler");
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
		
		GestionFenetreRegularisationCharges gestionClic = new GestionFenetreRegularisationCharges(this);
		btnValider.addActionListener(gestionClic);
		btnAnnuler.addActionListener(gestionClic);

	}
	
	/**
	 * Retourne le contrat de location concerné par la régularisation.
	 *
	 * @return le contrat de location
	 */
	public ContratLocation getContrat() {
		return contrat;
	}
	
	/**
	 * Retourne le montant de régularisation.
	 * Un montant positif signifie une augmentation,
	 * un montant négatif une diminution.
	 *
	 * @return le montant de régularisation
	 */
	public float getElement() {
		return element;
	}
	
	/**
	 * Retourne le DAO utilisé pour accéder aux contrats.
	 *
	 * @return le DaoContratLocation
	 */
	public DaoContratLocation getDao() {
		return dao;
	}

}
