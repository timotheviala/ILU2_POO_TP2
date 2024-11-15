package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.*;

class ControlAcheterProduitTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlAcheterProduit controlAcheterProduit;
	
	@BeforeEach
	void init() {
		System.out.println("Initialisation test Controleur acheter produit...");
		village=new Village("les réductibles", 10,10 );
		Chef chef=new Chef("chef",3,village);
		village.setChef(chef);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite=new ControlVerifierIdentite(village);
		controlAcheterProduit=new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois asterix=new Gaulois("Astérix",3);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "dessins", 5);
	}
	
	@Test
	void testVerifierId() {
		assertTrue(controlAcheterProduit.verifierIdentiteClient("Astérix"));
		assertFalse(controlAcheterProduit.verifierIdentiteClient("César"));
	}
	
	@Test
	void testTrouverVendeurProduits() {
		assertNull(controlAcheterProduit.trouverVendeursProduit("fleurs"));
		assertNotNull(controlAcheterProduit.trouverVendeursProduit("dessins"));
	}
	
	@Test
	void testAcheterproduit() {
		assertEquals(controlAcheterProduit.acheterProduit("Astérix", 5),5);
		assertEquals(controlAcheterProduit.acheterProduit("Astérix", 5), 0);
		assertThrows(NullPointerException.class, ()->{controlAcheterProduit.acheterProduit("César", 3);});
	}
}
