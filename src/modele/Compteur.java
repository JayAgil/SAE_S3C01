package modele;

import java.time.LocalDate;
import java.util.Objects;

public class Compteur {
	
	private String idCompteur;
	private double partieFixe;
	private double partieVariable;
	private double total;
	private LocalDate dataDernierChangement;
	private BienLouable bienLouable;
	private double consommation;
	
	public double getConsommation() {
		return consommation;
	}
	public void setConsommation(double consommation) {
		this.consommation = consommation;
	}
	public Compteur(String idCompteur, double partieFixe, double partieVariable, double total,
			LocalDate dataDernierChangement, BienLouable bl) {
		super();
		this.idCompteur = idCompteur;
		this.partieFixe = partieFixe;
		this.partieVariable = partieVariable;
		this.total = total;
		this.dataDernierChangement = dataDernierChangement;
		this.bienLouable = bl;
	}
	public BienLouable getBienLouable() {
		return bienLouable;
	}
	public void setBienLouable(BienLouable bienLouable) {
		this.bienLouable = bienLouable;
	}
	public String getIdCompteur() {
		return idCompteur;
	}
	public void setIdCompteur(String idCompteur) {
		this.idCompteur = idCompteur;
	}
	public double getPartieFixe() {
		return partieFixe;
	}
	public void setPartieFixe(double partieFixe) {
		this.partieFixe = partieFixe;
	}
	public double getPartieVariable() {
		return partieVariable;
	}
	public void setPartieVariable(double partieVariable) {
		this.partieVariable = partieVariable;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDate getDataDernierChangement() {
		return dataDernierChangement;
	}
	public void setDataDernierChangement(LocalDate dataDernierChangement) {
		this.dataDernierChangement = dataDernierChangement;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCompteur);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Compteur)) {
			return false;
		}
		Compteur other = (Compteur) obj;
		return Objects.equals(idCompteur, other.idCompteur);
	}
	@Override
	public String toString() {
		return "Compteur [idCompteur=" + idCompteur + ", partieFixe=" + partieFixe + ", partieVariable="
				+ partieVariable + ", total=" + total + ", dataDernierChangement=" + dataDernierChangement
				+ ", bienLouable=" + bienLouable + ", Consommation=" + consommation + "]";
	}
	
	public double calculerTotal() {
	    total = partieFixe + (partieVariable * consommation);
	    return total;
	}


}
