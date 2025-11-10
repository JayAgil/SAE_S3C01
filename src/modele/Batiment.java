package modele;

import java.time.LocalDate;
import java.util.Objects;
import java.time.Period;

public class Batiment {
	
    private String adresse;
    private LocalDate dateConstruction;
    
    public Batiment(String adresse, LocalDate dateConstruction) {
        this.adresse = adresse;
        this.dateConstruction = dateConstruction;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDate getDateConstruction() {
        return dateConstruction;
    }

    public void setDateConstruction(LocalDate dateConstruction) {
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
        return Period.between(dateConstruction, LocalDate.now()).getYears();
    }
}
