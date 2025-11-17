package modele;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import java.time.Period;
import java.time.ZoneId;

public class Batiment {
	
    private String adresse;
    private Date dateConstruction;
    
    public Batiment(String adresse, Date dateConstruction) {
        this.adresse = adresse;
        this.dateConstruction = dateConstruction;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateConstruction() {
        return dateConstruction;
    }

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
        return "Bâtiment [Adresse=" + adresse + ", Date de construction=" + dateConstruction + "]";
    }
    
    public boolean estValide() {
        return adresse != null && !adresse.isEmpty() && dateConstruction != null;
    }
    
    public int calculerAge() {
    	return Period.between(
    		    dateConstruction.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
    		    LocalDate.now()
    		).getYears();
    }
}
