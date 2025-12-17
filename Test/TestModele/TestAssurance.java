package TestModele;

import static org.junit.Assert.*;
import org.junit.Test;

import modele.Assurance;
import modele.Batiment;

import java.sql.Date;

public class TestAssurance {

    private Batiment batiment =
        new Batiment("10 rue de Paris", Date.valueOf("2000-01-01"));

    @Test
    public void calculerCoutAnnuel_ok() {
        Assurance a = new Assurance(
            "ASS-001", 100, 1000, "propriétaire",
            batiment, "AXA", "Paris", "0102030405");

        assertEquals(1200.0, a.calculerCoutAnnuel(), 0.001);
    }

    @Test
    public void estValide_ok() {
        Assurance a = new Assurance(
            "ASS-002", 50, 500, "aide juridique",
            batiment, "MAIF", "Lyon", "0600000000");

        assertTrue(a.estValide());
    }

    @Test
    public void typeAssuranceValide_false() {
        Assurance a = new Assurance(
            "ASS-003", 50, 500, "auto",
            batiment, "AXA", "Paris", "01");

        assertFalse(a.typeAssuranceValide());
    }
}
