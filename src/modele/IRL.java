package modele;

import java.util.Objects;

public class IRL {
	private int annee;
	private int trimestre;
	private double valeur;

	/**
	 * Constructeur complet pour un IRL.
	 *
	 * @param annee     année de l'IRL
	 * @param trimestre trimestre de l'année (1 à 4)
	 * @param valeur    valeur de l'IRL
	 */
	public IRL(int annee, int trimestre, double valeur) {
		this.annee = annee;
		this.trimestre = trimestre;
		this.valeur = valeur;
	}

	/** Retourne l'année de l'IRL. */
	public int getAnnee() {
		return annee;
	}

	/** Définit l'année de l'IRL. */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/** Retourne le trimestre de l'IRL. */
	public int getTrimestre() {
		return trimestre;
	}

	/** Définit le trimestre de l'IRL. */
	public void setTrimestre(int trimestre) {
		this.trimestre = trimestre;
	}

	/** Retourne la valeur de l'IRL. */
	public double getIRL() {
		return valeur;
	}

	/** Définit la valeur de l'IRL. */
	public void setIRL(double valeur) {
		this.valeur = valeur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(annee, trimestre, valeur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof IRL))
			return false;
		IRL other = (IRL) obj;
		return annee == other.annee && trimestre == other.trimestre
				&& Double.doubleToLongBits(valeur) == Double.doubleToLongBits(other.valeur);
	}

	@Override
	public String toString() {
		return "IRL [annee=" + annee + ", trimestre=" + trimestre + ", valeur=" + valeur + "]";
	}
}
