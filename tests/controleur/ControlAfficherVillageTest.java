package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.*;

class ControlAfficherVillageTest {
	private Village village;
	private ControlAfficherVillage controlAfficherVillage;
	
	@BeforeEach
	void init() {
		System.out.println("Initialisation test controleur afficher village...");
		village=new Village("Les gaulois", 10, 10);
		Chef boss=new Chef("Boss",3,village);
		village.setChef(boss);
		controlAfficherVillage=new ControlAfficherVillage(village);
	}
	
	@Test
	void testDonnerVillageois() {
		Gaulois obelix=new Gaulois("Obélix",3);
		Gaulois idefix=new Gaulois("Idéfix",4);
		Gaulois falbala=new Gaulois("Falbala",2);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(idefix);
		village.ajouterHabitant(falbala);
		assertEquals("Boss",controlAfficherVillage.donnerNomsVillageois()[0]);
		assertEquals("Obélix",controlAfficherVillage.donnerNomsVillageois() [1]);
		assertEquals("Idéfix",controlAfficherVillage.donnerNomsVillageois()[2]);
		assertEquals("Falbala",controlAfficherVillage.donnerNomsVillageois()[3]);
	}

	@Test
	void testNomVillage() {
		assertEquals("Les gaulois",controlAfficherVillage.donnerNomVillage());
	}
	
	@Test
	void testNbEtal() {
		assertEquals(10,controlAfficherVillage.donnerNbEtals());
	}
}
