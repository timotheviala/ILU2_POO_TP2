package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;
				case 2:
					//TODO
					StringBuilder accueilGaulois=new StringBuilder();
					accueilGaulois.append("Bienvenue villageois "+nomVisiteur+
							".\nQuelle est votre force?" );
					int force=-1;
					force=Clavier.entrerEntier(accueilGaulois.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;
				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		//TODO
		StringBuilder druideEmmenage=new StringBuilder();
		druideEmmenage.append("Bienvenue druide "+nomVisiteur+".\nQuelle est votre force?");
		int force=Clavier.entrerEntier(druideEmmenage.toString());
		int effetPotionMin=-1;
		int effetPotionMax=-2;
		StringBuilder questionMinPot=new StringBuilder();
		questionMinPot.append("Quelle est la force de potion la plus faible que vous produisez?\n");
		StringBuilder questionMaxPot=new StringBuilder();
		questionMaxPot.append("Quelle est la force de potion la plus forte que vous produisez?\n");
		StringBuilder avertissement=new StringBuilder();
		avertissement.append("Attention Druide,vous vous �tes tromp� entre le minimum et le maximum\n");
		while(effetPotionMax<effetPotionMin) {
			effetPotionMin=Clavier.entrerEntier(questionMinPot.toString());
			effetPotionMax=Clavier.entrerEntier(questionMaxPot.toString());
			if(effetPotionMax<effetPotionMin) {
				System.out.println(avertissement.toString());
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
