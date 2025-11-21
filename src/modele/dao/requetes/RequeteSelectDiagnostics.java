package modele.dao.requetes;

import modele.Diagnostics;

public class RequeteSelectDiagnostics extends Requete<Diagnostics>{

	@Override
	public String requete() {
		return "Select * from Diagnostics";
	}

}
