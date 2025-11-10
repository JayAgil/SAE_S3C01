package modele;

import java.time.LocalDate;
import java.util.Objects;

public class Facture {
	private String numeroFacture;
	private double montant;
	private LocalDate dateDeFacture;
	private String compteBancaire;
	private double montantDevis;
	private LocalDate datePaiement;
	private String designationDeTravaux;
	private BienLouable bienLoauble;
	private Entreprise entreprise;
	
	@Override
	public int hashCode() {
		return Objects.hash(numeroFacture);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Facture)) {
			return false;
		}
		Facture other = (Facture) obj;
		return Objects.equals(numeroFacture, other.numeroFacture);
	}
	public void setNumeroFacture(String numeroFacture) {
		this.numeroFacture = numeroFacture;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public void setDateDeFacture(LocalDate dateDeFacture) {
		this.dateDeFacture = dateDeFacture;
	}
	public void setCompteBancaire(String compteBancaire) {
		this.compteBancaire = compteBancaire;
	}
	public void setMontantDevis(double montantDevis) {
		this.montantDevis = montantDevis;
	}
	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}
	public void setDesignationDeTravaux(String designationDeTravaux) {
		this.designationDeTravaux = designationDeTravaux;
	}
	public String getNumeroFacture() {
		return numeroFacture;
	}
	public double getMontant() {
		return montant;
	}
	public LocalDate getDateDeFacture() {
		return dateDeFacture;
	}
	public String getCompteBancaire() {
		return compteBancaire;
	}
	public double getMontantDevis() {
		return montantDevis;
	}
	public LocalDate getDatePaiement() {
		return datePaiement;
	}
	@Override
	public String toString() {
		return "Facture [numeroFacture=" + numeroFacture + ", montant=" + montant + ", dateDeFacture=" + dateDeFacture
				+ ", compteBancaire=" + compteBancaire + ", montantDevis=" + montantDevis + ", datePaiement="
				+ datePaiement + ", designationDeTravaux=" + designationDeTravaux + ", bienLoauble=" + bienLoauble
				+ ", entreprise=" + entreprise + "]";
	}
	public String getDesignationDeTravaux() {
		return designationDeTravaux;
	}
	public BienLouable getBienLoauble() {
		return bienLoauble;
	}
	public void setBienLoauble(BienLouable bienLoauble) {
		this.bienLoauble = bienLoauble;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public Facture(String numeroFacture, double montant, LocalDate dateDeFacture, String compteBancaire,
			double montantDevis, LocalDate datePaiement, String designationDeTravaux, BienLouable bienLouable, Entreprise entreprise) {
		super();
		this.numeroFacture = numeroFacture;
		this.montant = montant;
		this.dateDeFacture = dateDeFacture;
		this.compteBancaire = compteBancaire;
		this.montantDevis = montantDevis;
		this.datePaiement = datePaiement;
		this.designationDeTravaux = designationDeTravaux;
		this.bienLoauble = bienLouable;
		this.entreprise = entreprise;
	}
	
	public double ecartMontant() {
        return montant - montantDevis;
    }
	
}
