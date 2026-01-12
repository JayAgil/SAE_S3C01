package modele;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class ContratLocation {
	private String numeroDeContrat;
	private Date dateDebut;
	private Date dateFin;
	private double montantDeCaution;
	private double provisionCharge;
	private double solde;
	private double montantMensuel;
	private Date dateVersement;
	private double indexCompteurEau;
	private double indexCompteurElectricite;
	private double indexCompteurGaz;
	private BienLouable bienLouable;

	/**
	 * Constructeur complet du contrat de location.
	 *
	 * @param numeroDeContrat          identifiant unique du contrat
	 * @param dateDebut                date de début du contrat
	 * @param dateFin                  date de fin du contrat
	 * @param montantDeCaution         montant de la caution
	 * @param provisionCharge          montant provisionné pour charges
	 * @param solde                    solde actuel du locataire
	 * @param montantMensuel           montant mensuel du loyer
	 * @param dateVersement            date du dernier versement
	 * @param indexCompteurEau         index du compteur d'eau
	 * @param indexCompteurElectricite index du compteur d'électricité
	 * @param indexCompteurGaz         index du compteur de gaz
	 * @param bienLouable              bien louable associé
	 */
	public ContratLocation(String numeroDeContrat, Date dateDebut, Date dateFin, double montantDeCaution,
			double provisionCharge, double solde, double montantMensuel, Date dateVersement, double indexCompteurEau,
			double indexCompteurElectricite, double indexCompteurGaz, BienLouable bienLouable) {
		this.numeroDeContrat = numeroDeContrat;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.montantDeCaution = montantDeCaution;
		this.provisionCharge = provisionCharge;
		this.solde = solde;
		this.montantMensuel = montantMensuel;
		this.dateVersement = dateVersement;
		this.indexCompteurEau = indexCompteurEau;
		this.indexCompteurElectricite = indexCompteurElectricite;
		this.indexCompteurGaz = indexCompteurGaz;
		this.bienLouable = bienLouable;
	}

	/** Retourne le numéro du contrat. */
	public String getNumeroDeContrat() {
		return numeroDeContrat;
	}

	/** Définit le numéro du contrat. */
	public void setNumeroDeContrat(String numeroDeContrat) {
		this.numeroDeContrat = numeroDeContrat;
	}

	/** Retourne la date de début du contrat. */
	public Date getDateDebut() {
		return dateDebut;
	}

	/** Définit la date de début du contrat. */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/** Retourne la date de fin du contrat. */
	public Date getDateFin() {
		return dateFin;
	}

	/** Définit la date de fin du contrat. */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/** Retourne le montant de la caution. */
	public double getMontantDeCaution() {
		return montantDeCaution;
	}

	/** Définit le montant de la caution. */
	public void setMontantDeCaution(double montantDeCaution) {
		this.montantDeCaution = montantDeCaution;
	}

	/** Retourne la provision pour charges. */
	public double getProvisionCharge() {
		return provisionCharge;
	}

	/** Définit la provision pour charges. */
	public void setProvisionCharge(double provisionCharge) {
		this.provisionCharge = provisionCharge;
	}

	/** Retourne le solde du locataire pour ce contrat. */
	public double getSolde() {
		return solde;
	}

	/** Définit le solde du locataire pour ce contrat. */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/** Retourne le montant mensuel du loyer. */
	public double getMontantMensuel() {
		return montantMensuel;
	}

	/** Définit le montant mensuel du loyer. */
	public void setMontantMensuel(double montantMensuel) {
		this.montantMensuel = montantMensuel;
	}

	/** Retourne la date du dernier versement. */
	public Date getDateVersement() {
		return dateVersement;
	}

	/** Définit la date du dernier versement. */
	public void setDateVersement(Date dateVersement) {
		this.dateVersement = dateVersement;
	}

	/** Retourne l'index du compteur d'eau. */
	public double getIndexCompteurEau() {
		return indexCompteurEau;
	}

	/** Définit l'index du compteur d'eau. */
	public void setIndexCompteurEau(double indexCompteurEau) {
		this.indexCompteurEau = indexCompteurEau;
	}

	/** Retourne l'index du compteur d'électricité. */
	public double getIndexCompteurElectricite() {
		return indexCompteurElectricite;
	}

	/** Définit l'index du compteur d'électricité. */
	public void setIndexCompteurElectricite(double indexCompteurElectricite) {
		this.indexCompteurElectricite = indexCompteurElectricite;
	}

	/** Retourne l'index du compteur de gaz. */
	public double getIndexCompteurGaz() {
		return indexCompteurGaz;
	}

	/** Définit l'index du compteur de gaz. */
	public void setIndexCompteurGaz(double indexCompteurGaz) {
		this.indexCompteurGaz = indexCompteurGaz;
	}

	/** Retourne le bien louable associé au contrat. */
	public BienLouable getBienLouable() {
		return bienLouable;
	}

	/** Définit le bien louable associé au contrat. */
	public void setBienLouable(BienLouable bienLouable) {
		this.bienLouable = bienLouable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroDeContrat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ContratLocation))
			return false;
		ContratLocation other = (ContratLocation) obj;
		return Objects.equals(numeroDeContrat, other.numeroDeContrat);
	}

	@Override
	public String toString() {
		return numeroDeContrat;
	}

	/**
	 * Calcule la durée du contrat en mois entiers.
	 * 
	 * @return nombre de mois entre dateDebut et dateFin
	 */
	public long dureeEnMois() {
		LocalDate d1 = dateDebut.toLocalDate();
		LocalDate d2 = dateFin.toLocalDate();
		return ChronoUnit.MONTHS.between(d1, d2);
	}

	/**
	 * Calcule le loyer total sur toute la durée du contrat.
	 * 
	 * @return montantMensuel * durée en mois
	 */
	public double calculerLoyerTotal() {
		return montantMensuel * dureeEnMois();
	}

	/**
	 * Met à jour le solde du locataire en ajoutant un montant versé.
	 * 
	 * @param montantVerse montant ajouté au solde
	 */
	public void miseAJourSolde(double montantVerse) {
		this.solde += montantVerse;
	}

	/**
	 * Enregistre un paiement en diminuant le solde et en mettant à jour la date du
	 * versement.
	 * 
	 * @param montantPaye montant payé
	 * @param date        date du paiement
	 */
	public void enregistrerPaiement(double montantPaye, Date date) {
		this.solde -= montantPaye;
		this.dateVersement = date;
	}

}
