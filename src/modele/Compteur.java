package modele;

import java.sql.Date;
import java.util.Objects;

public class Compteur {

	private String idCompteur;
	private double partieFixe;
	private double partieVariable;
	private double total;
	private Date dateInstallation;
	private BienLouable bienLouable;
	private double indexAncien;
	private double indexNouveau;
	private String type;

	/**
	 * Constructeur complet du compteur.
	 *
	 * @param idCompteur       identifiant unique du compteur
	 * @param partieFixe       partie fixe du compteur
	 * @param partieVariable   partie variable du compteur
	 * @param total            montant total
	 * @param dateInstallation date d'installation du compteur
	 * @param bienLouable      bien louable associé
	 * @param indexAncien      ancien index
	 * @param indexNouveau     nouvel index
	 * @param type             type du compteur
	 */
	public Compteur(String idCompteur, double partieFixe, double partieVariable, double total, Date dateInstallation,
			BienLouable bienLouable, double indexAncien, double indexNouveau, String type) {
		super();
		this.idCompteur = idCompteur;
		this.partieFixe = partieFixe;
		this.partieVariable = partieVariable;
		this.total = total;
		this.dateInstallation = dateInstallation;
		this.bienLouable = bienLouable;
		this.indexAncien = indexAncien;
		this.indexNouveau = indexNouveau;
		this.type = type;
	}

	/** Retourne l'identifiant du compteur. */
	public String getIdCompteur() {
		return idCompteur;
	}

	/** Définit l'identifiant du compteur. */
	public void setIdCompteur(String idCompteur) {
		this.idCompteur = idCompteur;
	}

	/** Retourne la partie fixe du compteur. */
	public double getPartieFixe() {
		return partieFixe;
	}

	/** Définit la partie fixe du compteur. */
	public void setPartieFixe(double partieFixe) {
	    this.partieFixe = partieFixe;
	    this.total = this.partieFixe + this.partieVariable; // recalc total
	}

	/** Retourne la partie variable du compteur. */
	public double getPartieVariable() {
		return partieVariable;
	}

	/** Définit la partie variable du compteur. */
	public void setPartieVariable(double partieVariable) {
	    this.partieVariable = partieVariable;
	    this.total = this.partieFixe + this.partieVariable; // recalc total
	}

	/** Retourne le total du compteur. */
	public double getTotal() {
		return total;
	}

	/** Définit le total du compteur. */
	public void setTotal(double total) {
		this.total = total;
	}

	/** Retourne la date d'installation du compteur. */
	public Date getDateInstallation() {
		return dateInstallation;
	}

	/** Définit la date d'installation du compteur. */
	public void setDateInstallation(Date dateInstallation) {
		this.dateInstallation = dateInstallation;
	}

	/** Retourne le bien louable associé au compteur. */
	public BienLouable getBienLouable() {
		return bienLouable;
	}

	/** Définit le bien louable associé au compteur. */
	public void setBienLouable(BienLouable bienLouable) {
		this.bienLouable = bienLouable;
	}

	/** Retourne l'ancien index du compteur. */
	public double getIndexAncien() {
		return indexAncien;
	}

	/** Définit l'ancien index du compteur. */
	public void setIndexAncien(double indexAncien) {
		this.indexAncien = indexAncien;
	}

	/** Retourne le nouvel index du compteur. */
	public double getIndexNouveau() {
		return indexNouveau;
	}

	/** Définit le nouvel index du compteur. */
	public void setIndexNouveau(double indexNouveau) {
		this.indexNouveau = indexNouveau;
	}

	/** Retourne le type du compteur. */
	public String getType() {
		return type;
	}

	/** Définit le type du compteur. */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCompteur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Compteur))
			return false;
		Compteur other = (Compteur) obj;
		return Objects.equals(idCompteur, other.idCompteur);
	}

	@Override
	public String toString() {
		return "Compteur [idCompteur=" + idCompteur + ", partieFixe=" + partieFixe + ", partieVariable="
				+ partieVariable + ", total=" + total + ", dateInstallation=" + dateInstallation + ", bienLouable="
				+ bienLouable + ", indexAncien=" + indexAncien + ", indexNouveau=" + indexNouveau + ", type=" + type
				+ "]";
	}

}
