package modele.dao.requetes;

public class RequeteDeleteDiagnostics extends RequeteSelectDiagnosticsById{
	@Override
	public String requete() {
		return "DELETE FROM Diagnostics where id_diagnostics = ?";
	}
}
