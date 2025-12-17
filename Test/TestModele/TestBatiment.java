package TestModele;

import static org.junit.Assert.*;
import org.junit.Test;

import modele.Batiment;

import java.sql.Date;
import java.time.LocalDate;

public class TestBatiment {

    @Test
    public void estValide_ok() {
        Batiment b = new Batiment(
            "12 avenue Victor Hugo",
            Date.valueOf("1990-01-01"));

        assertTrue(b.estValide());
    }

    @Test
    public void estValide_adresseVide_false() {
        Batiment b = new Batiment(
            "",
            Date.valueOf("1990-01-01"));

        assertFalse(b.estValide());
    }

    @Test
    public void estValide_dateNull_false() {
        Batiment b = new Batiment(
            "Rue de Paris",
            null);

        assertFalse(b.estValide());
    }

    @Test
    public void calculerAge_ok() {
        int annee = LocalDate.now().minusYears(10).getYear();
        Batiment b = new Batiment(
            "Rue test",
            Date.valueOf(annee + "-01-01"));

        assertTrue(b.calculerAge() >= 9);
    }

    @Test
    public void equals_memeAdresse_true() {
        Batiment b1 = new Batiment("Rue A", Date.valueOf("2000-01-01"));
        Batiment b2 = new Batiment("Rue A", Date.valueOf("2010-01-01"));

        assertEquals(b1, b2);
    }

    @Test
    public void equals_adresseDifferente_false() {
        Batiment b1 = new Batiment("Rue A", Date.valueOf("2000-01-01"));
        Batiment b2 = new Batiment("Rue B", Date.valueOf("2000-01-01"));

        assertNotEquals(b1, b2);
    }
}
