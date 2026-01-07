package modele;

import java.util.Objects;

public class Assurance {
	
	@Override
	public String toString() {
		return "Assurance [numeroAssurance=" + numeroAssurance + ", prime=" + prime + ", montant=" + montant
				+ ", typeAssurance=" + typeAssurance + ", batiment=" + batiment + ", agence=" + agence
				+ ", adresseAgence=" + adresseAgence + ", telAgence=" + telAgence + "]";
	}

	private String numeroAssurance;
	private double prime;
	private double montant;
	private String typeAssurance;
	private Batiment batiment;
	private String agence;
	private String adresseAgence;
	private String telAgence;
	
	public Assurance(String numeroAssurance, double prime, double montant, String typeAssurance, Batiment batiment,
			String agence, String adresseAgence, String telAgence) {
		this.numeroAssurance = numeroAssurance;
		this.prime = prime;
		this.montant = montant;
		this.typeAssurance = typeAssurance;
		this.batiment = batiment;
		this.agence = agence;
		this.adresseAgence = adresseAgence;
		this.telAgence = telAgence;
	}

	public String getNumeroAssurance() {
		return numeroAssurance;
	}

	public void setNumeroAssurance(String numeroAssurance) {
		this.numeroAssurance = numeroAssurance;
	}

	public double getPrime() {
		return prime;
	}

	public void setPrime(double prime) {
		this.prime = prime;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getTypeAssurance() {
		return typeAssurance;
	}

	public void setTypeAssurance(String typeAssurance) {
		this.typeAssurance = typeAssurance;
	}

	public Batiment getBatiment() {
		return batiment;
	}

	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public String getAdresseAgence() {
		return adresseAgence;
	}

	public void setAdresseAgence(String adresseAgence) {
		this.adresseAgence = adresseAgence;
	}

	public String getTelAgence() {
		return telAgence;
	}

	public void setTelAgence(String telAgence) {
		this.telAgence = telAgence;
	}

	public double calculerCoutAnnuel() {
	        return prime * 12;
	 }
	
	public boolean estValide() {
        return numeroAssurance != null && !(numeroAssurance == "")
                && prime >= 0 && montant >= 0 && typeAssurance != null;
    }
	
	public boolean typeAssuranceValide() {
	    return "propriétaire".equalsIgnoreCase(typeAssurance)
	        || "aide juridique".equalsIgnoreCase(typeAssurance);
	}
	
	public boolean estLieeABatiment() {
	    return batiment != null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroAssurance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assurance other = (Assurance) obj;
		return Objects.equals(numeroAssurance, other.numeroAssurance);
	}
	
	
	

	
}
