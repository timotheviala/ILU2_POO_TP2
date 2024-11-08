package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GauloisTest {
	private Gaulois idefix;
	
	@BeforeEach
	void init() {
		System.out.println("Initialisation test gaulois...");
		idefix=new Gaulois("Idéfix",2);
	}
	
	@Test
	void testGaulois() {
		assertNotNull(idefix);
	}
	
	@Test
	void testBoirepotion() {
		idefix.boirePotion(32);
		assertEquals(idefix.getEffetPotion(), 32);
	}

}
