package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ChefTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	void init() {
		System.out.println("Initialisation test Chef...");
		village=new Village("Les irréductibles",10,5);
		abraracourcix=new Chef("Abraracourcix",4,village);
	}
	
	@Test
	void testChef() {
		assertNotNull(abraracourcix);
	}

	@Test
	void testPrendreParole() {
		assertEquals("Le chef " + abraracourcix.getNom() + " du village " + village.getNom() + " : ",abraracourcix.prendreParole());
	}
}
