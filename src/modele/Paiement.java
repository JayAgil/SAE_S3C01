package modele;

import java.sql.Date;
import java.util.Objects;

public class Paiement {

	@Override
	public String toString() {
		return "Paiement [id_paiement=" + id_paiement + ", montant=" + montant + ", datepaiement=" + datepaiement
				+ ", designation=" + designation + ", contratLocation=" + contratLocation + "]";
	}

	private String id_paiement;
	private double montant;
	private Date datepaiement;
	private String designation;
	private ContratLocation contratLocation;

	public Paiement(String id_paiement, double montant, Date datepaiement, String designation, ContratLocation cl) {
		this.id_paiement = id_paiement;
		this.montant = montant;
		this.datepaiement = datepaiement;
		this.designation = designation;
		this.contratLocation = cl;
	}

	public ContratLocation getContratLocation() {
		return contratLocation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setContratLocation(ContratLocation contratLocation) {
		this.contratLocation = contratLocation;
	}

	public void setId_paiement(String id_paiement) {
		this.id_paiement = id_paiement;
	}

	public String getId_paiement() {
		return id_paiement;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDatepaiement() {
		return datepaiement;
	}

	public void setDatepaiement(Date datepaiement) {
		this.datepaiement = datepaiement;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_paiement);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Paiement)) {
			return false;
		}
		Paiement other = (Paiement) obj;
		return Objects.equals(id_paiement, other.id_paiement);
	}

}
