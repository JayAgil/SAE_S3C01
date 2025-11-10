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
	private BienLouable bienLouable;
	private List<Locataire> locataires;
	
	public ContratLocation(String numeroDeContrat, LocalDate dateDebut, LocalDate dateFin, double montantDeCaution,
			double provisionCharge, double solde, double montantMensuel, LocalDate dateVersement,
			double indexCompteurEau, double indexCompteurElectricite, BienLouable bienLouable) {
		this.bienLouable = bienLouable;
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
		this.locataires = new ArrayList<>();
	}

	public List<Locataire> getLocataires() {
		return locataires;
	}

	public void setLocataires(List<Locataire> locataires) {
		this.locataires = locataires;
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
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ContratLocation)) {
			return false;
		}
		ContratLocation other = (ContratLocation) obj;
		return Objects.equals(numeroDeContrat, other.numeroDeContrat);
	}

	@Override
	public String toString() {
		return "ContratLocation [numeroDeContrat=" + numeroDeContrat + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", montantDeCaution=" + montantDeCaution + ", provisionCharge=" + provisionCharge
				+ ", Solde=" + solde + ", montantMensuel=" + montantMensuel + ", dateVersement=" + dateVersement
				+ ", indexCompteurEau=" + indexCompteurEau + ", indexCompteurElectricite=" + indexCompteurElectricite
				+ ", bienLouable=" + bienLouable + ", locataires=" + locataires + "]";
	}

	public String getNumeroDeContrat() {
		return numeroDeContrat;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public double getMontantDeCaution() {
		return montantDeCaution;
	}

	public double getProvisionCharge() {
		return provisionCharge;
	}

	public double getSolde() {
		return solde;
	}

	public double getMontantMensuel() {
		return montantMensuel;
	}

	public LocalDate getDateVersement() {
		return dateVersement;
	}

	public double getIndexCompteurEau() {
		return indexCompteurEau;
	}

	public double getIndexCompteurElectricite() {
		return indexCompteurElectricite;
	}

	public void setNumeroDeContrat(String numeroDeContrat) {
		this.numeroDeContrat = numeroDeContrat;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public void setMontantDeCaution(double montantDeCaution) {
		this.montantDeCaution = montantDeCaution;
	}

	public void setProvisionCharge(double provisionCharge) {
		this.provisionCharge = provisionCharge;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public void setMontantMensuel(double montantMensuel) {
		this.montantMensuel = montantMensuel;
	}

	public void setDateVersement(LocalDate dateVersement) {
		this.dateVersement = dateVersement;
	}

	public void setIndexCompteurEau(double indexCompteurEau) {
		this.indexCompteurEau = indexCompteurEau;
	}

	public void setIndexCompteurElectricite(double indexCompteurElectricite) {
		this.indexCompteurElectricite = indexCompteurElectricite;
	}
	
	public long dureeEnMois() {
	    if (dateDebut == null || dateFin == null) return 0;
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
