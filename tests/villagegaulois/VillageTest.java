package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;


class VillageTest {
	private Village village;
	private Chef chef;
	
	
	@BeforeEach
	void init() {
		System.out.println("Initialisation test village...");
		village=new Village("Les gaulois",10,10);
		chef=new Chef("Le boss", 10, village);
		village.setChef(chef);
	}
	
	@Test
	void testGetNom() {
		assertEquals("Les gaulois",village.getNom());
	}
	
	@Test
	void testAjouterHabitant() {
		Gaulois obelix=new Gaulois("Obélix",134);
		village.ajouterHabitant(obelix);
		assertEquals(obelix,village.trouverHabitant("Obélix"));
		assertEquals(chef,village.trouverHabitant("Le boss"));
	}
	
	@Test
	void testDonnerVillageois() {
		Gaulois obelix=new Gaulois("Obélix",134);
		village.ajouterHabitant(obelix);
		Druide pano=new Druide("Panoramix",3,1,18);
		village.ajouterHabitant(pano);
		assertEquals("Le boss",village.donnerVillageois()[0]);
		assertEquals("Obélix", village.donnerVillageois()[1]);
		assertEquals("le druide Panoramix",village.donnerVillageois()[2]);
	}

	@Test
	void testDonnerNbEtal() {
		assertEquals(10,village.donnerNbEtal());
	}
	
	@Test
	void testInstallerVendeur() {
		Gaulois obelix=new Gaulois("Obélix",134);
		village.ajouterHabitant(obelix);
		assertEquals(0,village.installerVendeur(obelix, "marrons", 3));
	}
	
	@Test
	void testTrouverVendeur() {
		Gaulois obelix=new Gaulois("Obélix",134);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "marrons", 3);
		assertEquals(obelix,village.rechercherVendeursProduit("marrons")[0]);
	}
	
	@Test
	void testRechercherEtalVide() {
		assertTrue(village.rechercherEtalVide());
		for(int i=0;i<10;i++) {
			Gaulois obelix=new Gaulois("Ok",1);
			village.installerVendeur(obelix, "menhirs", i);
		}
		assertFalse(village.rechercherEtalVide());
	}
	
	@Test
	void testRechercherEtal() {
		Gaulois obelix=new Gaulois("Obélix",134);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "marrons", 3);
		assertEquals(obelix,village.rechercherEtal(obelix).getVendeur());
		assertEquals("Obélix",village.donnerEtatMarche()[0]);
	}
	
	@Test
	void testPartirVendeur() {
		Gaulois obelix=new Gaulois("Obélix",134);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "marrons", 3);
		assertTrue(village.rechercherEtal(obelix).isEtalOccupe());
		village.partirVendeur(obelix);
		assertFalse(village.rechercherEtal(obelix).isEtalOccupe());
	}
}