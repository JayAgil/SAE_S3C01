package modele;

import java.sql.Date;
import java.util.Objects;

public class Diagnostics {
	private String idDiagnostics;
	private String typeDiagnostics;
	private Date dateRealisation;
	private Date dateValidite;
	private String fichier;
	private BienLouable bienLouable;

	/**
	 * Constructeur complet d'un diagnostic.
	 *
	 * @param idDiagnostics   identifiant unique
	 * @param typeDiagnostics type de diagnostic
	 * @param dateRealisation date de réalisation
	 * @param dateValidite    date de validité
	 * @param fichier         fichier associé
	 * @param bienLouable     bien louable concerné
	 */
	public Diagnostics(String idDiagnostics, String typeDiagnostics, Date dateRealisation, Date dateValidite,
			String fichier, BienLouable bienLouable) {
		this.idDiagnostics = idDiagnostics;
		this.typeDiagnostics = typeDiagnostics;
		this.dateRealisation = dateRealisation;
		this.dateValidite = dateValidite;
		this.fichier = fichier;
		this.bienLouable = bienLouable;
	}

	/** Retourne le bien louable associé au diagnostic. */
	public BienLouable getBienLouable() {
		return bienLouable;
	}

	/** Définit le bien louable associé au diagnostic. */
	public void setBienLouable(BienLouable bienLouable) {
		this.bienLouable = bienLouable;
	}

	/** Retourne le fichier associé au diagnostic. */
	public String getFichier() {
		return fichier;
	}

	/** Définit le fichier associé au diagnostic. */
	public void setFichier(String fichier) {
		this.fichier = fichier;
	}

	/** Retourne l'identifiant du diagnostic. */
	public String getIdDiagnostics() {
		return idDiagnostics;
	}

	/** Définit l'identifiant du diagnostic. */
	public void setIdDiagnostics(String idDiagnostics) {
		this.idDiagnostics = idDiagnostics;
	}

	/** Retourne le type de diagnostic. */
	public String getTypeDiagnostics() {
		return typeDiagnostics;
	}

	/** Définit le type de diagnostic. */
	public void setTypeDiagnostics(String typeDiagnostics) {
		this.typeDiagnostics = typeDiagnostics;
	}

	/** Retourne la date de réalisation du diagnostic. */
	public Date getDateRealisation() {
		return dateRealisation;
	}

	/** Définit la date de réalisation du diagnostic. */
	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}

	/** Retourne la date de validité du diagnostic. */
	public Date getDateValidite() {
		return dateValidite;
	}

	/** Définit la date de validité du diagnostic. */
	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}

	@Override
	public String toString() {
		return "Diagnostics [idDiagnostics=" + idDiagnostics + ", typeDiagnostics=" + typeDiagnostics
				+ ", dateRealisation=" + dateRealisation + ", dateValidite=" + dateValidite + ", fichier=" + fichier
				+ ", bienLouable=" + bienLouable + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDiagnostics);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Diagnostics))
			return false;
		Diagnostics other = (Diagnostics) obj;
		return Objects.equals(idDiagnostics, other.idDiagnostics);
	}
}
