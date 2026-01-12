package modele;

import java.util.Objects;

public class Garant {
	private String idGarant;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;

	/**
	 * Constructeur complet d'un garant.
	 *
	 * @param idGarant identifiant unique du garant
	 * @param nom      nom de famille
	 * @param prenom   prénom
	 * @param adresse  adresse
	 * @param tel      numéro de téléphone
	 */
	public Garant(String idGarant, String nom, String prenom, String adresse, String tel) {
		this.idGarant = idGarant;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
	}

	/** Retourne l'identifiant unique du garant. */
	public String getIdGarant() {
		return idGarant;
	}

	/** Définit l'identifiant unique du garant. */
	public void setIdGarant(String idGarant) {
		this.idGarant = idGarant;
	}

	/** Retourne le nom de famille du garant. */
	public String getNom() {
		return nom;
	}

	/** Définit le nom de famille du garant. */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Retourne le prénom du garant. */
	public String getPrenom() {
		return prenom;
	}

	/** Définit le prénom du garant. */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Retourne l'adresse du garant. */
	public String getAdresse() {
		return adresse;
	}

	/** Définit l'adresse du garant. */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/** Retourne le numéro de téléphone du garant. */
	public String getTel() {
		return tel;
	}

	/** Définit le numéro de téléphone du garant. */
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idGarant);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Garant))
			return false;
		Garant other = (Garant) obj;
		return Objects.equals(idGarant, other.idGarant);
	}

	@Override
	public String toString() {
		return "Garant [idGarant=" + idGarant + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", tel=" + tel + "]";
	}
}
