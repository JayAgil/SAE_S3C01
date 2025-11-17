package modele;

import java.util.Objects;

public class Garant {
	private String idGarant;
	private String nom;
	private String adresse;
	private String tel;

	public Garant(String idGarant, String nom, String adresse, String tel) {
		this.idGarant = idGarant;
		this.nom = nom;
		this.adresse = adresse;
		this.tel = tel;
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
		return "Garant [idGarant=" + idGarant + ", nom=" + nom + ", Adresse=" + adresse + ", Tel=" + tel + "]";
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIdGarant() {
		return idGarant;
	}

	public String getNom() {
		return nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getTel() {
		return tel;
	}
}
