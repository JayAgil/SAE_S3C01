package modele;

import java.util.Objects;

public class Assurance {

	private String numeroAssurance;
	private double prime;
	private double montant;
	private String typeAssurance;
	private Batiment batiment;
	private String agence;
	private String adresseAgence;
	private String telAgence;

	/**
	 * Crée une nouvelle instance d'Assurance.
	 *
	 * @param numeroAssurance le numéro de l'assurance
	 * @param prime           la prime mensuelle
	 * @param montant         le montant couvert
	 * @param typeAssurance   le type d'assurance
	 * @param batiment        le bâtiment associé
	 * @param agence          le nom de l'agence
	 * @param adresseAgence   l'adresse de l'agence
	 * @param telAgence       le téléphone de l'agence
	 */
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

	/** Retourne le numéro de l'assurance. */
	public String getNumeroAssurance() {
		return numeroAssurance;
	}

	/** Définit le numéro de l'assurance. */
	public void setNumeroAssurance(String numeroAssurance) {
		this.numeroAssurance = numeroAssurance;
	}

	/** Retourne la prime mensuelle de l'assurance. */
	public double getPrime() {
		return prime;
	}

	/** Définit la prime mensuelle de l'assurance. */
	public void setPrime(double prime) {
		this.prime = prime;
	}

	/** Retourne le montant couvert par l'assurance. */
	public double getMontant() {
		return montant;
	}

	/** Définit le montant couvert par l'assurance. */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/** Retourne le type d'assurance. */
	public String getTypeAssurance() {
		return typeAssurance;
	}

	/** Définit le type d'assurance. */
	public void setTypeAssurance(String typeAssurance) {
		this.typeAssurance = typeAssurance;
	}

	/** Retourne le bâtiment associé à l'assurance. */
	public Batiment getBatiment() {
		return batiment;
	}

	/** Définit le bâtiment associé à l'assurance. */
	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	/** Retourne le nom de l'agence d'assurance. */
	public String getAgence() {
		return agence;
	}

	/** Définit le nom de l'agence d'assurance. */
	public void setAgence(String agence) {
		this.agence = agence;
	}

	/** Retourne l'adresse de l'agence d'assurance. */
	public String getAdresseAgence() {
		return adresseAgence;
	}

	/** Définit l'adresse de l'agence d'assurance. */
	public void setAdresseAgence(String adresseAgence) {
		this.adresseAgence = adresseAgence;
	}

	/** Retourne le téléphone de l'agence d'assurance. */
	public String getTelAgence() {
		return telAgence;
	}

	/** Définit le téléphone de l'agence d'assurance. */
	public void setTelAgence(String telAgence) {
		this.telAgence = telAgence;
	}

	/**
	 * Calcule le coût annuel de l'assurance.
	 *
	 * @return le coût annuel (prime * 12)
	 */
	public double calculerCoutAnnuel() {
		return prime * 12;
	}

	/**
	 * Vérifie si les informations de l'assurance sont valides.
	 *
	 * @return true si le numéro, la prime, le montant et le type sont valides
	 */
	public boolean estValide() {
		return numeroAssurance != null && !numeroAssurance.isEmpty() && prime >= 0 && montant >= 0
				&& typeAssurance != null;
	}

	/**
	 * Vérifie si le type d'assurance est valide.
	 *
	 * @return true si le type est "propriétaire" ou "aide juridique"
	 */
	public boolean typeAssuranceValide() {
		return "propriétaire".equalsIgnoreCase(typeAssurance) || "aide juridique".equalsIgnoreCase(typeAssurance);
	}

	/**
	 * Vérifie si l'assurance est liée à un bâtiment.
	 *
	 * @return true si un bâtiment est associé
	 */
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
		if (obj == null || getClass() != obj.getClass())
			return false;
		Assurance other = (Assurance) obj;
		return Objects.equals(numeroAssurance, other.numeroAssurance);
	}

	@Override
	public String toString() {
		return "Assurance [numeroAssurance=" + numeroAssurance + ", prime=" + prime + ", montant=" + montant
				+ ", typeAssurance=" + typeAssurance + ", batiment=" + batiment + ", agence=" + agence
				+ ", adresseAgence=" + adresseAgence + ", telAgence=" + telAgence + "]";
	}
}
