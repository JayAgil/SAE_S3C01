package modele;

import java.util.Objects;

public class Entreprise {

	private String numSiret;
	private String adresse;
	private String ville;
	private String codePostal;
	private String nom;
	private String numTel;
	private String specialite;

	/**
	 * Constructeur complet de l'entreprise.
	 *
	 * @param numSiret   numéro SIRET unique
	 * @param adresse    adresse postale
	 * @param ville      ville
	 * @param codePostal code postal
	 * @param nom        nom commercial
	 * @param numTel     numéro de téléphone
	 * @param specialite spécialité ou domaine d'activité
	 */
	public Entreprise(String numSiret, String adresse, String ville, String codePostal, String nom, String numTel,
			String specialite) {
		this.numSiret = numSiret;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.nom = nom;
		this.numTel = numTel;
		this.specialite = specialite;
	}

	/** Retourne le numéro SIRET de l'entreprise. */
	public String getNumSiret() {
		return numSiret;
	}

	/** Définit le numéro SIRET de l'entreprise. */
	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	/** Retourne l'adresse de l'entreprise. */
	public String getAdresse() {
		return adresse;
	}

	/** Définit l'adresse de l'entreprise. */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/** Retourne la ville de l'entreprise. */
	public String getVille() {
		return ville;
	}

	/** Définit la ville de l'entreprise. */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/** Retourne le code postal de l'entreprise. */
	public String getCodePostal() {
		return codePostal;
	}

	/** Définit le code postal de l'entreprise. */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/** Retourne le nom commercial de l'entreprise. */
	public String getNom() {
		return nom;
	}

	/** Définit le nom commercial de l'entreprise. */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Retourne le numéro de téléphone de l'entreprise. */
	public String getNumTel() {
		return numTel;
	}

	/** Définit le numéro de téléphone de l'entreprise. */
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	/** Retourne la spécialité ou domaine d'activité de l'entreprise. */
	public String getSpecialite() {
		return specialite;
	}

	/** Définit la spécialité ou domaine d'activité de l'entreprise. */
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numSiret);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Entreprise))
			return false;
		Entreprise other = (Entreprise) obj;
		return Objects.equals(numSiret, other.numSiret);
	}

	@Override
	public String toString() {
		return nom;
	}
}
