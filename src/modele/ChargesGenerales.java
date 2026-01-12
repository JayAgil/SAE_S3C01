package modele;

import java.sql.Date;
import java.util.Objects;

public class ChargesGenerales {

	private String idChargesGenerales;
	private String typeCharge;
	private double montant;
	private float pourcentage;
	private double quotite;
	private Date dateCharge;
	private BienLouable bienLouable;

	/**
	 * Constructeur complet de la charge générale.
	 *
	 * @param idChargesGenerales identifiant unique
	 * @param typeCharge         type de la charge
	 * @param montant            montant total
	 * @param pourcentage        pourcentage imputé
	 * @param quotite            quotité applicable
	 * @param dateCharge         date de la charge
	 * @param bienLouable        bien louable associé
	 */
	public ChargesGenerales(String idChargesGenerales, String typeCharge, double montant, float pourcentage,
			double quotite, Date dateCharge, BienLouable bienLouable) {
		super();
		this.idChargesGenerales = idChargesGenerales;
		this.typeCharge = typeCharge;
		this.montant = montant;
		this.pourcentage = pourcentage;
		this.quotite = quotite;
		this.dateCharge = dateCharge;
		this.bienLouable = bienLouable;
	}

	/** Retourne la date de la charge. */
	public Date getDateCharge() {
		return this.dateCharge;
	}

	/** Définit la date de la charge. */
	public void setDateCharge(Date dateCharge) {
		this.dateCharge = dateCharge;
	}

	/** Retourne le bien louable associé à cette charge. */
	public BienLouable getBienLouable() {
		return bienLouable;
	}

	/** Définit le bien louable associé à cette charge. */
	public void setBienLouable(BienLouable bienLouable) {
		this.bienLouable = bienLouable;
	}

	/** Retourne l'identifiant unique de la charge. */
	public String getIdChargesGenerales() {
		return idChargesGenerales;
	}

	/** Définit l'identifiant unique de la charge. */
	public void setIdChargesGenerales(String idChargesGenerales) {
		this.idChargesGenerales = idChargesGenerales;
	}

	/** Retourne le type de la charge. */
	public String getTypeCharge() {
		return typeCharge;
	}

	/** Définit le type de la charge. */
	public void setTypeCharge(String typeCharge) {
		this.typeCharge = typeCharge;
	}

	/** Retourne le montant total de la charge. */
	public double getMontant() {
		return montant;
	}

	/** Définit le montant total de la charge. */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/** Retourne le pourcentage de la charge imputé au bien. */
	public float getPourcentage() {
		return pourcentage;
	}

	/** Définit le pourcentage de la charge imputé au bien. */
	public void setPourcentage(float pourcentage) {
		this.pourcentage = pourcentage;
	}

	/** Retourne la quotité de la charge applicable au bien. */
	public double getQuotite() {
		return quotite;
	}

	/** Définit la quotité de la charge applicable au bien. */
	public void setQuotite(double quotite) {
		this.quotite = quotite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bienLouable, idChargesGenerales, montant, pourcentage, quotite, typeCharge);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ChargesGenerales))
			return false;
		ChargesGenerales other = (ChargesGenerales) obj;
		return Objects.equals(bienLouable, other.bienLouable)
				&& Objects.equals(idChargesGenerales, other.idChargesGenerales)
				&& Double.doubleToLongBits(montant) == Double.doubleToLongBits(other.montant)
				&& Float.floatToIntBits(pourcentage) == Float.floatToIntBits(other.pourcentage)
				&& Double.doubleToLongBits(quotite) == Double.doubleToLongBits(other.quotite)
				&& Objects.equals(typeCharge, other.typeCharge);
	}

	@Override
	public String toString() {
		return "ChargesGenerales [idChargesGenerales=" + idChargesGenerales + ", typeCharge=" + typeCharge
				+ ", montant=" + montant + ", pourcentage=" + pourcentage + ", quotite=" + quotite + ", bienLouable="
				+ bienLouable + "]";
	}

	/**
	 * Calcule le montant de la charge imputé au bien selon le pourcentage.
	 *
	 * @return montant imputé
	 */
	public double calculerMontantImpute() {
		return montant * (pourcentage / 100.0);
	}

}
