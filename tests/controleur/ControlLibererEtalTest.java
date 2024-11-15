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
		System.out.println("Initialisation test controleur libérer étal...");
		village=new Village("Gaulois",10,10);
		Chef boss=new Chef("Boss",3,village);
		village.setChef(boss);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
