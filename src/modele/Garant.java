package modele;

import java.util.Objects;

public class Garant {
	private String idGarant;
	private String nom;
	private String Adresse;
	private int Tel;
	public Garant(String idGarant, String nom, String adresse, int tel) {
		super();
		this.idGarant = idGarant;
		this.nom = nom;
		Adresse = adresse;
		Tel = tel;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idGarant);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Garant)) {
			return false;
		}
		Garant other = (Garant) obj;
		return Objects.equals(idGarant, other.idGarant);
	}
	public void setIdGarant(String idGarant) {
		this.idGarant = idGarant;
	}
	@Override
	public String toString() {
		return "Garant [idGarant=" + idGarant + ", nom=" + nom + ", Adresse=" + Adresse + ", Tel=" + Tel + "]";
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public void setTel(int tel) {
		Tel = tel;
	}
	public String getIdGarant() {
		return idGarant;
	}
	public String getNom() {
		return nom;
	}
	public String getAdresse() {
		return Adresse;
	}
	public int getTel() {
		return Tel;
	}
}
