package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.*;

class ControlAfficherMarcheTest {
	private ControlAfficherMarche controlAfficherMarche;
	private Village village;
	
	@BeforeEach
	void init() {
		System.out.println("Initialisation test controleur afficher marche...");
		village=new Village("Les gaulois",10,10);
		Chef chef=new Chef("Boss",3,village);
		village.setChef(chef);
		controlAfficherMarche=new ControlAfficherMarche(village);
		Gaulois falbala=new Gaulois("Falbala",2);
		village.installerVendeur(falbala, "fleurs", 4);
	}
	
	@Test
	void testDonnerInfosMarche() {
		assertEquals("Falbala",controlAfficherMarche.donnerInfosMarche()[0]);
		assertEquals("4", controlAfficherMarche.donnerInfosMarche()[1]);
		assertEquals("fleurs",controlAfficherMarche.donnerInfosMarche()[2]);
	}

}
