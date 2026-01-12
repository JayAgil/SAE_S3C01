package modele;

import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;

public class Locataire {

	private String idLocataire;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String email;
	private String codePostale;
	private String ville;
	private Date dateDeNaissance;
	private String lieuDeNaissance;
	private double salaire;
	private String profession;
	private String situationFamiliale;
	private Garant garant;

	/**
	 * Constructeur complet d'un locataire.
	 *
	 * @param idLocataire        identifiant unique du locataire
	 * @param nom                nom de famille
	 * @param prenom             prénom
	 * @param adresse            adresse
	 * @param tel                numéro de téléphone
	 * @param email              adresse email
	 * @param codePostale        code postal
	 * @param ville              ville
	 * @param dateDeNaissance    date de naissance
	 * @param lieuDeNaissance    lieu de naissance
	 * @param salaire            salaire
	 * @param profession         profession
	 * @param situationFamiliale situation familiale
	 * @param garant             garant associé
	 */
	public Locataire(String idLocataire, String nom, String prenom, String adresse, String tel, String email,
			String codePostale, String ville, Date dateDeNaissance, String lieuDeNaissance, double salaire,
			String profession, String situationFamiliale, Garant garant) {
		super();
		this.idLocataire = idLocataire;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.codePostale = codePostale;
		this.ville = ville;
		this.dateDeNaissance = dateDeNaissance;
		this.lieuDeNaissance = lieuDeNaissance;
		this.salaire = salaire;
		this.profession = profession;
		this.situationFamiliale = situationFamiliale;
		this.garant = garant;
	}

	/** Retourne l'identifiant unique du locataire. */
	public String getIdLocataire() {
		return idLocataire;
	}

	/** Définit l'identifiant unique du locataire. */
	public void setIdLocataire(String idLocataire) {
		this.idLocataire = idLocataire;
	}

	/** Retourne le nom de famille du locataire. */
	public String getNom() {
		return nom;
	}

	/** Définit le nom de famille du locataire. */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Retourne le prénom du locataire. */
	public String getPrenom() {
		return prenom;
	}

	/** Définit le prénom du locataire. */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Retourne l'adresse du locataire. */
	public String getAdresse() {
		return adresse;
	}

	/** Définit l'adresse du locataire. */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/** Retourne le numéro de téléphone du locataire. */
	public String getTel() {
		return tel;
	}

	/** Définit le numéro de téléphone du locataire. */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/** Retourne l'adresse email du locataire. */
	public String getEmail() {
		return email;
	}

	/** Définit l'adresse email du locataire. */
	public void setEmail(String email) {
		this.email = email;
	}

	/** Retourne le code postal du locataire. */
	public String getCodePostale() {
		return codePostale;
	}

	/** Définit le code postal du locataire. */
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	/** Retourne la ville du locataire. */
	public String getVille() {
		return ville;
	}

	/** Définit la ville du locataire. */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/** Retourne la date de naissance du locataire. */
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	/** Définit la date de naissance du locataire. */
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/** Retourne le lieu de naissance du locataire. */
	public String getLieuDeNaissance() {
		return lieuDeNaissance;
	}

	/** Définit le lieu de naissance du locataire. */
	public void setLieuDeNaissance(String lieuDeNaissance) {
		this.lieuDeNaissance = lieuDeNaissance;
	}

	/** Retourne le salaire du locataire. */
	public double getSalaire() {
		return salaire;
	}

	/** Définit le salaire du locataire. */
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	/** Retourne la profession du locataire. */
	public String getProfession() {
		return profession;
	}

	/** Définit la profession du locataire. */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/** Retourne la situation familiale du locataire. */
	public String getSituationFamiliale() {
		return situationFamiliale;
	}

	/** Définit la situation familiale du locataire. */
	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}

	/** Retourne le garant associé au locataire. */
	public Garant getGarant() {
		return garant;
	}

	/** Définit le garant associé au locataire. */
	public void setGarant(Garant garant) {
		this.garant = garant;
	}

	/** Indique si le locataire est majeur (>= 18 ans). */
	public boolean estMajeur() {
		if (dateDeNaissance == null)
			return false;
		java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateDeNaissance);
		cal.add(Calendar.YEAR, 18);
		java.sql.Date eighteenthBirthday = new java.sql.Date(cal.getTimeInMillis());
		return eighteenthBirthday.before(today);
	}

	/** Indique si le locataire a un garant. */
	public boolean aUnGarant() {
		return garant != null;
	}

	/** Retourne le nom complet du locataire (prénom + nom). */
	public String getNomComplet() {
		return prenom + " " + nom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLocataire);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Locataire))
			return false;
		Locataire other = (Locataire) obj;
		return Objects.equals(idLocataire, other.idLocataire);
	}

	@Override
	public String toString() {
		return "Locataire [idLocataire=" + idLocataire + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", tel=" + tel + ", email=" + email + "]";
	}

}
