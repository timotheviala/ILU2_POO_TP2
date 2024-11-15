package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.*;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	void init() {
		System.out.println("Initialisation test controleur trouver etal vendeur...");
		village=new Village("Gaulois",12,1);
		Chef boss=new Chef("Boss",3,village);
		village.setChef(boss);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
	}
	
	@Test
	void testTrouverEtalHabitantNonExistant() {
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("César"));
	}
	
	@Test
	void testTrouverEtalHabitantExistant() {
		Gaulois idefix=new Gaulois("Idéfix",3);
		village.ajouterHabitant(idefix);
		village.installerVendeur(idefix,"croquettes", 100);
		assertEquals(village.rechercherEtal(idefix),controlTrouverEtalVendeur.trouverEtalVendeur("Idéfix"));
	}

}
