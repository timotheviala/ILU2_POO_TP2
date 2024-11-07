package frontiere;

import java.util.Iterator;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche=controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length==0) {
			System.out.println("Le marché est vide,revenez plus tard.");
		}else {
			StringBuilder descriptionMarche=new StringBuilder();
			descriptionMarche.append(nomAcheteur+", vous trouverez au marché:\n");
			int i=0;
			while(i<infosMarche.length) {
				descriptionMarche.append("-"+infosMarche[i]);
				i++;
				descriptionMarche.append(" qui vend "+infosMarche[i]);
				i++;
				descriptionMarche.append(" "+infosMarche[i]+"\n");
				i++;
			}
			System.out.println(descriptionMarche.toString());
		}
	}
}
