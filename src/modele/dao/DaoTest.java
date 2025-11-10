package modele.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import modele.Assurance;
import modele.Batiment;
import modele.BienLouable;
import modele.ChargesGenerales;
import modele.Compteur;
import modele.ContratLocation;
import modele.Diagnostics;
import modele.Entreprise;
import modele.Facture;
import modele.Garant;
import modele.IRL;
import modele.Locataire;
import modele.Paiement;

public class DaoTest {

    private static final Collection<Assurance> ASSURANCE = new HashSet<>();
    private static final Collection<Batiment> BATIMENT = new HashSet<>();
    private static final Collection<BienLouable> BIENLOUABLE = new HashSet<>();
    private static final Collection<ChargesGenerales> CHARGESGENERALES = new HashSet<>();
    private static final Collection<Compteur> COMPTEUR = new HashSet<>();
    private static final Collection<ContratLocation> CONTRATLOCATION = new HashSet<>();
    private static final Collection<Diagnostics> DIAGNOSTICS = new HashSet<>();
    private static final Collection<Entreprise> ENTREPRISE = new HashSet<>();
    private static final Collection<Facture> FACTURE = new HashSet<>();
    private static final Collection<Garant> GARANT = new HashSet<>();
    private static final Collection<IRL> IRL = new HashSet<>();
    private static final Collection<Locataire> LOCATAIRE = new HashSet<>();
    private static final Collection<Paiement> PAIEMENT = new HashSet<>();

    // -------------------------- Assurance
    // --------------------------------------------

    public static List<Assurance> selectAssurance(String... id) {
        List<Assurance> liste;
        if (id.length != 0) {
            liste = DaoTest.ASSURANCE.stream()
                .filter(e->e.getNumeroAssurance().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.ASSURANCE);
        }
        return liste;
    }

    public static void insertAssurance(Assurance a) {
        DaoTest.ASSURANCE.add(a);
    }

    public static void updateAssurance(Assurance a) {
        List<Assurance> liste = DaoTest.selectAssurance(a.getNumeroAssurance());
        Assurance a1 = liste.get(0);
        a1.setPrime(a.getPrime());
        a1.setMontant(a.getPrime());
        a1.setTypeAssurance(a.getTypeAssurance());
    }

    public static void deleteAssurance(Assurance a) {
        DaoTest.ASSURANCE.remove(a);
    }

    // -------------------------- Batiment
    // --------------------------------------------

    public static List<Batiment> selectBatiment(String... id) {
        List<Batiment> liste;
        if (id.length != 0) {
            liste = DaoTest.BATIMENT.stream()
                .filter(b->b.getAdresse().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.BATIMENT);
        }
        return liste;
    }

    public static void insertBatiment(Batiment b) {
        DaoTest.BATIMENT.add(b);
    }

    public static void updateBatiment(Batiment b) {
        List<Batiment> liste = DaoTest.selectBatiment(b.getAdresse());
        Batiment b1 = liste.get(0);
        b1.setDateConstruction(b.getDateConstruction());
    }

    public static void deleteBatiment(Batiment b) {
        DaoTest.BATIMENT.remove(b);
    }

    // -------------------------- BienLouable
    // --------------------------------------------

    public static List<BienLouable> selectBienLouable(String... id) {
        List<BienLouable> liste;
        if (id.length != 0) {
            liste = DaoTest.BIENLOUABLE.stream()
                .filter(b->b.getIdBienLouable().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.BIENLOUABLE);
        }
        return liste;
    }

    public static void insertBienLouable(BienLouable b) {
        DaoTest.BIENLOUABLE.add(b);
    }

    public static void updateBienLouable(BienLouable b) {
        List<BienLouable> liste = DaoTest
            .selectBienLouable(b.getIdBienLouable());
        BienLouable b1 = liste.get(0);
        b1.setNumeroFiscale(b.getNumeroFiscale());
        b1.setAdresse(b.getAdresse());
        b1.setSurfaceHabituable(b.getSurfaceHabituable());
        b1.setNbPieces(b.getNbPieces());
        b1.setTypeBienLouable(b.getTypeBienLouable());
    }

    public static void deleteBienLouable(BienLouable b) {
        DaoTest.BIENLOUABLE.remove(b);
    }

    // -------------------------- ChargesGenerales
    // --------------------------------------------

    public static List<ChargesGenerales> selectChargesGenerales(String... id) {
        List<ChargesGenerales> liste;
        if (id.length != 0) {
            liste = DaoTest.CHARGESGENERALES.stream()
                .filter(c->c.getIdChargesGenerales().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.CHARGESGENERALES);
        }
        return liste;
    }

    public static void insertChargesGenerales(ChargesGenerales cg) {
        DaoTest.CHARGESGENERALES.add(cg);
    }

    public static void updateChargesGenerales(ChargesGenerales cg) {
        List<ChargesGenerales> liste = DaoTest
            .selectChargesGenerales(cg.getIdChargesGenerales());
        ChargesGenerales nouvelle = liste.get(0);
        nouvelle.setTypeCharge(cg.getTypeCharge());
        nouvelle.setMontant(cg.getMontant());
        nouvelle.setPourcentage(cg.getPourcentage());
        nouvelle.setQuotite(cg.getQuotite());
    }

