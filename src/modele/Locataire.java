package modele;

import java.time.LocalDate;
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
	private LocalDate dateDeNaissance;
	private String lieuDeNaissance;
	private double salaire;
	private String profession;
	private String situationFamiliale;
	private String image;
	private Garant garant;

	public Locataire(String idLocataire, String nom, String prenom, String adresse, String tel, String email,
			String codePostale, String ville, LocalDate dateDeNaissance, String lieuDeNaissance, double salaire,
			String profession, String situationFamiliale, String image, Garant garant) {
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
		this.image = image;
		this.garant = garant;
	}

	public String getIdLocataire() {
		return idLocataire;
	}

	public void setIdLocataire(String idLocataire) {
		this.idLocataire = idLocataire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getLieuDeNaissance() {
		return lieuDeNaissance;
	}

	public void setLieuDeNaissance(String lieuDeNaissance) {
		this.lieuDeNaissance = lieuDeNaissance;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getSituationFamiliale() {
		return situationFamiliale;
	}

	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Garant getGarant() {
		return garant;
	}

	public void setGarant(Garant garant) {
		this.garant = garant;
	}

	public boolean estMajeur() {
		return dateDeNaissance != null && dateDeNaissance.plusYears(18).isBefore(LocalDate.now());
	}

	public boolean aUnGarant() {
		return garant != null;
	}

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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locataire other = (Locataire) obj;
		return Objects.equals(idLocataire, other.idLocataire);
	}
	
	

}
