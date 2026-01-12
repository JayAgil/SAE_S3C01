package modele;

import java.sql.Date;
import java.util.Objects;

public class Paiement {

	private String id_paiement;
	private double montant;
	private Date datepaiement;
	private String designation;
	private ContratLocation contratLocation;

	/**
	 * Constructeur complet d'un paiement.
	 *
	 * @param id_paiement  identifiant unique du paiement
	 * @param montant      montant du paiement
	 * @param datepaiement date du paiement
	 * @param designation  désignation ou description du paiement
	 * @param cl           contrat de location associé au paiement
	 */
	public Paiement(String id_paiement, double montant, Date datepaiement, String designation, ContratLocation cl) {
		this.id_paiement = id_paiement;
		this.montant = montant;
		this.datepaiement = datepaiement;
		this.designation = designation;
		this.contratLocation = cl;
	}

	/** Retourne l'identifiant unique du paiement. */
	public String getId_paiement() {
		return id_paiement;
	}

	/** Définit l'identifiant unique du paiement. */
	public void setId_paiement(String id_paiement) {
		this.id_paiement = id_paiement;
	}

	/** Retourne le montant du paiement. */
	public double getMontant() {
		return montant;
	}

	/** Définit le montant du paiement. */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/** Retourne la date du paiement. */
	public Date getDatepaiement() {
		return datepaiement;
	}

	/** Définit la date du paiement. */
	public void setDatepaiement(Date datepaiement) {
		this.datepaiement = datepaiement;
	}

	/** Retourne la désignation ou description du paiement. */
	public String getDesignation() {
		return designation;
	}

	/** Définit la désignation ou description du paiement. */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/** Retourne le contrat de location associé à ce paiement. */
	public ContratLocation getContratLocation() {
		return contratLocation;
	}

	/** Définit le contrat de location associé à ce paiement. */
	public void setContratLocation(ContratLocation contratLocation) {
		this.contratLocation = contratLocation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_paiement);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Paiement))
			return false;
		Paiement other = (Paiement) obj;
		return Objects.equals(id_paiement, other.id_paiement);
	}

	@Override
	public String toString() {
		return "Paiement [id_paiement=" + id_paiement + ", montant=" + montant + ", datepaiement=" + datepaiement
				+ ", designation=" + designation + ", contratLocation=" + contratLocation + "]";
	}
}