    public static void deleteChargesGenerales(ChargesGenerales cg) {
        DaoTest.CHARGESGENERALES.remove(cg);
    }

//-------------------------- Compteur --------------------------------------------

    public static List<Compteur> selectCompteur(String... id) {
        List<Compteur> liste;
        if (id.length != 0) {
            liste = DaoTest.COMPTEUR.stream()
                .filter(c->c.getIdCompteur().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.COMPTEUR);
        }
        return liste;
    }

    public static void insertCompteur(Compteur c) {
        DaoTest.COMPTEUR.add(c);
    }

    public static void updateCompteur(Compteur c) {
        List<Compteur> liste = DaoTest.selectCompteur(c.getIdCompteur());
        Compteur nouvelle = liste.get(0);
        nouvelle.setPartieFixe(c.getPartieFixe());
        nouvelle.setPartieVariable(c.getPartieVariable());
        nouvelle.setConsommation(c.getConsommation());
        nouvelle.setTotal(c.getTotal());
        nouvelle.setDataDernierChangement(c.getDataDernierChangement());
    }

    public static void deleteCompteur(Compteur c) {
        DaoTest.COMPTEUR.remove(c);
    }

//-------------------------- ContratLocation --------------------------------------------

    public static List<ContratLocation> selectContratLocation(String... id) {
        List<ContratLocation> liste;
        if (id.length != 0) {
            liste = DaoTest.CONTRATLOCATION.stream()
                .filter(c->c.getNumeroDeContrat().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.CONTRATLOCATION);
        }
        return liste;
    }

    public static void insertContratLocation(ContratLocation c) {
        DaoTest.CONTRATLOCATION.add(c);
    }

    public static void updateContratLocation(ContratLocation c) {
        List<ContratLocation> liste = DaoTest
            .selectContratLocation(c.getNumeroDeContrat());
        ContratLocation nouvelle = liste.get(0);
        nouvelle.setDateDebut(c.getDateDebut());
        nouvelle.setDateFin(c.getDateFin());
        nouvelle.setMontantDeCaution(c.getMontantDeCaution());
        nouvelle.setProvisionCharge(c.getProvisionCharge());
        nouvelle.setSolde(c.getSolde());
        nouvelle.setMontantMensuel(c.getMontantMensuel());
        nouvelle.setDateVersement(c.getDateVersement());
        nouvelle.setIndexCompteurEau(c.getIndexCompteurEau());
        nouvelle.setIndexCompteurElectricite(c.getIndexCompteurElectricite());
    }

    public static void deleteContratLocation(ContratLocation c) {
        DaoTest.CONTRATLOCATION.remove(c);
    }

    // -------------------------- Diagnostics
    // --------------------------------------------

    public static List<Diagnostics> selectDiagnostics(String... id) {
        List<Diagnostics> liste;
        if (id.length != 0) {
            liste = DaoTest.DIAGNOSTICS.stream()
                .filter(d->d.getIdDiagnostics().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.DIAGNOSTICS);
        }
        return liste;
    }

    public static void insertDiagnostics(Diagnostics d) {
        DaoTest.DIAGNOSTICS.add(d);
    }

    public static void updateDiagnostics(Diagnostics d) {
        List<Diagnostics> liste = DaoTest
            .selectDiagnostics(d.getIdDiagnostics());
        Diagnostics nouvelle = liste.get(0);
        nouvelle.setTypeDiagnostics(d.getTypeDiagnostics());
        nouvelle.setDateRealisation(d.getDateRealisation());
        nouvelle.setDateValidite(d.getDateValidite());
        nouvelle.setFichier(d.getFichier());
    }

    public static void deleteDiagnostics(Diagnostics d) {
        DaoTest.DIAGNOSTICS.remove(d);
    }

    // -------------------------- Entreprise
    // --------------------------------------------

    public static List<Entreprise> selectEntreprise(String... id) {
        List<Entreprise> liste;
        if (id.length != 0) {
            liste = DaoTest.ENTREPRISE.stream()
                .filter(e->e.getNumSiret().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.ENTREPRISE);
        }
        return liste;
    }

    public static void insertEntreprise(Entreprise e) {
        DaoTest.ENTREPRISE.add(e);
    }

    public static void updateEntreprise(Entreprise e) {
        List<Entreprise> liste = DaoTest.selectEntreprise(e.getNumSiret());
        Entreprise nouvelle = liste.get(0);
        nouvelle.setAdresse(e.getAdresse());
        nouvelle.setVille(e.getVille());
        nouvelle.setCodePostal(e.getCodePostal());
        nouvelle.setNom(e.getNom());
        nouvelle.setNumTel(e.getNumTel());
        nouvelle.setSpecialite(e.getSpecialite());
    }

    public static void deleteEntreprise(Entreprise e) {
        DaoTest.ENTREPRISE.remove(e);
    }

