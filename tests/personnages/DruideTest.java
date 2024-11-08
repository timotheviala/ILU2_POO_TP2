package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DruideTest {
	private int forcePotion;
	private Druide panoramix;
	
	@BeforeEach
	void init() {
		System.out.println("Initialisation test druide...");
		panoramix=new Druide("Panoramix",3,4,8);
		forcePotion=-1;
	}
	
	@Test
	void testDruide() {
		assertNotNull(panoramix);
	}
	
	@Test
	void testPrendreparole() {
		assertEquals("Le druide " + panoramix.getNom() + " : ",panoramix.prendreParole());
	}
	
	@Test
	void testPreparerPotion() {
		panoramix.preparerPotion();
		assertTrue(panoramix.getForcePotion()<9);
		assertTrue(panoramix.getForcePotion()>3);
	}
	
	@Test
	void testBoosterGauloisNonObelix() {
		Gaulois obelix=new Gaulois("Obélix",67);
		Gaulois asterix=new Gaulois("Astérix",20);
		panoramix.preparerPotion();
		panoramix.booster(asterix);
		assertEquals(panoramix.getForcePotion(),asterix.getEffetPotion()); 
	}
	
	@Test
	void testBoosterGauloisObelix() {
		Gaulois obelix=new Gaulois("Obélix",67);
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		System.out.println(panoramix.getForcePotion()+obelix.getEffetPotion());
		assertNotEquals(panoramix.getForcePotion(),obelix.getEffetPotion()); 
	}
}
