package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;
import personnages.*;

class ControlVerifierIdentiteTest {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	void init() {
		System.out.println("Initialisation test controleur vérifier identité...");
		village=new Village("Gaulois",12,1);
		Chef boss=new Chef("Boss",3,village);
		village.setChef(boss);
		controlVerifierIdentite=new ControlVerifierIdentite(village);
	}
	
	@Test
	void testVerifierId() {
		assertTrue(controlVerifierIdentite.verifierIdentite("Boss"));
		assertFalse(controlVerifierIdentite.verifierIdentite("César"));
		Gaulois idefix=new Gaulois("idéfix",3);
		village.ajouterHabitant(idefix);
		assertTrue(controlVerifierIdentite.verifierIdentite("idéfix"));
	}

}
