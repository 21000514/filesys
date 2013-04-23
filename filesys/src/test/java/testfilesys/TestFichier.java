package testfilesys;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.FichierTailleNegativeException;

import filesys.Fichier;

public class TestFichier {

	@Test
	public void testFichier() {
		try {
			Fichier f1 = new Fichier("f1",10);
			assertTrue(f1.getTaille()>0);
		} catch (FichierTailleNegativeException e) {
			e.printStackTrace();
		}
	}

}
