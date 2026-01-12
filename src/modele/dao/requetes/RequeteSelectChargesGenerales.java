package modele.dao.requetes;

import modele.ChargesGenerales;

/**
 * Requête permettant de récupérer toutes les charges générales de la base de
 * données. Les résultats sont triés par date de charge.
 */
public class RequeteSelectChargesGenerales extends Requete<ChargesGenerales> {

	/**
	 * Fournit la requête SQL pour récupérer toutes les charges générales.
	 *
	 * @return la requête SQL SELECT
	 */
	@Override
	public String requete() {
		// TODO Auto-generated method stub
		return " Select * from MSF5131A.SAE_Charges_Generale " + "Order by Date_Charge";
	}

}
