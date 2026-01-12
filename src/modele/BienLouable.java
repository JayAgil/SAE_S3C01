package modele;

import java.util.Objects;

public class BienLouable {

	private String idBienLouable;
	private String numeroFiscale;
	private String adresse;
	private double surfaceHabituable;
	private int nbPieces;
	private String typeBienLouable;
	private Batiment batiment;
	private BienLouable bienLouableLie;

	/**
	 * Crée un nouveau bien louable avec ses informations principales.
	 *
	 * @param idBienLouable     identifiant unique
	 * @param numeroFiscale     numéro fiscal
	 * @param adresse           adresse du bien
	 * @param surfaceHabituable surface habitable
	 * @param nbPieces          nombre de pièces
	 * @param typeBienLouable   type du bien
	 * @param batiment          bâtiment associé
	 * @param bl                bien lié (peut être null)
	 */
	public BienLouable(String idBienLouable, String numeroFiscale, String adresse, double surfaceHabituable,
			int nbPieces, String typeBienLouable, Batiment batiment, BienLouable bl) {
		this.idBienLouable = idBienLouable;
		this.numeroFiscale = numeroFiscale;
		this.adresse = adresse;
		this.surfaceHabituable = surfaceHabituable;
		this.nbPieces = nbPieces;
		this.typeBienLouable = typeBienLouable;
		this.batiment = batiment;
		this.bienLouableLie = bl;
	}

	/** Retourne le bien lié (ex : garage associé à un appartement). */
	public BienLouable getLogement() {
		return bienLouableLie;
	}

	/** Définit le bien lié. */
	public void setLogement(BienLouable logement) {
		bienLouableLie = logement;
	}

	/** Retourne le bâtiment associé au bien. */
	public Batiment getBatiment() {
		return batiment;
	}

	/** Définit le bâtiment associé au bien. */
	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	/** Retourne l'identifiant unique du bien. */
	public String getIdBienLouable() {
		return idBienLouable;
	}

	/** Définit l'identifiant unique du bien. */
	public void setIdBienLouable(String idBienLouable) {
		this.idBienLouable = idBienLouable;
	}

	/** Retourne le numéro fiscal du bien. */
	public String getNumeroFiscale() {
		return numeroFiscale;
	}

	/** Définit le numéro fiscal du bien. */
	public void setNumeroFiscale(String numeroFiscale) {
		this.numeroFiscale = numeroFiscale;
	}

	/** Retourne l'adresse du bien. */
	public String getAdresse() {
		return adresse;
	}

	/** Définit l'adresse du bien. */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/** Retourne la surface habitable du bien. */
	public double getSurfaceHabituable() {
		return surfaceHabituable;
	}

	/** Définit la surface habitable du bien. */
	public void setSurfaceHabituable(double surfaceHabituable) {
		this.surfaceHabituable = surfaceHabituable;
	}

	/** Retourne le nombre de pièces du bien. */
	public int getNbPieces() {
		return nbPieces;
	}

	/** Définit le nombre de pièces du bien. */
	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}

	/** Retourne le type du bien (ex : Appartement, Maison, Garage). */
	public String getTypeBienLouable() {
		return typeBienLouable;
	}

	/** Définit le type du bien. */
	public void setTypeBienLouable(String typeBienLouable) {
		this.typeBienLouable = typeBienLouable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresse, batiment, idBienLouable, nbPieces, numeroFiscale, surfaceHabituable,
				typeBienLouable);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof BienLouable))
			return false;
		BienLouable other = (BienLouable) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(batiment, other.batiment)
				&& Objects.equals(idBienLouable, other.idBienLouable) && nbPieces == other.nbPieces
				&& Objects.equals(numeroFiscale, other.numeroFiscale)
				&& Double.doubleToLongBits(surfaceHabituable) == Double.doubleToLongBits(other.surfaceHabituable)
				&& Objects.equals(typeBienLouable, other.typeBienLouable);
	}

	@Override
	public String toString() {
		return "BienLouable [idBienLouable=" + idBienLouable + ", numeroFiscale=" + numeroFiscale + ", adresse="
				+ adresse + ", surfaceHabituable=" + surfaceHabituable + ", nbPieces=" + nbPieces + ", typeBienLouable="
				+ typeBienLouable + ", batiment=" + batiment + ", Logement=" + bienLouableLie + "]";
	}

	/**
	 * Vérifie si le bien est valide. - Les bâtiments doivent avoir un type valide
	 * et une adresse. - Si le bien est un "Bâtiment", le numéro fiscal peut être
	 * vide. - Les logements (Appartement, Maison, Studio) doivent avoir un numéro
	 * fiscal, une surface > 0 et au moins une pièce.
	 *
	 * @return true si le bien est valide
	 */
	public boolean estValide() {
		if (typeBienLouable == null || adresse == null || adresse.isEmpty())
			return false;
		if (typeBienLouable.equalsIgnoreCase("Bâtiment")) {
			return numeroFiscale == null || numeroFiscale.isEmpty();
		} else {
			return numeroFiscale != null && !numeroFiscale.isEmpty() && surfaceHabituable > 0 && nbPieces > 0;
		}
	}

	/**
	 * Vérifie si le bien et son bien lié forment une relation valide (ex : un
	 * appartement avec un garage).
	 *
	 * @return true si la relation est correcte
	 */
	public boolean verifParent() {
		if (this.bienLouableLie == null)
			return false;

		String typeA = this.typeBienLouable;
		String typeB = this.bienLouableLie.getTypeBienLouable();

		boolean aIsLogement = typeA.equalsIgnoreCase("Appartement") || typeA.equalsIgnoreCase("Studio")
				|| typeA.equalsIgnoreCase("Maison");

		boolean bIsLogement = typeB.equalsIgnoreCase("Appartement") || typeB.equalsIgnoreCase("Studio")
				|| typeB.equalsIgnoreCase("Maison");

		boolean aIsGarage = typeA.equalsIgnoreCase("Garage");
		boolean bIsGarage = typeB.equalsIgnoreCase("Garage");

		return (aIsLogement && bIsGarage) || (aIsGarage && bIsLogement);
	}

}
