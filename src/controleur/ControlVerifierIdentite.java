package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		//TODO
		Gaulois gauloisTrouve=village.trouverHabitant(nomVendeur);
		return(gauloisTrouve!=null);
		}
}
