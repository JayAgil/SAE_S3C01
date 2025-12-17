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

	@Override
	public int hashCode() {
		return Objects.hash(numeroFacture);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Facture)) {
			return false;
		}
		Facture other = (Facture) obj;
		return Objects.equals(numeroFacture, other.numeroFacture);
	}

	public void setNumeroFacture(String numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public void setDateDeFacture(Date dateDeFacture) {
		this.dateDeFacture = dateDeFacture;
	}

	public void setCompteBancaire(String compteBancaire) {
		this.compteBancaire = compteBancaire;
	}

	public void setMontantDevis(double montantDevis) {
		this.montantDevis = montantDevis;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public void setDesignationDeTravaux(String designationDeTravaux) {
		this.designationDeTravaux = designationDeTravaux;
	}

	public String getNumeroFacture() {
		return numeroFacture;
	}

	public double getMontant() {
		return montant;
	}

	public Date getDateDeFacture() {
		return dateDeFacture;
	}

	public String getCompteBancaire() {
		return compteBancaire;
	}

	public double getMontantDevis() {
		return montantDevis;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public String getDesignationDeTravaux() {
		return designationDeTravaux;
	}

	public BienLouable getBienLoauble() {
		return bienLoauble;
	}

	public void setBienLoauble(BienLouable bienLoauble) {
		this.bienLoauble = bienLoauble;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public double ecartMontant() {
		return montant - montantDevis;
	}

	/* ===== TEXTE FACTURE ===== */
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

}
