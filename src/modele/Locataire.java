package modele;

import java.time.LocalDate;
import java.util.Objects;

public class Locataire {
	
	private String idLocataire;
	private String nom;
	private String prenom;
	private String adresse;
	private int tel;
	private String email;
	private int codePostale;
	private String ville;
	private LocalDate dateDeNaissance;
	private String lieuDeNaissance;
	private double salaire;
	private String profession;
	private String situationFamiliale;
	private Garant garant;
	
	@Override
	public int hashCode() {
		return Objects.hash(adresse, codePostale, dateDeNaissance, email, garant, idLocataire, lieuDeNaissance, nom,
				prenom, profession, salaire, situationFamiliale, tel, ville);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Locataire)) {
			return false;
		}
		Locataire other = (Locataire) obj;
		return Objects.equals(adresse, other.adresse) && codePostale == other.codePostale
				&& Objects.equals(dateDeNaissance, other.dateDeNaissance) && Objects.equals(email, other.email)
				&& Objects.equals(garant, other.garant) && Objects.equals(idLocataire, other.idLocataire)
				&& Objects.equals(lieuDeNaissance, other.lieuDeNaissance) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(profession, other.profession)
				&& Double.doubleToLongBits(salaire) == Double.doubleToLongBits(other.salaire)
				&& Objects.equals(situationFamiliale, other.situationFamiliale) && tel == other.tel
				&& Objects.equals(ville, other.ville);
	}

	@Override
	public String toString() {
		return "Locataire [idLocataire=" + idLocataire + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", tel=" + tel + ", email=" + email + ", codePostale=" + codePostale + ", ville=" + ville
				+ ", dateDeNaissance=" + dateDeNaissance + ", lieuDeNaissance=" + lieuDeNaissance + ", salaire="
				+ salaire + ", profession=" + profession + ", situationFamiliale=" + situationFamiliale + ", garant="
				+ garant + "]";
	}

	public void setIdLocataire(String idLocataire) {
		this.idLocataire = idLocataire;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public void setLieuDeNaissance(String lieuDeNaissance) {
		this.lieuDeNaissance = lieuDeNaissance;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}

	public String getIdLocataire() {
		return idLocataire;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public int getCodePostale() {
		return codePostale;
	}

	public String getVille() {
		return ville;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public String getLieuDeNaissance() {
		return lieuDeNaissance;
	}

	public double getSalaire() {
		return salaire;
	}

	public String getProfession() {
		return profession;
	}

	public String getSituationFamiliale() {
		return situationFamiliale;
	}

	public Locataire(String idLocataire, String nom, String prenom, String adresse, int tel, String email,
			int codePostale, String ville, LocalDate dateDeNaissance, String lieuDeNaissance, double salaire,
			String profession, String situationFamiliale, Garant garant) {
		this.garant = garant;
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
	}

	public Garant getGarant() {
		return garant;
	}

	public void setGarant(Garant garant) {
		this.garant = garant;
	}
	
	public boolean estMajeur() {
        return dateDeNaissance != null && 
               dateDeNaissance.plusYears(18).isBefore(LocalDate.now());
    }
	
	public boolean aUnGarant() {
        return garant != null;
    }
	
	 public String getNomComplet() {
	        return prenom + " " + nom;
	    }

	
}
