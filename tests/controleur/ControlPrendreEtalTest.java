package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.*;

class ControlPrendreEtalTest {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;
	
	@BeforeEach
	void init() {
		System.out.println("Initialisation test controleur verifier identité...");
		village=new Village("Les gaulois",10,1);
		controlVerifierIdentite=new ControlVerifierIdentite(village);
		Chef boss=new Chef("Boss",3,village);
		village.setChef(boss);
		controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite, village);
	}
	
	@Test
	void testRestePrendreEtalsDispo() {
		assertTrue(controlPrendreEtal.resteEtals());
		assertEquals(0,controlPrendreEtal.prendreEtal("Obélix", "Menhirs", 17));
	}
	
	@Test
	void testRestePrendreEtalsNonDispo() {
		controlPrendreEtal.prendreEtal("Falbala", "roses", 55);
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testVerifierId() {
		Gaulois falbala=new Gaulois("Falbala",3);
		village.ajouterHabitant(falbala);
		assertTrue(controlPrendreEtal.verifierIdentite("Falbala"));
		assertFalse(controlPrendreEtal.verifierIdentite("César"));
	}

}
