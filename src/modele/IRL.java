package modele;

import java.util.Objects;

public class IRL {
	public double IRL;
	public String annee;
	
	public IRL(double IRL, String anne) {
		this.IRL = IRL;
		this.annee = anne;
	}

	@Override
	public String toString() {
		return "IRL [IRL=" + IRL + ", anne=" + annee + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(IRL, annee);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof IRL)) {
			return false;
		}
		IRL other = (IRL) obj;
		return Double.doubleToLongBits(IRL) == Double.doubleToLongBits(other.IRL) && Objects.equals(annee, other.annee);
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String anne) {
		this.annee = anne;
	}

	public void setIRL(double iRL) {
		IRL = iRL;
	}

	public double getIRL() {
		return IRL;
	}
	
}
