package testfilesys;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.FichierTailleNegativeException;

import filesys.Fichier;

/** 
 * Classe TestFichier testant les méthodes de la classe fichier  
 * 
 *  @author RASAMOELA Gilberto, HAMEUR Youssef 
 *  @version 23/04/13 
 */
public class TestFichier {

	/** 
	 * Teste qu'un fichier créé ne renvoie pas une référence null
	 * et qu'il ne soit pas avec une taille négative
	 * 
	 */
	@Test
	public void testFichier() {
		try {
			Fichier f1 = new Fichier("f1",10);
			assertNotNull(f1);
			assertTrue(f1.getTaille()>0);
		} catch (FichierTailleNegativeException e) {
			e.printStackTrace();
		}
	}

}
