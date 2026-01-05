package modele;

import java.util.Objects;

public class IRL {
    private int annee;
    private int trimestre; 
    private double valeur; 

    public IRL(int annee, int trimestre, double valeur) {
        this.annee = annee;
        this.trimestre = trimestre;
        this.valeur = valeur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public void setIRL(double valeur) {
        this.valeur = valeur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(annee, trimestre, valeur);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof IRL)) return false;
        IRL other = (IRL) obj;
        return annee == other.annee &&
               trimestre == other.trimestre &&
               Double.doubleToLongBits(valeur) == Double.doubleToLongBits(other.valeur);
    }

	public double getIRL() {
		return valeur;
	}
}
