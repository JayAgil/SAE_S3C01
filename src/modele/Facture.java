package modele;

import java.sql.Date;
import java.util.Objects;

public class Facture {
	private String numeroFacture;
	private double montant;
	private Date dateDeFacture;
	private String compteBancaire;
	private double montantDevis;
	private Date datePaiement;
	private String designationDeTravaux;
	private BienLouable bienLoauble;
	private Entreprise entreprise;

	/**
	 * Constructeur complet d'une facture.
	 *
	 * @param numeroFacture        numéro unique de la facture
	 * @param montant              montant total facturé
	 * @param dateDeFacture        date de la facture
	 * @param compteBancaire       compte bancaire pour le paiement
	 * @param montantDevis         montant du devis initial
	 * @param datePaiement         date de paiement effective
	 * @param designationDeTravaux description des travaux
	 * @param bienLouable          bien louable concerné
	 * @param entreprise           entreprise réalisant les travaux
	 */
	public Facture(String numeroFacture, double montant, Date dateDeFacture, String compteBancaire, double montantDevis,
			Date datePaiement, String designationDeTravaux, BienLouable bienLouable, Entreprise entreprise) {
		super();
		this.numeroFacture = numeroFacture;
		this.montant = montant;
		this.dateDeFacture = dateDeFacture;
		this.compteBancaire = compteBancaire;
		this.montantDevis = montantDevis;
		this.datePaiement = datePaiement;
		this.designationDeTravaux = designationDeTravaux;
		this.bienLoauble = bienLouable;
		this.entreprise = entreprise;
	}

	/** Retourne le numéro unique de la facture. */
	public String getNumeroFacture() {
		return numeroFacture;
	}

	/** Définit le numéro unique de la facture. */
	public void setNumeroFacture(String numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	/** Retourne le montant total facturé. */
	public double getMontant() {
		return montant;
	}

	/** Définit le montant total facturé. */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/** Retourne la date de la facture. */
	public Date getDateDeFacture() {
		return dateDeFacture;
	}

	/** Définit la date de la facture. */
	public void setDateDeFacture(Date dateDeFacture) {
		this.dateDeFacture = dateDeFacture;
	}

	/** Retourne le compte bancaire associé. */
	public String getCompteBancaire() {
		return compteBancaire;
	}

	/** Définit le compte bancaire associé. */
	public void setCompteBancaire(String compteBancaire) {
		this.compteBancaire = compteBancaire;
	}

	/** Retourne le montant du devis initial. */
	public double getMontantDevis() {
		return montantDevis;
	}

	/** Définit le montant du devis initial. */
	public void setMontantDevis(double montantDevis) {
		this.montantDevis = montantDevis;
	}

	/** Retourne la date de paiement effective. */
	public Date getDatePaiement() {
		return datePaiement;
	}

	/** Définit la date de paiement effective. */
	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	/** Retourne la désignation des travaux. */
	public String getDesignationDeTravaux() {
		return designationDeTravaux;
	}

	/** Définit la désignation des travaux. */
	public void setDesignationDeTravaux(String designationDeTravaux) {
		this.designationDeTravaux = designationDeTravaux;
	}

	/** Retourne le bien louable concerné. */
	public BienLouable getBienLoauble() {
		return bienLoauble;
	}

	/** Définit le bien louable concerné. */
	public void setBienLoauble(BienLouable bienLoauble) {
		this.bienLoauble = bienLoauble;
	}

	/** Retourne l'entreprise réalisant les travaux. */
	public Entreprise getEntreprise() {
		return entreprise;
	}

	/** Définit l'entreprise réalisant les travaux. */
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	/**
	 * Calcule l'écart entre le montant facturé et le montant du devis.
	 *
	 * @return différence entre montant facturé et montant devis
	 */
	public double ecartMontant() {
		return montant - montantDevis;
	}

	/**
	 * Retourne le texte complet de la facture pour affichage ou impression.
	 *
	 * @return texte formaté de la facture
	 */
	public String getTexteFacture() {
		StringBuilder sb = new StringBuilder();

		sb.append("===== FACTURE TRAVAUX =====\n\n");
		sb.append("Numéro facture : ").append(numeroFacture).append("\n");
		sb.append("Date facture : ").append(dateDeFacture).append("\n");
		sb.append("Travaux : ").append(designationDeTravaux).append("\n\n");
		sb.append("Entreprise : ").append(entreprise.getNom()).append("\n");
		sb.append("Compte bancaire : ").append(compteBancaire).append("\n\n");
		sb.append("Montant devis : ").append(String.format("%.2f €", montantDevis)).append("\n");
		sb.append("Montant facture : ").append(String.format("%.2f €", montant)).append("\n");
		sb.append("Écart : ").append(String.format("%.2f €", ecartMontant())).append("\n");

		if (datePaiement != null) {
			sb.append("Date de paiement : ").append(datePaiement).append("\n");
		}

		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroFacture);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Facture))
			return false;
		Facture other = (Facture) obj;
		return Objects.equals(numeroFacture, other.numeroFacture);
	}

}
