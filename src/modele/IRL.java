package modele;

import java.util.Objects;

public class IRL {
	public double IRL;
	public int annee;
	
	public IRL(double IRL, int anne) {
		this.IRL = IRL;
		this.annee = anne;
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

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int anne) {
		this.annee = anne;
	}

	public void setIRL(double iRL) {
		IRL = iRL;
	}

	public double getIRL() {
		return IRL;
	}
	
}
