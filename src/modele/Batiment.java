package modele;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import java.time.Period;
import java.time.ZoneId;

public class Batiment {

	private String adresse;
	private Date dateConstruction;

	/**
	 * Crée un nouveau bâtiment avec son adresse et sa date de construction.
	 *
	 * @param adresse          l'adresse du bâtiment
	 * @param dateConstruction la date de construction du bâtiment
	 */
	public Batiment(String adresse, Date dateConstruction) {
		this.adresse = adresse;
		this.dateConstruction = dateConstruction;
	}

	/** Retourne l'adresse du bâtiment. */
	public String getAdresse() {
		return adresse;
	}

	/** Définit l'adresse du bâtiment. */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/** Retourne la date de construction du bâtiment. */
	public Date getDateConstruction() {
		return dateConstruction;
	}

	/** Définit la date de construction du bâtiment. */
	public void setDateConstruction(Date dateConstruction) {
		this.dateConstruction = dateConstruction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Batiment))
			return false;
		Batiment other = (Batiment) obj;
		return Objects.equals(adresse, other.adresse);
	}

	@Override
	public String toString() {
		return this.adresse;
	}

	/**
	 * Vérifie si le bâtiment est valide. Un bâtiment est valide si son adresse
	 * n'est pas nulle ou vide et si sa date de construction est renseignée.
	 *
	 * @return true si le bâtiment est valide
	 */
	public boolean estValide() {
	    return adresse != null && !adresse.isBlank() && dateConstruction != null;
	}

	/**
	 * Calcule l'âge du bâtiment en années.
	 *
	 * @return l'âge du bâtiment
	 */
	public int calculerAge() {
		return Period
				.between(dateConstruction.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now())
				.getYears();
	}
}
