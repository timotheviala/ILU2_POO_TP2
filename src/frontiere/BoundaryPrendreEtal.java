package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//TODO
		boolean vendeurConnu=controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!vendeurConnu) {
			System.out.println("Je suis d�sol�e " + nomVendeur+ " mais il faut"
					+ " �tre un habitant de notre village pour commercer ici.");
		}else {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux "
					+ "vous trouver un �tal.");
			boolean etalDispo=controlPrendreEtal.resteEtals();
			if(!etalDispo) {
				System.out.println("D�sol�e "+nomVendeur+" je n'ai plus d'�tal qui ne"
						+ " soit pas d�j� occup�.");
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO
		StringBuilder typeProduit=new StringBuilder();
		typeProduit.append("C'est Parfait,il me reste un �tal pour vous!\n"
				+"Il me faudrait quelques renseignements:\nQuel produit souhaitez vous vendre?\n");
		String produitVendu=Clavier.entrerChaine(typeProduit.toString());
		StringBuilder quantiteProduits=new StringBuilder();
		quantiteProduits.append("Combien souhaitez vous en vendre?");
		int nbProduits=Clavier.entrerEntier(quantiteProduits.toString());
		int numeroEtable=controlPrendreEtal.prendreEtal(nomVendeur, produitVendu, nbProduits);
		if(numeroEtable!=-1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est install� � l'�tal n�"+
		(numeroEtable+1));
		}
	}
}
