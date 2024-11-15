package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean estVillageois=controlAcheterProduit.verifierIdentiteClient(nomAcheteur);
		if(!estVillageois) {
			System.out.println("Je suis désolé "+nomAcheteur+" mais il faut être un"
					+ "habitant de notre village pour commercer ici.");
		}else {
			System.out.println("Quel produit voulez-vous acheter?\n");
			String produitSouhaite=scan.next();
			Gaulois vendeurs[]=controlAcheterProduit.trouverVendeursProduit(produitSouhaite);
			if(vendeurs==null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}else {
				System.out.println("Chez quel commerçant voulez-vous acheter des "+produitSouhaite);
				StringBuilder listeVendeurs=new StringBuilder();
				for(int i=0;i<vendeurs.length;i++) {
					listeVendeurs.append((i+1)+ " - ");
					listeVendeurs.append(vendeurs[i].getNom()+"\n");
				}
				int vendeurChoisi=Clavier.entrerEntier(listeVendeurs.toString());
				System.out.println(nomAcheteur+" se déplace jusqu'à l'étal de "+vendeurs[vendeurChoisi-1].getNom()+".\n");
				StringBuilder quantiteSouhaitee=new StringBuilder();
				quantiteSouhaitee.append("Bonjour " +nomAcheteur+"\nCombien de "+produitSouhaite+
						" voulez-vous acheter?\n");
				int quantiteChoisi=Clavier.entrerEntier(quantiteSouhaitee.toString());
				String nomVendeurChoisi=vendeurs[vendeurChoisi-1].getNom();
				int quantiteObtenu=controlAcheterProduit.acheterProduit(nomVendeurChoisi, quantiteChoisi);
				if(quantiteObtenu==quantiteChoisi) {
					System.out.println(nomAcheteur+" achète "+quantiteObtenu+produitSouhaite+" à "+nomVendeurChoisi);
				}else if(quantiteObtenu==0) {
					System.out.println(nomAcheteur+" veut acheter "+quantiteChoisi+" "+produitSouhaite+", malheureusement il n'y"
							+ " en a plus!");
				}else {
					System.out.println(nomAcheteur+ " veut acheter "+quantiteChoisi+" "+produitSouhaite+",malheureusement "+ nomVendeurChoisi +
							" n'en a plus que "+quantiteObtenu+"."+nomAcheteur+" achète tout le stock de "
							+nomVendeurChoisi+".\n");
				}
			}
		}
	}
}
