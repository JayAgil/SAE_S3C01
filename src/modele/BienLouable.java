package modele;

import java.util.Objects;

public class BienLouable { 

	private String idBienLouable;
	private String numeroFiscale;
	private String adresse;
	private double surfaceHabituable;
	private int nbPieces;
	private String typeBienLouable;
	private Batiment batiment;
	private BienLouable bienLouableLie;
	public BienLouable(String idBienLouable, String numeroFiscale, String adresse, double surfaceHabituable,
			int nbPieces, String typeBienLouable, Batiment batiment, BienLouable bl) {
		this.idBienLouable = idBienLouable;
		this.numeroFiscale = numeroFiscale;
		this.adresse = adresse;
		this.surfaceHabituable = surfaceHabituable;
		this.nbPieces = nbPieces;
		this.typeBienLouable = typeBienLouable;
		this.batiment = batiment;
		this.bienLouableLie = bl;
	}
	public BienLouable getLogement() {
		return bienLouableLie;
	}
	public void setLogement(BienLouable logement) {
		bienLouableLie = logement;
	}
	public Batiment getBatiment() {
		return batiment;
	}
	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}
	public String getIdBienLouable() {
		return idBienLouable;
	}
	public void setIdBienLouable(String idBienLouable) {
		this.idBienLouable = idBienLouable;
	}
	public String getNumeroFiscale() {
		return numeroFiscale;
	}
	public void setNumeroFiscale(String numeroFiscale) {
		this.numeroFiscale = numeroFiscale;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public double getSurfaceHabituable() {
		return surfaceHabituable;
	}
	public void setSurfaceHabituable(double surfaceHabituable) {
		this.surfaceHabituable = surfaceHabituable;
	}
	public int getNbPieces() {
		return nbPieces;
	}
	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}
	public String getTypeBienLouable() {
		return typeBienLouable;
	}
	public void setTypeBienLouable(String typeBienLouable) {
		this.typeBienLouable = typeBienLouable;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adresse, batiment, idBienLouable, nbPieces, numeroFiscale, surfaceHabituable,
				typeBienLouable);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BienLouable)) {
			return false;
		}
		BienLouable other = (BienLouable) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(batiment, other.batiment)
				&& Objects.equals(idBienLouable, other.idBienLouable) && nbPieces == other.nbPieces
				&& Objects.equals(numeroFiscale, other.numeroFiscale)
				&& Double.doubleToLongBits(surfaceHabituable) == Double.doubleToLongBits(other.surfaceHabituable)
				&& Objects.equals(typeBienLouable, other.typeBienLouable);
	}
	@Override
	public String toString() {
		return "BienLouable [idBienLouable=" + idBienLouable + ", numeroFiscale=" + numeroFiscale + ", adresse="
				+ adresse + ", surfaceHabituable=" + surfaceHabituable + ", nbPieces=" + nbPieces + ", typeBienLouable="
				+ typeBienLouable + ", batiment=" + batiment + ", Logement=" + bienLouableLie+ "]";
	}
	
	public boolean estValide() {
	    if (typeBienLouable == null || adresse == null || adresse.isEmpty()) return false;
	    if (typeBienLouable.equalsIgnoreCase("Bâtiment")) {
	        return numeroFiscale == null || numeroFiscale.isEmpty();
	    } else {
	        return numeroFiscale != null && !numeroFiscale.isEmpty()
	                && surfaceHabituable > 0
	                && nbPieces > 0;
	    }
	}
	
	public boolean verifParent() {
		
	    if (this.bienLouableLie == null) {
	        return false; 
	    }
	    
	    String typeA = this.typeBienLouable;
	    String typeB = this.bienLouableLie.getTypeBienLouable();
	    
	    boolean aIsLogement = typeA.equalsIgnoreCase("Appartement") ||
	                          typeA.equalsIgnoreCase("Studio") ||
	                          typeA.equalsIgnoreCase("Maison");

	    boolean bIsLogement = typeB.equalsIgnoreCase("Appartement") ||
	                          typeB.equalsIgnoreCase("Studio") ||
	                          typeB.equalsIgnoreCase("Maison");
	    
	    boolean aIsGarage = typeA.equalsIgnoreCase("Garage");
	    boolean bIsGarage = typeB.equalsIgnoreCase("Garage");
	    
	    if (aIsLogement && bIsGarage) { 
	    	return true;
	    }
	    if (aIsGarage && bIsLogement) {
	    	return true;
	    }
	    
	    return false;
	}

	
}
