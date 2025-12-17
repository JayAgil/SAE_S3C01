package modele.dao.requetes;

public class RequeteDeleteDiagnostics extends RequeteSelectDiagnosticsById{
	@Override
	public String requete() {
		return "DELETE FROM MSF5131A.SAE_Diagnostics where Id_Diagnostics = ?";
	}
}
