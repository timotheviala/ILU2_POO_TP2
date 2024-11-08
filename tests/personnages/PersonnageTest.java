package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonnageTest {
	Personnage marchand;
	
	@BeforeEach
	void init() {
		System.out.println("Initialisation test personnage...");
		marchand=new Personnage("Didier",3);
	}
	
	@Test
	void testPersonnage() {
		assertNotNull(marchand);
	}
	
	@Test
	void testPrendreParole() {
		assertEquals(marchand.prendreParole(), "Didier : ");
	}

	@Test
	void testGetForce() {
		assertEquals(marchand.getForce(), 3);
	}
	
	@Test
	void testGetNom() {
		assertEquals(marchand.getNom(), "Didier");
	}
}
