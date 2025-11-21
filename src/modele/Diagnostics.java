package modele;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Diagnostics {
	private String idDiagnostics;
	private String typeDiagnostics;
	private Date dateRealisation;
	private Date dateValidite;
	private String fichier;
	private BienLouable bienLouable;
	public Diagnostics(String idDiagnostics, String typeDiagnostics, Date dateRealisation, Date dateValidite,
			String fichier, BienLouable bienLouable) {
		this.idDiagnostics = idDiagnostics;
		this.typeDiagnostics = typeDiagnostics;
		this.dateRealisation = dateRealisation;
		this.dateValidite = dateValidite;
		this.fichier = fichier;
		this.bienLouable = bienLouable;
	}
	public BienLouable getBienLouable() {
		return bienLouable;
	}
	public void setBienLouable(BienLouable bienLouable) {
		this.bienLouable = bienLouable;
	}
	public String getFichier() {
		return fichier;
	}
	public String getIdDiagnostics() {
		return idDiagnostics;
	}
	public String getTypeDiagnostics() {
		return typeDiagnostics;
	}
	public Date getDateRealisation() {
		return dateRealisation;
	}
	public Date getDateValidite() {
		return dateValidite;
	}
	public void setIdDiagnostics(String idDiagnostics) {
		this.idDiagnostics = idDiagnostics;
	}
	public void setTypeDiagnostics(String typeDiagnostics) {
		this.typeDiagnostics = typeDiagnostics;
	}
	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}
	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}
	public void setFichier(String fichier) {
		this.fichier = fichier;
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
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Diagnostics)) {
			return false;
		}
		Diagnostics other = (Diagnostics) obj;
		return Objects.equals(idDiagnostics, other.idDiagnostics);
	}
}
