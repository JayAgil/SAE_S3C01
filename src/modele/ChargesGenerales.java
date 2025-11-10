package modele;

import java.util.Objects;

public class ChargesGenerales {
	
	private String idChargesGenerales;
	private String typeCharge;
	private double montant;
	private float pourcentage;
	private double quotite;
	private BienLouable bienLouable;
	
	public ChargesGenerales(String idChargesGenerales, String typeCharge, double montant, float pourcentage,
			double quotite, BienLouable bienLouable) {
		super();
		this.idChargesGenerales = idChargesGenerales;
		this.typeCharge = typeCharge;
		this.montant = montant;
		this.pourcentage = pourcentage;
		this.quotite = quotite;
		this.bienLouable = bienLouable;
	}
	
	public BienLouable getBienLouable() {
		return bienLouable;
	}

	public void setBienLouable(BienLouable bienLouable) {
		this.bienLouable = bienLouable;
	}

	public String getIdChargesGenerales() {
		return idChargesGenerales;
	}
	public void setIdChargesGenerales(String idChargesGenerales) {
		this.idChargesGenerales = idChargesGenerales;
	}
	public String getTypeCharge() {
		return typeCharge;
	}
	public void setTypeCharge(String typeCharge) {
		this.typeCharge = typeCharge;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public float getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(float pourcentage) {
		this.pourcentage = pourcentage;
	}
	public double getQuotite() {
		return quotite;
	}
	public void setQuotite(double quotite) {
		this.quotite = quotite;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bienLouable, idChargesGenerales, montant, pourcentage, quotite, typeCharge);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ChargesGenerales)) {
			return false;
		}
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
	
	
	public double calculerMontantImpute() {
	    return montant * (pourcentage / 100.0);
	}


}
