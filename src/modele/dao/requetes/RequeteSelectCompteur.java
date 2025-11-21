package modele.dao.requetes;

import modele.Compteur;

public class RequeteSelectCompteur extends Requete<Compteur> {
	
	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return " Select * from Compteur " ;
	}
}
