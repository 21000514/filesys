package filesys;

import Exceptions.FichierTailleNegativeException;

/** Classe Fichier.
 * @author (RASAMOELA Gilberto)
 * @version (22/04/2013)
 */
public class Fichier extends Entite
{
    /**Taille du fichier.*/
    private int taille;
    /**
     * Constructeur de la classe Fichier.
     * Elle necessite un nom et une taille entres en parametre
     * @param parNom, nom du fichier
     * @param parTaille, taille du fichier
     */
    public Fichier(String parNom, int parTaille) throws FichierTailleNegativeException
    {
        type = "F";
        nom = parNom;

        if (parTaille < 0)
        {
        	throw new FichierTailleNegativeException("La taille du fichier est negative");
        }
        taille = parTaille;
    }
    /**
     * Retourne la taille du fichier
     * @return taille du fichier
     */
    public int getTaille()
    {
     return taille;   
    }
}
