package TestModele;

import static org.junit.Assert.*;
import org.junit.Test;

import modele.Batiment;
import modele.BienLouable;

import java.sql.Date;

public class TestBienLouable {

    private Batiment batiment =
        new Batiment("10 rue centrale", Date.valueOf("1995-01-01"));

    @Test
    public void estValide_logement_ok() {
        BienLouable b = new BienLouable(
            "BL-001", "NF-001", "10 rue A",
            50, 3, "Appartement",
            batiment, null);

        assertTrue(b.estValide());
    }

    @Test
    public void estValide_logement_surfaceZero_false() {
        BienLouable b = new BienLouable(
            "BL-002", "NF-002", "10 rue A",
            0, 3, "Appartement",
            batiment, null);

        assertFalse(b.estValide());
    }

    @Test
    public void estValide_batiment_numeroFiscalNull_ok() {
        BienLouable b = new BienLouable(
            "BL-003", null, "Rue bâtiment",
            0, 0, "Bâtiment",
            batiment, null);

        assertTrue(b.estValide());
    }

    @Test
    public void estValide_batiment_numeroFiscalVide_ok() {
        BienLouable b = new BienLouable(
            "BL-004", "", "Rue bâtiment",
            0, 0, "Bâtiment",
            batiment, null);

        assertTrue(b.estValide());
    }

    @Test
    public void verifParent_logement_garage_ok() {
        BienLouable logement = new BienLouable(
            "BL-005", "NF-005", "Rue A",
            60, 4, "Appartement",
            batiment, null);

        BienLouable garage = new BienLouable(
            "BL-006", "NF-006", "Rue A",
            20, 1, "Garage",
            batiment, logement);

        logement.setLogement(garage);

        assertTrue(logement.verifParent());
        assertTrue(garage.verifParent());
    }

    @Test
    public void verifParent_memeType_false() {
        BienLouable b1 = new BienLouable(
            "BL-007", "NF-007", "Rue A",
            50, 3, "Appartement",
            batiment, null);

        BienLouable b2 = new BienLouable(
            "BL-008", "NF-008", "Rue A",
            40, 2, "Appartement",
            batiment, b1);

        b1.setLogement(b2);

        assertFalse(b1.verifParent());
    }

    @Test
    public void verifParent_parentNull_false() {
        BienLouable b = new BienLouable(
            "BL-009", "NF-009", "Rue A",
            40, 2, "Garage",
            batiment, null);

        assertFalse(b.verifParent());
    }
}
