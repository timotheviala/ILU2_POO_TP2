package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation test controleurEmmenager...");
		village=new Village("le village des irr�ductibles",10,5);
		abraracourcix=new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager=new ControlEmmenager(village);
		assertNotNull(controlEmmenager,"different null");
	}
	
	@Test
	void testisHabitantExiste() {
		ControlEmmenager controlEmmenager=new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Ast�rix",23);
		controlEmmenager.ajouterDruide("Panoramix", 3, 43, 78);
		assertTrue(controlEmmenager.isHabitant("Ast�rix"));
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}
	
	@Test
	void testisHabitantExistePas() {
		ControlEmmenager controlEmmenager=new ControlEmmenager(village);
		assertFalse(controlEmmenager.isHabitant("C�sar"));
	}

}