    // -------------------------- Facture
    // --------------------------------------------

    public static List<Facture> selectFacture(String... id) {
        List<Facture> liste;
        if (id.length != 0) {
            liste = DaoTest.FACTURE.stream()
                .filter(e->e.getNumeroFacture().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.FACTURE);
        }
        return liste;
    }

    public static void insertFacture(Facture f) {
        DaoTest.FACTURE.add(f);
    }

    public static void updateFacture(Facture f) {
        List<Facture> liste = DaoTest.selectFacture(f.getNumeroFacture());
        Facture nouvelle = liste.get(0);
        nouvelle.setMontant(f.getMontant());
        nouvelle.setDateDeFacture(f.getDateDeFacture());
        nouvelle.setCompteBancaire(f.getCompteBancaire());
        nouvelle.setMontantDevis(f.getMontantDevis());
        nouvelle.setDatePaiement(f.getDatePaiement());
        nouvelle.setDesignationDeTravaux(f.getDesignationDeTravaux());

    }

    public static void deleteFacture(Facture f) {
        DaoTest.FACTURE.remove(f);
    }

    // -------------------------- Garant
    // --------------------------------------------

    public static List<Garant> selectGarant(String... id) {
        List<Garant> liste;
        if (id.length != 0) {
            liste = DaoTest.GARANT.stream()
                .filter(g->g.getIdGarant().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.GARANT);
        }
        return liste;
    }

    public static void insertGarant(Garant g) {
        DaoTest.GARANT.add(g);
    }

    public static void updateGarant(Garant g) {
        List<Garant> liste = DaoTest.selectGarant(g.getIdGarant());
        Garant nouvelle = liste.get(0);
        nouvelle.setNom(g.getNom());
        nouvelle.setAdresse(g.getAdresse());
        nouvelle.setTel(g.getTel());

    }

    public static void deleteGarant(Garant g) {
        DaoTest.GARANT.remove(g);
    }

    // -------------------------- IRL
    // --------------------------------------------

    public static List<IRL> selectIRL(String... id) {
        List<IRL> liste;
        if (id.length != 0) {
            liste = DaoTest.IRL.stream()
                .filter(i->i.getAnnee().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.IRL);
        }
        return liste;
    }

    public static void insertIRL(IRL irl) {
        DaoTest.IRL.add(irl);
    }

    public static void updateIRL(IRL irl) {
        List<IRL> liste = DaoTest.selectIRL(irl.getAnnee());
        IRL nouvelle = liste.get(0);
        nouvelle.setIRL(irl.getIRL());

    }

    public static void deleteIRL(IRL irl) {
        DaoTest.IRL.remove(irl);
    }

    // -------------------------- Locataire
    // --------------------------------------------

    public static List<Locataire> selectLocataire(String... id) {
        List<Locataire> liste;
        if (id.length != 0) {
            liste = DaoTest.LOCATAIRE.stream()
                .filter(l->l.getIdLocataire().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.LOCATAIRE);
        }
        return liste;
    }

    public static void insertLocataire(Locataire l) {
        DaoTest.LOCATAIRE.add(l);
    }

    public static void updateLocataire(Locataire l) {
        List<Locataire> liste = DaoTest.selectLocataire(l.getIdLocataire());
        Locataire nouvelle = liste.get(0);
        nouvelle.setNom(l.getNom());
        ;
        nouvelle.setPrenom(l.getPrenom());
        nouvelle.setAdresse(l.getAdresse());
        nouvelle.setTel(l.getTel());
        nouvelle.setEmail(l.getEmail());
        nouvelle.setCodePostale(l.getCodePostale());
        nouvelle.setVille(l.getVille());
        nouvelle.setDateDeNaissance(l.getDateDeNaissance());
        nouvelle.setLieuDeNaissance(l.getLieuDeNaissance());
        nouvelle.setSalaire(l.getSalaire());
        nouvelle.setProfession(l.getProfession());
        nouvelle.setSituationFamiliale(l.getSituationFamiliale());
    }

    public static void deleteLocataire(Locataire l) {
        DaoTest.LOCATAIRE.remove(l);
    }

    // -------------------------- Paiement
    // --------------------------------------------

    public static List<Paiement> selectPaiement(String... id) {
        List<Paiement> liste;
        if (id.length != 0) {
            liste = DaoTest.PAIEMENT.stream()
                .filter(p->p.getId_paiement().equals(id[0]))
                .collect(Collectors.toList());
        } else {
            liste = new ArrayList<>(DaoTest.PAIEMENT);
        }
        return liste;
    }

    public static void insertPaiement(Paiement p) {
        DaoTest.PAIEMENT.add(p);
    }

    public static void updatePaiement(Paiement p) {
        List<Paiement> liste = DaoTest.selectPaiement(p.getId_paiement());
        Paiement nouvelle = liste.get(0);
        nouvelle.setMontant(p.getMontant());
    }

    public static void deletePaiement(Paiement p) {
        DaoTest.PAIEMENT.remove(p);
    }

}
