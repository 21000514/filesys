package testfilesys;
import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.AddNullException;
import Exceptions.FichierTailleNegativeException;
import Exceptions.IsInHimselfException;
import Exceptions.NomExistePasException;
import filesys.Repertoire;
import filesys.Entite;
import filesys.Fichier;

/** 
 * Classe TestRepertoire testant les méthodes de la classe répertoire  
 * 
 *  @author RASAMOELA Gilberto, HAMEUR Youssef 
 *  @version 23/04/13 
 */
public class TestRepertoire {

	/** 
	 * Teste qu'un répertoire créé ne renvoie pas une référence null
	 * 
	 */
	@Test
	public void testRepertoire() {
		Repertoire r = new Repertoire();
		assertNotNull(r);
		assertTrue(r.getType() != null);
	}

	/** 
	 * Teste que l'ajout dans un répertoire ne peut se faire dans lui-même
	 * 
	 */
	@Test
	public void testAdd() {
		Repertoire pere = new Repertoire();
		Repertoire r1 = new Repertoire("r1");

		try {
			pere.add(r1);
			assertFalse(pere.equals(r1));
		} catch (AddNullException e) {
			e.printStackTrace();
		} catch (NomExistePasException e) {
			e.printStackTrace();
		} catch (IsInHimselfException e) {
			e.printStackTrace();
		}
		
	}
	/** 
	 * Test de la méthode de détection qu'un répertoire est dans lui-même
	 * 
	 */
	@Test
	public void testIsInHimself() {
		Repertoire r1 = new Repertoire("r1");
		try {
			r1.add(r1);
			assertTrue(r1.isInHimself(r1));
		} catch (AddNullException e1) {
			e1.printStackTrace();
		} catch (NomExistePasException e1) {
			e1.printStackTrace();
		} catch (IsInHimselfException e1) {
			e1.printStackTrace();
		}
		
	}
	/** 
	 * Teste qu'un répertoire ajouté n'a pas le même nom qu'un répertoire déjà présent
	 * 
	 */
	@Test
	public void testNomExistePas() {
		Repertoire r1 = new Repertoire();
		Repertoire r2 = new Repertoire("r1");
		Repertoire r3 = new Repertoire("r1");
		
		try {
			r1.add(r2);
			for (Entite e : r1.getContenu())
			{
			assertTrue(r1.getNom() != e.getNom());
			}
		} catch (AddNullException e) {
			e.printStackTrace();
		} catch (NomExistePasException e) {
			e.printStackTrace();
		} catch (IsInHimselfException e) {
			e.printStackTrace();
		}
		
		
	}

}
