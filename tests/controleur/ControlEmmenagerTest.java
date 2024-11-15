package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation test controleurEmmenager...");
		village=new Village("le village des irréductibles",10,5);
		abraracourcix=new Chef("Abraracourcix",10,village);
		controlEmmenager=new ControlEmmenager(village);
		village.setChef(abraracourcix);
	}
	
	
	@Test
	void testisHabitantExiste() {
		controlEmmenager.ajouterGaulois("Astérix",23);
		controlEmmenager.ajouterDruide("Panoramix", 3, 43, 78);
		assertTrue(controlEmmenager.isHabitant("Astérix"));
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}
	
	@Test
	void testisHabitantExistePas() {
		assertFalse(controlEmmenager.isHabitant("César"));
	}

}
