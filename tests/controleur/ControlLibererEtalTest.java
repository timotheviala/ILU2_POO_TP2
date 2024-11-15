package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import personnages.*;

import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlLibererEtal controlLibererEtal;
	
	@BeforeEach
	void init(){
		System.out.println("Initialisation test controleur lib�rer �tal...");
		village=new Village("Gaulois",10,10);
		Chef boss=new Chef("Boss",3,village);
		village.setChef(boss);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
	}
	
	@Test
	void testIsVendeur() {
		Gaulois falbala=new Gaulois("Falbala",3);
		village.ajouterHabitant(falbala);
		village.installerVendeur(falbala, "rose", 10);
		assertTrue(controlLibererEtal.isVendeur("Falbala"));
		assertFalse(controlLibererEtal.isVendeur("Obélix"));
	}
	
	@Test
	void testLibererEtal() {
		Gaulois falbala=new Gaulois("Falbala",3);
		village.ajouterHabitant(falbala);
		village.installerVendeur(falbala, "rose", 10);
		assertEquals("true",controlTrouverEtalVendeur.trouverEtalVendeur("Falbala").etatEtal()[0]);
		assertEquals("false",controlLibererEtal.libererEtal("Falbala")[0]);
	}

}
