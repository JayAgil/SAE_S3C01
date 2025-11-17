package modele;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Paiement {

	private String id_paiement;
	private double montant;
	private Date datepaiement;
	private ContratLocation contratLocation;

	public Paiement(String id_paiement, double montant, Date datepaiement, ContratLocation cl) {
		this.id_paiement = id_paiement;
		this.montant = montant;
		this.datepaiement = datepaiement;
		this.contratLocation = cl;
	}

	public ContratLocation getContratLocation() {
		return contratLocation;
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
