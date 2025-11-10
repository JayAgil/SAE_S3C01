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
	public Entreprise(String numSiret, String adresse, String ville, String codePostal, String nom, String numTel,
			String specialite) {
		super();
		this.numSiret = numSiret;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.nom = nom;
		this.numTel = numTel;
		this.specialite = specialite;
	}
	public String getNumSiret() {
		return numSiret;
	}
	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	@Override
	public int hashCode() {
		return Objects.hash(numSiret);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Entreprise)) {
			return false;
		}
		Entreprise other = (Entreprise) obj;
		return Objects.equals(numSiret, other.numSiret);
	}
	@Override
	public String toString() {
		return "Entreprise [numSiret=" + numSiret + ", adresse=" + adresse + ", ville=" + ville + ", codePostal="
				+ codePostal + ", nom=" + nom + ", numTel=" + numTel + ", specialite=" + specialite + "]";
	}
	
	
	

}
