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
