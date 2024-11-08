package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EtalTest {
	Etal etal;
	
	@BeforeEach
	void init() {
		System.out.println("Initialisation test etal...");
		etal=new Etal();

	}
	
	@Test
	void testEtal() {
		assertNotNull(etal);
	}

}
