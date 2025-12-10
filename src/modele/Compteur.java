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

	public Compteur(String idCompteur, double partieFixe, double partieVariable, double total,
			Date dateInstallation, BienLouable bienLouable, double indexAncien, double indexNouveau,
			String type) {
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

	public Date getDateInstallation() {
		return dateInstallation;
	}

	public void setDateInstallation(Date dateInstallation) {
		this.dateInstallation = dateInstallation;
	}

	public BienLouable getBienLouable() {
		return bienLouable;
	}

	public void setBienLouable(BienLouable bienLouable) {
		this.bienLouable = bienLouable;
	}

	public double getIndexAncien() {
		return indexAncien;
	}

	public void setIndexAncien(double indexAncien) {
		this.indexAncien = indexAncien;
	}

	public double getIndexNouveau() {
		return indexNouveau;
	}

	public void setIndexNouveau(double indexNouveau) {
		this.indexNouveau = indexNouveau;
	}

	public String getType() {
		return type;
	}

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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compteur other = (Compteur) obj;
		return Objects.equals(idCompteur, other.idCompteur);
	}

	public double calculerTotal() {
		total = partieFixe + (partieVariable * (indexNouveau - indexAncien));
		return total;
	}

}
