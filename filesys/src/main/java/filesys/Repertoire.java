package filesys;

import java.util.ArrayList;

import Exceptions.AddNullException;
import Exceptions.IsInHimselfException;
import Exceptions.NomExistePasException;

/**
 * Classe Repertoire
 * 
 * @author (RASAMOELA Gilberto, HAMEUR Youssef) 
 * @version (22/04/2013)
 */
public class Repertoire extends Entite
{
    /** Liste des fichiers et repertoires contenu dans le repertoire */
    private ArrayList<Entite> contenu = new ArrayList<Entite>();

    /**
     * Constructor for objects of class Repertoire
     */
    public Repertoire()
    {
       type = "R";
       nom="racine";
    }
    public Repertoire(String parnom)
    {
       type="R";
       nom=parnom;
    }
    public void add(Entite entite) throws AddNullException, NomExistePasException, IsInHimselfException
    {
    	if (entite == null)
    	{
    		throw new AddNullException("On ne peut pas ajouter une référence null à un répertoire");
    	}
    	if (nomExistePas(entite.getNom())== false)
    	{
    		throw new NomExistePasException("On ne peut pas ajouter dans un répertoire un élément de même nom qu'un élément déjà dans le répertoire");
    	}
    	if (isInHimself(entite))
    	{
    		throw new IsInHimselfException("Un répertoire ne peut pas être un sous-répertoire de lui-même (même indirectement)");

    	}
    	
     contenu.add(entite);
    }
    
    
    public boolean isInHimself(Entite e)
    {
    	Repertoire r = null;
    	boolean res=false;
    	
    	if (e.getClass().equals(r.getClass()))
    	{
    		r = (Repertoire) e;
    		if (r.equals(this))
    		{
    			res=true;
    		}
    		else
    		{
    			for (Entite e2 : r.getContenu())
    			{
    				if (isInHimself(e2))
    					res=true;
    			}
    		}
    	}
    	
    	
    	return res;
    }
    
    
    public boolean nomExistePas(String nom)
    {
    	boolean b = true;
    	for (Entite e : contenu)
    	{
    		if(nom.equals(e.getNom()))
    			b = false;
    	}
    	
    	return b;
    }
    
    public int getTaille()
    {
       int taille=0; 

       for(Entite e : contenu)
       {
       taille+=e.getTaille(); 
       }
        
       return taille;
    }
    public ArrayList<Entite> getContenu()
    {
    	return contenu;
    }
}
