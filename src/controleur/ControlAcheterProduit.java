package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public boolean verifierIdentiteClient(String nomClient) {
		return controlVerifierIdentite.verifierIdentite(nomClient);
	}
	
	public Gaulois[] trouverVendeursProduit(String produit) {
		Gaulois[] listeVendeurs=village.rechercherVendeursProduit(produit);
		return listeVendeurs;
	}
	
	public int acheterProduit(String nomVendeur,int quantite) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(quantite);
	}
}
