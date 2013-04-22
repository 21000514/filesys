package filesys;

import Exceptions.FichierTailleNegativeException;

/**
 * Write a description of class Fichier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fichier extends Entite
{
    // instance variables - replace the example below with your own
    private int taille;
 
    public Fichier(String parNom,int parTaille) throws FichierTailleNegativeException
    {
        type="F";
        
        nom=parNom;

        if (parTaille < 0)
        {
        	throw new FichierTailleNegativeException("La taille du fichier est negative");
        }
        taille=parTaille;
    }
    
    public int getTaille()
    {
     return taille;   
    }
}
