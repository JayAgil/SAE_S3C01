package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContratLocation {
	private String numeroDeContrat;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private double montantDeCaution;
	private double provisionCharge;
	private double solde;
	private double montantMensuel;
	private LocalDate dateVersement;
	private double indexCompteurEau;
	private double indexCompteurElectricite;
	private double indexCompteurGaz;
	private BienLouable bienLouable;

	public ContratLocation(String numeroDeContrat, LocalDate dateDebut, LocalDate dateFin, double montantDeCaution,
			double provisionCharge, double solde, double montantMensuel, LocalDate dateVersement,
			double indexCompteurEau, double indexCompteurElectricite, double indexCompteurGaz,
			BienLouable bienLouable) {
		super();
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

	public String getNumeroDeContrat() {
		return numeroDeContrat;
	}

	public void setNumeroDeContrat(String numeroDeContrat) {
		this.numeroDeContrat = numeroDeContrat;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getMontantDeCaution() {
		return montantDeCaution;
	}

	public void setMontantDeCaution(double montantDeCaution) {
		this.montantDeCaution = montantDeCaution;
	}

	public double getProvisionCharge() {
		return provisionCharge;
	}

	public void setProvisionCharge(double provisionCharge) {
		this.provisionCharge = provisionCharge;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public double getMontantMensuel() {
		return montantMensuel;
	}

	public void setMontantMensuel(double montantMensuel) {
		this.montantMensuel = montantMensuel;
	}

	public LocalDate getDateVersement() {
		return dateVersement;
	}

	public void setDateVersement(LocalDate dateVersement) {
		this.dateVersement = dateVersement;
	}

	public double getIndexCompteurEau() {
		return indexCompteurEau;
	}

	public void setIndexCompteurEau(double indexCompteurEau) {
		this.indexCompteurEau = indexCompteurEau;
	}

	public double getIndexCompteurElectricite() {
		return indexCompteurElectricite;
	}

	public void setIndexCompteurElectricite(double indexCompteurElectricite) {
		this.indexCompteurElectricite = indexCompteurElectricite;
	}

	public double getIndexCompteurGaz() {
		return indexCompteurGaz;
	}

	public void setIndexCompteurGaz(double indexCompteurGaz) {
		this.indexCompteurGaz = indexCompteurGaz;
	}

	public BienLouable getBienLouable() {
		return bienLouable;
	}

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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContratLocation other = (ContratLocation) obj;
		return Objects.equals(numeroDeContrat, other.numeroDeContrat);
	}

	public long dureeEnMois() {
		if (dateDebut == null || dateFin == null)
			return 0;
		return java.time.temporal.ChronoUnit.MONTHS.between(dateDebut, dateFin);
	}

	public double calculerLoyerTotal() {
		return montantMensuel * dureeEnMois();
	}

	public void miseAJourSolde(double montantVerse) {
		this.solde += montantVerse;
	}

	public void enregistrerPaiement(double montantPaye, LocalDate date) {
		this.solde -= montantPaye;
		this.dateVersement = date;
	}

}
